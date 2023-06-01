package Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperUtils {
    // <T> T --> Herhangi bir data tipini temsil eder.
    //ReadValue methodu: 1. parametrede belirtilen String json datayi ikinci parametrede belirtilen data tipine cevirir.


   public  static <T> T convertJsonToJava(String json,Class<T> cls){//Generic Method böyledir
       try {
           return new ObjectMapper().readValue(json,cls);
       } catch (JsonProcessingException e) {
           throw new RuntimeException(e);
       }
   }
}
//        Map<String, Object> actualData = new ObjectMapper().readValue(response.asString(), HashMap.class);
