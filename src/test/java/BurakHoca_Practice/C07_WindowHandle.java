package BurakHoca_Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.Arrays;

public class C07_WindowHandle extends TestBase{

    @Test
    public void test02(){

        // 1- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
       String ilkwindowsayfa= driver.getWindowHandle();

        // 2- url'in 'amazon' icerdigini test edelim
        String url= driver.getCurrentUrl();
        Assert.assertTrue(url.contains("amazon"));

        // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String ikinciwindowsayfa= driver.getWindowHandle();

        // 4- title'in 'Best Buy' icerdigini test edelim
       String bestBuyTitle= driver.getTitle();
       Assert.assertTrue(bestBuyTitle.contains("Best Buy"));

        // 5- ilk sayfaya(amazon) donup sayfada "Java" aratalım
        driver.switchTo().window(ilkwindowsayfa);
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Java"+ Keys.ENTER);

        // 6- arama sonuclarının 'Java' icerdigini test edelim
       String sonucyazi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
       Assert.assertTrue(sonucyazi.contains("Java"));

        // 7- ikinci sayfaya(bestbuy) donelim
       driver.switchTo().window(ikinciwindowsayfa);

        // 8- logonun gorundugunu test edelim
       WebElement logo= driver.findElement(By.xpath("(//a[@class='canada-link'])[1]"));
       Assert.assertTrue(logo.isDisplayed());
    }
}
