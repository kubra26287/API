package herokuapp_SmokeTest;

import Base_Urls.HerOkuAppBase_Url;
import Utils.ObjectMapperUtils;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.HerOkuAppTestData;

import java.util.HashMap;
import java.util.Map;

import static herokuapp_SmokeTest.C01_PostRequest.bookingId;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C04_PatchRequest extends HerOkuAppBase_Url {
    /*
    Given
    https://restful-booker.herokuapp.com/booking/:id

   And

   {
    "additionalneeds": "Lunch"
    }
When
send patch request
Then
status Code is 200
and
body:
  {
        "firstname": "Ali",
        "lastname": "Can",
        "totalprice": 222,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2018-01-01",
            "checkout": "2019-01-01"
        },
        "depositpaid": true
        "additionalneeds": "Lunch"


     */

    @Test
    public void patch01() {
        //set the url
     spec.pathParams("first","booking","second",bookingId);

     //set the expected data
   Map<String,Object> expectedData = new HerOkuAppTestData().expectedDataMethod(null,null,null,true,null,"Lunch");
        System.out.println("expectedData = " + expectedData);


    }

    @Test
    public void patch02() {
        //set the url
        spec.pathParams("first","booking","second",bookingId);

        //set the expected data
        Map<String,Object> expectedData = new HashMap<>();
        expectedData.put("additionalneeds","Lunch");
        System.out.println("expectedData = " + expectedData);

        //send the request get the response
    Response response = given(spec).body(expectedData).patch("{first}/{second}");
    response.prettyPrint();

    //do assertion
    Map<String,Object> actualData = ObjectMapperUtils.convertJsonToJava(response.asString(),HashMap.class);
        System.out.println("actualData = " + actualData);
        assertEquals(200,response.statusCode());
    assertEquals(expectedData.get("additionalneeds"),actualData.get("additionalneeds"));


    }
}
