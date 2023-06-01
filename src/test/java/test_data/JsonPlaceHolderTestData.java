package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {
    
    public Map<String, Object> expectedDataMapMethod(Integer userId, String title, Boolean completed ){

        Map<String, Object> expectedData = new HashMap<>();
        if (userId!= null) {
            expectedData.put("userId", userId);
        }
        if (title!=null) {
            expectedData.put("title", title);
        }
        if (completed!=null) {
            expectedData.put("completed", completed);
        }
        
        return expectedData;

    }

    public static String expectedDatainString(int userId,String title,boolean completed){
        return  "{\"userId\": "+userId+",\n" +
                "  \"id\": 198,\n" +
                " \"title\": \""+title+"\",\n" +
                " \"completed\":"+completed+"}";

    }



}