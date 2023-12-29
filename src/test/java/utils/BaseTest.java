package utils;

import org.testng.Assert;

import static utils.Constant.*;

public class BaseTest {

    public static void validateSizeMoreThanOne(Integer num1){
       Assert.assertTrue(num1 > 1);
    }

    public static void validateFormatDate(String date){
        Assert.assertTrue(date.matches(REG_EXP_DATE.getText()));
    }

    public static void validateStatusCode404(Integer statusCode){
        Assert.assertEquals(statusCode,Integer.parseInt(NOT_FOUND_CODE.getText()));
    }

    public static void validateStatusCode200(Integer statusCode){
        Assert.assertEquals(statusCode,Integer.parseInt(SUCCESS_CODE.getText()));
    }

    public static void validateSameStrings(String actual, String expected){
        Assert.assertEquals(actual,expected);
    }

    public static void validateSameNumbers(Integer actual, Integer expected){
        Assert.assertEquals(actual,expected);
    }




}
