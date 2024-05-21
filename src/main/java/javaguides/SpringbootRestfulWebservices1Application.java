package javaguides;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootRestfulWebservices1Application {
	@Bean
	public ModelMapper modelMapper()
	{return new ModelMapper();}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestfulWebservices1Application.class, args);
	}

}
