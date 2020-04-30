package com.micanasta.service;

import com.micanasta.dto.CrearFamiliaDTO;
import com.micanasta.dto.FamiliaDTO;
import com.micanasta.dto.converter.FamiliaDTOConverter;
import com.micanasta.model.Familia;
import com.micanasta.repository.FamiliaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FamiliaServiceImpl implements FamiliaService {

    @Autowired
    private FamiliaRepository familiaRepository;

    @Autowired
    private FamiliaDTOConverter familiaDTOConverter;

    @Override
    public Familia save(CrearFamiliaDTO familiaDTO) {
        Familia familia=familiaDTOConverter.convertToEntity(familiaDTO);
        return familiaRepository.save(familia);
    }

    @Override
    public List<FamiliaDTO> getAll() {
        List<FamiliaDTO> familiasDTO=familiaRepository.findAll().stream().map(familiaDTOConverter::convertToDto)
                .collect(Collectors.toList());
        return familiasDTO;
    }

    @Override
    public Optional<FamiliaDTO> findById(Long id) {
        return familiaRepository.findById(id).map(familiaDTOConverter::convertToDto);
    }

    /*@Override
    public List<FamiliaDTO> getAll(String nombreUnico) {
        List<FamiliaDTO> familiasDTO=familiaRepository.findAll().stream().map(familiaDTOConverter::convertToDto)
                .collect(Collectors.toList());
        return familiasDTO;
    }*/
}
