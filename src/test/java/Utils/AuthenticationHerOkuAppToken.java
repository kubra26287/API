package Utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthenticationHerOkuAppToken {
    public static String generateToken(){
        String body ="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
    Response response = given().contentType(ContentType.JSON).body(body).post("https://restful-booker.herokuapp.com/auth");
    //response.prettyPrint();
    return response.jsonPath().getString("token");


    }
}
