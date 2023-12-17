package restAssuredrRequestBodyAutomation;

import core.StatusCode;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.io.IOUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import poJo.PostRequestBody;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ValidateRequestWithPOJO {

    @Test
    public void validatePostWithPOJO() {
        PostRequestBody pr = new PostRequestBody();
        pr.setName("Ayush ");
        pr.setJob("Software Engineer-3");
        RestAssured.baseURI="https://reqres.in";
        Response response=
                given()
                        .header("Content-Type","application/json")
                        .body(pr)
                        .when()
                        .post("/api/users");
        Assert.assertEquals(response.getStatusCode(), StatusCode.CREATED.code);
        System.out.println(response.getBody().asString());
        System.out.println("PostWith POJO class Executed sucessfully");


    }
    @Test
    public void validatePostWithPOJOList()  {
        List<String > listLanguages= new ArrayList<>();
        listLanguages.add("Java");
        listLanguages.add("Java Script");

        PostRequestBody pr = new PostRequestBody();
        pr.setName("Ayush ");
        pr.setJob("Software Engineer-Test-4");
        pr.setLanguages(listLanguages);
        RestAssured.baseURI="https://reqres.in";
        Response response=
                given()
                        .header("Content-Type","application/json")
                        .body(pr)
                        .when()
                        .post("/api/users");
        Assert.assertEquals(response.getStatusCode(), StatusCode.CREATED.code);
        System.out.println(response.getBody().asString());
        System.out.println("PostWith POJO list  Executed sucessfully");


    }
    @Test
    public void validatePUTRequestWithPOJO() throws IOException{
        PostRequestBody putRequest = new PostRequestBody();
        putRequest.setName("Ayush Raj");
        putRequest.setJob("SDET-1");
       // pr.setLanguages(listLanguages);
        RestAssured.baseURI="https://reqres.in";
        Response response=
                given()
                        .header("Content-Type","application/json")
                        .body(putRequest)
                        .when()
                        .put("/api/users/2");
        Assert.assertEquals(response.getStatusCode(), StatusCode.SUCCESS.code);
        System.out.println(response.getBody().asString());
        System.out.println("PostWith POJO list  Executed sucessfully");


    }
    @Test
    public void validatePatchRequestWithPOJO() throws IOException {
        PostRequestBody patchRequest = new PostRequestBody();
        patchRequest.setName("Jacob");

        RestAssured.baseURI = "https://reqres.in";
        Response response = given()
                .header("Content-Type", "application/json")
                .body(patchRequest)
                .when()
                .patch("/api/users/2");

        Assert.assertEquals(response.getStatusCode(), StatusCode.SUCCESS.code);
        System.out.println(response.getBody().asString());
        System.out.println("PATCH With POJO list Executed successfully");
    }
    @Test
    public void validatePatchRequestWithPOJO2() throws IOException {
        PostRequestBody patchRequest = new PostRequestBody();
        patchRequest.setName("Jacob");

        RestAssured.baseURI = "https://reqres.in";
        Response response = given()
                .header("Content-Type", "application/json")
                .body(patchRequest)
                .when()
                .patch("/api/users/2");

        Assert.assertEquals(response.getStatusCode(), StatusCode.SUCCESS.code);

        // Parse and verify the "name" field from the response
        String actualName = response.jsonPath().getString("name");
        Assert.assertEquals("Jacob", actualName);

        System.out.println(response.getBody().asString());
        System.out.println("PATCH With POJO list Executed successfully");
    }



}
