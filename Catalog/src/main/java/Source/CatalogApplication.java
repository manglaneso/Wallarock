package Source;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class CatalogApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CatalogApplication.class, args);
		System.out.println(System.getProperty("catalina.home"));
	}
	
	/**
     * Used when is a WAR
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(CatalogApplication.class);
    }
}
