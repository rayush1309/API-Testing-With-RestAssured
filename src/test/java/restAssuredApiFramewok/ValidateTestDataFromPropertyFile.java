package restAssuredApiFramewok;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.PropertyReader;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class ValidateTestDataFromPropertyFile {
    @Test
    public void validateStatusCode() {
        String webURI= PropertyReader.propertyReader("enviornmentdetails","URI");
        String endPoints=PropertyReader.propertyReader("enviornmentdetails","endpoint");
        System.out.println(webURI+endPoints);

        // Send a GET request with a query parameter "page" set to 2 and store the response
        RestAssured.baseURI=webURI;//reading from properties file;
        Response resp =
                given()
                        .queryParam("page", 2)
                        .when()
                        .get(endPoints);
        // Extract the actual status code from the response using RestAssured
        int actualStatusCode = resp.statusCode();
        // Assert that the actual status code is equal to the expected status code (200)
        assertEquals(actualStatusCode, 200); // Using TestNG assertion
        // Note: If the status code is not equal to 200, the assertion will fail and the test will be marked as failed.
    }
}
