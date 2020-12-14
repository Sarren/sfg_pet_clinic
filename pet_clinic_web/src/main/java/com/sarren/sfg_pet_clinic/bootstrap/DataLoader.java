package com.sarren.sfg_pet_clinic.bootstrap;

import com.sarren.sfg_pet_clinic.model.*;
import com.sarren.sfg_pet_clinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtiesService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtiesService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtiesService = specialtiesService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if(count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadialogy = specialtiesService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtiesService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtiesService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setName("Sarren");
        owner1.setLastName("Abbeloos");
        owner1.setAddress("Langevelde 67");
        owner1.setCity("Merchtem");
        owner1.setTelephone("052 37 30 38");


        Pet sarrensPet = new Pet();
        sarrensPet.setPetType(savedDogPetType);
        sarrensPet.setOwner(owner1);
        sarrensPet.setBirthDate(LocalDate.now());
        sarrensPet.setName("frie");
        owner1.getPets().add(sarrensPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setName("Yana");
        owner2.setLastName("Kiekens");
        owner2.setAddress("Langevelde 67");
        owner2.setCity("Merchtem");
        owner2.setTelephone("052 37 30 38");

        Pet yanasPet = new Pet();
        yanasPet.setPetType(savedCatPetType);
        yanasPet.setOwner(owner2);
        yanasPet.setBirthDate(LocalDate.now());
        yanasPet.setName("Fons");
        owner2.getPets().add(yanasPet);
        ownerService.save(owner2);

        System.out.println("Loaded owners" + owner2.getId());

        Visit catVisit = new Visit();
        catVisit.setPet(yanasPet);
        catVisit.setLocalDate(LocalDate.now());
        catVisit.setDescription("Sneezy kitty");

        visitService.save(catVisit);

        Vet vet1 = new Vet();
        vet1.setName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialties().add(savedRadialogy);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setName("Frodo");
        vet2.setLastName("Baggins");
        vet2.getSpecialties().add(savedSurgery);
        vetService.save(vet2);
        System.out.println("Loaded vets . . .");
    }
}
