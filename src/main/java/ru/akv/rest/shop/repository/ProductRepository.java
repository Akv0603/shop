package ru.akv.rest.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.akv.rest.shop.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
