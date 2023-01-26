package day14_GetScreenshotClassWork;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ScreenShot extends TestBase {
    @Test
    public void fullPageScreenshotpage() throws IOException {
     /*
     Selenium tun ekran goruntusu nasil alinir?
         -tum ekran goruntusu seleniumdan gelen getScreenshotAs metotu ile alinir.
         -getScreenshotAs metotu seleniumdaki TakesScreenshot api indan gelir
      */

      //  Techproeducation a git ve Sayfanin goruntusunu al
        driver.get("https://www.techproeducation.com");

      // 1-oncelikle  ekran goruntusunu getScreenShotAs methodu ile alip File olarak olusturalim
       File goruntu=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //ekran goruntusunu aldik

      // 2-almis oldugum ekran goruntusunu belirledigim bir PATH e kaydet
        //Note: kayit ismini dinamik yapmak icin data objesini kullandim
        String currentDate=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path=System.getProperty("user.dir")+"/test-output/EkranGoruntuleri/"+currentDate+"image.png";
        File hedef=new File(path);

       // 3-goruntu ile dosayami birlestirip kaydet
        FileUtils.copyFile(goruntu,hedef);

     //  ALTERNATIF OLARAK TUM BU ADIMLARI TEK SEFERDE DEGISKEN KULLANMADAN YAPABILIRIM
     //  FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE),//goruntu
     //  new File(System.getProperty("user.dir")+"/test-output/EkranGoruntuleri/image.png"));//path



//        -“QA” aramasi yap
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("QA"+ Keys.ENTER);

        waitFor(3);
//        Acilen sayfanin metnini test et ve ekran goruntusu al: “Search Results for: qa”
        String expected ="Search Results for: QA";
        String text = driver.findElement(By.xpath("//*[contains(text(),'Search Results for')]")).getText();
        Assert.assertTrue(expected.contains(text));


        //reusable method yardimiyla ekran goruntusu alalim
        takeScreenShotOfPage();
    }
}
