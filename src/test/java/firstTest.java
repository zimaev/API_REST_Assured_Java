import config.TestConfig;
import org.testng.annotations.Test;

import static constans.Constants.Actions.GET_PEOPLE;
import static io.restassured.RestAssured.*;


public class firstTest extends TestConfig {

    @Test
    void restTest(){
        given().log().uri().
        when().get(GET_PEOPLE+"1").
        then().log().body().
        statusCode(200);
    }


}
