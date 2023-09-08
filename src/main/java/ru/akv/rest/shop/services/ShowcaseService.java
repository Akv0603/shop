package ru.akv.rest.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.akv.rest.shop.entity.Showcase;
import ru.akv.rest.shop.repository.ShowcaseRepository;

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
}
