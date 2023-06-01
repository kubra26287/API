package get_requests;

import Base_Urls.HerOkuAppBase_Url;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojoInner;
import pojos.BookingPojo;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Get11 extends HerOkuAppBase_Url {
             /*
     Given
         https://restful-booker.herokuapp.com/booking/803
     When
    I send GET Request to the URL
   Then
    Status code is 200
And
    Response body is like:
              {
                     "firstname": "John",
                     "lastname": "Smith",
                     "totalprice": 111,
                     "depositpaid": true,
                     "bookingdates": {
                         "checkin": "2018-01-01",
                         "checkout": "2019-01-01"
                     },
                     "additionalneeds": "Breakfast"
                 }
  */

    @Test
    public void get11() {
        //set the url
        spec.pathParams("first","booking","second",11);
       //set the expected data
       BookingDatesPojoInner bookingDatesPojo =   new BookingDatesPojoInner("2018-01-01","2019-01-01");
       BookingPojo expectedData =  new BookingPojo("John","Smith",111,true,bookingDatesPojo,"Breakfast");
        System.out.println("expectedData = " + expectedData);

        //send the request get the response
      Response response = given(spec).get("{first}/{second}");
        System.out.println("response = " + response);

        //Do assertion
        BookingPojo actualData = response.as(BookingPojo.class);//De-Serialization
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getFirstname(), actualData.getFirstname());
        assertEquals(expectedData.getLastname(), actualData.getLastname());
        assertEquals(expectedData.getTotalprice(), actualData.getTotalprice());
        assertEquals(expectedData.getDepositpaid(), actualData.getDepositpaid());
        assertEquals(bookingDatesPojo.getCheckin(), actualData.getBookingdates().getCheckin());
        assertEquals(bookingDatesPojo.getCheckout(), actualData.getBookingdates().getCheckout());
        assertEquals(expectedData.getAdditionalneeds(), actualData.getAdditionalneeds());
    }
}
