package com.sarren.sfg_pet_clinic.controllers;

import com.sarren.sfg_pet_clinic.model.Owner;
import com.sarren.sfg_pet_clinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    OwnerService ownerService;

    @InjectMocks
    OwnerController ownerController;

    Set<Owner> owners;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        owners = new HashSet<>();
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());

        mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
    }

    @Test
    void listOwners() throws Exception{
        when(ownerService.findAll()).thenReturn(owners);

        mockMvc.perform(get("/owners/"))
                //test http response 2xx
                .andExpect(status().isOk())
                //test return string for view
        .andExpect(view().name("owners/index"))
                //"owners" refers to set of owners created at setup
        .andExpect(model().attribute("owners", hasSize(2)));
    }

    @Test
    void findOwners() throws Exception{

        mockMvc.perform(get("/owners/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("notImplemented"));
        //Find owners should not be interacting with ownerservice
        verifyNoInteractions(ownerService);
    }
}