package ru.akv.rest.shop.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import ru.akv.rest.shop.entity.Showcase;
import ru.akv.rest.shop.services.ShowcaseService;

import java.time.DateTimeException;
import java.time.LocalDate;
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
        return showcaseService.getAll();
    }

    @GetMapping("/filter")
    @Operation(summary = "Метод для фильтра витрин по типу, или по адресу, или по дате создания, или по дате актуализации." +
            "В противном случае вернет все витрины.")
    public List<Showcase> filterShowcase(
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate createDateFirst,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate createDateLast,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate lastDateFirst,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate lastDateLast
            ){

        if(type != null){
            return showcaseService.filterByType(type);
        }

        if(address != null){
            return showcaseService.filterByAddress(address);
        }

        if(createDateFirst != null && createDateLast != null){
            if(createDateLast.isBefore(createDateFirst)) throw new DateTimeException("Введите даты корректно.");
            return showcaseService.filterByCreateDateBetween(createDateFirst, createDateLast);
        }

        if(lastDateFirst != null && lastDateLast != null){
            if(lastDateLast.isBefore(lastDateFirst)) throw new DateTimeException("Введите даты корректно.");
            return showcaseService.filterByLastDateBetween(lastDateFirst, lastDateLast);
        }
        return showcaseService.getAll();
    }

    @PostMapping
    @Operation(summary = "Добавить новую витрину. Id указывать не нужно ")
    public Showcase addNewShowcase(@RequestBody Showcase showcase){
        showcaseService.saveShowcase(showcase);
        return showcase;
    }

    @PutMapping
    @Operation(summary = "Изменить данные витрины (в теле запроса так же указываем id изменяемой витрины)")
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
