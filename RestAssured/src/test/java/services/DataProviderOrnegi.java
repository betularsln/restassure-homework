package services;
import io.restassured.RestAssured;
import io.restassured.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class DataProviderOrnegi {


    @DataProvider(name = "dataProvider" )
    public Object[][] dataProvider(){
        return new Object[][]{
            {1,200},
            {2,200},
            {3,200},
            {4,200}

        };
    }

    @Test(dataProvider = "dataProvider")
    public void GetBookingIds(int bookingid, int statusCode){

        given()
                .log().all()
                .when()
                .get("https://restful-booker.herokuapp.com/booking/")
                .then()
                .statusCode(200)
                .log().all();
    }
}
