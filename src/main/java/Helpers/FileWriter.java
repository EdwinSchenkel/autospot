package Helpers;

import Interfaces.ICanWriteToTextFile;

import java.io.File;

public class FileWriter implements ICanWriteToTextFile
{
    @Override
    public File OpenFile(String fileName) {
        return null;
    }

    @Override
    public void WriteToFile(File file) {

    }
}
