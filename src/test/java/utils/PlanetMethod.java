package utils;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojos.Planet;

import static utils.Constant.URI_PEOPLE2;
import static utils.FilmMethod.methodFilm;

public class PlanetMethod {

    public static Planet methodPlanet(){

        Response responseFirstPlanet = RestAssured.when().get(getFilm2());

        return new JsonPath(responseFirstPlanet.asString()).getObject("", Planet.class);
    }

    public static String getFilm2(){
        return methodFilm().getPlanets().get(0);
    }



}
