package herokuapp_SmokeTest;

import Base_Urls.HerOkuAppBase_Url;
import io.restassured.response.Response;
import org.junit.Test;

import static herokuapp_SmokeTest.C01_PostRequest.bookingId;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C06_GetRequest_Negative extends HerOkuAppBase_Url {
    /*
    Given
            https://restful-booker.herokuapp.com/booking/:id
   When
   Send get request
   Then
   Status code is 404
   And
   Body is "Not Found"
     */

    @Test
    public void C06get() {
        //set the url
        spec.pathParams("first","booking","second",bookingId);
        //set the expected data
        String expectedData = "Not Found";
        //send the request get the response
        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        //do assertion
        assertEquals(404,response.statusCode());
        assertEquals(expectedData,response.asString());
    }
}
