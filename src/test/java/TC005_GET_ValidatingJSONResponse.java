import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC005_GET_ValidatingJSONResponse {

    @Test
    void GetWeatherDetailsTest() {

        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET,"/London");

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is:"+responseBody);
        Assert.assertEquals(responseBody.contains("London"), true);
    }

}
