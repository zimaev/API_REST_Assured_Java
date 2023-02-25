package config;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import io.restassured.RestAssured;

import static constans.Constants.RunVariable.path;
import static constans.Constants.RunVariable.server;

public class TestConfig {


    public RequestSpecification requestSpecificationXML =  new RequestSpecBuilder()
            .setBaseUri("https://eo4ac24z0gd192h.m.pipedream.net/")
            .addHeader("Content-Type","application/xml")
            .addCookie("myCookie","testXML ")
            .build();


    @BeforeClass
    public void setUp(){
        RestAssured.baseURI =  server;
        RestAssured.basePath = path;
        RequestSpecification requestSpecificationJSON =  new RequestSpecBuilder()
                .addHeader("Content-Type","application/json")
                .addCookie("myCookie","testJSON ")
                .build();
        RestAssured.requestSpecification =requestSpecificationJSON;



    }
}
