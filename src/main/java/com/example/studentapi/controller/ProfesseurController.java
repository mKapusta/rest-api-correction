package com.example.studentapi.controller;

import com.example.studentapi.dto.ProfesseurDto;
import com.example.studentapi.dto.ProfesseurSearchCriteria;
import com.example.studentapi.service.ProfesseurService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professeurs")
public class ProfesseurController {

    private static Logger LOG = LoggerFactory.getLogger(ProfesseurController.class);

    @Autowired
    private ProfesseurService professeurService;

    @RequestMapping("")
    public List<ProfesseurDto> getAllProfesseurs(ProfesseurSearchCriteria professeurSearchCriteria) {
        LOG.debug("mon Message");
        return professeurService.searchProfesseurs(professeurSearchCriteria);
    }

    @RequestMapping("/{id}")
    public ProfesseurDto getProfesseurById(@PathVariable Integer id) {
        return professeurService.getProfesseurById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ProfesseurDto saveProfesseur(@RequestBody ProfesseurDto professeur) {
        return professeurService.saveProfesseur(professeur);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteProfesseurById(@PathVariable Integer id) {
        professeurService.deleteProfesseurById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ProfesseurDto updateProfesseur(@PathVariable Integer id, @RequestBody ProfesseurDto professeur) {
        return professeurService.updateProfesseur(id, professeur);
    }
}
