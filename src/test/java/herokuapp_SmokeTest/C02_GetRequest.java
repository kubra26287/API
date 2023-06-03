package herokuapp_SmokeTest;

import Base_Urls.HerOkuAppBase_Url;
import Utils.ObjectMapperUtils;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojoInner;
import pojos.BookingPojo;

import static herokuapp_SmokeTest.C01_PostRequest.bookingId;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C02_GetRequest extends HerOkuAppBase_Url {
    /*
    Given
    https://restful-booker.herokuapp.com/booking/
    
    When
    send get request
    
    Then
    status code is 200
    
    And
    Body:
    {  "firstname": "Jim",
    "lastname": "Brown",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "Breakfast"}

     */

    @Test
    public void get01() {
        //set the Url
        spec.pathParams("first","booking","second",bookingId);

        //set the expected data
        BookingDatesPojoInner bookingDatesPojoInner = new BookingDatesPojoInner("2018-01-01","2019-01-01");
        BookingPojo expectedData =  new BookingPojo("Jim","Brown",111,true,bookingDatesPojoInner, "Breakfast");
        System.out.println("expectedData = " + expectedData);

        //send the request get the response
      Response response = given(spec).get("{first}/{second}");
      response.prettyPrint();

      //do assertion
      BookingPojo actualData =  ObjectMapperUtils.convertJsonToJava(response.asString(),BookingPojo.class);
        System.out.println("actualData = " + actualData);
        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getFirstname(),actualData.getFirstname());
        assertEquals(expectedData.getLastname(),actualData.getLastname());
        assertEquals(expectedData.getTotalprice(),actualData.getTotalprice());
        assertEquals(expectedData.getDepositpaid(),actualData.getDepositpaid());
        assertEquals(expectedData.getBookingdates().getCheckin(),actualData.getBookingdates().getCheckin());
        assertEquals(expectedData.getBookingdates().getCheckout(),actualData.getBookingdates().getCheckout());
        assertEquals(expectedData.getAdditionalneeds(),actualData.getAdditionalneeds());
    }
}
