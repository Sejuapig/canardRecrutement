package canard.esport.recrutement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import canard.esport.recrutement.services.MainService;

@SpringBootApplication
public class RecrutementApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecrutementApplication.class, args);
        MainService mainService = new MainService();
	}
}
