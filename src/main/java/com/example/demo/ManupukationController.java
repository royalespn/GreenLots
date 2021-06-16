package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RequestMapping("/manipulate")
@RestController
public class ManupukationController {

    @Autowired
    private ManupulativeService manupulativeService;


    @RequestMapping
    public ResponseEntity manupulateStringMethod(@RequestParam("str") String str ){

        if(str == null || str.trim().isEmpty())
            return ResponseEntity.ok(Map.of("result", "Please enter a proper n valid string"));

        Map<String, String> result = manupulativeService.doOperation(str);

        log.info("result {}"+ result );

        return ResponseEntity.ok(result);
    }
}
