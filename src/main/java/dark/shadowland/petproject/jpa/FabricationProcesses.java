package dark.shadowland.petproject.jpa;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class FabricationProcesses {
  private @Id @Getter @Setter @GeneratedValue Long id;

  @Getter @Setter private String name;

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.name);
  }

  @Override
  public String toString() {
    return "FabricationProcesses{" + "id=" + this.id + ", name='" + this.name + '}';
  }
}
