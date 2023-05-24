package get_requests;

import Base_Urls.HerOkuAppBase_Url;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Get06 extends HerOkuAppBase_Url {
       /*
  Given
      https://restful-booker.herokuapp.com/booking/23
  When
      User send a GET request to the URL
  Then
      HTTP Status Code should be 200
  And
      Response content type is "application/json"
  And
      Response body should be like;
           {
              "firstname": "Josh",
              "lastname": "Allen",
              "totalprice": 111,
              "depositpaid": true,
              "bookingdates": {
                  "checkin": "2018-01-01",
                  "checkout": "2019-01-01"
              },
              "additionalneeds": "super bowls"
           }
*/

    @Test
    public void get06() {
        //Set the url
        spec.pathParams("first","booking","second",837);

        //Send the request get the response
       Response response = given(spec).get("{first}/{second}");
       response.prettyPrint();

       //Do assertion
        //1.yol
        response.then().statusCode(200).body("firstname",equalTo("Josh"),
                "lastname",equalTo("Allen"),
                "totalprice",equalTo(111),
                "depositpaid",equalTo(true),
                "bookingdates.checkin",equalTo("2018-01-01"),
                "bookingdates.checkout",equalTo("2019-01-01"),
                "additionalneeds",equalTo("super bowls"));

        //2.yol
       JsonPath jsonPath = response.jsonPath(); //jsonPath() methodu ile response i JsonPath objesine cevirdik.

        //JsonPath objesi ile  dataya spesifik olarak ulasabiliriz
       Assert.assertEquals(111,jsonPath.getInt("totalprice"));
       Assert.assertEquals("Josh",jsonPath.getString("firstname"));
       Assert.assertEquals("Allen",jsonPath.getString("lastname"));
       Assert.assertEquals("2018-01-01",jsonPath.getString("bookingdates.checkin"));
       Assert.assertEquals("2019-01-01",jsonPath.getString("bookingdates.checkout"));
       Assert.assertEquals("super bowls",jsonPath.getString( "additionalneeds"));
       Assert.assertTrue(jsonPath.getBoolean("depositpaid"));

        //3.yol
        //TestNg soft assertion ile
        //Soft assertion adimlari
        //1 softAssert objesi olustur
        SoftAssert softAssert =new SoftAssert();
        //2 assertion yap
        softAssert.assertEquals(jsonPath.getString("firstname"),"Josh","firstname uyuşmadı");
        softAssert.assertEquals(jsonPath.getString("lastname"),"Allen","lastname uyuşmadı");
        softAssert.assertEquals(jsonPath.getInt("totalprice"),111,"totalprice uyuşmadı");
        softAssert.assertTrue(jsonPath.getBoolean("depositpaid"),"depositpaid uyuşmadı");
        softAssert.assertEquals(jsonPath.getString("bookingdates.checkin"),"2018-01-01","checkin uyuşmadı");
        softAssert.assertEquals(jsonPath.getString("bookingdates.checkout"),"2019-01-01","checkout uyuşmadı");
        softAssert.assertEquals(jsonPath.getString("additionalneeds"),"super bowls","additionalneeds uyuşmadı");
        //3 assertAll() methodunu kullan
        softAssert.assertAll();

    }
}
