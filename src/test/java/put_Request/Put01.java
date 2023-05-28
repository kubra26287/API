package put_Request;

import Base_Urls.JsonPlaceHolderBase_Url;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.Assert;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Put01 extends JsonPlaceHolderBase_Url {
       /*
    Given
     1) https://jsonplaceholder.typicode.com/todos/198
     2) {
             "userId": 21,
             "title": "Wash the dishes",
             "completed": false
           }
    When
I send PUT Request to the Url
 Then
      Status code is 200
      And response body is like   {
                   "userId": 21,
                   "title": "Wash the dishes",
                   "completed": false
                   "id": 198
                  }
  */

    @Test
    public void put01() {
        //set the url
        spec.pathParams("first","todos","second",198);
        //set the expected data
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("userId",21);
        expectedData.put("title","Wash the dishes");
        expectedData.put("completed",false);
        System.out.println("expectedData = " + expectedData);

        //send the request get the response
       Response response = given(spec).body(expectedData).put("{first}/{second}");
       response.prettyPrint();

       //do assertion
       Map<String,Object>  actualData = response.as(HashMap.class);
        System.out.println("actualData = " + actualData);

        Assert.assertEquals(200,response.statusCode());
        Assert.assertEquals(expectedData.get("completed"),actualData.get("completed"));
        Assert.assertEquals(expectedData.get("title"),actualData.get("title"));
        Assert.assertEquals(expectedData.get("userId"),actualData.get("userId"));

    }

    @Test
    public void put01B() {
        //set the url
        spec.pathParams("first","todos","second",198);
        //set the expected data
        Map<String,Object> expectedData =  new JsonPlaceHolderTestData()
                .expectedDataMapMethod(21,"Wash the dishes",false);
        //test1 deki farki; sadece set the expected i Method yaparak o methodu cagirarak olusturduk.

        //send the request get the response
        Response response = given(spec).body(expectedData).put("{first}/{second}");
        response.prettyPrint();

        //do assertion
        Map<String,Object>  actualData = response.as(HashMap.class);
        System.out.println("actualData = " + actualData);

        Assert.assertEquals(200,response.statusCode());
        Assert.assertEquals(expectedData.get("completed"),actualData.get("completed"));
        Assert.assertEquals(expectedData.get("title"),actualData.get("title"));
        Assert.assertEquals(expectedData.get("userId"),actualData.get("userId"));
    }
}
