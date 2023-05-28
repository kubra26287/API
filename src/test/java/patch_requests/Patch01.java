package patch_requests;

import Base_Urls.JsonPlaceHolderBase_Url;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Patch01 extends JsonPlaceHolderBase_Url {
         /*
    Given
     1) https://jsonplaceholder.typicode.com/todos/198
     2) {
             "title": "Wash the dishes"
           }
    When
I send PATCH Request to the Url
 Then
      Status code is 200
      And response body is like   {
                   "userId": 10,
                   "title": "Wash the dishes",
                   "completed": true,
                   "id": 198
                   }
 */

    @Test
    public void patch01() { //Patch request kismi guncelleme (Update)
        //set the url
        spec.pathParams("first","todos","second",198);

        //set the expected data
       JsonPlaceHolderTestData obj = new JsonPlaceHolderTestData();
      Map<String,Object> expectedData = obj.expectedDataMapMethod(null,"Wash the dishes",null);
        System.out.println("expectedData = " + expectedData);

        //send the request end get the response
       Response response =  given(spec).body(expectedData).patch("{first}/{second}");
       response.prettyPrint();

        // Eger Tüm data assert edilecekse put ile ekleriz
        expectedData.put("userId", 10);
        expectedData.put("completed", true);

       //Do assertion
      Map<String,Object> actualData =  response.as(HashMap.class);
        System.out.println("actualData = " + actualData);
        assertEquals(200,response.statusCode());
        assertEquals(expectedData.get("title"),actualData.get("title"));

        //eger tüm data assert edilecekse asagidakileri yapariz
        assertEquals(expectedData.get("userId"), actualData.get("userId"));
        assertEquals(expectedData.get("completed"), actualData.get("completed"));
    }
}
