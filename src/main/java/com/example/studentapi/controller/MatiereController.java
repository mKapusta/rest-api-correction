package com.example.studentapi.controller;

import com.example.studentapi.dto.MatiereDto;
import com.example.studentapi.service.MatiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/matieres")
public class MatiereController {
    @Autowired
    private MatiereService matiereService;

    @RequestMapping("")
    public List<MatiereDto> getAllMatiere() {
        return matiereService.getAllMatieres();
    }

}
