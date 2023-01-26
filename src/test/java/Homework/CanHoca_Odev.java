package Homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;
import java.util.Set;

public class CanHoca_Odev extends TestBase {
    //go to web site : https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
    //maximize the web site
    // ikinci emojiye tıklayın
    // ikinci emoji altındaki tüm öğelere tıklayın
    // ana iframe'e geri dön
    //formu doldurun,(Formu istediğiniz metinlerle doldurun)
    // uygula butonuna tıklayın

    @Test
    public void odev1() throws InterruptedException {
        //go to web site : https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        //maximize the web site
        driver.manage().window().maximize();
        Thread.sleep(2000);

          // // ikinci emojiye tıklayın(iframe ile icine giris yaptim
        driver.switchTo().frame(driver.findElement(By.id("emoojis")));

        // ikinci emoji altındaki tüm öğelere tıklayın
       driver.findElement(By.xpath("(//span[@data-upgraded=',MaterialRipple'])[2]")).click();
       List<WebElement> emojiler= driver.findElements(By.xpath("//div[@id='nature']//div/img"));
       for (WebElement w:emojiler){
           w.click();
       }
       //Lambda ile ==> emojiler.stream().forEach(t-> t.click());


        // ana iframe'e geri dön
        driver.switchTo().defaultContent();


        //formu doldurun,(Formu istediğiniz metinlerle doldurun)
        driver.findElement(By.id("text")).sendKeys("htc", Keys.TAB,"blc",Keys.TAB,"amn",Keys.TAB,"svd",Keys.TAB,
                "htc", Keys.TAB,"blc",Keys.TAB,"amn",Keys.TAB,"svd",Keys.TAB,"zfr",Keys.TAB  );
        driver.findElement(By.xpath("//button[@id='send']"));
        Thread.sleep(2000);

    }

    @Test
    public void odev2() throws InterruptedException {
        /*
       url'ye git: http://demo.guru99.com/popup.php
       ilk pencereyi al
       "Click Here" butonuna tıklayın
       setteki tüm pencereyi al
       diğer pencereye geç
       e-posta kimliğini (somepne@gmail.com) girin ve bu girişe bir şey yazın
       Gönder düğmesine tıklayarak
       ""This access is valid only for 20 days."" ifadesinin beklendiği gibi olduğunu doğrula
       Tekrar ilk pencereye geç
       İlk pencerede olduğunu doğrula
      */
        //  url'ye git: http://demo.guru99.com/popup.php
        driver.get(" http://demo.guru99.com/popup.php");

        // ilk pencereyi al
        String windowhandle1= driver.getWindowHandle();
        Thread.sleep(2000);
        String pencere1url=  driver.getCurrentUrl();

        //cookies
        WebElement iframe=driver.findElement(By.id("gdpr-consent-notice"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("(//div[@class='action-wrapper'])[3]")).click();
        driver.switchTo().parentFrame();
        Thread.sleep(2000);

        // "Click Here" butonuna tıklayın
        driver.findElement(By.linkText("Click Here")).click();
       Thread.sleep(3000);

        // setteki tüm pencereyi al ve
        Set<String> pencereler=  driver.getWindowHandles();
        System.out.println(pencereler);

        // diğer pencereye geç
        for (String w :pencereler){
            if (!w.equals(windowhandle1)){
                driver.switchTo().window(w);
            }
      }
      // e-posta kimliğini (somepne@gmail.com) girin ve bu girişe bir şey yazın,gonder dugmesine tiklayarak
        driver.findElement(By.name("emailid")).sendKeys("somepne@gmail.com", Keys.ENTER);

        // ""This access is valid only for 20 days."" ifadesinin beklendiği gibi olduğunu doğrula
       String yazi= driver.findElement(By.xpath("//h3[text()='This access is valid only for 20 days.']")).getText();
       String expectedYazi="This access is valid only for 20 days.";
        Assert.assertEquals(expectedYazi,yazi);
        Thread.sleep(1000);

        //  Tekrar ilk pencereye geç
       driver.switchTo().window(windowhandle1);
       Thread.sleep(1000);

        // İlk pencerede olduğunu doğrula
          Assert.assertEquals(pencere1url,driver.getCurrentUrl());

    }


       //https://demoqa.com/ url'ine gidin.
       //Alerts, Frame & Windows Butonuna click yap
       //""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
       //Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
       //New Tab butonunun görünür olduğunu doğrula
       //New Tab butonuna click yap
       //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
       //İlk Tab'a geri dön
       ////New Tab butonunun görünür olduğunu doğrula

    @Test
    public void odev3(){

        // //https://demoqa.com/ url'ine gidin.
        driver.get("https://demoqa.com/");
       String windowhndl1= driver.getWindowHandle();

        //Alerts, Frame & Windows Butonuna click yap
        driver.findElement(By.xpath("(//div[@class='card mt-4 top-card'])[3]")).click();

        //""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
      String actualmetin=  driver.findElement(By.xpath("//div[.='Please select an item from left to start practice.']")).getText();
      String expectedmetin="Please select an item from left to start practice.";
      Assert.assertEquals(expectedmetin,actualmetin);

       waitFor(3);
       //Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
        driver.findElement(By.xpath("(//*[@id='item-0'])[3]")).click();

        // //New Tab butonunun görünür olduğunu doğrula
       WebElement newtab= driver.findElement(By.id("tabButton"));
      Assert.assertTrue(newtab.isDisplayed());
      waitFor(3);

        //New Tab butonuna click yap
        newtab.click();

        // //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
          Set<String> pencereler= driver.getWindowHandles();
          for (String w:pencereler){
              if(!w.equals(windowhndl1)){
                  driver.switchTo().window(w);
              }
          }
          String windowhandl2=driver.getWindowHandle();
       String actualmetn= driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText();
       String expectedmetn="This is a sample page";
       Assert.assertEquals(expectedmetn,actualmetn);

       // //İlk Tab'a geri dön
        driver.switchTo().window(windowhndl1);

        ////New Tab butonunun görünür olduğunu doğrula
       Assert.assertTrue(newtab.isDisplayed());
    }
}
