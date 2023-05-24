package get_requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Get03 {
        /*
      Given
          https://jsonplaceholder.typicode.com/todos/23
      When
          User send GET Request to the URL
      Then
          HTTP Status Code should be 200
And
    Response format should be "application/json"
And
    "title" is "et itaque necessitatibus maxime molestiae qui quas velit",
And
    "completed" is false
And
    "userId" is 2
   */

    @Test
    public void get03() {
        //Set the Url
        String url = "https://jsonplaceholder.typicode.com/todos/23";
        //set the expected data

        //send the request and get the response
       Response response = given().get(url);
       response.prettyPrint();

       //do assertion
        //1. yol;  Hard assertion
        response.then()
                .statusCode(200)
                .contentType("application/json")
                .body("userId",equalTo(2))
                .body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit"))
                .body("completed",equalTo(false));


        //2. yol; Soft ASSERTION : TEK BODY ICINDE YAZILINCA SOFT OLUYOR
        response.then().statusCode(200)
                .contentType(ContentType.JSON)
                .body("userId",equalTo(2),
                        "title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
                        "completed",equalTo(false));


        //Tek body() methodu içinde çoklu assertion yaparak "soft assertion" yapabiliriz. Tüm fail durumları hakkında bilgi alabiliriz.
        //Çoklu body() methodları içinde tek assertion yaparak "hard assertion" yaparız. İlk fail durumunda çalışma durur ve sonraki assetionlar hakkında bilgi alamayız.



    }
}
