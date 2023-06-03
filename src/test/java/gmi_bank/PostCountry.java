package gmi_bank;

import Base_Urls.GmiBankBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.CountryPojo_Satate;
import pojos.StatePojo;

import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PostCountry extends GmiBankBaseUrl {
    /*
    Given
        https://gmibank.com/api/tp-countries
    And
    {
  "name": "Banana",
  "states": [
    {
      "id": 0,
      "name": "Apple"
    },
        {
      "id": 1,
      "name": "Orange"
    },
        {
      "id": 2,
      "name": "Pear"
    }
  ]
}
When
send post request
Then
statusCode is 201
And body:
{
            "id": 187487,
            "name": "Banana",
            "states": [
                {
                    "id": 0,
                    "name": "Apple",
                    "tpcountry": null
                },
                {
                    "id": 1,
                    "name": "Orange",
                    "tpcountry": null
                },
                {
                    "id": 2,
                    "name": "Pear",
                    "tpcountry": null
                }
            ]
        }


     */

    @Test
    public void postCountry() {
        //set the Url
        spec.pathParams("first","api","second","tp-countries");

        //set the expected data
        StatePojo state1 = new StatePojo(1,"Apple");
        StatePojo state2 = new StatePojo(2,"Orange");
        StatePojo state3 = new StatePojo(3,"Pear");
        List<StatePojo> stateList= new ArrayList<>();
        stateList.add(state1);
        stateList.add(state2);
        stateList.add(state3);

        CountryPojo_Satate expectedData = new CountryPojo_Satate("Banane",stateList);
        System.out.println("expectedData = " + expectedData);

        //send the request get the response
     Response response = given(spec).body(expectedData).post("{first}/{second}");
     response.prettyPrint();


    }
}
