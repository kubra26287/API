package get_requests;

import Base_Urls.GoRestBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.testng.AssertJUnit.assertTrue;

public class Get10 extends GoRestBaseUrl {
      /*
   Given
       https://gorest.co.in/public/v1/users
   When
       User send GET Request
   Then
       The value of "pagination limit" is 10
   And
       The "current link" should be "https://gorest.co.in/public/v1/users?page=1"
   And
       The number of users should  be 10
   And
       We have at least one "active" status
   And
       "Gov. Vrinda Panicker", "Sen. Devika Embranthiri" and "Rev. Jay Shukla" are among the users
   And
       The female users are less than or equals to male users
       (Kadın kullanıcı sayısı erkek kullanıcı sayısından küçük yada eşit olamlı)
*/

    @Test
    public void get10() {
        //set the Url
        spec.pathParam("first","users");

        //set the expected data
        //gelen data list oldugu icin burayi yapmiyoruz

        //send the request get the response
       Response response = given(spec).get("{first}");
        System.out.println("response = " + response);

        //Do assertion
        response.then()
                .statusCode(200)
                .body("meta.pagination.limit", equalTo(10),
                        "meta.pagination.links.current", equalTo("https://gorest.co.in/public/v1/users?page=1"),
                        "data", hasSize(10),
                        "data.status", hasItem("active"),
                        "data.name", hasItems("Anand Verma", "Amb. Ekaksh Bharadwaj", "Amogh Patel"));

        //The female users are less than or equals to male users
        //Kadın ve erkek sayılarını karşılaştıralım:

        //1. yol : for Loop ile kadin ve erkek sayisini bulup assert yapalim
        JsonPath jsonPath = response.jsonPath();
        List<String> genderList = jsonPath.getList("data.gender");
        System.out.println("genderList = " + genderList);

        int kadinSayisi = 0;
        for (String w : genderList) {
            if (w.equalsIgnoreCase("female")) {
                kadinSayisi++;
            }
        }

        System.out.println("kadinSayisi = " + kadinSayisi);
        assertTrue(kadinSayisi >= genderList.size() - kadinSayisi);

        //2. Yol Groovy:
        int kadinSayisiGro0vy = jsonPath.getList("data.findAll{it.gender=='female'}").size();
        System.out.println("kadinSayisiGrovy = " + kadinSayisiGro0vy);
        int erkekSayisiGroovy = jsonPath.getList("data.findAll{it.gender=='male'}").size();
        System.out.println("erkekSayisiGroovy = " + erkekSayisiGroovy);

        assertTrue(kadinSayisiGro0vy>=erkekSayisiGroovy);


    }
}
