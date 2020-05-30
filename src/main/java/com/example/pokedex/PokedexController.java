package com.example.pokedex;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokedexController {
    @RequestMapping("/")
    public String pokedex() {
        return "Hello World";
    }
}
