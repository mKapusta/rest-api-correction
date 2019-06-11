package com.example.studentapi.controller;

import com.example.studentapi.dto.ResponsableDto;
import com.example.studentapi.service.ResponsableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/responsables")
public class ResponsableController {
    @Autowired
    private ResponsableService responsableService;

    @RequestMapping("")
    public List<ResponsableDto> getAllAdresses() {
        return responsableService.getAllResponsables();
    }

    @RequestMapping("/{id}")
    public ResponsableDto getAdresseById(@PathVariable Integer id) {
        return responsableService.getResponsableById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponsableDto saveEtudiant(@RequestBody ResponsableDto adresseDto) {
        return responsableService.saveResponsable(adresseDto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteAdresseById(@PathVariable Integer id) {
        responsableService.deleteResponsable(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponsableDto adr(@PathVariable Integer id, @RequestBody ResponsableDto adresseDto) {
        return responsableService.updateResponsable(id, adresseDto);
    }


}
