package org.com.labs.service;

import org.com.labs.mapper.FileMapper;
import org.com.labs.model.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

/**
 * Class responsible for reading and handling files based on the rules established in this challenge
 * **/
public class FileDecoderService {

    private final String filePath;

    public FileDecoderService(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Reads the file and return a hash map with the structured data
     * **/
    public HashMap<Integer, User> readFile() {

        try {

            BufferedReader reader = new BufferedReader(new FileReader(this.filePath));
            String line = reader.readLine();
            int lineNumber = 1;

            HashMap<Integer, User> map = new HashMap<>();

            /* For each line on the file we map and group the data for future process */
            while (line != null) {
                map = FileMapper.mapLine(line, map);
                line = reader.readLine();
                lineNumber++;
            }

            System.out.println(lineNumber + " registros processados!");
            return map;

        } catch (Exception e) {
            // TODO: Improve error handling
            System.out.println("Error!");
            return null;
        }

    }

}
