package ru.akv.rest.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.akv.rest.shop.entity.Showcase;
import ru.akv.rest.shop.repository.ShowcaseRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class ShowcaseService {

    @Autowired
    private ShowcaseRepository showcaseRepository;


    public List<Showcase> getAll(){
        return showcaseRepository.findAll();
    }

    public void deleteShowcase(Integer showcaseId){
        showcaseRepository.deleteById(showcaseId);
    }

    public void saveShowcase(Showcase showcase){
        showcaseRepository.save(showcase);
    }

//filter
    public List<Showcase> filterByAddress(String address){
        return showcaseRepository.findAllByAddress(address);
    }

    public List<Showcase> filterByType(String type){
        return showcaseRepository.findAllByType(type);
    }

    public List<Showcase> filterByCreateDateBetween(LocalDate dateFirst, LocalDate dateLast){
        return showcaseRepository.findAllByCreateDateBetween(dateFirst, dateLast);
    }

    public List<Showcase> filterByLastDateBetween(LocalDate dateFirst, LocalDate dateLast){
        return showcaseRepository.findAllByLastDateBetween(dateFirst, dateLast);
    }
}
