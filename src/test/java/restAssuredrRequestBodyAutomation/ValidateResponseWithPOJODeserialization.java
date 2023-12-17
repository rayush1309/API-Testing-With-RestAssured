package restAssuredrRequestBodyAutomation;

import core.StatusCode;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import poJo.PostRequestBody;

import static io.restassured.RestAssured.given;

public class ValidateResponseWithPOJODeserialization {
    @Test
    public void validatePATCHRequestUsingString() {
        String job = "Nikhil";
        PostRequestBody patchRequest = new PostRequestBody();
        patchRequest.setJob(job);
        RestAssured.baseURI = "https://reqres.in";
        Response response = given()
                .header("Content-Type", "application/json")
                .body(patchRequest)
                .when()
                .patch("/api/users/2");
        PostRequestBody responseBody = response.as(PostRequestBody.class);

        Assert.assertEquals(responseBody.getJob(), job, "Job mismatch");
        Assert.assertEquals(response.getStatusCode(), StatusCode.SUCCESS.code, "Incorrect status code");

        // Corrected println statement
        System.out.println(responseBody.getJob() + " " + job);

        System.out.println(response.getBody().asString());
        System.out.println("validatePATCHRequestUsingString() executed Successfully");
    }
}
