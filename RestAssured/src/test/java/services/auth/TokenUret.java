package services.auth;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TokenUret {

    public static Response postCreateToken(){
        Response response = given()
                .log().all()
                .header("Content-Type","application/json")
                .header("username","admin")
                .header("password","password123")
                .when()
                .post("https://restful-booker.herokuapp.com/auth");
        return response;

    }
}
