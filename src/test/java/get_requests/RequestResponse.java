package get_requests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestResponse {
    /*
1) Postman manuel test için kullanılır
2) Otomasyon için Rest-Assured library kullanıyoruz
3) Otomasyonu yazabilmek için şu adımların izlenmesi gerekir:
    a) Gereksinimleri anlama
    b) Test case yazma:
        -Test yazmak için Gherkin Language kullanılır
        x) Given: Ön koşullar --> Url, Body ...
        y) When: Yapılacak işlemler --> Get, Put, Post ... requests...
        z) Then: Dönütler, çıktılar --> Assertion, close...
        t) And: Art arda yapılan aynı çoklu işlmeleri bağlamak için kullanılır
    c) Otomasyon kodlarını yazma:
            i) Set the url --> endpoint'i kur
            ii) Set the expected data --> beklenen veriyi kur
            iii) Send the request and get the response --> request'i gönder ve response'ı al
            iv) Do assertion --> Doğrulama yap

 */
    public static void main(String[] args) {
        String url="https://petstore.swagger.io/v2/pet/1287889";
        Response response =given().get(url);
        response.prettyPrint(); //prettyPrint() ile response konsola yazdirdik

        //Status code nasil yazdirilir:
        System.out.println("Status Code : "+response.statusCode());

        //Content Type nasil yazdirilir(Icerik):
        System.out.println("Content Type : "+response.contentType());

        //Status Line nasil yazdirilir?
        System.out.println("Status Line : "+response.statusLine());

        //Header nasil yazdirilir:
        System.out.println(response.header("Date"));//Tue, 23 May 2023 18:52:11 GMT
        System.out.println(response.header("Connection"));
        System.out.println(response.header("Server"));
        System.out.println(response.header("Transfer-Encoding"));

        //Headers nasil yazdirilir
        System.out.println(response.headers());

        //time nasil yazdirilir
        System.out.println("\nTime : "+response.time());
    }
}
