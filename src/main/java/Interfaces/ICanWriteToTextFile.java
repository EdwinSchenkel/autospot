package Interfaces;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public interface ICanWriteToTextFile {
    String sourcePath = Paths.get(System.getProperty("user.dir"), "Logs", "").toString();

    File OpenFile(String fileName);
    void WriteToFile(String fileContent) throws IOException;
}
