package com.sarren.sfg_pet_clinic.bootstrap;

import com.sarren.sfg_pet_clinic.model.Owner;
import com.sarren.sfg_pet_clinic.model.Pet;
import com.sarren.sfg_pet_clinic.model.PetType;
import com.sarren.sfg_pet_clinic.model.Vet;
import com.sarren.sfg_pet_clinic.services.OwnerService;
import com.sarren.sfg_pet_clinic.services.PetTypeService;
import com.sarren.sfg_pet_clinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setName("Sarren");
        owner1.setLastName("Abbeloos");
        owner1.setAddress("Langevelde 67");
        owner1.setCity("Merchtem");
        owner1.setTelephone("052 37 30 38");
        ownerService.save(owner1);

        Pet sarrensPet = new Pet();
        sarrensPet.setPetType(savedDogPetType);
        sarrensPet.setOwner(owner1);
        sarrensPet.setBirthDate(LocalDate.now());
        sarrensPet.setName("frie");
        owner1.getPets().add(sarrensPet);

        Owner owner2 = new Owner();
        owner2.setName("Yana");
        owner2.setLastName("Kiekens");
        owner2.setAddress("Langevelde 67");
        owner2.setCity("Merchtem");
        owner2.setTelephone("052 37 30 38");
        ownerService.save(owner2);

        Pet yanasPet = new Pet();
        yanasPet.setPetType(savedCatPetType);
        yanasPet.setOwner(owner2);
        yanasPet.setBirthDate(LocalDate.now());
        yanasPet.setName("Fons");
        owner2.getPets().add(yanasPet);

        System.out.println("Loaded owners ...");

        Vet vet1 = new Vet();
        vet1.setName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setName("Frodo");
        vet2.setLastName("Baggins");
        vetService.save(vet2);
        System.out.println("Loaded vets . . .");

    }
}
