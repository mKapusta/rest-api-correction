package com.example.studentapi.controller;

import com.example.studentapi.dto.ProfesseurDto;
import com.example.studentapi.service.ProfesseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/professeurs-view")
public class ProfesseurViewController {

    private ProfesseurService professeurService;

    public ProfesseurViewController(@Autowired ProfesseurService professeurService) {
        this.professeurService = professeurService;
    }

    @GetMapping("/display")
    public String getProfesseursView(Model model) {
        model.addAttribute("professeurs", professeurService.searchProfesseurs(null));
        model.addAttribute("newProfesseur", new ProfesseurDto());
        return "professeurs";
    }

    @PostMapping("/create")
    public String createProfesseur(@ModelAttribute ProfesseurDto newProfesseur) {
        professeurService.saveProfesseur(newProfesseur);
        return "redirect:/professeurs-view/display";
    }
}
