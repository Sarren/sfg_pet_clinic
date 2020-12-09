package com.sarren.sfg_pet_clinic.controllers;

import com.sarren.sfg_pet_clinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"","/", "/index", "/index.html"})
    public String listOwners(Model model){

        model.addAttribute("owners", ownerService.findAll());
        System.out.println("somehting");
        return "owners/index";
    }

    @RequestMapping("/find")
    public String findOwners(){
        return "notImplemented";
    }
}
