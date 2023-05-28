package get_requests;

import Base_Urls.JsonPlaceHolderBase_Url;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Get08 extends JsonPlaceHolderBase_Url {
        /*
    Given
       https://jsonplaceholder.typicode.com/todos/2
   When
       I send GET Request to the URL
   Then
       Status code is 200
       And "completed" is false
       And "userId" is 1
       And "title" is "quis ut nam facilis et officia qui"
       And header "Via" is "1.1 vegur"
       And header "Server" is "cloudflare"
       {
           "userId": 1,
           "id": 2,
           "title": "quis ut nam facilis et officia qui",
           "completed": false
       }
*/

    @Test
    public void get08() {
        //set the Url
        spec.pathParams("first","todos","second",2);

        //set the expected Data
        JsonPlaceHolderTestData obj = new JsonPlaceHolderTestData();
        Map<String,Object> expectedData = obj.expectedDataMapMethod(1,"quis ut nam facilis et officia qui",false);

        expectedData.put("Via", "1.1 vegur");
        expectedData.put("Server", "cloudflare"); //burada expecteddata methoduna  put ile yeni datalar ekledik
        //Set expected daha kisminda degikenler olur, assert kisminda sabit degerler olur

        System.out.println("expectedData = " + expectedData);

        //send the request get the response
      Response response = given(spec).get("{first}/{second}");
      response.prettyPrint();

       //Do assertion
       Map<String,Object> actualData = response.as(HashMap.class);
        Assert.assertEquals(200,response.statusCode());
        Assert.assertEquals(expectedData.get("userId"),actualData.get("userId"));
        Assert.assertEquals(expectedData.get("title"),actualData.get("title"));
        Assert.assertEquals(expectedData.get("completed"),actualData.get("completed"));


        //            And header "Via" is "1.1 vegur"
        assertEquals(expectedData.get("Via"), response.header("Via")); //assertion islemini sabit degerlerle yapmaliyiz

        //            And header "Server" is "cloudflare"
        assertEquals(expectedData.get("Server"), response.header("Server"));
    }
}
