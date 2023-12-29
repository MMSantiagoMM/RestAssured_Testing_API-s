package tests;

import org.testng.annotations.Test;
import static utils.BaseTest.validateStatusCode404;
import static utils.Film404Method.methodGetFilm;

public class TestFilmSeven404 {

    @Test
    public void testFilmSeven(){
        validateStatusCode404(methodGetFilm().statusCode());

    }

}
