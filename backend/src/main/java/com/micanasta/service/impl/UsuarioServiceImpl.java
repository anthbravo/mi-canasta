package com.micanasta.service.impl;

import com.micanasta.dto.*;
import com.micanasta.exception.*;
import com.micanasta.model.*;
import com.micanasta.repository.*;
import com.micanasta.service.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private FamiliaRepository familiaRepository;
	@Autowired
	private TiendaRepository tiendaRepository;
	@Autowired
	private UsuarioPorFamiliaRepository usuarioPorFamiliaRepository;
	@Autowired
	private UsuarioPorTiendaRepository usuarioPorTiendaRepository;
	@Autowired
	private RolPorUsuarioRepository rolPorUsuarioRepository;
	@Autowired
	private SolicitudRepository solicitudRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private ModelMapper modelMapper = new ModelMapper();

	public UsuarioDto save(UsuarioReniecDto model) {
		Usuario usuario = new Usuario();
		usuario.setDni(model.dni);
		usuario.setNombre(model.nombre1 + " " + model.nombre2);
		usuario.setApellidoMaterno(model.apellidoMaterno);
		usuario.setApellidoPaterno(model.apellidoPaterno);
		usuario.setContrasena(bCryptPasswordEncoder.encode(model.dni));
		usuario.setCorreoElectronico(" ");
		usuario.setFechaNacimiento(model.getFechaNacimiento());
		usuarioRepository.save(usuario);
		return modelMapper.map(usuario, UsuarioDto.class);
	}

	public UsuarioDto findByDni(String dni) {
		try {
			Optional<Usuario> usuario = usuarioRepository.findById(dni);

			return modelMapper.map(usuario.get(), UsuarioDto.class);
		} catch (Exception exception) {
			return new UsuarioDto();
		}
	}

	public UsuarioAccesoDto ValidateLogin(String dni, String contrasena)
			throws UserLoginIncorrectException, UserLoginNotFoundException {
		ReniecServiceImpl reniecService = new ReniecServiceImpl();
		UsuarioDto usuarioDto = findByDni(dni);
		if (usuarioDto.dni == null) {
			if (!dni.equals(contrasena)) {
				throw new UserLoginNotFoundException();
			}
			UsuarioReniecDto resultIdentity = reniecService.validateIdentity(dni);
			if (resultIdentity.dni.equals("NotExist")) {
				throw new UserLoginNotFoundException();
			}
			Object result = save(resultIdentity);
			return modelMapper.map(result, UsuarioAccesoDto.class);
		}
		if (bCryptPasswordEncoder.matches(contrasena, usuarioDto.getContrasena())) {
			return modelMapper.map(usuarioDto, UsuarioAccesoDto.class);
		} else {
			throw new UserLoginIncorrectException();
		}
	}

	@Override
	public UsuarioDataDto GetDatosUsuario(String dni, String contrasena)
			throws UserLoginIncorrectException, UserLoginNotFoundException {
		UsuarioDataDto usuarioDataDto = new UsuarioDataDto();
		FamiliaDataDto familiaDataDto;
		TiendaDataDto tiendaDataDto;
		List<RolPorUsuarioDataDto> rolPorUsuarioDataDtoList = new ArrayList<RolPorUsuarioDataDto>();
		Long familiaId = usuarioPorFamiliaRepository.findByDni(dni);
		if (familiaId != null) {
			Optional<Familia> familia = familiaRepository.findById(familiaId);
			familiaDataDto = modelMapper.map(familia.get(), FamiliaDataDto.class);
		} else
			familiaDataDto = null;
		Long tiendaId = usuarioPorTiendaRepository.findByDni(dni);
		if (tiendaId != null) {
			Optional<Tienda> tienda = tiendaRepository.findById(tiendaId);
			tiendaDataDto = modelMapper.map(tienda.get(), TiendaDataDto.class);
		} else
			tiendaDataDto = null;
		List<RolPorUsuario> rolesPorUsuario = rolPorUsuarioRepository.findAllById(dni);
		modelMapper.map(rolesPorUsuario, rolPorUsuarioDataDtoList);
		usuarioDataDto.setUsuarioAccesoDto(ValidateLogin(dni, contrasena));
		usuarioDataDto.setFamilia(familiaDataDto);
		usuarioDataDto.setTienda(tiendaDataDto);
		usuarioDataDto.setRolPorUsuario(rolPorUsuarioDataDtoList);
		return usuarioDataDto;

	}

	public static boolean correoValido(String email) {
		if (email == null)
			return true;
		Pattern pattern = Pattern
				.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

		Matcher mather = pattern.matcher(email);
		return mather.find();
	}

	@Override
	public UsuarioUpdateDto update(String dni, UsuarioUpdateDto usuarioUpdateDto)
			throws EmailWrongFormatException, NewPasswordNotMatchException, ActualPasswordNotMatchException {
		Usuario entry = usuarioRepository.findByDni(dni);

		if (correoValido(usuarioUpdateDto.correoElectronico) == false) {
			throw new EmailWrongFormatException();
		}
		if (usuarioUpdateDto.contrasena != null) {
			if (!usuarioUpdateDto.contrasena.equals(entry.getContrasena())) {
				throw new ActualPasswordNotMatchException();
			}
		} else {
			throw new ActualPasswordNotMatchException();
		}

		if (usuarioUpdateDto.nuevaContrasena != null && usuarioUpdateDto.repetirContrasena != null) {
			if (!usuarioUpdateDto.nuevaContrasena.equals(usuarioUpdateDto.repetirContrasena)) {
				throw new NewPasswordNotMatchException();
			}
		}

		if (usuarioUpdateDto.contrasena != null) {
			if (usuarioUpdateDto.correoElectronico != null)
				entry.setCorreoElectronico(usuarioUpdateDto.correoElectronico);
			if (usuarioUpdateDto.nuevaContrasena != null)
				entry.setContrasena(usuarioUpdateDto.nuevaContrasena);
			usuarioRepository.save(entry);
		}
		return usuarioUpdateDto;
	}

	@Override
	public UsuarioFamiliaGetDto GetUsuarioFamilia(String dni) throws UserFamilyNotFoundException {
		Long familiaId = usuarioPorFamiliaRepository.findByDni(dni);
		if (familiaId != null) {
			UsuarioFamiliaGetDto usuarioFamiliaGetDto = new UsuarioFamiliaGetDto();
			usuarioFamiliaGetDto.setDni(dni);
			usuarioFamiliaGetDto.setFamiliaId(familiaId);
			return usuarioFamiliaGetDto;
		}
		throw new UserFamilyNotFoundException();
	}

	public Solicitud cancelarSolicitud(String dni, Long idFamilia) throws SolicitudeNotFoundException {
		Usuario usuario = usuarioRepository.findByDni(dni);
		Optional<Familia> optionalFamilia = familiaRepository.findById(idFamilia);
		if (usuario != null && optionalFamilia.isPresent()) {
			SolicitudIdentity solicitudIdentity = new SolicitudIdentity();
			solicitudIdentity.setUsuario(usuario);
			Familia familia = optionalFamilia.get();
			solicitudIdentity.setFamilia(familia);
			Solicitud solicitud = new Solicitud();
			solicitud.setSolicitudIdentity(solicitudIdentity);
			solicitudRepository.delete(solicitud);
			return solicitud;
		}
		return null;
	}
}
