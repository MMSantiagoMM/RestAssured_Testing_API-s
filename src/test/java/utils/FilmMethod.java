package utils;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojos.Film;

import static utils.PeopleMethod.methodPeople;

public class FilmMethod {

    public static Film methodFilm(String uri){
        Response responsePeople = RestAssured.when().get(uri);
        String uriFilms = methodPeople(responsePeople,uri).getFilms().get(5);
        Response responseFilms = RestAssured.when().get(uriFilms);
        return new JsonPath(responseFilms.asString()).getObject("", Film.class);
    }



}
