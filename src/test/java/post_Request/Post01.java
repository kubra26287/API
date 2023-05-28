package post_Request;

import Base_Urls.JsonPlaceHolderBase_Url;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class Post01 extends JsonPlaceHolderBase_Url {
    /*
         Given
           1)  https://jsonplaceholder.typicode.com/todos
           2)  {
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
    public void post01(){
        //set the url
        spec.pathParam("first","todos");
        //Set the expected data  //1. oncelikle java formatinda gonderilmesi gerekir bunun icinde Json datayi String e ceviriyoruz
     String payload = "{\n" +   //String ile post yapmak kolaydir fakar assert islemi icin tavsiye edilmez.as
             "\"userId\": 55,\n" +
             "\"title\": \"Tidy your room\",\n" +
             "\"completed\": false\n" +
             "}";
     //sen the request and get the response
       Response response = given(spec).contentType(ContentType.JSON).body(payload).post("{first}");
       response.prettyPrint();

     //Do assertion
        assertEquals(201,response.statusCode());
        JsonPath jsonPath = response.jsonPath();
        assertEquals(55,jsonPath.getInt("userId"));
        assertEquals("Tidy your room", jsonPath.getString("title"));
        assertFalse(jsonPath.getBoolean("completed"));

    }

    @Test
    public void post01Map() {
        //set the url
        spec.pathParam("first","todos");
        //Set the expected data
        Map<String,Object> expectedData = new HashMap<>();
        expectedData.put("userId",55);
        expectedData.put("title","Tidy your room");
        expectedData.put("completed",false);
        System.out.println("expectedData = " + expectedData);
        //Send the request get the response
       Response response = given(spec).body(expectedData).post("{first}");   //serialization islemi yapildi:Java objesi Jackson vasitasiyla Json data ya cevrildi (Jackson pomxml e yuklenerek)

      //do assertion
        Map<String,Object> actualData = response.as(HashMap.class); //De-Serialization islemi yapildi Json datayi java objesi map e cevirdik. Jackson vasitasiyla
        System.out.println("actualData = " + actualData);
        assertEquals(201,response.statusCode());
        assertEquals(expectedData.get("completed"),actualData.get("completed"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("userId"),actualData.get("userId"));


    }
}
