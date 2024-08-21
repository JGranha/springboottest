package dark.shadowland.petproject;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AppStartup implements ApplicationListener<ApplicationStartedEvent> {
  @Override
  public void onApplicationEvent(ApplicationStartedEvent event) {
    System.out.println("Almost there");
  }
}
