package com.example.studentapi.service;

import com.example.studentapi.dto.ResponsableDto;

import java.util.List;

public interface ResponsableService {

    List<ResponsableDto> getAllResponsables();

    ResponsableDto getResponsableById(Integer id);

    ResponsableDto saveResponsable(ResponsableDto responsableDto);

    void deleteResponsable(Integer id);

    ResponsableDto updateResponsable(Integer id, ResponsableDto responsableDto);
}
