package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pojos.Film;

import static utils.FilmMethod.methodFilm;

public class TestFilm {


    @Test
    @Parameters({"uri-people","reg-exp-date","amount"})
    public void testFilms(String url, String regExp, String amount){
        Film film = methodFilm(url);
        Integer one = Integer.parseInt(amount);

        Assert.assertTrue(film.getRelease_date().matches(regExp));

        Assert.assertTrue(film.getCharacters().size() > one);
        Assert.assertTrue(film.getPlanets().size() > one);
        Assert.assertTrue(film.getStarships().size() > one);
        Assert.assertTrue(film.getVehicles().size() > one);
        Assert.assertTrue(film.getSpecies().size() > one);

    }


}
