package co.edu.usa.lasartenreto4.reto4_lasarten.repositories.crud;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.edu.usa.lasartenreto4.reto4_lasarten.models.Cookware;

public interface CookwareCrudRepository extends MongoRepository<Cookware, String> {
    
}
