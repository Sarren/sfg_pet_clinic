package com.sarren.sfg_pet_clinic.repositories;

import com.sarren.sfg_pet_clinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
