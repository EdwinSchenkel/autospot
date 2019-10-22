package Logging;

import Business.bUser;
import Helpers.DataConnection;
import Interfaces.ICanWriteToTextFile;
import Models.Errorlogging;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.io.File;

public class Logging implements ICanWriteToTextFile
{
    public static void LogMessage(String message)
    {

    }

    public static void HandleError(Exception ex)
    {
        try (var db = new DataConnection())
        {
            var log = new Errorlogging();
            log.setMessage(ex.getMessage());
            log.setStacktrace(ExceptionUtils.getStackTrace(ex));
            log.setUserId(bUser.UserLoggedIn.getId());

            db.insertObject(log.getClass(), log);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void HandleError(Exception ex, DataConnection _db)
        {
        try (var db = new DataConnection(_db))
        {
            var log = new Errorlogging();
            log.setMessage(ex.getMessage());
            log.setStacktrace(ExceptionUtils.getStackTrace(ex));
            log.setUserId(bUser.UserLoggedIn.getId());

            db.insertObject(log.getClass(), log);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void WriteErrorToTextFile(Errorlogging log)
    {

    }

    @Override
    public File OpenFile(String fileName) {
        return null;
    }

    @Override
    public void WriteToFile(String fileContent) {

    }
}
