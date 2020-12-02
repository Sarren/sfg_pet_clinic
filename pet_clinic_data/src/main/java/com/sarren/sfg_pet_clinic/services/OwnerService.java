package com.sarren.sfg_pet_clinic.services;

import com.sarren.sfg_pet_clinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByLastName(String lastName);
}
