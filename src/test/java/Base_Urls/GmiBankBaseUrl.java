package Base_Urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class GmiBankBaseUrl {
  //Setup methodu ile tekrarli yapilacak olan request islemleri burada bir kez yapilmis oldu.Test öncesi calismasi icin Before notasyonu ekliyoruz.
    protected RequestSpecification spec;

    @Before
    public void setUp(){
        spec = new RequestSpecBuilder().setContentType(ContentType.JSON).addHeader("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYXJrX3R3YWluIiwiYXV0aCI6IlJPTEVfQURNSU4sUk9MRV9NQU5BR0VSIiwiZXhwIjoxNjg1OTA3NTE3fQ.Y3MwTnQVrl7aI2M5-4EOL2gih5KYvggTx6BPhA27LCHp-1Y8US4pAlSz87QGHOxO-IorONbX-hnN-Rp1-iaWDQ").setBaseUri("https://gmibank.com").build();
    }

}
