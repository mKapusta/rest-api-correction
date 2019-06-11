package com.example.studentapi.service.impl;

import com.example.studentapi.dto.ResponsableDto;
import com.example.studentapi.entity.Responsable;
import com.example.studentapi.repository.ResponsableHibernateRepository;
import com.example.studentapi.service.ResponsableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResponsableServiceImpl implements ResponsableService {

    @Autowired
    private ResponsableHibernateRepository responsableServicernateRepository;

    @Override
    public List<ResponsableDto> getAllResponsables() {
        return responsableServicernateRepository.getAllResponsables().stream()
                .map(responsable -> new ResponsableDto(responsable))
                .collect(Collectors.toList());
    }

    @Override
    public ResponsableDto getResponsableById(Integer id) {
        return new ResponsableDto(responsableServicernateRepository.getResponsableById(id));
    }

    @Override
    public ResponsableDto saveResponsable(ResponsableDto responsableDto) {
        Responsable responsableEntity = fromResponsableDto(responsableDto);
        responsableServicernateRepository.saveResponsable(responsableEntity);
        return new ResponsableDto(responsableEntity);
    }

    @Override
    public void deleteResponsable(Integer id) {
        responsableServicernateRepository.deleteResposableById(id);
    }

    @Override
    public ResponsableDto updateResponsable(Integer id, ResponsableDto responsableDto) {
        Responsable responsableEntity = fromResponsableDto(responsableDto);
        responsableServicernateRepository.updateResponsable(id, responsableEntity);
        return new ResponsableDto(responsableEntity);
    }

    private Responsable fromResponsableDto(ResponsableDto responsableDto) {
        Responsable responsable= new Responsable();
        responsable.setPrenom(responsableDto.getPrenom());
        responsable.setNom(responsableDto.getNom());
        responsable.setId(responsableDto.getId());
        return responsable;
    }
}
