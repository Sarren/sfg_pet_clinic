package com.sarren.sfg_pet_clinic.bootstrap;

import com.sarren.sfg_pet_clinic.model.Owner;
import com.sarren.sfg_pet_clinic.model.Vet;
import com.sarren.sfg_pet_clinic.services.OwnerService;
import com.sarren.sfg_pet_clinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setName("Sarren");
        owner1.setLastName("Abbeloos");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setName("Yana");
        owner2.setLastName("Kiekens");
        ownerService.save(owner2);

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
