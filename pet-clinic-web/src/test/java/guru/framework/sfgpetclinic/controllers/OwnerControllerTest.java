package guru.framework.sfgpetclinic.controllers;

import guru.framework.sfgpetclinic.model.Owner;
import guru.framework.sfgpetclinic.service.OwnerService;
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

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class OwnerControllerTest {

    @Mock
    OwnerService ownerService;

    @InjectMocks
    OwnerController controller;

    Set<Owner> owners;

    MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        owners = new HashSet<>();
        owners.add(Owner.builder().id(1l).build());
        owners.add(Owner.builder().id(2l).build());

        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }

//    @Test
//    public void listOwners() throws Exception {
//        when(ownerService.findAll()).thenReturn(owners);
//
//        mockMvc.perform(get("/owners"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("owners/findOwners"))
//                .andExpect(model().attribute("owners", hasSize(2)));
//    }

    @Test
    public void listOwnersByIndex() throws Exception {
        when(ownerService.findAll()).thenReturn(owners);

        mockMvc.perform(get("/owners/index"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners", hasSize(2)));
    }

    @Test
    public void findOwners() throws Exception {
        mockMvc.perform(get("/owners/findOwners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/findOwnres"))
                .andExpect(model().attributeExists("owner"));

        verifyZeroInteractions(ownerService);
    }

    @Test
    public void displayOwner() throws Exception{
        when(ownerService.findById(anyLong())).thenReturn(Owner.builder().id(1l).build());

        mockMvc.perform(get("/owners/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownerDetails"))
                .andExpect(model().attribute("owner", hasProperty("id", is(1l))));
    }

//    @Test
//    void setAllowedFields() {
//    }
//
//    @Test
//    void findOwner() {
//    }
//
//    @Test
//    void processFindForm() {
//    }
//
//    @Test
//    void showOwner() {
//    }
//
//    @Test
//    void initCreationForm() {
//    }
//
//    @Test
//    void processCreationForm() {
//    }
//
//    @Test
//    void initUpdateOwnerForm() {
//    }
//
//    @Test
//    void processUpdateOwnerForm() {
//    }
}