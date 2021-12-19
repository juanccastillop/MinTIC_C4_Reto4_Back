package co.edu.usa.lasartenreto4.reto4_lasarten;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import co.edu.usa.lasartenreto4.reto4_lasarten.repositories.crud.CookwareCrudRepository;
import co.edu.usa.lasartenreto4.reto4_lasarten.repositories.crud.OrderCrudRepository;
import co.edu.usa.lasartenreto4.reto4_lasarten.repositories.crud.UserCrudRepository;

@Component
@SpringBootApplication
public class Reto4LasartenApplication implements CommandLineRunner {

	@Autowired
	private CookwareCrudRepository cookwareInterface;

	@Autowired
	private UserCrudRepository userInterface;

	@Autowired
	private OrderCrudRepository orderInterface;

	public static void main(String[] args) {
		SpringApplication.run(Reto4LasartenApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		cookwareInterface.deleteAll();
		userInterface.deleteAll();
		orderInterface.deleteAll();
	}

}
