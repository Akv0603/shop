package ru.akv.rest.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.akv.rest.shop.entity.Showcase;
import ru.akv.rest.shop.services.ShowcaseService;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShowcaseController {

    @Autowired
    private ShowcaseService showcaseService;

    @GetMapping
    public List<Showcase> showAllShowcase(){
        List<Showcase> allShowcase =showcaseService.getAll();
        return allShowcase;
    }
}
