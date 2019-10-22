package Helpers;

import Interfaces.ICanWriteToTextFile;
import Logging.Logging;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class FileWriterHelper implements ICanWriteToTextFile
{
    @Override
    public File OpenFile(String fileName) throws IOException
    {
        File check = new File(sourcePath);
        if(!check.exists() && !check.isDirectory())
              check.mkdir();

        File f = new File(Paths.get(sourcePath, fileName).toString());
        if(f.exists())
            return f;
        else
        {
            f.createNewFile();
            return f;
        }
    }

    @Override
    public void WriteToFile(File file, String fileContent) throws IOException
    {
        if(file == null) throw new IllegalStateException("Geen file om naartoe te schrijven!");

        try (var writer = new FileWriter(file))
        {
            writer.write(fileContent);
            writer.flush();
        }
        catch (Exception ex)
        {
            Logging.HandleError(ex);
        }
    }

    public String FileContentToString(File file)
    {
        if(file == null) return null;

        try (FileReader fr = new FileReader(file))
        {
            var builder = new StringBuilder();
            int ch;
            while((ch = fr.read()) != -1)
                builder.append((char) ch);

            return builder.toString();
        }
        catch (Exception ex)
        {
            Logging.HandleError(ex);
        }

        return null;
    }
}
