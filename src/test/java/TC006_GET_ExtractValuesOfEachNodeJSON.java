import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC006_GET_ExtractValuesOfEachNodeJSON {

    @Test
    void GetWeatherDetailsTest() {

        String temperatureExpected = "27.65 Degree celsius";

        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET,"/London");

        JsonPath jsonPath = response.jsonPath();

        String city = jsonPath.get("City");
        String temperature = jsonPath.get("Temperature");
        String humidity = jsonPath.get("Humidity");
        String weatherDescription = jsonPath.get("WeatherDescription");
        String windSpeed = jsonPath.get("WindSpeed");
        String windDirectionDegree = jsonPath.get("WindDirectionDegree");

        System.out.println(city);
        System.out.println(temperature);
        System.out.println(humidity);
        System.out.println(weatherDescription);
        System.out.println(windSpeed);
        System.out.println(windDirectionDegree);

        Assert.assertEquals(jsonPath.get("Temperature"),temperatureExpected);
    }

}
