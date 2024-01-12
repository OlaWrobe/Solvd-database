package com.solvd.secondBlock.parsers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Jackson {
    public static void main(String[] args) throws IOException {

        File file = new File("src/main/resources/parsers/olympics.json");
        ObjectMapper mapper = new ObjectMapper();
        Olympics olympics = mapper.readValue(file, Olympics.class);
    }
}
