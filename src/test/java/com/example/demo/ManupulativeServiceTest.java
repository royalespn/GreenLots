package com.example.demo;

import com.example.demo.Service.ManupulativeService;
import com.example.demo.Service.ManupulativeServiceImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Map;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ManupulativeServiceImpl.class })
public class ManupulativeServiceTest {

    private static final String INPUT_STRING = "ABCDE";

    @Autowired
    private ManupulativeService manupulativeService;

    @Test
    @DisplayName("Test that the embedded Spring AC can be successfully spun up")
    void testEnvironment() {
    }

    @Test
    @DisplayName("Test that the service layer that accepts string and return manipulative string")
    public void testStringSplitOnManipulativeLogic() {

        Map<String, String> actualResult = manupulativeService.doOperation(INPUT_STRING);
        Map<String, String> expectedResult = Map.of("result", "EDABC");
        Assertions.assertEquals(expectedResult, actualResult);
    }


    @Test
    @DisplayName("Test that the service layer that accepts null string and return meaningful error")
    public void testStringSplitOnManipulativeLogicWhenStringIsNULL() {

        Map<String, String> actualResultWhenStringNULL = manupulativeService.doOperation(null);
        Assertions.assertNull(actualResultWhenStringNULL);
    }

    @Test
    @DisplayName("Test that the service layer that accepts empty string and return meaningful error")
    public void testStringSplitOnManipulativeLogicWhenStringIsEmpty() {

        Map<String, String> actualResult = manupulativeService.doOperation("");
        Assertions.assertNull(actualResult);
    }


}
