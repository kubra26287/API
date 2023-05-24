package Base_Urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonPlaceHolderBase_Url {
  //Setup methodu ile tekrarli yapilacak olan request islemleri burada bir kez yapilmis oldu.Test öncesi calismasi icin Before notasyonu ekliyoruz.
    protected RequestSpecification spec;

    @Before
    public void setUp(){
        spec = new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com/").setAccept(ContentType.JSON).build();
    }

}
