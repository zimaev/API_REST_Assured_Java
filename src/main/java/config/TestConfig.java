package config;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import io.restassured.RestAssured;

import static constans.Constants.RunVariable.path;
import static constans.Constants.RunVariable.server;

public class TestConfig {

    //RequestSpecification -RequestSpecification - общие свойства(спецификации) для запроса
    public RequestSpecification requestSpecificationXML =  new RequestSpecBuilder()
            .setBaseUri("https://eo4ac24z0gd192h.m.pipedream.net/")
            .addHeader("Content-Type","application/xml")
            .addCookie("myCookie","testXML ")
            .build();

    public RequestSpecification requestSpecificationJSON =  new RequestSpecBuilder()
            .addHeader("Content-Type","application/json")
            .addCookie("myCookie","testJSON ")
            .build();

    //ResponseSpecification - общие свойства(спецификации) для ответа
    public ResponseSpecification responseSpecificationGET = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();

    public ResponseSpecification responseSpecificationPOST = new ResponseSpecBuilder()
            .expectStatusCode(201)
            .build();


    @BeforeClass
    public void setUp(){
        RestAssured.baseURI =  server;
        RestAssured.basePath = path;
        RequestSpecification requestSpecificationJSON =  new RequestSpecBuilder()
                .addHeader("Content-Type","application/json")
                .addCookie("myCookie","testJSON ")
                .build();




    }
}
