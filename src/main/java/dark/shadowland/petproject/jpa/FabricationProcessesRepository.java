package dark.shadowland.petproject.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface FabricationProcessesRepository extends JpaRepository<FabricationProcesses, Long> {
	Optional<FabricationProcesses> findById(Long id);
	
}
