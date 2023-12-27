package utils;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojos.Planet;

import static utils.FilmMethod.methodFilm;

public class PlanetMethod {

    public static Planet methodPlanet(String uri){

        Response responsePlanets = RestAssured.when().get(getFilm(uri));

        return new JsonPath(responsePlanets.asString()).getObject("", Planet.class);
    }

    public static String getFilm(String uri){
        return methodFilm(uri).getPlanets().get(0);
    }



}
