package ru.akv.rest.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.akv.rest.shop.entity.Product;
import ru.akv.rest.shop.entity.Showcase;
import ru.akv.rest.shop.exceptions.ShowcaseNotFoundException;
import ru.akv.rest.shop.repository.ProductRepository;
import ru.akv.rest.shop.repository.ShowcaseRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ShowcaseRepository showcaseRepository;

    public Product saveProduct(Integer showcaseId, Product product){
        Showcase showcase = showcaseRepository.findById(showcaseId).orElseThrow(() -> new ShowcaseNotFoundException(showcaseId));
        product.setShowcase(showcase);
        return productRepository.save(product);
    }

    public void deleteProduct(Integer productId){
        productRepository.deleteById(productId);
    }
}
