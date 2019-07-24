package basic;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.HashMap;
import org.apache.log4j.Logger;

public class TestJSON {
    private static Logger logger = Logger.getLogger(TestJSON.class);

    public static void main(String[] args) {
        String jsonStr = "{'name':'xiaoming','age':12,'class':[{'name':'math'},{'name':'english'}]}";
        JSONObject jsonObject = new JSONObject(jsonStr);
        jsonObject.put("memo",String.valueOf("this is test."));
        logger.debug(jsonObject.get("name"));

        JSONArray jsonArray = (JSONArray)jsonObject.get("class");

        for(int i=0;i<jsonArray.length();i++){
            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
            logger.debug(jsonObject1.get("name"));
        }

        HashMap hashMap = new HashMap();
        hashMap.put("name","xiaowang");
        hashMap.put("age",13);
        JSONObject jsonObject2 = new JSONObject(hashMap);
        logger.debug(jsonObject2.get("name"));

    }
}
