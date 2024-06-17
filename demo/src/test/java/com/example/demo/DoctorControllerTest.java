package com.example.demo;

import contoller.DoctorController;
import entity.Doctor;
import service.DoctorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class DoctorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DoctorService doctorService;

    @BeforeEach
    public void setUp() {
        when(doctorService.addDoctor(any(Doctor.class))).thenAnswer(invocation -> {
            Doctor doctor = invocation.getArgument(0);
            doctor.setId(1L); // Assigning an ID for testing purpose
            return doctor;
        });
    }

    @Test
    public void testAddDoctor() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/doctors/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"firstName\": \"John\", \"secondName\": \"Doe\", \"specialization\": \"Cardiology\", \"appointment_price\": 200.0 }"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("John"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.secondName").value("Doe"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.specialization").value("Cardiology"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.appointment_price").value(200.0));

    }
}

