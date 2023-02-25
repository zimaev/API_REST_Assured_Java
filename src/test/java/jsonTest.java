import config.TestConfig;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static constans.Constants.Actions.*;
import static io.restassured.RestAssured.*;

public class jsonTest extends TestConfig {

    @Test
    public void testJsonPlaceHolder() {
        given().
                queryParam("postId", 1).
                log().uri().
        when().
                get(GET_COMMENTS).
        then().
                log().body().
                 statusCode(200);
    }

    @Test
    public void testPUT() {

        String bodyJSON = "{\n" +
                "    \"id\": 1,\n" +
                "    \"title\": \"foo\",\n" +
                "    \"body\": \"bar\",\n" +
                "    \"userId\": 1\n" +
                "}";

        given().
                body(bodyJSON)
                .log()
                .uri().
        when().
                put(PUT_POST).
        then().
                log().all()
                .statusCode(200);
    }

    @Test
    public void testDelete() {
        given().
                log().uri()
        .when()
                .delete(DELETE_POST)
        .then()
                .log().body()
                .statusCode(200);
    }


    @Test
    public void testPOSTJson() {

        String bodyJSON = "{\n" +
                "    \"title\": \"foo\",\n" +
                "    \"body\": \"bar\",\n" +
                "    \"userId\": 1\n" +
                "}";

        given()
                .body(bodyJSON)
                .log().all()
        .when()
                .post(POSTS)
        .then()
                .log().body()
                .statusCode(201);
    }


    @Test
    public void testXML() {
        String xmlBody = "<note>\n" +
                "<to>Tove</to>\n" +
                "<from>Jani</from>\n" +
                "<heading>Reminder</heading>\n" +
                "<body>Don't forget me this weekend!</body>\n" +
                "</note>";

        given()
                .spec(requestSpecificationXML)
                .body(xmlBody)

                .log().all()
        .when()
                .post("")
        .then()
                .log().body()
                .statusCode(200);
    }

}
