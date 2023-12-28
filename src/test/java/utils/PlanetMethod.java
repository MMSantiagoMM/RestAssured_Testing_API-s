package utils;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojos.Planet;

import static utils.FilmMethod.methodFilm;

public class PlanetMethod {

    public static Planet methodPlanet(String uri){

        Response responseFirstPlanet = RestAssured.when().get(getFilm2(uri));

        return new JsonPath(responseFirstPlanet.asString()).getObject("", Planet.class);
    }

    public static String getFilm2(String uri){
        return methodFilm(uri).getPlanets().get(0);
    }



}
