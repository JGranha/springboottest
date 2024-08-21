package dark.shadowland.petproject;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AppReady implements ApplicationListener<ApplicationReadyEvent> {
  @Override
  public void onApplicationEvent(ApplicationReadyEvent event) { 
	  System.out.println("Hello World!");
  }
}
