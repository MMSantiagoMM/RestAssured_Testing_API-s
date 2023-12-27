package utils;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojos.People;

public class PeopleMethod {

    public static People methodPeople(Response response, String url) {
        response = RestAssured.given().when().get(url);
        return new JsonPath(response.asString()).getObject("", People.class);
    }

}
