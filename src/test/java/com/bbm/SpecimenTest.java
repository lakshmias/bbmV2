package com.bbm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class SpecimenTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void simpleSpecimenListPositiveTest() throws Exception
    {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/specimen")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        // Assert the response content or perform additional checks
        String responseContent = result.getResponse().getContentAsString();
        // Add your assertions here
        
    }

    @Test
    public void invalidSpecimenOID() throws Exception
    {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/specimen/test")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andReturn();
    }
}
