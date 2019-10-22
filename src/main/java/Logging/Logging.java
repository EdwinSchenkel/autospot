package Logging;

import Business.bUser;
import Helpers.DataConnection;
import Helpers.FileWriterHelper;
import Helpers.JsonHelper;
import Models.Errorlogging;
import org.apache.commons.lang3.exception.ExceptionUtils;
import java.io.IOException;
import java.util.ArrayList;

public class Logging
{
    public static void LogMessage(String message)
    {
        var log = new Errorlogging();
        log.setMessage(message);
        log.setStacktrace("");
        log.setUserId(bUser.UserLoggedIn.getId());

        try (var db = new DataConnection())
        {
            db.insertObject(log.getClass(), log);
        }
        catch (Exception ex)
        {
            WriteErrorToTextFile(log);
            ex.printStackTrace();
        }
    }

    public static void HandleError(Exception ex)
    {
        var log = new Errorlogging();
        log.setMessage(ex.getMessage());
        log.setStacktrace(ExceptionUtils.getStackTrace(ex));
        log.setUserId(bUser.UserLoggedIn.getId());

        try (var db = new DataConnection())
        {
            db.insertObject(log.getClass(), log);
        }
        catch (Exception e)
        {
            WriteErrorToTextFile(log);
            e.printStackTrace();
        }
    }

    public static void HandleError(Exception ex, DataConnection _db)
    {
        var log = new Errorlogging();
        log.setMessage(ex.getMessage());
        log.setStacktrace(ExceptionUtils.getStackTrace(ex));
        log.setUserId(bUser.UserLoggedIn.getId());

        try (var db = new DataConnection(_db))
        {
            db.insertObject(log.getClass(), log);
        }
        catch (Exception e)
        {
            WriteErrorToTextFile(log);
            e.printStackTrace();
        }
    }

    private static void WriteErrorToTextFile(Errorlogging log)
    {
        var fwHelper = new FileWriterHelper();
        try
        {
            var listLogging = new ArrayList<Errorlogging>();
            var file = fwHelper.OpenFile("logging.json");

            var currentContent = JsonHelper.fromJson(file, listLogging);

            if(currentContent != null) listLogging.add(log);

            var content = JsonHelper.toJson(log);
            
            fwHelper.WriteToFile(file, content);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
