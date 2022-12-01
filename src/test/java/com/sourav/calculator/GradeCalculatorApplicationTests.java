package com.sourav.calculator;

import com.google.gson.Gson;
import com.sourav.calculator.controller.GradeController;
import com.sourav.calculator.model.Grade;
import org.apiguardian.api.API;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcResultHandlersDsl;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class GradeCalculatorApplicationTests {

    @Autowired
    private GradeController gradeController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
        Assert.assertNotNull(gradeController);
        Assert.assertNotNull(mockMvc);

    }
    @Test
    public void testShowGrades() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/grades?name=sourav");

        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());

    }

    @Test
    public void testSuccessfulSubmission() throws Exception {
        Grade grade = new Grade("Harry", "80", "DSA", 100);
        Gson gson = new Gson();
        String json = gson.toJson(grade);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/grades")
                .contentType(
                        MediaType.APPLICATION_JSON).content(json);


        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

    @Test
    public void testUnSuccessfulSubmission() throws Exception {

        Grade grade = new Grade("Harry", "80", "DSA", 100);
        Gson gson = new Gson();
        String json = gson.toJson(grade);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/grades")
                .contentType(
                        MediaType.APPLICATION_JSON).content(json);


        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }
}
