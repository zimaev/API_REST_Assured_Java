package config;
import org.testng.annotations.BeforeClass;
import io.restassured.RestAssured;

import static constans.Constants.RunVariable.path;
import static constans.Constants.RunVariable.server;

public class TestConfig {


    @BeforeClass
    public void setUp(){
        RestAssured.baseURI =  server;
        RestAssured.basePath = path;

    }
}
