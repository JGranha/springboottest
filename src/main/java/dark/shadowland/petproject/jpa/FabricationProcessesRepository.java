package dark.shadowland.petproject.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FabricationProcessesRepository extends JpaRepository<FabricationProcesses, Long> {

/*extends CrudRepository<FabricationProcesses, Long> {

	FabricationProcesses findById(long id);*/
	
}
