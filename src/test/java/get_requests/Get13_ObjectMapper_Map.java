package get_requests;

import Base_Urls.JsonPlaceHolderBase_Url;
import Utils.ObjectMapperUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Get13_ObjectMapper_Map extends JsonPlaceHolderBase_Url {
    /*
    Given
        https://jsonplaceholder.typicode.com/todos/198
    When
         I send GET Request to the URL
     Then
         Status code is 200
         And response body is like {
                                    "userId": 10,
                                    "id": 198,
                                    "title": "quis eius est sint explicabo",
                                    "completed": true
                                  }
 */
    @Test
    public void get13() {
        //set the url
        spec.pathParams("first","todos","second",198);

        //set the expected Data
        String body = "{\"userId\": 10,\n" +
                "  \"id\": 198,\n" +
                " \"title\": \"quis eius est sint explicabo\",\n" +
                " \"completed\": true}";
        Map<String,Object> expectedData = ObjectMapperUtils.convertJsonToJava(body, HashMap.class);
        System.out.println("expectedData = " + expectedData);

       //send the request and get the response
     Response response = given(spec).get("{first}/{second}");
     response.prettyPrint();

     //do assertipn
        Map<String,Object> actualData =  ObjectMapperUtils.convertJsonToJava(response.asString(),HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.get("userId"),actualData.get("userId"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("completed"),actualData.get("completed"));



    }
}
