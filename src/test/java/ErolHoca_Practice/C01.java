package ErolHoca_Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {
    /*
         -"amazon.com" adresine gidelim
      bu web adresinin sayfa basligini(title) ve adres(url)ini yazdıralım
      title ve url'nin "Spend" kelimesinin icerip icermedigini kontrol edelim
      Ardindan "trendyol.com" adresine gidelim
      bu adresin basligini alalim ve "Sitesi" kelismesini icerip icermedigini kontrol edelim
      Bi onceki web sayfamiza geri donelim
      sayfayi yenileyelim
      Daha sonra trendyol sayfamiza tekrar donelim ve sayfayi kapatalim

     */

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //  -"amazon.com" adresine gidelim
        driver.get("https://www.amazon.com/");

        // bu web adresinin sayfa basligini(title) ve adres(url)ini yazdıralım
        String actualTitel=driver.getTitle();
        String acturalUrl= driver.getCurrentUrl();
        System.out.println(actualTitel);
        System.out.println(acturalUrl);

        // title ve url'nin "Oto" kelimesinin icerip icermedigini kontrol edelim
        Assert.assertTrue(actualTitel.contains("spend") && acturalUrl.contains("spend"));

        // Ardindan "trendyol.com" adresine gidelim
       driver.get("https://www.trendyol.com");

       //bu adresin basligini alalim ve "Sitesi" kelismesini icerip icermedigini kontrol edelim
        String trendyolBaslik=driver.getTitle();
        Assert.assertFalse(trendyolBaslik.contains("Sitesi"));

     //  Bi onceki web sayfamiza geri donelim
        driver.navigate().back();

        // sayfayi yenileyelim
        driver.navigate().refresh();

        // Daha sonra trendyol sayfamiza tekrar donelim ve sayfayi kapatalim
        driver.navigate().forward();

        driver.quit();
    }
}
