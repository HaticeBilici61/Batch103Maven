package day17_Js_Executors;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.IOException;

public class C01_ extends TestBase {

    @Test
    public void  scrollIntoViewTest() throws IOException {

        //    scrollIntoViewTest metotu olustur
//    Techpro education ana sayfasina git
        driver.get("https://www.techproeducation.com");

//    We Offer elementi gorunur olacak sekilde uzerine scroll et ve ekran gorunturunu al

        //1.elementi bul
       WebElement weOffer= driver.findElement(By.xpath("//span[text()='we offer']"));

       //2.javascript excuter objesi olustur
        JavascriptExecutor js=(JavascriptExecutor)driver;

        //3.yapmak istedigim islemi js.executeScript ile yap

        //        scrollIntoView(true); metotu belirli bir elemente scroll yapmak icin kullanilir
        //arguments[0] ilk parametredeki element
        js.executeScript("arguments[0].scrollIntoView(true);",weOffer);
        waitFor(3);
        takeScreenShotOfPage();//sayfa goruntusunu aldik method ile

        //    Ayni sayfada Enroll Free elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
        scrollIntoViewJS(driver.findElement(By.xpath("//span[.='Enroll Free Course']")));
        waitFor(3);
        takeScreenShotOfPage();

//    Ayni sayfada WHY US? elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
     scrollIntoViewJS(driver.findElement(By.xpath("//h3[text()='WHY US?']")));
     takeScreenShotOfPage();//tum sayfanin goruntusunu aldik

//    Ayni sayfada tekrar Enroll Free elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al

        scrollIntoViewJS(driver.findElement(By.xpath("//span[.='Enroll Free Course']")));
        waitFor(3);
        takeScreenShotOfPage();
    }









    }

