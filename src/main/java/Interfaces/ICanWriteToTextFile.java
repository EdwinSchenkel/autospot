package Interfaces;

import java.io.File;
import java.nio.file.Paths;

public interface ICanWriteToTextFile {
    final String sourcePath = Paths.get(System.getProperty("user.dir"), "Logs", "").toString();

    File OpenFile(String fileName);
    void WriteToFile(File file);
}
