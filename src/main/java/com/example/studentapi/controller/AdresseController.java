package com.example.studentapi.controller;

import com.example.studentapi.dto.AdresseDto;
import com.example.studentapi.service.AdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adresses")
public class AdresseController {
    @Autowired
    private AdresseService adresseService;

    @RequestMapping("")
    public List<AdresseDto> getAllAdresses(@RequestParam(required = false) boolean furthest) {
        if(furthest) {
            return adresseService.getFurthestAdresses();
        }else{
            return adresseService.getAllAdresses();
        }
    }

    @RequestMapping("/{id}")
    public AdresseDto getAdresseById(@PathVariable Integer id) {
        return adresseService.getAdresseById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public AdresseDto saveEtudiant(@RequestBody AdresseDto adresseDto) {
        return adresseService.saveAdresse(adresseDto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteAdresseById(@PathVariable Integer id) {
        adresseService.deleteAdresse(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public AdresseDto adr(@PathVariable Integer id, @RequestBody AdresseDto adresseDto) {
        return adresseService.updateAdresse(id, adresseDto);
    }

}
