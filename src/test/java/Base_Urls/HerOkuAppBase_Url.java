package Base_Urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

import static Utils.AuthenticationHerOkuApp.generateToken;

public class HerOkuAppBase_Url {
  //Setup methodu ile tekrarli yapilacak olan request islemleri burada bir kez yapilmis oldu.Test öncesi calismasi icin Before notasyonu ekliyoruz.
    protected RequestSpecification spec;

    @Before
    public void setUp(){
        spec = new RequestSpecBuilder().addHeader("Cookie","token="+generateToken()).setContentType(ContentType.JSON).setBaseUri("https://restful-booker.herokuapp.com").build();
    }

}
