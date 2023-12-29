package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojos.Film;

import static utils.Constant.URI_FILM_7;


public class Film404Method {


    public static Response methodGetFilm(){

        return RestAssured.given().when().get(URI_FILM_7.getText());
    }


}
