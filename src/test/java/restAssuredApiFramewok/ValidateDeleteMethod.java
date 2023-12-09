package restAssuredApiFramewok;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.ExtentReport;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class ValidateDeleteMethod  {
    @Test(groups = {"Regression","sanity"})
    public void validateDeleteStatusCode(){
        ExtentReport.extentlog = ExtentReport.extentReport.startTest("testCookieUsingCookieBuilder"+
                "Validate 200 Status code for Get request");

        Response resp= given()
                .delete("https://reqres.in/api/users/2");
        assertEquals(resp.getStatusCode(),204);
        System.out.println("Delete Method Executed Sucessfully"+"No Content: "+"204 Status Code");
    }

}
