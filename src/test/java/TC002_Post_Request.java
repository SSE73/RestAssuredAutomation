import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC002_Post_Request {

    @Test
    void RegistrationSuccefullTest() {

        RestAssured.baseURI = "http://restapi.demoqa.com/customer";
        RequestSpecification httpRequest = RestAssured.given();
        JSONObject requestParams = new JSONObject();

        requestParams.put("FirstName", "Sysylyatin");
        requestParams.put("LastName","Sergei");
        requestParams.put("UserName","cerbersse");
        requestParams.put("Password","12345678");
        requestParams.put("Email","ssesev65@mail.ru");

        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(requestParams.toJSONString()); //atach above data to the request

        Response response = httpRequest.request(Method.POST,"/register");

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is:"+responseBody);

        int statusCode = response.getStatusCode();
        System.out.println("Status Code is:" + statusCode);
        Assert.assertEquals(statusCode,201);

        String successCode = response.jsonPath().get("SuccessCode");
        Assert.assertEquals(successCode,"OPERATION_SUCCESS");

    }

}
