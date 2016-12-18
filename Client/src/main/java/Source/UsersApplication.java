package Source;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class UsersApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(UsersApplication.class, args);
	}
	
	/**
     * Used when is a WAR
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

        return builder.sources(UsersApplication.class);
    }
}
