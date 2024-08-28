package dark.shadowland.petproject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Component;

import dark.shadowland.petproject.databasedto.FabricationProcesses;
import dark.shadowland.petproject.jpa.FabricationProcessesRepository;
import jakarta.inject.Inject;

@Component
public class AppReady implements ApplicationListener<ApplicationReadyEvent> {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Inject private ReadConfig readConfig;

  @Autowired private Environment environment;

  @Autowired private JdbcTemplate jdbcTemplate;

  @Autowired private FabricationProcessesRepository repository;

  @Override
  public void onApplicationEvent(ApplicationReadyEvent event) {
    System.out.println("Hello World!");

    System.out.println(readConfig.getDatabaseDriver());

    if (environment.getActiveProfiles() != null && environment.getActiveProfiles().length > 0) {
      for (String profileName : environment.getActiveProfiles()) {
        System.out.println("Currently active profile - " + profileName);
      }
    } else {
      System.out.println("No profiles available!");
    }

    try { // Playing a bit with
      System.out.println(
          "fabrication processes count: "
              + jdbcTemplate.queryForObject(
                  "SELECT COUNT(*) FROM fabrication_processes", Integer.class));
    } catch (DataAccessException e) {
      e.printStackTrace();
      logger.atError().log("Something went wrong" + e.getStackTrace());
    }

    jdbcTemplate
        .query(
            "SELECT id, name from fabrication_processes",
            (rs, rownum) -> new FabricationProcesses(rs.getInt(1), rs.getString(2)))
        .forEach(n -> System.out.println(n.toString()));

    System.out.println("Another version"); 
    repository.findAll().stream().forEach(n -> System.out.println(n.toString()));
  }
}
