package restAssuredrRequestBodyAutomation;

import core.StatusCode;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.Assert;
import poJo.CityRequest;
import poJo.PostRequestBody;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ValidateMethodsWithPOJOList {

    @Test
    public void validatePostWithPOJOList() {
        List<String> listLanguages = new ArrayList<>();
        listLanguages.add("Java");
        listLanguages.add("Java Script");

        CityRequest cr1 = new CityRequest();
        cr1.setName("Bangalore");
        cr1.setTemperature("22.90");

        CityRequest cr2 = new CityRequest();
        cr2.setName("Delhi");
        cr2.setTemperature("33.9");

        List<CityRequest> cityRequests = new ArrayList<>();
        cityRequests.add(cr1);
        cityRequests.add(cr2);

        PostRequestBody pr = new PostRequestBody();
        pr.setName("Ayush ");
        pr.setJob("Software Engineer-Test-4");
        pr.setLanguages(listLanguages);
        pr.setCityRequestBody(cityRequests); // Assuming you have a setter for cityRequests in PostRequestBody

        RestAssured.baseURI = "https://reqres.in";
        Response response = given()
                .header("Content-Type", "application/json")
                .body(pr)
                .when()
                .post("/api/users");

        Assert.assertEquals(response.getStatusCode(), StatusCode.CREATED.code);
        System.out.println(response.getBody().asString());
        System.out.println("PostWith POJO list Executed successfully");
    }
}
