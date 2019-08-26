import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC003_Get_Request {

    @Test
    void googleMapTest() {

        RestAssured.baseURI = "https://maps.googleapis.com";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET,"/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is:"+responseBody);

        String contentType = response.header("Content-type"); //capture details of Content-Type header
        System.out.println("Response Content-type is:"+contentType);
        Assert.assertEquals(contentType,"application/xml; charset=UTF-8");

        String contentEncoding = response.header("Content-Encoding"); //capture details of Content-Encoding header
        System.out.println("Response Content-Encoding is:"+contentEncoding);
        Assert.assertEquals(contentEncoding,"gzip");

    }

}
