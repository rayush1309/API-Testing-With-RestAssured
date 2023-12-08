package restAssuredApiFramewok;

import core.StatusCode;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.PropertyReader;
import utils.SoftAssertionUtils;

import static io.restassured.RestAssured.given;

public class ValidateWithSoftwareUtils {
    SoftAssertionUtils st= new SoftAssertionUtils();


    @Test
    public void validateResponseUsingSoftUtils(){
        String url= PropertyReader.propertyReader("enviornmentdetails.properties","URI");
        RestAssured.baseURI=url;
        System.out.println(url);
        Response response=
                given()
                        .queryParam("page",2)
                        .when()
                        .get("/api/users/2")
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();
          st.assertEquals(response.getStatusCode(), StatusCode.SUCCESS.code,"Status code is not 200");
          st.assertAll();

        System.out.println("validateResponseUsingSoftUtils Executed Sucessfully");



    }

}
