package ru.akv.rest.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.akv.rest.shop.entity.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByType(String type);

    @Query(nativeQuery = true, value = "select * from product where showcase_id = :showcaseId and (price > :p1 and price < :p2)")
    List<Product> findAllByPriceBetweenByShowcaseId(@Param("showcaseId") Integer showcaseId, @Param("p1") BigDecimal p1,
                                    @Param("p2") BigDecimal p2);
}
