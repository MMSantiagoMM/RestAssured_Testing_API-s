package utils;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojos.Film;

import static utils.PeopleMethod.methodPeople;

public class FilmMethod {

    public static Film methodFilm(String uri){
        Response responsePeople2 = RestAssured.when().get(uri);
        String uriSecondFilm = methodPeople(responsePeople2,uri).getFilms().get(1);
        Response responseFilm2 = RestAssured.when().get(uriSecondFilm);
        return new JsonPath(responseFilm2.asString()).getObject("", Film.class);
    }



}
