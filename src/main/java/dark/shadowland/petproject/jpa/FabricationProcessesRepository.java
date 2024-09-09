package dark.shadowland.petproject.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FabricationProcessesRepository
    extends JpaRepository<FabricationProcessesEntity, Long> {
	
  @Query(value = "SELECT * FROM FABRICATION_PROCESSES WHERE NAME = ?1", nativeQuery = true)
  Optional<FabricationProcessesEntity> findByName(String name);
}
