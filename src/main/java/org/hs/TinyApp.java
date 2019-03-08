package org.hs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "org.hs")
public class TinyApp {
	private static final Logger log = LoggerFactory.getLogger(TinyApp.class);
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(TinyApp.class);
		application.run(args);
		log.info("Application has started ...");
	}
}
