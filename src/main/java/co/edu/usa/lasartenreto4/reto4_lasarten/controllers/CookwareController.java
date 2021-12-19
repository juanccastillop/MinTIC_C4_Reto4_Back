package co.edu.usa.lasartenreto4.reto4_lasarten.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usa.lasartenreto4.reto4_lasarten.models.Cookware;
import co.edu.usa.lasartenreto4.reto4_lasarten.services.CookwareService;

@RestController
@RequestMapping("/api/cookware")
@CrossOrigin("*")
public class CookwareController {
    
    @Autowired
    private CookwareService cookwareService;
       
     @GetMapping("/all")
    public List<Cookware> getAll() {
        return cookwareService.getAll();
    }
    
    @GetMapping("/{reference}")
    public Optional<Cookware> getClothe(@PathVariable("reference") String reference) {
        return cookwareService.getCook(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Cookware create(@RequestBody Cookware gadget) {
        return cookwareService.create(gadget);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cookware update(@RequestBody Cookware gadget) {
        return cookwareService.update(gadget);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return cookwareService.delete(reference);
    } 
    
    @GetMapping("/price/{price}")
	public List<Cookware> findByPrice(@PathVariable("price")double price){
		return cookwareService.getByPrice(price);
	}

    @GetMapping("/description/{description}")
	public List<Cookware> getByDescriptionContains(@PathVariable("description")String description){
		return cookwareService.getByDescriptionContains(description);
	}
}
