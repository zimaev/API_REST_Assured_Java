import config.TestConfig;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static constans.Constants.Actions.GET_PEOPLE;
import static constans.Constants.Path.SWAPI_PATH;
import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;


public class testFirstTest extends TestConfig {

    @Test
    void restTest(){
        given().log().uri().
        when().get(GET_PEOPLE+"1").
        then().log().all().
        statusCode(200);
    }


    @Test
    public void testSomeFiledInResponse() {
        given()
                .spec(requestSpecificationSWAPI)
                .log().uri().
        when()
                .get(SWAPI_PATH).
        then()
                .body("people", equalTo("https://swapi.dev/api/people/"))
                .log().body();
    }

    @Test
    public void testSomeFiledInResponseWithIndex() {
        given()
                .spec(requestSpecificationSWAPI)
                .log().uri().
        when()
                .get(SWAPI_PATH+GET_PEOPLE).
        then()
                .body("results[3].name", equalTo("Darth Vader"))
                .body("results[3].homeworld", equalTo("https://swapi.dev/api/planets/1/"))
                .log().body();
    }

    @Test
    public void testGetAllDataFromResponse() {

        Response response =  given()
                .when()
                .log().uri()
                .get(SWAPI_PATH)
                .then().extract().response();

        String jsonRsponse = response.asString();

        System.out.println(jsonRsponse);
    }

    @Test
    public void testGetCookie() {
        Response response =  given()
                .when()
                .log().uri()
                .get("https://ya.ru")
                .then()
                .extract().response();

        Map<String, String> responseCookies = response.getCookies();

        System.out.println(responseCookies);
    }

    @Test
    public void testGetHeaders() {
        Response response =  given()
                             .when()
                                .log().uri()
                                .get(SWAPI_PATH)
                             .then()
                                .extract().response();

        Headers responseHeaders = response.getHeaders();
        System.out.println(responseHeaders);
    }

    @Test
    public void testValidateJSONSchema() {
        given()
                .when()
                .log().uri()
                .get(SWAPI_PATH+GET_PEOPLE)
                .then()
                    .body(matchesJsonSchemaInClasspath("jsonSchema.json"))
                    .log().body();

    }
}
