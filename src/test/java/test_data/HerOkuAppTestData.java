package test_data;

import java.util.HashMap;
import java.util.Map;

public class HerOkuAppTestData {
    public Map<String,String> bookingdatesMapMethod(String checkin,String checkout){
        Map<String,String> bookingdatesMap = new HashMap<>(); //once inner Map olusturulur
        bookingdatesMap.put("checkin",checkin);
        bookingdatesMap.put("checkout",checkout);
        return bookingdatesMap;
    }

    public Map<String, Object> expectedDataMethod(String firstname,String lastname,Integer totalprice,Boolean depositpait,Map<String,String> bookingdatesMap,String additionalneeds){
        Map<String, Object> expectedData = new HashMap<>();
        if (firstname!=null){
            expectedData.put("firstname",firstname);
        }
        if (lastname!=null){
            expectedData.put("lastname",lastname);
        }
        if (totalprice!=null){
            expectedData.put("totalprice",totalprice);
        }
        if (depositpait!=null){
            expectedData.put("depositpaid",depositpait);
        }
        if (bookingdatesMap!=null){
            expectedData.put("bookingdates",bookingdatesMap); //Inner Map yaparak buraya ekledik
        }

        if (additionalneeds != null) {
            expectedData.put("additionalneeds", additionalneeds);
        }

        return expectedData;
    }
}
/*

        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("firstname","John");
        expectedData.put("lastname","Smith");
        expectedData.put("totalprice",111);
        expectedData.put("depositpaid",true);
        expectedData.put("bookingdates",bookingdatesMap); //Inner Map yaparak buraya ekledik
        expectedData.put("additionalneeds","Breakfast");
 */

