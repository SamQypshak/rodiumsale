package com.sam.rodiumsale.controllers;

import com.sam.rodiumsale.models.Partner;
import com.sam.rodiumsale.models.Product;
import com.sam.rodiumsale.repos.PartnerRepo;
import com.sam.rodiumsale.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PartnerController {
    @Autowired
    private PartnerRepo partnerRepo;

    @GetMapping("/partners")
    public String home(Model model) {
        Iterable<Partner> partners=partnerRepo.findAll();
        model.addAttribute("partners",partners);
        return "partners";
    }

    @PostMapping("/partners/add")
    public String partners_add(@RequestParam String name, @RequestParam String phone, @RequestParam String email,@RequestParam String adres, Model model){
        //String name,phone,email,adres;
        Partner item=new Partner( name, phone,email,adres);
        partnerRepo.save(item);
        return "redirect:/partners";
    }

    @PostMapping ("/partners/{id}/remove")
    public String partners_remove(@PathVariable(value ="id") long id, Model model){

        Partner item=partnerRepo.findById(id).orElseThrow();
        partnerRepo.delete(item);
        return "redirect:/partners";
    }
}
