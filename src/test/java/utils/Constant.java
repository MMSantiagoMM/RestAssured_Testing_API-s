package utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Constant {
    URI_PEOPLE2("https://swapi.dev/api/people/2"),
    URI_FILM_7("https://swapi.dev/api/films/7"),
    SUCCESS_CODE("200"),
    NOT_FOUND_CODE("404"),
    REG_EXP_DATE("\\d{4}-\\d{2}-\\d{2}");


    public final String text;

}
