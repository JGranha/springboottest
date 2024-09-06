package dark.shadowland.petproject.jpa;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import dark.shadowland.petproject.databasedto.FabricationProcessesDTO;

@Component
public class AppJPAPlay {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired private JdbcTemplate jdbcTemplate;

  @Autowired private FabricationProcessesRepository repository;
  
  public void testJPA() {
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
            (rs, rownum) -> new FabricationProcessesDTO(rs.getInt(1), rs.getString(2)))
        .forEach(n -> System.out.println(n.toString()));

    System.out.println("Another version");
    repository.findAll().stream().forEach(n -> System.out.println(n.toString()));

    System.out.println("Another version");
    Optional<FabricationProcesses> reg = repository.findById(Long.parseLong("1"));
    
    if (reg.isPresent()) {
    	System.out.println(reg.get() ); 
    }
    else {
    	System.out.println("Not present" ); 
    }
  }
}
