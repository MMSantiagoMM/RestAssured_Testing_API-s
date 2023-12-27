package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pojos.Film;

import static utils.FilmMethod.methodFilm;

public class TestFilm {


    @Test
    @Parameters({"uri-people","reg-exp-date"})
    public void testFilms(String url, String regExp){
        Film film = methodFilm(url);

        Assert.assertTrue(film.getRelease_date().matches(regExp));

        Assert.assertTrue(film.getCharacters().size() > 1);
        Assert.assertTrue(film.getPlanets().size() > 1);
        Assert.assertTrue(film.getStarships().size() > 1);
        Assert.assertTrue(film.getVehicles().size() > 1);
        Assert.assertTrue(film.getSpecies().size() > 1);

    }


}
