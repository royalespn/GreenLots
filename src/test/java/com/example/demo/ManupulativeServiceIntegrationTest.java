package com.example.demo;

import com.example.demo.Service.ManupulativeServiceImpl;
import com.example.demo.controller.ManupukationController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(ManupukationController.class)
public class ManupulativeServiceIntegrationTest {

    private static final String INPUT_STRING = "ABCDE";
    private static final String URL_PATH = "/manipulate?str=ABCDE";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ManupulativeServiceImpl manupulativeService;

    @Autowired
    private ManupukationController controller;

    @Test
    @DisplayName("Test that the embedded Spring Application Container can be successfully spun up")
    public void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    @DisplayName("Test Manipulative controller that returns valid String")
    public void testGetResultWhenValidQueryParamStringPassed() throws Exception {

        Map<String, String> expectedResult = Map.of("result", "EDABC");
        when(manupulativeService.doOperation(INPUT_STRING)).thenReturn(expectedResult);

        this.mockMvc.perform(get("/manipulate?str=ABCDE")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("EDABC")))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

    }

    @Test
    @DisplayName("Test Manipulative controller that entered invalid string in query param ")
    public void testGetResultWhenEmptyValueIsPassedInQueryParam() throws Exception {

        this.mockMvc.perform(get("/manipulate?str=")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Please enter a proper n valid string")));
    }

    @Test
    @DisplayName("Test Manipulative controller that entered invalid string in query param ")
    public void testGetResultWhenInvalidQueryParamStringPassed() throws Exception {

        this.mockMvc.perform(get("/manipulate?str")).andExpect(status().is4xxClientError());
    }

}
