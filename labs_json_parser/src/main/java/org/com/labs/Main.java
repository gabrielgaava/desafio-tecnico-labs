package org.com.labs;

import org.com.labs.mapper.HashMapper;
import org.com.labs.model.User;
import org.com.labs.service.FileDecoderService;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {


        System.out.println("============== Labs File Parser ============== ");
        String userPath;

        /* Verifies if the path was passed on execution arguments
        *  In case not, the path will be requested on the terminal
        * */
        if(args.length == 0){
            System.out.println("|> Informe o diretorio completo do arquivo: ");
            Scanner input = new Scanner(System.in);
            userPath = input.nextLine();
        }

        /* Using args path */
        else {
            userPath = args[0];
        }


        Path filePath = Paths.get(userPath);
        System.out.println("|> Diretorio: " + filePath);

        /* Reads the file and return the data formatted in a HashMap grouped by Users */
        FileDecoderService decoder = new FileDecoderService(filePath);
        HashMap<Integer, User> jsonMap = decoder.readFile();

        /* Transcode the HashMap to a JSON File */
        String json = HashMapper.toJson(jsonMap);
        decoder.createFile(json);

    }
}