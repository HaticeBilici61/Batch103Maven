package Team21_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Soru1 {
           //1. "https://www.saucedemo.com" Adresine gidin
       //2. Username kutusuna "standard_user" yazdirin
       //3. Password kutusuna "secret_sauce" yazdirin
       //4. Login tusuna basin
       //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
       //6. Add to Cart butonuna basin
       //7. Alisveris sepetine tiklayin
       //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
       //9. Sayfayi kapatin

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        ////1. "https://www.saucedemo.com" Adresine gidin
        driver.get("https://www.saucedemo.com");

        //2. Username kutusuna "standard_user" yazdirin
       driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //3. Password kutusuna "secret_sauce" yazdirin
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("secret_sauce");

        //4. Login tusuna basin
        driver.findElement(By.id("login-button")).click();

        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
     String  ilkUriuntest= driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']")).getText();
        driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']")).click();

        //6. Add to Cart butonuna basin
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        // //7. Alisveris sepetine tiklayin
          driver.findElement(By.className("shopping_cart_badge")).click();

        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
      String sepetKontrol=  driver.findElement(By.id("item_4_title_link")).getText();
      if (sepetKontrol.contains(ilkUriuntest)){
          System.out.println("sepet test passed");
      }else{
          System.out.println("sepet test failed");
      }

        //9. Sayfayi kapatin
        driver.quit();

     }
}
