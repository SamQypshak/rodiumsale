package com.sam.rodiumsale.controllers;

import com.sam.rodiumsale.models.Product;
import com.sam.rodiumsale.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class ProductsController {
    @Autowired
    private ProductRepo productRepo;

    @GetMapping("/products")
    public String home(Model model) {
        Iterable<Product> products=productRepo.findAll();
        model.addAttribute("productlist",products);
        return "products";
    }

    @PostMapping("/products/add")
    public String products_add(@RequestParam String name, @RequestParam String articul, @RequestParam double price, Model model){
        Product item=new Product( name, articul,price,0);
        productRepo.save(item);
        return "redirect:/products";
    }

    @PostMapping ("/products/{id}/remove")
    public String products_remove(@PathVariable(value ="id") long id, Model model){

        Product product=productRepo.findById(id).orElseThrow();
        productRepo.delete(product);
        return "redirect:/products";
    }
}
