package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class JsonArrayReader extends JsonReader{

    public static JSONArray getJsonArray(String key) throws IOException, ParseException {
        JSONObject jsonObject=getJsonData();
        JSONArray jsonArray=(JSONArray) jsonObject.get(key);
        return  jsonArray;

    }
    public static Object getJsonArrayData(String key ,int index) throws IOException, ParseException{
        JSONArray languages=getJsonArray("languages");
        return languages.get(index);


    }
}
