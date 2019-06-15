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
    public List<ResponsableDto> getAllResponsable() {
        return responsableService.getAllResponsables();
    }

    @RequestMapping("/{id}")
    public ResponsableDto getResponsableById(@PathVariable Integer id) {
        return responsableService.getResponsableById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponsableDto saveResponsable(@RequestBody ResponsableDto adresseDto) {
        return responsableService.saveResponsable(adresseDto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteResponsable(@PathVariable Integer id) {
        responsableService.deleteResponsable(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponsableDto modifyResponsable(@PathVariable Integer id, @RequestBody ResponsableDto adresseDto) {
        return responsableService.updateResponsable(id, adresseDto);
    }


}
