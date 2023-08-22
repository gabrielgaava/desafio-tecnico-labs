package service;

import org.com.labs.model.User;
import org.com.labs.service.FileDecoderService;
import org.junit.*;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class FileDecoderServiceTest {

    private final static String DATA_SRC = "src/test/resources/";

    @Test
    public void shouldReadFileWithSucess() throws IOException {

        Path filePath = Paths.get(DATA_SRC + "data_1.txt");
        FileDecoderService decoder = new FileDecoderService(filePath);
        HashMap<Integer, User> map = decoder.readFile();

        Assert.assertEquals(3, map.size());
    }

    @Test(expected = IOException.class)
    public void shouldThowExceptionWhenPahtIsNotValid() throws IOException {

        Path filePath = Paths.get("src/test/resources/data_2.txt");
        FileDecoderService decoder = new FileDecoderService(filePath);
        HashMap<Integer, User> map = decoder.readFile();
    }

    @Test
    public void shouldCreateOutputFileWithSucess() throws IOException {

        String fileContent = "{}";

        Path filePath = Paths.get(DATA_SRC + "data_1.txt");
        FileDecoderService decoder = new FileDecoderService(filePath);
        decoder.createFile(fileContent);

        File data1 = new File(DATA_SRC + "data_1.json");
        Assert.assertTrue(data1.delete());

    }

    @Test(expected = Exception.class)
    public void shouldThrowExceptioOnCreateFile() throws IOException {

        String fileContent = "{}";

        Path filePath = Paths.get("21312!@");
        FileDecoderService decoder = new FileDecoderService(filePath);
        decoder.createFile(fileContent);

    }

}
