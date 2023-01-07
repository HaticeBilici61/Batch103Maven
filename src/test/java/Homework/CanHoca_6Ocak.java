package Homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class CanHoca_6Ocak extends TestBase {

    @Test
    public void odev(){
        //Go to https://www.amazon.com.tr/.... // https://www.amazon.com.tr/ adresine gidin
        driver.get("https://www.amazon.com.tr/");


        driver.findElement(By.xpath("(//span[.='Çerezleri Kabul Et'])[1]")).click();//cerez icin
        //    //Search iPhone13 512.........  // //iPhone13 512'de ara
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iPhone13 512", Keys.ENTER);

       waitFor(1);
        //    //Check that the results are listed...... // //Sonuçların listelenip listelenmediğini kontrol edin
        String actuallist=   driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        Assert.assertTrue(actuallist.contains("iphone 13 512"));

        //    //Click iPhone13 at the top of the list....../ //Listenin en üstündeki iPhone13'e tıklayın
        driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]")).click();

            //Log the following values for each size .Size information .Price .Color .Stock status....

        waitFor(1);
        String model= driver.findElement(By.xpath("//span[@id='productTitle']")).getText();
        System.out.println("model = " + model);

        String size = driver.findElement(By.xpath("(//p[@class='a-text-left a-size-base'])[3]")).getText();
        System.out.println("size = " + size);

        String fiyat= driver.findElement(By.xpath("//div[@class='a-section a-spacing-none aok-align-center']")).getText();
        System.out.println("fiyat = " + fiyat);

        String stock = driver.findElement(By.xpath("//*[@class='a-size-medium a-color-success']")).getText();
        System.out.println("stock = " + stock);


        }


    }



