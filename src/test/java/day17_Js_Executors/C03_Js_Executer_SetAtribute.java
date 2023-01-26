package day17_Js_Executors;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03_Js_Executer_SetAtribute extends TestBase {

    /*
    typeTest metotu olustur
    Techpro education ana sayfasina git
    Arama kutusuna QA yaz
     */
    @Test
    public void typeTest(){
        //    Techpro education ana sayfasina git
        driver.get("https://www.techproeducation.com");
        waitFor(3);
        typeWithJS(driver.findElement(By.xpath("//input[@type='search']")),"QA");
    }


}
