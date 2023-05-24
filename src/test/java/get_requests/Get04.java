package get_requests;

import Base_Urls.JsonPlaceHolderBase_Url;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

/*
   Given
       https://jsonplaceholder.typicode.com/todos
   When
  I send a GET request to the Url
And
    Accept type is "application/json"
Then
    HTTP Status Code should be 200
And
    Response format should be "application/json"
And
    There should be 200 todos => toplam 200 todos olması gerekir
And
    "quis eius est sint explicabo" should be one of the todos title => todos başlıklarından en az birinin "quis eius est sint explicabo" olması gerekir
And
    2, 7, and 9 should be among the userIds => userId değerleri arasında 2, 7 ve 9 bulunmalıdır
*/
public class Get04 extends JsonPlaceHolderBase_Url {
    @Test
    public void get04() {
        //set the Url
     //   String url = "https://jsonplaceholder.typicode.com/todos";  bu tavsiye edilmiyor
        spec.pathParam("first","todos");

       //Set the expected data

        //send the request get the reponses
       Response response =  given(spec).get("{first}");
       response.prettyPrint();

       //Do assertion
        response.then().statusCode(200).contentType(ContentType.JSON)
                .body("id",hasSize(200))
                .body("titel",hasItem( "quis eius est sint explicabo"))
                .body("userId",hasItems(2,7,9));

        //HasSize() ; Datanin eleman sayisini assert eder.
        // hasItem() methodu contains() gibi tek bir objenin içerilip içrilmediğini assert eder.
        // hasItems() methodu containsAll() gibi çoklu objelerin içerilip içrilmediğini assert eder.



    }
}
