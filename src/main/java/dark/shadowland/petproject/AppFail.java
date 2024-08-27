package dark.shadowland.petproject;

import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

public class AppFail {
	@Component
	public class AppReady implements ApplicationListener<ApplicationFailedEvent> {
	  @Override
	  public void onApplicationEvent(ApplicationFailedEvent event) { 
		  System.out.println("This was not nice...");

	  }
	}
}
