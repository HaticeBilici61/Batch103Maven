package day08_IFrame;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class C01_WindowHandle1 extends TestBase {
    // Tests package’inda yeni bir class olusturun: WindowHandle
    // https://the-internet.herokuapp.com/windows adresine gidin.
    // Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    // Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    // Click Here butonuna basın.
    // Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    // Sayfadaki textin “New Window” olduğunu doğrulayın.
    // Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.

    @Test
    public void handleWindow() throws InterruptedException {
        // https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

      //  ILK SAYFANIN ID SINI ALALIM
        String window1handle= driver.getWindowHandle();


        // Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
       String baslik= driver.findElement(By.xpath("//*[text()='Opening a new window']")).getText();
       String expectedBaslik="Opening a new window";
        Assert.assertEquals(expectedBaslik,baslik);

        // Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
      String window1title=  driver.getTitle();
      String expectedtitel="The Internet";
      Assert.assertEquals(expectedtitel,window1title);

        // Click Here butonuna basın.
        driver.findElement(By.xpath("//a[.='Click Here']")).click();

        // Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.

        //BU NOKTADA 2 PENCERE ACIK VE 2:SINE GECIS YAPMAK ISTIYORUM bunun icin driver.getwindowhandles ile tum pencere id lerini alalim
      Set<String> pencereler=  driver.getWindowHandles();//{window1handle,window2handle}
      System.out.println(pencereler);

      for (String w: pencereler){
          if (!w.equals(window1handle)){
              driver.switchTo().window(w);
              break;
     //NOT:eger listedeki id window1handel a esit degilse ,otomatik olarak window2handle a esittir

              //lambda ile
           //   pencereler.stream().filter(t-> !t.equals(window1handle)).forEach(t-> System.out.println(driver.switchTo().window(t)));
          }
      }

      //BU NOKTADA DRIVER 2. PENCEREDE
        // Sayfadaki textin “New Window” olduğunu doğrulayın.
      String baslik2sayfa=  driver.findElement(By.xpath("//h3[.='New Window']")).getText();
      String expectedbaslik2="New Window";
      Assert.assertEquals(expectedbaslik2,baslik2sayfa);

      // // Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
        String windowhandle2=driver.getWindowHandle();//suanda driver 2.sayfa da

        driver.switchTo().window(window1handle);//1.sayfaya direk gecis
        String window1titles=  driver.getTitle();
        String expectedtitels="The Internet";
        Assert.assertEquals(expectedtitels,window1titles);


        Thread.sleep(3000);
//        2. windowa tekrar gecelim
        driver.switchTo().window(windowhandle2);
        Thread.sleep(3000);
//        1. windowa tekrar gecelim
        driver.switchTo().window(window1handle);
    }

}
