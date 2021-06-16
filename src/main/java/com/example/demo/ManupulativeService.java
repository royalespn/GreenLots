package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class ManupulativeService {

    public Map<String, String> doOperation(String str) {

        if (str == null || str.trim().isEmpty())
            return null;

        Map<String, String> manipulativeResult = new HashMap<>();
        int length = str.length();
        String firstHalf, secondHalf;

        if (length % 2 == 0) {
            firstHalf = str.substring(0, length / 2);
            secondHalf = str.substring(length / 2);
        } else {
            firstHalf = str.substring(0, length / 2 + 1);
            secondHalf = str.substring(length / 2 + 1);
        }

        String manipulativeComputeString = new StringBuilder().append(secondHalf).reverse().toString() + firstHalf;
        log.info("manipulated string result " + manipulativeComputeString);

        manipulativeResult.put("result", manipulativeComputeString);
        return manipulativeResult;
    }
}
