package utils;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojos.People;

import static utils.Constant.URI_PEOPLE2;

public class PeopleMethod {

    public static People methodPeople(Response response) {
        response = RestAssured.given().when().get(URI_PEOPLE2.getText());
        return new JsonPath(response.asString()).getObject("", People.class);
    }

}
