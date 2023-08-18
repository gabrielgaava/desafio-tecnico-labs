package org.com.labs;

import org.com.labs.model.User;
import org.com.labs.service.FileDecoderService;

import java.util.HashMap;


public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        FileDecoderService decoder = new FileDecoderService("C:\\Users\\nerog\\Downloads\\data_1.txt");
        HashMap<Integer, User> jsonMapper = decoder.readFile();

        //TODO: Format data to output as a JSON file

    }
}