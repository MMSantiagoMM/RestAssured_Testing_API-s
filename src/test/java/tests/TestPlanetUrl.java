package tests;

import org.testng.annotations.Test;
import pojos.Planet;
import utils.BaseTest;

import static utils.BaseTest.validateSameStrings;
import static utils.PlanetMethod.getFilm2;
import static utils.PlanetMethod.methodPlanet;

public class TestPlanetUrl {


    @Test
    public void testPlanetUrl(){

        Planet planet = methodPlanet();

        validateSameStrings(planet.getUrl(), getFilm2());

    }
}
