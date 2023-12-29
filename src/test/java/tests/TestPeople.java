package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Parameters;
import pojos.People;
import org.testng.annotations.Test;

import static utils.BaseTest.*;
import static utils.Constant.URI_PEOPLE2;
import static utils.PeopleMethod.methodPeople;

public class TestPeople {

    @Test
    @Parameters({"skin-color","film-size"})
    public void testApiOne(String skin,String filmSize){

        Response responsePeople2 = RestAssured.given().when().get(URI_PEOPLE2.getText());
        People people = methodPeople(responsePeople2);

        validateStatusCode200(responsePeople2.statusCode());
        validateSameStrings(people.getSkin_color(),skin);
        validateSameNumbers(people.getFilms().size(),Integer.parseInt(filmSize));
    }



}
