package guru.framework.sfgpetclinic.controllers;

import guru.framework.sfgpetclinic.model.Owner;
import guru.framework.sfgpetclinic.model.Pet;
import guru.framework.sfgpetclinic.model.PetType;
import guru.framework.sfgpetclinic.service.OwnerService;
import guru.framework.sfgpetclinic.service.PetService;
import guru.framework.sfgpetclinic.service.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {

    private static final String VIEWS_PETS_CREATED_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";
    private final PetService petService;
    private final OwnerService ownerService;
    private final PetTypeService petTypeService;

    public PetController(PetService pets, OwnerService owners, PetTypeService petTypeService) {
        this.petService = pets;
        this.ownerService = owners;
        this.petTypeService = petTypeService;
    }

    @ModelAttribute("types")
    public Collection<PetType> populatePetTypes() {
        return this.petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable Long ownerId) {
        return this.ownerService.findById(ownerId);
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }

//    @InitBinder("pet")
//    public void initPetBinder(WebDataBinder dataBinder){
//        dataBinder.setValidator(new PetValidator());
//    }
//
//    @GetMapping("/pets/new")
//    public String initCreationForm(Owner owner, Model model){
//        Pet pet = new Pet();
//        owner.addPet(pet);
//        model.addAttribute("pet", pet);
//        return VIEWS_PETS_CREATED_OR_UPDATE_FORM;
//    }


}
