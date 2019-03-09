package com.example.studentapi.service.impl;

import com.example.studentapi.dto.MatiereDto;
import com.example.studentapi.repository.MatiereJpaRepository;
import com.example.studentapi.service.MatiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatiereServiceImpl implements MatiereService {
    @Autowired
    private MatiereJpaRepository matiereJpaRepository;

    @Override
    public List<MatiereDto> getAllMatieres() {
        List<MatiereDto> matieres = new ArrayList<>();
        matiereJpaRepository.findAll().forEach(
                mat -> matieres.add(new MatiereDto(mat))
        );
        return matieres;
    }
}
