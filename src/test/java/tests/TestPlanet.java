package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pojos.Planet;

import static utils.PlanetMethod.getFilm2;
import static utils.PlanetMethod.methodPlanet;

public class TestPlanet {


    @Test
    @Parameters({"uri-people","gravity","terrains"})
    public void testPlanet(String uri,String gravity,String terrains){

        Planet planet = methodPlanet(uri);

        Assert.assertEquals(planet.getGravity(),gravity);
        Assert.assertEquals(planet.getTerrain(),terrains);

        Assert.assertEquals(planet.getUrl(), getFilm2(uri));


    }
}
