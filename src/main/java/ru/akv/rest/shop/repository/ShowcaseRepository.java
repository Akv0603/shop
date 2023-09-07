package ru.akv.rest.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.akv.rest.shop.entity.Showcase;

public interface ShowcaseRepository extends JpaRepository<Showcase, Integer> {
}
