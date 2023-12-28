package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojos.Film;

public class Film404Method {


    public static Response methodGetFilm(String uri){

        return RestAssured.given().when().get("https://swapi.dev/api/films/7");
    }


}
