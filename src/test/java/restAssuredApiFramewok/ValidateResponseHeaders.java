package restAssuredApiFramewok;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.http.Header; // Import the correct Header class
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
public class ValidateResponseHeaders {
    @Test
    public void validateResponseHeader() {
        // Set the base URI for the RestAssured requests
        RestAssured.baseURI = "https://reqres.in";
        // Send a GET request to the specified endpoint ("/api/users?page=2")
        Response response = given()
                .when()
                .get("/api/users?page=2");  // Add a forward slash before "api"
        // Extract the response for further inspection
        Headers headers = response.getHeaders();
        // Iterate through the headers and validate the "Server" header value
        for (Header h : headers) {
            // Check if the current header is the "Server" header
            if (h.getName().equals("Server")) {
                // Uncomment the next line if you want to print the header name and value
                // System.out.println(h.getName() + ": " + h.getValue());
                // Validate that the "Server" header value is "cloudflare"
                assertEquals(h.getValue(), "cloudflare");
                // Print a success message if validation passes
                System.out.println("Validated Response From Header Successfully");
            }
        }
    }


}
