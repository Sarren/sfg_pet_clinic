package com.sarren.sfg_pet_clinic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Person extends BaseEntity {

    public Person(Long id, String name, String lastName) {
        super(id);
        this.name = name;
        this.lastName = lastName;
    }

    @Column(name = "first_name")
    private String name;

    @Column(name = "last_name")
    private String lastName;
}
