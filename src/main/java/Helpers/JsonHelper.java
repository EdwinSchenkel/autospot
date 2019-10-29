package Helpers;

import Logging.Logging;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class JsonHelper {
    private static ObjectMapper mapper = new ObjectMapper();

    public static String toJson(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (Exception ex) {
            Logging.HandleError(ex);
        }

        return null;
    }

    public static <T> T fromJson(String json, T klasse) {
        try {
            return (T) mapper.readValue(json, klasse.getClass());
        } catch (Exception ex) {
            Logging.HandleError(ex);
        }

        return null;
    }

    public static <T> T fromJson(File json, T klasse) {
        try {
            return (T) mapper.readValue(json, klasse.getClass());
        } catch (Exception ex) {
            Logging.HandleError(ex);
        }

        return null;
    }
}
