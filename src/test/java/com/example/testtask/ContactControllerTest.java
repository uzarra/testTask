package com.example.testtask;

import com.example.testtask.api.ContactController;
import com.example.testtask.model.Contact;
import com.example.testtask.service.ContactService;
import lombok.var;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ContactControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContactService contactService;

    @InjectMocks
    private ContactController contactController;

    @Test
    public void testGetAllContacts() throws Exception {
        var listContacts = new ArrayList<Contact>();
        listContacts.add(new Contact("Test", "TestJob"));
        listContacts.add(new Contact("Test1", "TestJob1"));

        Mockito.when(contactService.getAllContacts()).thenReturn(listContacts);

        var mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/contacts")
            .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                    .andReturn();

        var response = mvcResult.getResponse().getContentAsString();
        var jsonArray = new JSONArray(response);
        assertEquals(2, jsonArray.length());
        var object = (JSONObject) jsonArray.getJSONObject(0);
        assertTrue(object.getString("fullName").contains("Test"));
    }
}
