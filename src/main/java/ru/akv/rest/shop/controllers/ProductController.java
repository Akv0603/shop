package ru.akv.rest.shop.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.akv.rest.shop.entity.Product;
import ru.akv.rest.shop.services.ProductService;

@RestController
@RequestMapping("/product")
@Tag(name = "Товар", description = "Контроллер для товара.")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/{showcaseId}")
    @Operation(summary = "Добавить новый товар на нужную витрину(по ее id).")
    public Product addNewProduct(@PathVariable Integer showcaseId, @RequestBody Product product){
        productService.saveProduct(showcaseId, product);
        return product;
    }

    @PutMapping("/{showcaseId}")
    @Operation(summary = "Изменить данные товара на нужной витрине.")
    public Product UpdateProduct(@PathVariable Integer showcaseId, @RequestBody Product product){
        productService.saveProduct(showcaseId, product);
        return product;
    }

    @DeleteMapping("/{productId}")
    @Operation(summary = "Удаление товара о его id.")
    public String deleteProduct(@PathVariable Integer productId){
        productService.deleteProduct(productId);
        return "Товар под номером " + productId + " был удален.";
    }
}
