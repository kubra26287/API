package herokuapp_SmokeTest;

import Base_Urls.HerOkuAppBase_Url;
import Utils.ObjectMapperUtils;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojoInner;
import pojos.BookingPojo;
import pojos.BookingResponsePojo;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C01_PostRequest extends HerOkuAppBase_Url {
    /*
    Given
    https://restful-booker.herokuapp.com/booking
    And
    {
    "firstname" : "Jim",
    "lastname" : "Brown",
    "totalprice" : 111,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2018-01-01",
        "checkout" : "2019-01-01"
    },
    "additionalneeds" : "Breakfast"
}
When
Send post request
Then
StatusCode is 200
And
Body:
{
    "bookingid": 3049,
    "booking": {
        "firstname": "Jim",
        "lastname": "Brown",
        "totalprice": 111,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2018-01-01",
            "checkout": "2019-01-01"
        },
        "additionalneeds": "Breakfast"
    }
     */
    public static int bookingId;
    @Test
    public void post01() {
        //set the Url
       spec.pathParam("first","booking");
       //set the expected data
        BookingDatesPojoInner bookingDatesPojoInner = new BookingDatesPojoInner("2018-01-01","2019-01-01");
      BookingPojo expectedData =  new BookingPojo("Jim","Brown",111,true,bookingDatesPojoInner, "Breakfast");
        System.out.println("expectedData = " + expectedData);
        //send the request get the response
       Response response = given(spec).body(expectedData).post("{first}");
       response.prettyPrint();
       //do assertion
     BookingResponsePojo actualData =ObjectMapperUtils.convertJsonToJava(response.asString(), BookingResponsePojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getFirstname(),actualData.getBooking().getFirstname());
        assertEquals(expectedData.getLastname(),actualData.getBooking().getLastname());
        assertEquals(expectedData.getTotalprice(),actualData.getBooking().getTotalprice());
        assertEquals(expectedData.getDepositpaid(),actualData.getBooking().getDepositpaid());
        assertEquals(expectedData.getBookingdates().getCheckin(),actualData.getBooking().getBookingdates().getCheckin());
        assertEquals(expectedData.getBookingdates().getCheckout(),actualData.getBooking().getBookingdates().getCheckout());
        assertEquals(expectedData.getAdditionalneeds(),actualData.getBooking().getAdditionalneeds());

       bookingId = response.jsonPath().getInt("bookingid");
    }
}
