package tests;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojos.People;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.arrayWithSize;

public class TestApiOne {



    @Test
    public void testApiOne() throws IOException {


        Response response = RestAssured.get("https://swapi.dev/api/people/2");
        ObjectMapper objectMapper = new ObjectMapper();
        SoftAssert softAssert = new SoftAssert();
        String json = response.getBody().asString();
        People people = objectMapper.readValue(json,People.class);


        softAssert.assertEquals(response.getStatusCode(),200);
        softAssert.assertEquals(people.getSkin_color(),"gold");
        softAssert.assertEquals(people.getFilms().size(),6);


        /*

        given()
                .when()
                .get("https://swapi.dev/api/people/2")
                .then()
                .statusCode(200)
                .body("films.size()",equalTo(6));



*/





        //Response response;
        //response = (Response) given("https://swapi.dev/").getList("api/2/");
        //Assert.assertEquals(response.getStatusCode(),200);









    }



}
