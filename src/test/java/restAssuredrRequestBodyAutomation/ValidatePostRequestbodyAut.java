package restAssuredrRequestBodyAutomation;

import core.StatusCode;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.io.IOUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static io.restassured.RestAssured.given;



public class ValidatePostRequestbodyAut {

    @Test
    public void validatePostWithString(){
        RestAssured.baseURI="https://reqres.in";
        Response response=
                given()
                        .header("Content-Type","application/json")
                        .body("{\"name\":\"ayush\",\"job\":\"SoftwareEngineer\"}")
                        .when()
                        .post("/api/users")
                          .then()
                        .extract()
                        .response();
          System.out.println(response.getBody().asString());
//        Assert.assertEquals(response.getStatusCode(), StatusCode.CREATED.code);
//        System.out.println(response.getBody().asString());
//        System.out.println("PostWithString Executed sucessfully");


    }
    @Test
    public void validatePostWithJsonFile() throws IOException,FileNotFoundException{
        RestAssured.baseURI="https://reqres.in";
        Response response=
                given()
                        .header("Content-Type","application/json")
                        .body(IOUtils.toString(new FileInputStream(System.getProperty("user.dir")+
                                "/resources/Testdata/postRequestBodyJson.json")))
                        .when()
                        .post("/api/users");
        Assert.assertEquals(response.getStatusCode(), StatusCode.CREATED.code);
        System.out.println(response.getBody().asString());
        System.out.println("PostWith JSon file Executed sucessfully");


    }


}
