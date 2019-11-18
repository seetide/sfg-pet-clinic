package guru.framework.sfgpetclinic.service.map;

import guru.framework.sfgpetclinic.model.Owner;
import guru.framework.sfgpetclinic.model.Pet;
import guru.framework.sfgpetclinic.service.CrudService;
import guru.framework.sfgpetclinic.service.OwnerService;
import guru.framework.sfgpetclinic.service.PetService;
import guru.framework.sfgpetclinic.service.PetTypeService;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

@Service
@Profile({"default", "map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetService petService;
    private final PetTypeService petTypeService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {

        if(object != null){
            if(object.getPets() != null){
                object.getPets().forEach(pet -> {
                    if(pet.getPetType() != null){
                        if(pet.getPetType().getId() == null){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    }else{
                        throw new RuntimeException("Pet Type is required");
                    }

                    if(pet.getId() == null){
                        Pet savedPet =  petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(object);
        }
        else{
            return null;
        }

    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        Stream<Owner> ownerStream = this.findAll().stream();

        Optional<Owner> curr = ownerStream.findFirst();
        Owner ownerCurr = curr.orElse(null);
        System.out.println(ownerCurr.getLastName());
//        Stream<Owner> ownerStream1 = ownerStream.filter(owner -> owner.getLastName().equalsIgnoreCase(lastName));
//
//        Optional<Owner> ownerOption  = ownerStream1.findFirst();
//        Owner ownerL = ownerOption.orElse(null);

        return null;
    }
}
