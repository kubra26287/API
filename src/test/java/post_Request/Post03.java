package post_Request;

import Base_Urls.JsonPlaceHolderBase_Url;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Post03 extends JsonPlaceHolderBase_Url {
        /*
    Given
       https://jsonplaceholder.typicode.com/todos
       {
       "userId": 55,
       "title": "Tidy your room",
       "completed": false
       }
   When
       I send POST Request to the Url
   Then
       Status code is 201
   And
       response body is like {
                               "userId": 55,
                               "title": "Tidy your room",
                               "completed": false,
                               "id": 201
                               }
*/

    @Test
    public void post03() {
        //SEt the Url
        spec.pathParam("first","todos");
        //Set the expected Data
     JsonPlaceHolderPojo expectedData =   new JsonPlaceHolderPojo(55,"Tidy your room",false);
        System.out.println("expectedData = " + expectedData);

        //send the request and get the response
       Response response = given(spec).body(expectedData).post("{first}");
       response.prettyPrint();

       //do assert
      JsonPlaceHolderPojo actualData =  response.as(JsonPlaceHolderPojo.class);
        System.out.println("actualData = " + actualData);
        assertEquals(201,response.statusCode());
        assertEquals(expectedData.getUserId(),actualData.getUserId());
        assertEquals(expectedData.getTitle(),actualData.getTitle());
        assertEquals(expectedData.getCompleted(),actualData.getCompleted());

    }
}
