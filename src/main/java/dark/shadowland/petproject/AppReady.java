package dark.shadowland.petproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import jakarta.inject.Inject;

@Component
public class AppReady implements ApplicationListener<ApplicationReadyEvent> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Inject private ReadConfig readConfig;

  @Autowired private Environment environment;

  @Autowired private JdbcTemplate jdbcTemplate;

  @Override
  public void onApplicationEvent(ApplicationReadyEvent event) {
    System.out.println("Hello World!");

    System.out.println(readConfig.getDatabaseDriver());

    if (environment.getActiveProfiles() != null && environment.getActiveProfiles().length > 0) {
      for (String profileName : environment.getActiveProfiles()) {
        System.out.println("Currently active profile - " + profileName);
      }
    } else {
      logger.atError().log("No profiles available!");
    }
    
    // Playing a bit with 
    jdbcTemplate.query("SELECT count(1) from chairs", (rs, rownum) -> rs.getInt(0)).forEach(n -> System.out.println("Number of chairs:" + n) ); 
    
  }
}
