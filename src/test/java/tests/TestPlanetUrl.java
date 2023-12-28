package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pojos.Planet;

import static utils.PlanetMethod.getFilm2;
import static utils.PlanetMethod.methodPlanet;

public class TestPlanetUrl {


    @Test
    @Parameters({"uri-people"})
    public void testPlanetUrl(String url){

        Planet planet = methodPlanet(url);
        Assert.assertEquals(planet.getUrl(), getFilm2(url));

    }
}
