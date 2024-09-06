package dark.shadowland.petproject;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import lombok.Getter;

@Configuration
public class ReadConfig {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Getter
  @Value("${app.datasource.url}")
  private String databaseUrl;

  @Getter
  @Value("${app.datasource.username}")
  private String databaseUsername;

  @Getter
  @Value("${app.datasource.password}")
  private String databasePassword;

  @Getter
  @Value("${app.datasource.driver-class-name}")
  private String databaseDriver;

  @Bean
  public DataSource springJpaDataSource() {
    logger.atInfo().log("Starting JPA Data source information");

    DriverManagerDataSource dataSource = new DriverManagerDataSource();

    dataSource.setUrl(databaseUrl);
    dataSource.setUsername(databaseUsername);
    dataSource.setPassword(databasePassword);
    dataSource.setDriverClassName(databaseDriver);

    //logger.atInfo().log("Database URL: " + databaseUrl);
    //logger.atInfo().log("Database Username: " +  databaseUsername);
    //logger.atInfo().log("Database Password: " +  databasePassword);
    //logger.atInfo().log("Database Driver: " +  databaseDriver);

    return dataSource;
  }
}
