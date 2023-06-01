package post_Request;

import Base_Urls.JsonPlaceHolderBase_Url;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Post05_ObjectMapper extends JsonPlaceHolderBase_Url {
    /*
       Given
         1) https://jsonplaceholder.typicode.com/todos
         2) {
               "userId": 55,
               "title": "Tidy your room",
               "completed": false
             }


          I send POST Request to the Url
      Then
          Status code is 201
      And
          response body is like {
                                  "userId": 55,
                                  "title": "Tidy your room",
                                  "completed": false,
                                  "id": 201
                                  }
   */
    @Test
    public void post05() throws JsonProcessingException {
        //set the url
        spec.pathParams("first","todos");
        //set the expected data
        Map<String ,Object> expectedData = new JsonPlaceHolderTestData().expectedDataMapMethod(55,"Tidy your room",false);
        System.out.println("expectedData = " + expectedData);

        //send the request get the
      Response response = given(spec).body(expectedData).post("{first}");
      response.prettyPrint();

      //do assertion
        // new ObjectMapper().readValue() methodu ile birinci paramterede belirtilen String datayı ikinci paramterede belirtilen data türnüe çeviriyoruz.
      Map<String,Object> actualData =  new ObjectMapper().readValue(response.asString(), HashMap.class);
        System.out.println("actualData = " + actualData);
        assertEquals(201, response.statusCode());
        assertEquals(expectedData.get("completed"), actualData.get("completed"));
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("userId"), actualData.get("userId"));
    }
}
