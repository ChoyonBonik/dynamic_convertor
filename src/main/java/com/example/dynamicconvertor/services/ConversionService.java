package com.example.dynamicconvertor.services;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@Service
public class ConversionService {
	
	public String convertXmlToJson(String xmlData) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        
        JsonNode jsonNode = xmlMapper.readTree(xmlData.getBytes());
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(jsonNode);
    }

    public String convertJsonToXml(String jsonData) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonData);
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.writeValueAsString(jsonNode);
    }

}
