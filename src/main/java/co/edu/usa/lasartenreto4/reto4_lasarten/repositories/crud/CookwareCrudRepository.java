package co.edu.usa.lasartenreto4.reto4_lasarten.repositories.crud;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.edu.usa.lasartenreto4.reto4_lasarten.models.Cookware;

public interface CookwareCrudRepository extends MongoRepository<Cookware, String> {
    public List<Cookware> findByPriceLessThanEqual(double price);
    public List<Cookware> findByDescriptionContainingIgnoreCase(String description);
}
