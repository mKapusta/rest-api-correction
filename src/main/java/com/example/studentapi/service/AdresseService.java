package com.example.studentapi.service;

import com.example.studentapi.dto.AdresseDto;

import java.util.List;

public interface AdresseService {

    List<AdresseDto> getAllAdresses();

    AdresseDto getAdresseById(Integer id);

    AdresseDto saveAdresse(AdresseDto adresse);

    void deleteAdresse(Integer id);

    AdresseDto updateAdresse(Integer id, AdresseDto adresseDto);
}
