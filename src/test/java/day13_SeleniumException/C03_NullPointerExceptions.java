package day13_SeleniumException;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import utilities.TestBase;

public class C03_NullPointerExceptions extends TestBase {
//    NullPointerException
//    Degiskenleri oluşturup instantiate etmediğimizde alırız(new kelimesini kullanmadigimizda)
//    Ornegin WebDriver driver; deyip = new ChromeDriver() demezisek null pointer exception aliriz
//    Solution:
//    Degiskeni instantiate et


    WebDriver driver;
    Faker faker;

    @Test
    public void nullPointerExceptionTest(){
        driver.get("https://www.techproeducation.com"); //Java.lang.NullPointerexception cunku =NEW WEB.cHROMEDRIVER demedik


    }

    @Test
    public void nullPointerExceptionTest02(){
        System.out.println(faker.name().fullName());//Java.lang.NullPointerexception cunku  =NEW WEB.FAKER DEMEDIK
    }
}
