package herokuapp_SmokeTest;

import Base_Urls.HerOkuAppBase_Url;
import org.junit.Test;

import static herokuapp_SmokeTest.C01_PostRequest.bookingId;

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
        "additionalneeds": "Lunch"

     */

    @Test
    public void patch01() {
        //set the url
     spec.pathParams("first","booking","second",bookingId);

     //set the expected data
        

    }
}
