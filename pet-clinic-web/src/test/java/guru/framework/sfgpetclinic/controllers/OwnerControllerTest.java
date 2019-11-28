package guru.framework.sfgpetclinic.controllers;

import guru.framework.sfgpetclinic.model.Owner;
import guru.framework.sfgpetclinic.service.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashSet;
import java.util.Set;

public class OwnerControllerTest {

    @Mock
    OwnerService ownerService;

    @InjectMocks
            OwnerController controller;

    Set<Owner> owners;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        owners = new HashSet<>();
        owners.add(Owner.builder().id(1L).build());
    }

    @Test
    void setAllowedFields() {
    }

    @Test
    void findOwner() {
    }

    @Test
    void processFindForm() {
    }

    @Test
    void showOwner() {
    }

    @Test
    void initCreationForm() {
    }

    @Test
    void processCreationForm() {
    }

    @Test
    void initUpdateOwnerForm() {
    }

    @Test
    void processUpdateOwnerForm() {
    }
}