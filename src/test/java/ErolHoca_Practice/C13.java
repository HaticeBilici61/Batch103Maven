package ErolHoca_Practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.ArrayList;

public class C13 extends TestBase {
    //- https://html.com/tags/iframe/ adresine gidiniz
    //    - youtube videosunu çalıştırınız
    //    - üç saniye çalıştıktan sonra sayfayı yenileyiniz
    //    - yeni sekmede amazon adresine gidiniz
    //    - iphone aratınız
    //    - arama sonucu olarak sadece sonuc sayısını yazdırınız
    //    - ilk sekmeye geri dönüp url'ini konsola yazdıralım
    //    - ilk sekmeyi kapatalım
    //    - Sonra diğer sekmeyide kapatalım

    @Test
    public void test01() throws InterruptedException {
        //- https://html.com/tags/iframe/ adresine gidiniz
        driver.get("https://html.com/tags/iframe/");
       String ilkwindow= driver.getWindowHandle();

        //    - youtube videosunu çalıştırınız
        WebElement iframe = driver.findElement(By.cssSelector("iframe[frameborder='0']"));
        driver.switchTo().frame(iframe);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[aria-label='Oynat']")).click();

        //    - üç saniye çalıştıktan sonra sayfayı yenileyiniz
        Thread.sleep(3000);
        driver.navigate().refresh();

        //    - yeni sekmede amazon adresine gidiniz
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com/");
        String amazonsayfasi=driver.getWindowHandle();

        //    - iphone aratınız
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone", Keys.ENTER);


        //    - arama sonucu olarak sadece sonuc sayısını yazdırınız
        String [] aramasonuc= driver.findElement(By.xpath(" //span[text()='1-16 of over 1,000 results for']")).getText().split(" ");
        System.out.println(aramasonuc[2]);

        // //    - ilk sekmeye geri dönüp url'ini konsola yazdıralım
        driver.switchTo().window(ilkwindow);
        String baglanti= driver.getCurrentUrl();
        System.out.println(baglanti);

        //    - ilk sekmeyi kapatalım amazon sayfasini
        driver.switchTo().window(amazonsayfasi);
        driver.close();
    }
}
