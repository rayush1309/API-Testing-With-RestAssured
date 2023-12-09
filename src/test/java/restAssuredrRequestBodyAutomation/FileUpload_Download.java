package restAssuredrRequestBodyAutomation;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class FileUpload_Download {

    @Test
    public void fileUploadExample(){
        File file =new File("resources/demo.txt");
        Response response= given()
                .multiPart("file",file)
                .when()
                .post("https://www.example.com");
        System.out.println(response.getStatusCode());
    }
}
