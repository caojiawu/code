package basic;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.HashMap;

public class TestJSON {
    public static void main(String[] args) {
        String jsonStr = "{'name':'xiaoming','age':12,'class':[{'name':'math'},{'name':'english'}]}";
        JSONObject jsonObject = new JSONObject(jsonStr);
        jsonObject.put("memo",String.valueOf("this is test."));
        System.out.println(jsonObject.get("name"));

        JSONArray jsonArray = (JSONArray)jsonObject.get("class");

        for(int i=0;i<jsonArray.length();i++){
            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
            System.out.println(jsonObject1.get("name"));
        }

        HashMap hashMap = new HashMap();
        hashMap.put("name","xiaowang");
        hashMap.put("age",13);
        JSONObject jsonObject2 = new JSONObject(hashMap);
        System.out.println(jsonObject2.get("name"));
    }
}
