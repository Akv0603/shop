package ru.akv.rest.shop.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.akv.rest.shop.entity.Showcase;
import ru.akv.rest.shop.services.ShowcaseService;

import java.util.List;

@RestController
@RequestMapping("/shop")
@Tag(name = "Витрины", description = "Контроллер для витрин")
public class ShowcaseController {

    @Autowired
    private ShowcaseService showcaseService;

    @GetMapping
    @Operation(summary = "показать все витрины")
    public List<Showcase> showAllShowcase(){
        List<Showcase> allShowcase =showcaseService.getAll();
        return allShowcase;
    }

    @PostMapping
    @Operation(summary = "Добавить новую витрину.  ")
    public Showcase addNewShowcase(@RequestBody Showcase showcase){
        showcaseService.saveShowcase(showcase);
        return showcase;
    }

    @PutMapping
    @Operation(summary = "Изменить данные витрины (в теле запроса указываем и id изменяемой витрины)")
    public Showcase UpdateShowcase(@RequestBody Showcase showcase){
        showcaseService.saveShowcase(showcase);
        return showcase;
    }

    @DeleteMapping("/{showcaseId}")
    @Operation(summary = "Удалить витрину. В запросе указать id витрины, которую нужно удалить.")
    public String deleteShowcase(@PathVariable Integer showcaseId){
        showcaseService.deleteShowcase(showcaseId);
        return "Витрина под номером " + showcaseId + " расформирована.";
    }
}
