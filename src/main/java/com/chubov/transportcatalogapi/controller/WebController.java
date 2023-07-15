package com.chubov.transportcatalogapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping
    public String renderMainPage(){
        return "index";
    }
}
