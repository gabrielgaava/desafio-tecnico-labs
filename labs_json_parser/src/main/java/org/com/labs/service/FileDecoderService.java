package org.com.labs.service;

import org.com.labs.mapper.FileMapper;
import org.com.labs.model.User;

import java.io.*;
import java.nio.file.Path;
import java.util.HashMap;

/**
 * Class responsible for reading and handling files based on the rules established in this challenge
 * **/
public class FileDecoderService {

    private final Path filePath;

    public FileDecoderService(Path filePath) {
        this.filePath = filePath;
    }

    /**
     * Reads the file and return a hash map with the structured data
     * **/
    public HashMap<Integer, User> readFile() {

        try {

            BufferedReader reader = new BufferedReader(new FileReader(this.filePath.toString()));
            String line = reader.readLine();
            int lineNumber = 1;

            HashMap<Integer, User> map = new HashMap<>();

            /* For each line on the file we map and group the data for future process */
            while (line != null) {
                map = FileMapper.mapLine(line, map);
                line = reader.readLine();
                lineNumber++;
            }

            System.out.println("|> " + lineNumber + " registros processados!");
            return map;

        } catch (Exception e) {
            System.out.println("|> 🚨 Erro ao ler aquivo. Verifique o diretório e tente novamente!");
            return null;
        }

    }

    /**
     * Creates the JSON file with de data formatted in the same previous informed path
     * @param fileContent: The String with the JSON data
     * **/
    public void createFile(String fileContent) {

        /* Creating the new file path */
        String fileName = this.filePath.getFileName().toString().replace("txt", "json");
        String root = this.filePath.getParent().toString();
        String newFilePath = root + File.separator + fileName;

        try {

            FileWriter fileWriter = new FileWriter(newFilePath);
            fileWriter.write(fileContent);
            fileWriter.close();
            System.out.println("|> Arquivo formatado gerado em: " + newFilePath);

        } catch (IOException exception) {
            System.out.println(exception.getMessage());
            return;
        }

    }

}
