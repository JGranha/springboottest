package dark.shadowland.petproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "dark.shadowland.petproject")
public class App {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
		
		System.out.println("Application:" + context.getApplicationName());
		context.getEnvironment().getActiveProfiles();
		/*
		System.out.println("Available beans" ); 
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }*/
	}
}
