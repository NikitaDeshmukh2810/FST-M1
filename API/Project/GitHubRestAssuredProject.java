package project;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class GitHubRestAssuredProject {
    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;
    String sshKey="ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIIViD6WB99LkSr+FednThLG9HuEKTpk3CPMxHInfORb/";
    int sshKeyId;

    @BeforeClass
    public void setUp() {
        // Create request specification
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.github.com")
                .addHeader("Authorization","token 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")
                .addHeader("Content-Type","application/json")
                .build();

        // Create response specification
        responseSpec = new ResponseSpecBuilder()
                .expectResponseTime(lessThan(6000L))
                .expectBody("key",equalTo(sshKey))
                .expectBody("title",equalTo("TestAPIKey"))
                .build();
    }

    @Test(priority =1)
    public void POSTkeyRequestTest() {
        Map<String,String> reqBody=new HashMap<>();
        reqBody.put("title","TestAPIKey");
        reqBody.put("key",sshKey);
        Response response = given().spec(requestSpec).body(reqBody).when().post("/user/keys"); // Send POST request
        //ID Extraction
        sshKeyId = response.then().extract().path("id");
        response.then().statusCode(201).spec(responseSpec);
    }

    @Test(priority=2)
    public void GETkeyRequestTest(){
        given().spec(requestSpec).pathParam("keyId",sshKeyId)
                .when().get("/user/keys/{keyId}")
                .then().statusCode(200).spec(responseSpec);
    }

    @Test(priority=3)
    public void DELETEkeyRequestTest(){
        given().spec(requestSpec).pathParam("keyId",sshKeyId)
                .when().delete("/user/keys/{keyId}")
                .then().statusCode(204).time(lessThan(4000L));
    }

}
