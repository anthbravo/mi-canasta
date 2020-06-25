package com.micanasta.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.micanasta.model.Usuario;
import com.micanasta.repository.RolPorUsuarioRepository;
import com.micanasta.repository.UsuarioRepository;

//TODO: Implementar la interfaz de Spring para que el framework sepa dónde están
//los usuarios y sus roles
@Service("userDetailsService")
public class UserServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private RolPorUsuarioRepository rolPorUsuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String dni) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByDni(dni);
		if (usuario == null) {
			throw new UsernameNotFoundException(String.format("Usuario no existe", dni));
		}
		List<GrantedAuthority> authorities = new ArrayList<>();

		rolPorUsuarioRepository.findAllById(dni).forEach(role -> {
			System.out.println("loadUserByUsername:" + role.getRolPorUsuarioIdentity().getRolPerfil().getDescripcion());
			authorities
					.add(new SimpleGrantedAuthority(role.getRolPorUsuarioIdentity().getRolPerfil().getDescripcion()));
		});

		UserDetails userDetails = new User(usuario.getDni(), usuario.getContrasena(), authorities);
		return userDetails;
	}

}
