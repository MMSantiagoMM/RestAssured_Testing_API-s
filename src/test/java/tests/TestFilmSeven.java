package tests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pojos.Film;
import utils.Film404Method;


import java.util.List;
import java.util.Optional;

import static utils.Film404Method.methodGetFilm;
import static utils.PeopleMethod.methodPeople;

public class TestFilmSeven {

    @Test
    @Parameters({"uri-film"})
    public void testFilmSeven(String uri){

        System.out.println(methodGetFilm(uri).statusCode());

    }

}
