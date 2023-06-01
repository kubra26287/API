package delete_requests;

import Base_Urls.JsonPlaceHolderBase_Url;
import Utils.ObjectMapperUtils;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Delete01 extends JsonPlaceHolderBase_Url {
         /*
        Given
            https://jsonplaceholder.typicode.com/todos/198
        When
         I send DELETE Request to the Url
      Then
         Status code is 200
         And Response body is { }
     */

    @Test
    public void delete01() {
    //set the Url
        spec.pathParams("first","todos","second",198);

        //set the expected Data
        Map<String ,String > expectedData= new HashMap<>();

       //send the request get the Url
     Response response = given(spec).delete("{first}/{second}");
     response.prettyPrint();

     //do Assertion
      Map<String ,String > actualData = ObjectMapperUtils.convertJsonToJava(response.asString(),HashMap.class);
        System.out.println("actualData = " + actualData);
        assertEquals(200,response.statusCode());
      //  1. yol
        assertEquals(0,actualData.size());

        //2.yol
        assertTrue(actualData.isEmpty());

        //3. yol
        assertEquals(expectedData,actualData);
    }

}
