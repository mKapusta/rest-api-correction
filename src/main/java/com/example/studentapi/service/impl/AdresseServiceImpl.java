package com.example.studentapi.service.impl;

import com.example.studentapi.dto.AdresseDto;
import com.example.studentapi.entity.Adresse;
import com.example.studentapi.repository.AdresseHibernateRepository;
import com.example.studentapi.service.AdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AdresseServiceImpl implements AdresseService {

    @Autowired
    private AdresseHibernateRepository adresseHibernateRepository;

    @Override
    public List<AdresseDto> getAllAdresses() {
        return adresseHibernateRepository.getAllAdresses().stream()
                .map(adresse -> new AdresseDto(adresse))
                .collect(Collectors.toList());
    }

    @Override
    public AdresseDto getAdresseById(Integer id) {
        return new AdresseDto(adresseHibernateRepository.getAdresseById(id));
    }

    @Override
    public AdresseDto saveAdresse(AdresseDto adresse) {
        Adresse adresseEntity = fromAdresseDto(adresse);
        adresseHibernateRepository.saveAdresse(adresseEntity);
        return new AdresseDto(adresseEntity);
    }

    @Override
    public void deleteAdresse(Integer id) {
        adresseHibernateRepository.deleteAdresseById(id);
    }

    @Override
    public AdresseDto updateAdresse(Integer id, AdresseDto adresseDto) {
        Adresse adresseEntity = fromAdresseDto(adresseDto);
        adresseHibernateRepository.updateAdresse(id, adresseEntity);
        return new AdresseDto(adresseEntity);
    }

    private Adresse fromAdresseDto(AdresseDto adresseDto) {
        Adresse adresse = new Adresse();
        adresse.setDistance(adresseDto.getDistance());
        adresse.setVille(adresseDto.getVille());
        adresse.setId(adresseDto.getId());
        return adresse;
    }
}
