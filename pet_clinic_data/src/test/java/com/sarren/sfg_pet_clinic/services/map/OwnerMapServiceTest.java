package com.sarren.sfg_pet_clinic.services.map;

import com.sarren.sfg_pet_clinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;

    final Long OWNERID = 1L;
    final String LASTNAME = "Abbeloos";

    @BeforeEach
    void setUp() {
        // By using the mapService the Service  Interface is autowired, so no need for mocks here
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder().id(OWNERID).lastName(LASTNAME).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();
        assertEquals(OWNERID, ownerSet.size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(OWNERID);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(OWNERID));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Owner owner2 = Owner.builder().id(2L).build();
        Owner savedOwner = ownerMapService.save(owner2);

        assertEquals(id, savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner savedOwner2 = ownerMapService.save(Owner.builder().build());

        assertNotNull(savedOwner2);
        assertNotNull(savedOwner2.getId());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(OWNERID);
        assertEquals(OWNERID, owner.getId());
    }

    @Test
    void findByLastName() {
        Owner abbeloos = ownerMapService.findByLastName(LASTNAME);

        assertNotNull(abbeloos);
        assertEquals(OWNERID, abbeloos.getId());
    }

    @Test
    void findByLastNameNotFound() {
        Owner abbeloos = ownerMapService.findByLastName("foo");

        assertNull(abbeloos);
    }
}