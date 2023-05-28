package post_Request;

import Base_Urls.HerOkuAppBase_Url;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_data.HerOkuAppTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Post02 extends HerOkuAppBase_Url {
           /*
   Given
       1) https://restful-booker.herokuapp.com/booking
       2) {
            "firstname": "John",
            "lastname": "Doe",
            "totalprice": 11111,
            "depositpaid": true,
            "bookingdates": {
                "checkin": "2021-09-09",
                "checkout": "2021-09-21"
             }
          }
   When
       I send POST Request to the Url
   Then
       Status code is 200
       And response body should be like {
                                           "bookingid": 5315,
                                           "booking": {
                                               "firstname": "John",
                                               "lastname": "Doe",
                                               "totalprice": 11111,
                                               "depositpaid": true,
                                               "bookingdates": {
                                                   "checkin": "2021-09-09",
                                                   "checkout": "2021-09-21"
                                               }
                                           }
                                        }
*/

    @Test
    public void pos02() {
    //Set the Url
        spec.pathParam("first", "booking");

        //Set the expected data
        HerOkuAppTestData obj = new HerOkuAppTestData();
        Map<String, String> bookingdatesMap =  obj.bookingdatesMapMethod("2021-09-09", "2021-09-21" );
        Map<String, Object> expectedData = obj.expectedDataMethod("John","Doe",11111, true, bookingdatesMap,null);

        System.out.println("expectedData = " + expectedData);

        //send the request and get the respons
      Response response = given(spec).body(expectedData).post("{first}");
      response.prettyPrint();

      //do assertion
       Map<String , Object> actualData =  response.as(HashMap.class);
        System.out.println("actualData = " + actualData);
        Assert.assertEquals(200,response.statusCode());
        Assert.assertEquals(expectedData.get("firstname"),((Map)actualData.get("booking")).get("firstname"));
        Assert.assertEquals(expectedData.get("lastname"),((Map)actualData.get("booking")).get("lastname"));
        Assert.assertEquals(expectedData.get("totalprice"),((Map)actualData.get("booking")).get("totalprice"));
        Assert.assertEquals(expectedData.get("depositpaid"),((Map)actualData.get("booking")).get("depositpaid"));
        Assert.assertEquals(bookingdatesMap.get("checkout"),((Map)((Map)actualData.get("booking")).get("bookingdates")).get("checkout"));
        Assert.assertEquals(bookingdatesMap.get("checkin"),((Map)((Map)actualData.get("booking")).get("bookingdates")).get("checkin"));


    }
    
}
