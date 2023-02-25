import config.TestConfig;
import org.testng.annotations.Test;

import static constans.Constants.Actions.GET_COMMENTS;
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
}
