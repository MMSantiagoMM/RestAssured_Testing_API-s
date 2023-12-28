package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import static utils.Film404Method.methodGetFilm;

public class TestFilmSeven404 {

    @Test
    @Parameters({"uri-film","not-found-status-code"})
    public void testFilmSeven(String uri,String notFound){

        Assert.assertEquals(methodGetFilm(uri).statusCode(),Integer.parseInt(notFound));

    }

}
