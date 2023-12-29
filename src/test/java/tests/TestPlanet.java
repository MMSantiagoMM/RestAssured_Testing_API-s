package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pojos.Planet;

import static utils.BaseTest.validateSameStrings;
import static utils.PlanetMethod.getFilm2;
import static utils.PlanetMethod.methodPlanet;

public class TestPlanet {


    @Test
    @Parameters({"gravity","terrains"})
    public void testPlanet(String gravity,String terrains){

        Planet planet = methodPlanet();

        validateSameStrings(planet.getGravity(), gravity);
        validateSameStrings(planet.getTerrain(), terrains);
        validateSameStrings(planet.getUrl(), getFilm2());

    }
}
