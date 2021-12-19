package co.edu.usa.lasartenreto4.reto4_lasarten.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.lasartenreto4.reto4_lasarten.models.Cookware;
import co.edu.usa.lasartenreto4.reto4_lasarten.repositories.crud.CookwareCrudRepository;

@Repository
public class CookwareRepository {
    
    @Autowired
    private CookwareCrudRepository cookwareCrudRepository;

    public List<Cookware> getAll() {
        return cookwareCrudRepository.findAll();
    }

    public Optional<Cookware> getCook(String reference) {
        return cookwareCrudRepository.findById(reference);
    }
    public Cookware create(Cookware cook) {
        return cookwareCrudRepository.save(cook);
    }

    public void update(Cookware cook) {
        cookwareCrudRepository.save(cook);
    }
    
    public void delete(Cookware cook) {
        cookwareCrudRepository.delete(cook);
    }

    public List<Cookware> getByPrice(double price){
		return cookwareCrudRepository.findByPriceLessThanEqual(price);
	}

    public List<Cookware> getByDescriptionContains(String description){
		return cookwareCrudRepository.findByDescriptionContainingIgnoreCase(description);
	}

}
