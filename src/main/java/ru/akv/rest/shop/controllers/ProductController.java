package ru.akv.rest.shop.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import javafx.beans.property.ListProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.akv.rest.shop.entity.Product;
import ru.akv.rest.shop.services.ProductService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
@Tag(name = "Товар", description = "Контроллер для товара.")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    @Operation(summary = "Показать все товары на всех витринах всех магазинов.")
    public List<Product> showAllProduct(){
        return productService.getAll();
    }

    @GetMapping("/filter/{showcaseId}")
    @Operation(summary = "Фильтрация по типу товара или диапазону цен в выбранной витрине." +
            "При указании только id витрины, выдаст список всех товаров на данной витрине.")
    public List<Product> filterByTypeOrPrice(@PathVariable Integer showcaseId,
                                             @RequestParam(required = false) String type,
                                             @RequestParam(required = false) BigDecimal p1,
                                             @RequestParam(required = false) BigDecimal p2 ){

        if(type != null) {
            return productService.filterProductByType(type);
        }

        if(p1 != null && p2 != null) {
//            if(p1.compareTo(p2) > 0) throw new Exception("Введите верный диапазон цен.");
            return productService.filterByPriceBetween(showcaseId, p1, p2);
        }
        return productService.getProductByShowcase(showcaseId);
    }


    @PostMapping("/{showcaseId}")
    @Operation(summary = "Добавить новый товар на нужную витрину(по ее id).")
    public Product addNewProduct(@PathVariable Integer showcaseId, @RequestBody Product product){
        productService.saveProduct(showcaseId, product);
        return product;
    }

    @PutMapping("/{showcaseId}")
    @Operation(summary = "Изменить данные товара на нужной витрине по ее id.")
    public Product UpdateProduct(@PathVariable Integer showcaseId, @RequestBody Product product){
        productService.saveProduct(showcaseId, product);
        return product;
    }

    @DeleteMapping("/{productId}")
    @Operation(summary = "Удаление товара по его id.")
    public String deleteProduct(@PathVariable Integer productId){
        productService.deleteProduct(productId);
        return "Товар под номером " + productId + " был удален.";
    }
}
