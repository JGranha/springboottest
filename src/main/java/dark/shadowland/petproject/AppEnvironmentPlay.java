package dark.shadowland.petproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class AppEnvironmentPlay {
  @Autowired private Environment environment;

  public void environmentTest() {
    if (environment.getActiveProfiles() != null && environment.getActiveProfiles().length > 0) {
      for (String profileName : environment.getActiveProfiles()) {
        System.out.println("Currently active profile - " + profileName);
      }
    } else {
      System.out.println("No profiles available!");
    }
  }
}
