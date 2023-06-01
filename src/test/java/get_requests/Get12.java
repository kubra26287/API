package get_requests;

import Base_Urls.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.GorestDataPojo;
import pojos.GorestPojo;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Get12 extends GoRestBaseUrl {
        /*
    Given
        https://gorest.co.in/public/v1/users/2587
    When
        User send GET Request to the URL
    Then
        Status Code should be 200
    And
        Response body should be like
            {
                "meta": null,
                "data": {
                    "id": 2587,
                    "name": "Ganapati Prajapat",
                    "email": "prajapat_ganapati@okeefe.org",
                    "gender": "female",
                    "status": "active"
                }
            }
*/

    @Test
    public void get12() {
        //set the url
        spec.pathParams("first","users","second",2587);
        //set the expected data
     GorestDataPojo gorestDataPojo =   new GorestDataPojo("Ganapati Prajapat","prajapat_ganapati@okeefe.org","female","active");
     GorestPojo expectedData = new GorestPojo(null,gorestDataPojo);
        System.out.println("expectedData = " + expectedData);

        //send the request get the response
       Response response = given(spec).get("{first}/{second}");
       response.prettyPrint();
       //Do assertion
        GorestPojo actualData = response.as(GorestPojo.class);
        System.out.println("actualData = " + actualData);
        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getData(),actualData.getData());
        assertEquals(expectedData.getMeta(),actualData.getMeta());
        assertEquals(gorestDataPojo.getName(),actualData.getData().getName());
        assertEquals(gorestDataPojo.getEmail(),actualData.getData().getEmail());
        assertEquals(gorestDataPojo.getGender(),actualData.getData().getGender());
        assertEquals(gorestDataPojo.getStatus(),actualData.getData().getStatus());

    }
}
