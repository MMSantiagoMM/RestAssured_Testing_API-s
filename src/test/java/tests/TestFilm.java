package tests;

import org.testng.annotations.Test;
import pojos.Film;

import static utils.BaseTest.validateFormatDate;
import static utils.BaseTest.validateSizeMoreThanOne;
import static utils.FilmMethod.methodFilm;

public class TestFilm {


    @Test
    public void testFilms(){
        Film film = methodFilm();

        validateFormatDate(film.getRelease_date());
        validateSizeMoreThanOne(film.getCharacters().size());
        validateSizeMoreThanOne(film.getPlanets().size());
        validateSizeMoreThanOne(film.getStarships().size());
        validateSizeMoreThanOne(film.getVehicles().size());
        validateSizeMoreThanOne(film.getSpecies().size());

    }


}
