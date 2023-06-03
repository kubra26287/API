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

public class C03_PutRequest extends HerOkuAppBase_Url {
    /*
    Given
    https://restful-booker.herokuapp.com/booking/:id
    And
    {
    "firstname": "Ali",
    "lastname": "Can",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "Breakfast"
}
When
Send put request
And
Body:
  {
    "firstname": "Ali",
    "lastname": "Can",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "Breakfast"
     */

    @Test
    public void put1() {
        //set the url
        spec.pathParams("first", "booking", "second", bookingId);

        //set the expected data
        BookingDatesPojoInner bookingDatesPojoInner = new BookingDatesPojoInner("2018-01-01", "2019-01-01");
        BookingPojo expectedData = new BookingPojo("Ali", "Can", 222, true, bookingDatesPojoInner, "Breakfast");
        System.out.println("expectedData = " + expectedData);

        //send the request get the response
        Response response = given(spec).body(expectedData).put("{first}/{second}");
        response.prettyPrint();

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
