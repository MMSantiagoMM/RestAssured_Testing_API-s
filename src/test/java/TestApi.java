import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.pojos.People;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestApi {



    @Test
    public void testApi() throws IOException {

        /*
        Response response = RestAssured.get("https://swapi.dev/api/people/1");
        ObjectMapper objectMapper = new ObjectMapper();

        String json = response.getBody().asString();

        try {
            People people = objectMapper.readValue(json,People.class);
            System.out.println(people.getName());
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }*/

        given()
                .when()
                .get("https://swapi.dev/api/people/1")
                .then()
                .statusCode(200)
                .body("name",equalTo("Luke Skywalker"));









        //Response response;
        //response = (Response) given("https://swapi.dev/").getList("api/2/");
        //Assert.assertEquals(response.getStatusCode(),200);









    }



}
