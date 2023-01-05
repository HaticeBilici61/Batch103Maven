package day08_IFrame;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01_IFrame extends TestBase {

    @Test
          public void iframeTest(){
      //  Iframe nedir?
      //  https://testcenter.techproeducation.com/index.php?page=iframe
      //  Ana sayfadaki " An iframe with a thin black border": metnin "black border "yazisinin oldugunu test edelim
      //  Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim
      //  Son olarak footer daki ‘Powered By’ yazisini varligini test edilip

         //        https://testcenter.techproeducation.com/index.php?page=iframe
       driver.get(" https://testcenter.techproeducation.com/index.php?page=iframe");

        //        Ana sayfadaki " An iframe with a thin black border": metnin "black border "yazisinin oldugunu test edelim
      String anaMetin=  driver.findElement(By.xpath("//p[.='An iframe with a thin black border:']")).getText();
      //tag[.='metin']; --->bana su tagli metni ver demek

      String expectedTest="black border";
      Assert.assertTrue(anaMetin.contains(expectedTest));

        //        Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim
        //Applications list elementi iframe in icinde .Iframe swich yapmam sart
        driver.switchTo().frame(0);
       String icMetin= driver.findElement(By.xpath("//h1[.='Applications lists']")).getText();
       String expectedIcMetin="Applications lists";
       Assert.assertEquals(expectedIcMetin,icMetin);

        //  Son olarak footer daki ‘Powered By’ yazisini varligini test edilip

        //ic metinden dis kisima yani ana sayfadaki yaziyi test emek istiyorum.Driver i Iframe in disina cikmak icin
        driver.switchTo().parentFrame();
      String text=  driver.findElement(By.xpath("(//footer[@class='blog-footer'][1])//p")).getText();
      String expectedMetin="Powered By";
      Assert.assertTrue(text.contains(expectedMetin));


      //bir sayfadaki toplam Iframe sayisi nasil bulunur
        /*
        iframe ler iframe tagi kullanilarak olusturulur.bu durumda find element by frame
        locaterini kullanarak tum iframe leri bulurum
         */
        driver.findElements(By.tagName("iframe"));//tum iframe leri liste olarak verir.
        driver.findElements(By.xpath("//iframe"));

        //tekrar anasayfaya nasil donersin
        /*
        iki farkli yol vardir.1--defaultContent ...
                              2--parentFrame e gecis yapaniliriz

        DEFAULTCONTENT ILE PARENTFRAME arasindaki fark nedir?
        a)oncelikle her ikiside frame in disina cikmamizi saglar.Ama defaultContenct ana sayfaya direk atlatir
        ParentFrame ise bir ust seviyeye atlatir.

         */
        //bir test Case in fail etme sebepleri neler olabilir
        /*
        1-yanlis locater...cozum tekrar elementi locate etmek.Degisken element var ise ona gore dinamik bir xpath yazilir
        2-wait/Synchronization /Bekleme problemi---imlicitywait de yeterli sure oldugundan emin oluruz.o sureyi artirabiliriz
        .30 saniye verilebilir.Explicit wait kullanilabilir
        3-iframe cozum: switch to iframe
        4-alert  cozum:swich to alert
        5-new window(yeni pencere):switch to window

         */

        }
    }

