package Homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class ErolHoca_odev extends TestBase {

    @Test
    public void odev1() {


//    - http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");

//    - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        Actions actions = new Actions(driver);
        WebElement sayfa = driver.findElement(By.xpath("//*[@class='signature-pad--body']"));

        actions.clickAndHold(sayfa).moveToElement(sayfa, 120, 0).release(sayfa).perform();
        actions.clickAndHold(sayfa).moveToElement(sayfa, 0, 120).release(sayfa).perform();
        actions.clickAndHold(sayfa).moveToElement(sayfa, -120, 0).release(sayfa).perform();
        actions.clickAndHold(sayfa).moveToElement(sayfa, 0, -120).release(sayfa).perform();
        actions.clickAndHold(sayfa).moveToElement(sayfa, 120, 120).release(sayfa).perform();
        actions.clickAndHold(sayfa).moveToElement(sayfa, -120, -120).release(sayfa).perform();
        actions.clickAndHold(sayfa).moveToElement(sayfa, -120, 120).release(sayfa).perform();
        actions.clickAndHold(sayfa).moveToElement(sayfa, 120, -120).release(sayfa).perform();


        //    - Çizimden sonra clear butonuna basalım
        //    - Son olarak sayfayı temizleyiniz/

    }

     @Test
     public void test01() {
         //    - http://szimek.github.io/signature_pad/ sayfasına gidiniz
         driver.get("http://szimek.github.io/signature_pad/");

         //    - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
         Actions actions = new Actions(driver);

         int radius = 110;
         WebElement centerOfCircle = driver.findElement(By.xpath("//*[@width='830']"));
         actions.moveToElement(centerOfCircle, 0, 0).perform();
         actions.clickAndHold().perform();

         actions.moveByOffset(-radius, 0).perform();
         actions.moveByOffset(0, -radius).perform();
         actions.moveByOffset(radius, 0).perform();
         actions.moveByOffset(0, radius).perform();
         actions.moveByOffset(-radius, 0).perform();
         actions.release().perform();

         //    - Cizimden sonra clear butonuna basalim
         waitFor(5);
         driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
         //    - Son olarak sayfayı temizleyiniz

     }
         //EROL HOCA COZUM

//         http://szimek.github.io/signature_pad/ sayfasına gidiniz
//         - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
//         - Çizimden sonra clear butonuna basalım
//         - Son olarak sayfayı temizleyiniz
//                 */
         @Test
         public void name() throws InterruptedException {
             driver.get("http://szimek.github.io/signature_pad/");
             WebElement yaziTahtasi = driver.findElement(By.xpath("//canvas"));
             Actions actions = new Actions(driver);
             actions.moveToElement(yaziTahtasi).clickAndHold();
             for (int i = 0; i < 10; i++) {
                 actions.moveByOffset(5,5);
             }
             for (int i = 0; i < 10; i++) {
                 actions.moveByOffset(0,5);
             }
             for (int i = 0; i < 10; i++) {
                 actions.moveByOffset(5,0);
             }
             actions.release().build().perform();
             Thread.sleep(5000);
             driver.findElement(By.xpath("//*[text()='Clear']")).click();

         }



    @Test
    public void odev2(){

      /*
     -https://jqueryui.com/slider/#colorpicker adrese gidiniz
     -Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız

     */ //-https://jqueryui.com/slider/#colorpicker adrese gidiniz
            driver.get("https://jqueryui.com/slider/#colorpicker");
            Actions actions = new Actions(driver);
            WebElement iframe = driver.findElement(By.xpath("//*[@class='demo-frame']"));
            driver.switchTo().frame(iframe);
            
            //Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
            WebElement Tus2 = driver.findElement(By.xpath("(//*[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]"));
            Tus2.click();
            for (int i=0 ; i<200 ;i++){
                actions.sendKeys(Keys.ARROW_LEFT).build().perform();
            }
            WebElement Tus3 = driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[3]"));
            Tus3.click();
            waitFor(2);
            for (int i=0;i<100;i++){
                actions.sendKeys(Keys.ARROW_LEFT).build().perform();
            }
            Tus2.click();
            for (int i =0;i<300;i++){
                actions.sendKeys(Keys.ARROW_RIGHT).build().perform();
            }
    }

    //EROL HOCA COZUM
        /*
     -https://jqueryui.com/slider/#colorpicker adrese gidiniz
     -Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
     -Sarı olduğunu test edelim
     */
    @Test
    public void name1() {
        //-https://jqueryui.com/slider/#colorpicker adrese gidiniz
        driver.get("https://jqueryui.com/slider/#colorpicker");
        WebElement iframe = driver.findElement(By.xpath("//*[@class='demo-frame']"));
        driver.switchTo().frame(iframe);
        //-Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
        WebElement yesilTus = driver.findElement(By.xpath("(//*[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]"));
        WebElement maviTus = driver.findElement(By.xpath("(//*[@class='ui-slider-handle ui-corner-all ui-state-default'])[3]"));
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(yesilTus,-175,0);//Genellikle slider' lar için bu method kullanılır
        actions.dragAndDropBy(maviTus,-80,0);
        actions.dragAndDropBy(yesilTus,301,0).release().build().perform();
        //-Sarı olduğunu test edelim
        WebElement sari = driver.findElement(By.xpath("//*[@style='background-color: rgb(255, 255, 0);']"));
        assert sari.isDisplayed();
    }
}




