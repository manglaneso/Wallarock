package Source;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class ChatApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ChatApplication.class, args);
	}
	
	/**
     * Used when is a WAR
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

        return builder.sources(ChatApplication.class);
    }
}
