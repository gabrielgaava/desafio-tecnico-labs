package org.com.labs;

import org.com.labs.mapper.HashMapper;
import org.com.labs.model.User;
import org.com.labs.service.FileDecoderService;
import org.com.labs.utils.TerminalUI;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;


public class Main {
    public static void main(String[] args) {

        TerminalUI UI = new TerminalUI(args);
        UI.showAppHeader();
        String userPath = UI.getFilePath();
        boolean isMinified = UI.getMinified();

        Path filePath = Paths.get(userPath);
        UI.showAppHeader();
        UI.print("|> Diretorio: " + filePath);
        UI.print("|> Processando arquivos...");

        /* Reads the file and return the data formatted in a HashMap grouped by Users */
        FileDecoderService decoder = new FileDecoderService(filePath);
        HashMap<Integer, User> jsonMap = decoder.readFile();

        /* Transcode the HashMap to a JSON File and Minify it */
        String json = HashMapper.toJson(jsonMap);
        if(isMinified) json = json.replaceAll("\\s+", "");
        decoder.createFile(json);

    }
}