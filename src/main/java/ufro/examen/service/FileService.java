package ufro.examen.service;

import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
@Service
public class FileService {
    public void generateTextFile(String fileName, String content) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        fileWriter.write(content);
        fileWriter.close();
    }
}
