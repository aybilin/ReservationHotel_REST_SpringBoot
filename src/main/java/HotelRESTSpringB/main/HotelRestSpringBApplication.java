package HotelRESTSpringB.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EntityScan(basePackages = {
		"HotelRESTSpringB.models"
})
@EnableJpaRepositories(basePackages = {
		"HotelRESTSpringB.repositories"
})
@SpringBootApplication(scanBasePackages = {
		"HotelRESTSpringB.data",
		"HotelRESTSpringB.exceptions",
		"HotelRESTSpringB.controllers"
})
public class HotelRestSpringBApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelRestSpringBApplication.class, args);
//		List<Object> offre = new ArrayList<Object>();
//		offre.add([);
//		o
	}

}
