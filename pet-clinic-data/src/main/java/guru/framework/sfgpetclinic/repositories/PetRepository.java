package guru.framework.sfgpetclinic.repositories;

import guru.framework.sfgpetclinic.model.Pet;
import guru.framework.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
