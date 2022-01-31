package services;
import io.restassured.RestAssured;
import io.restassured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import services.auth.TokenUret;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringStartsWith.startsWith;

//
public class BeforeAfterOrnegi {



    @BeforeClass
    public void postCreateBooking(){

        String postData = "'{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}'";

        given()
                .body(postData)
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .post("https://restful-booker.herokuapp.com/booking")
                .then()
                .statusCode(400)
                .log().all();

    }

    @Test
    public void getBookingIds(){
        given()
                .log().all()
                .when()
                .get("https://restful-booker.herokuapp.com/booking/")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void updateBooking(){
        given()
                .log().all()
                .header("Content-Type","application/json")
                .header("Accept","application/json")
                .header("Cookie", "token="+TokenUret.postCreateToken())
                .header("Authorisation","Basic")
                .header("firstname","Raziye")
                .header("lastname","Arslan")
                .when()
                .put("https://restful-booker.herokuapp.com/booking/1")
                .then()
                .statusCode(200)
                .log().all();
    }


}
