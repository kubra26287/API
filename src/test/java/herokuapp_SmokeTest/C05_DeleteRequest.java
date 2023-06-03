package herokuapp_SmokeTest;

import Base_Urls.HerOkuAppBase_Url;
import io.restassured.response.Response;
import org.junit.Test;

import static herokuapp_SmokeTest.C01_PostRequest.bookingId;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C05_DeleteRequest extends HerOkuAppBase_Url {
    /*
    Given
        https://restful-booker.herokuapp.com/booking/:id
    when
        Send delete request
    Then
        status code is 201
        And
        Body should be : "Created"

     */

    @Test
    public void delete() {
        //set the url
        spec.pathParams("first","booking","second",bookingId);

        //set the expected data
        String expectedData ="Created";

        //send the request get the response
        Response response =given(spec).delete("{first}/{second}");
        response.prettyPrint();

        //do assertion
        assertEquals(201,response.statusCode());
        assertEquals(expectedData,response.asString());

    }
}
