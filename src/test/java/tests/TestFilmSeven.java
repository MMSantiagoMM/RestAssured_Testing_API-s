package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.PeopleMethod;

import static utils.PeopleMethod.methodPeople;

public class TestFilmSeven {

    @Test
    @Parameters({"uri-people"})
    public void testFilmSeven(String uri){
        Response responsePeople = RestAssured.given().when().get(uri);
        
        Integer statusCode;
        String uriFilmSeven = null;
        try {
            uriFilmSeven = methodPeople(responsePeople,uri).getFilms().get(6);
            statusCode = 200;
        }catch (Exception e){
            statusCode = 404;
        }

        Assert.assertEquals(statusCode,404);



    }
}
