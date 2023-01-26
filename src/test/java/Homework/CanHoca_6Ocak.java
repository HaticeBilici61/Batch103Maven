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

        List<WebElement> boyutlar = driver.findElements(By.xpath("(//ul[@class='a-unordered-list a-nostyle a-button-list a-declarative a-button-toggle-group a-horizontal dimension-values-list'])[2]//li[@data-asin]"));
        List<WebElement> renkler = driver.findElements(By.xpath("(//ul[@class='a-unordered-list a-nostyle a-button-list a-declarative a-button-toggle-group a-horizontal dimension-values-list'])[1]//li[@data-asin]"));
        renkler.stream().forEach(t-> System.out.println(t.getText()));
        for (int i = 0; i < renkler.size(); i++) {
            renkler.get(i).click();
            waitFor(2);
            for (int j = 0; j < boyutlar.size(); j++) {
                waitFor(2);
                if (!boyutlar.get(j).getText().contains("Mevcut")) {
                    boyutlar.get(j).click();
                    waitFor(2);
                    driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
                    waitFor(2);
                    driver.findElement(By.xpath("//a[@id='attach-close_sideSheet-link']")).click();//alisverise devam etmek icin acilan sayfayi kapatir
                    System.out.println();
                }
            }
        }
        driver.findElement(By.xpath("//span[@id='nav-cart-count']")).click();
        List<WebElement>w=driver.findElements(By.xpath("//span[@class='a-list-item']"));//konsolda gormek istedigimiz tum bilgileri bir list icine attik
        waitFor(1);
        w.add(driver.findElement(By.xpath("//span[text()='Fiyat']")));//fiyat ismini eklrdik
        w.add(driver.findElement(By.xpath("//*[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']")));//fiyatin kendisini yazdirdik
        waitFor(1);
        w.stream().skip(4).filter(t->!t.getText().startsWith("B")).forEach(t-> System.out.println(t.getText()));
    }


}






