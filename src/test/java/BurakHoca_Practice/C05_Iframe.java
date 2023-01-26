package BurakHoca_Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_Iframe extends TestBase {
    @Test
    public void iframe01(){
// ...Exercise 1...


        // https://html.com/tags/iframe sayfasına gidiniz
        driver.get("https://html.com/tags/iframe");

        // Videoyu görecek kadar asagiya ininiz
       Actions actions=new Actions(driver);
       actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();

        // Videoyu izlemek icin Play tusuna basiniz
        WebElement iframe = driver.findElement(By.xpath("(//div[@class='render'])[1]//iframe"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//div[@class='ytp-impression-link-logo']")).click();

        // Videoyu calistirdiginizi test ediniz
        WebElement youtubeYazısı=driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youtubeYazısı.isDisplayed());

        // 'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz
        driver.switchTo().parentFrame();
        WebElement Powerful=driver.findElement(By.xpath("//span[text()='Powerful, but easy to misuse']"));
        Assert.assertTrue(Powerful.isDisplayed());

    }

    @Test
    public void C02Iframe(){
        
        // ...Exercise 2...


    // https://the-internet.herokuapp.com/iframe sayfasina gidiniz
       driver.get("https://the-internet.herokuapp.com/iframe");

    // 'An iFrame containing the TinyMCE WYSIWYG Editor' basliginin erisilebilir oldugunu test edin ve konsolda yazdırın.
       WebElement baslik= driver.findElement(By.xpath("//h3"));
       Assert.assertTrue(baslik.isEnabled());

       String basliktext= baslik.getText();
        System.out.println("BASLIK = " + basliktext);

    // TextBox'a 'Merhaba Dunya' yazin.
      WebElement iframe=  driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
      driver.switchTo().frame(iframe);

      WebElement texbox= driver.findElement(By.xpath("//body[@id='tinymce']"));
      texbox.clear();
      texbox.sendKeys("Merhaba Dunya");

    // TextBox'in altinda bulunan 'Elemental Selenium' linkinin gorunur oldugunu test edin ve konsolda yazdirin
      driver.switchTo().parentFrame();
      WebElement disyazi= driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
      Assert.assertTrue(disyazi.isDisplayed());
      System.out.println(disyazi.getText());

    }
}
