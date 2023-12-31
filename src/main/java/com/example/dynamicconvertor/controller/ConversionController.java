package com.example.dynamicconvertor.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dynamicconvertor.services.ConversionService;
import com.fasterxml.jackson.core.JsonProcessingException;


@RestController
@RequestMapping("/converter")
public class ConversionController {
	
	@Autowired
    private ConversionService conversionService;

    @PostMapping("/xml-to-json")
    public ResponseEntity<String> convertXmlToJson(@RequestBody String xmlData) throws IOException {
        String jsonData = conversionService.convertXmlToJson(xmlData);
        return ResponseEntity.ok(jsonData);
    }

    @PostMapping("/json-to-xml")
    public ResponseEntity<String> convertJsonToXml(@RequestBody String jsonData) throws JsonProcessingException {
        String xmlData = conversionService.convertJsonToXml(jsonData);
        return ResponseEntity.ok(xmlData);
    }

}
