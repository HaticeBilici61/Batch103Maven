package Homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;
import java.util.Set;

public class day7_Odev extends TestBase {
//    Bir class olusturun: IframeOdev
//    https://the-internet.herokuapp.com/iframe  sitesine gidiniz
//    sayfadaki toplam iframe sayısını bulunuz.
//    Sayfa basliginda ‘Editor’ yazını içerdiğini test edelim.
//    Paragrafdaki yaziyi silelim
//    Sonrasinda paragrafa “iframein icindeyim” yazisini yazdıralım
//    Alt kısımdaki yazının ‘Elemental Selenium’ yazisini içerdiğini test edelim

    @Test
    public void ifRame(){
        //    https://the-internet.herokuapp.com/iframe  sitesine gidiniz
        driver.get(" https://the-internet.herokuapp.com/iframe");

        //    sayfadaki toplam iframe sayısını bulunuz.
    List<WebElement> baslik = driver.findElements(By.tagName("iframe"));
    int basliksayisi= baslik.size();
    System.out.println("basliksayisi =" + basliksayisi);

        //    Sayfa basliginda ‘Editor’ yazını içerdiğini test edelim.
    String baslikmetni=driver.findElement(By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']")).getText();
    String expectedmetin="Editor";
    Assert.assertTrue(baslikmetni.contains(expectedmetin));

        //    Paragrafdaki yaziyi silelim
     driver.switchTo().frame(0);
     WebElement sayfa=   driver.findElement(By.xpath("//p[text()='Your content goes here.']"));
     sayfa.clear();

        //    Sonrasinda paragrafa “iframein icindeyim” yazisini yazdıralım
        sayfa.sendKeys("iframein icindeyim");

     //    Alt kısımdaki yazının ‘Elemental Selenium’ yazisini içerdiğini test edelim
      driver.switchTo().parentFrame();
      String metin=  driver.findElement(By.xpath("//a[.='Elemental Selenium']")).getText();
      String expectedmetins="Elemental Selenium";
      Assert.assertTrue(metin.contains(expectedmetins));
    }

    @Test
    public void odev2(){
         /*
      https://testcenter.techproeducation.com/index.php?page=multiple-windows
      Title'in "Windows" oldugunu test edin
      Click here a tiklayin
      Sonra acilan sayfadaki title in "New Window" oldugunu dogrulayin

 */
   // https://testcenter.techproeducation.com/index.php?page=multiple-windows
        driver.get("https://testcenter.techproeducation.com/index.php?page=multiple-windows");

    //  Title'in "Windows" oldugunu test edin
       String windowhandle1= driver.getTitle();
       String expectedbaslik="Windows";
       Assert.assertEquals(expectedbaslik,windowhandle1);

     //   Click here a tiklayin
       driver.findElement(By.xpath("//a[.='Click Here']")).click();

     // Sonra acilan sayfadaki title in "New Window" oldugunu dogrulayin
      Set<String> pencereler= driver.getWindowHandles();
      for (String w:pencereler){
          pencereler.stream().filter(t-> !t.equals(windowhandle1)).forEach(t-> System.out.println(driver.switchTo().window(t)));

          String windowhandle2=driver.findElement(By.xpath("//h3[.='New Window']")).getText();
          String expectedbaslik2="New Window";
          Assert.assertEquals(expectedbaslik2,windowhandle2);
      }
    }



}
