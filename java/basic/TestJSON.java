package basic;
import org.json.JSONArray;
import org.json.JSONObject;

public class TestJSON {
    public static void main(String[] args) {
        String jsonStr = "{'name':'xiaoming','age':12,'class':[{'name':'math'},{'name':'english'}]}";
        JSONObject jsonObject = new JSONObject(jsonStr);
        System.out.println(jsonObject.get("name"));

        JSONArray jsonArray = (JSONArray)jsonObject.get("class");

        for(int i=0;i<jsonArray.length();i++){
            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
            System.out.println(jsonObject1.get("name"));

        }

    }
}
