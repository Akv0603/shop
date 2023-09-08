package ru.akv.rest.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.akv.rest.shop.entity.Showcase;

import java.time.LocalDate;
import java.util.List;

public interface ShowcaseRepository extends JpaRepository<Showcase, Integer> {
    List<Showcase> findAllByAddress(String address);
    List<Showcase> findAllByType(String type);
    List<Showcase> findAllByCreateDateBetween(LocalDate dateFirst, LocalDate dateLast);
    List<Showcase> findAllByLastDateBetween(LocalDate dateFirst, LocalDate dateLast);

}
