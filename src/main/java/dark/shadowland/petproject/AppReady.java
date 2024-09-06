package dark.shadowland.petproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import dark.shadowland.petproject.jpa.AppJPAPlay;
import jakarta.inject.Inject;

@Component
public class AppReady implements ApplicationListener<ApplicationReadyEvent> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Inject private ReadConfig readConfig;

  @Inject private AppEnvironmentPlay appEnvironmentPlay;
  
  @Inject private AppJPAPlay appJPAPlay;
  
  @Override
  public void onApplicationEvent(ApplicationReadyEvent event) {
    System.out.println("Hello World!");

    System.out.println("Driver:" + readConfig.getDatabaseDriver());

    appEnvironmentPlay.environmentTest();
    
    appJPAPlay.testJPA();
  }

}
