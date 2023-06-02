package get_requests;

import Base_Urls.JsonPlaceHolderBase_Url;
import Utils.ObjectMapperUtils;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;
import test_data.JsonPlaceHolderTestData;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Get13_ObjectMapper_Pojo extends JsonPlaceHolderBase_Url {
      /*
       Given
           https://jsonplaceholder.typicode.com/todos/198
       When
            I send GET Request to the URL
        Then
            Status code is 200
            And response body is like {
                                       "userId": 10,
                                       "id": 198,
                                       "title": "quis eius est sint explicabo",
                                       "completed": true
                                     }

       */
    @Test
    public void get13() {
        //set the url
        spec.pathParams("first","todos","second",198);
        //set the expected Data
        String body = JsonPlaceHolderTestData.expectedDatainString(10,"quis eius est sint explicabo",true);
       JsonPlaceHolderPojo expextedData = ObjectMapperUtils.convertJsonToJava(body,JsonPlaceHolderPojo.class);
        System.out.println("expextedData = " + expextedData);

        //send the
       Response response = given(spec).get("{first}/{second}");
       response.prettyPrint();

       //Do assertion
     JsonPlaceHolderPojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(),JsonPlaceHolderPojo.class);
        System.out.println("actualData = " + actualData);
        assertEquals(200,response.statusCode());
        assertEquals(expextedData.getUserId(),actualData.getUserId());
        assertEquals(expextedData.getTitle(),actualData.getTitle());
        assertEquals(expextedData.getCompleted(),actualData.getCompleted());

    }
}
