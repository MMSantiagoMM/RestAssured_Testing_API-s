package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import pojos.People;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.io.IOException;
import static utils.PeopleMethod.methodPeople;

public class TestPeople {

    @Test
    @Parameters({"url-api","success-status-code","skin-color","film-size"})
    public void testApiOne(String url, String success,String skin,String filmSize){

        Response responsePeople2 = RestAssured.given().when().get(url);
        People people = methodPeople(responsePeople2,url);

        Assert.assertEquals(responsePeople2.getStatusCode(),Integer.parseInt(success));
        Assert.assertEquals(people.getSkin_color(),skin);
        Assert.assertEquals(people.getFilms().size(),Integer.parseInt(filmSize));

    }



}
