package tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpException;
import org.testng.Assert;
import pojos.Film;
import pojos.People;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pojos.Planet;

import java.util.List;
import java.util.Optional;

import static io.restassured.RestAssured.when;
import static io.restassured.path.xml.XmlPath.given;

public class TestApiTwo {

    @Test
    public void testApiTwo() throws JsonProcessingException, HttpException {

        Response response = RestAssured.get("https://swapi.dev/api/people/2");
        ObjectMapper objectMapper = new ObjectMapper();
        SoftAssert softAssert = new SoftAssert();
        String json = response.getBody().asString();
        People people = objectMapper.readValue(json,People.class);

        Response response2 = RestAssured.get(people.getFilms().get(5));

        String json2 = response2.getBody().asString();
        Film film = objectMapper.readValue(json2, Film.class);

        softAssert.assertTrue(film.getRelease_date().matches("^(19|20)\\d\\d[-](0[1-9]|1[012])[-](0[1-9]|[12][0-9]|3[01])$"));

        softAssert.assertTrue(film.getCharacters().size()>=1);
        softAssert.assertTrue(film.getPlanets().size()>=1);
        softAssert.assertTrue(film.getStarships().size()>=1);
        softAssert.assertTrue(film.getVehicles().size()>=1);
        softAssert.assertTrue(film.getSpecies().size()>=1);


        Response response3 = RestAssured.get(film.getPlanets().get(0));
        String json3 = response3.getBody().asString();

        ObjectMapper objectMapper3 = new ObjectMapper();
        Planet planet = objectMapper3.readValue(json3, Planet.class);
        softAssert.assertEquals(planet.getDiameter(),10465);
        softAssert.assertEquals(planet.getTerrain(),"desert");


        Response response4 = RestAssured.get(planet.getUrl());
        softAssert.assertEquals(response4.getStatusCode(),response3.getStatusCode());


        /*Integer code = 0;
        try {
            Response response5 = RestAssured
                    .given()
                    .urlEncodingEnabled(true)
                    .when()
                    .get(people.getFilms().get(6));
            System.out.println(response.statusCode());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("La lista de películas no tiene suficientes elementos.");
            code = 404;
            softAssert.assertEquals(Optional.of(code),404);
        }*/

        List<String> films = people.getFilms();
        for (String s : films) {
            Response response5 = RestAssured.given()
                    .when()
                    .get(s)
                    .then()
                    .extract()
                    .response();

            // If status is not 404 print the status to debug
            if (response5.getStatusCode() != 404) {
                System.out.println("Status Code for " + s + " : " + response5.getStatusCode());
            }
            // assert that the response status is indeed 404
            Assert.assertEquals(response5.getStatusCode(), 404);
        }
    }


}
