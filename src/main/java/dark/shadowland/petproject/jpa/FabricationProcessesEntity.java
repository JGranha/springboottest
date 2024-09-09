package dark.shadowland.petproject.jpa;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

// If the name of the class is not the same as the table, them you need to specify the name
@Entity(name = "FabricationProcesses")
public class FabricationProcessesEntity {
  private @Id @Getter @Setter @GeneratedValue Long id;

  @Getter @Setter private String name;

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.name);
  }

  @Override
  public String toString() {
    return "FabricationProcesses{" + "id=" + this.id + ", name='" + this.name + "'}";
  }
}
