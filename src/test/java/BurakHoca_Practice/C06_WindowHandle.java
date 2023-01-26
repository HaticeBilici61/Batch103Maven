package BurakHoca_Practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C06_WindowHandle extends TestBase {
    @Test
    public void test01(){
       // 1- https://www.amazon.com sayfasına gidin
        driver.get("https://www.amazon.com");
        String ilksayfa= driver.getWindowHandle();

        // 2- nutella icin arama yapın
       WebElement searchbox= driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
       searchbox.sendKeys("nutella", Keys.ENTER);

        // 3- yeni bir tab'da ilk urunun resmine tıklayınız
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("nutella" + Keys.ENTER);
        WebElement ilkurun=driver.findElement(By.xpath("(//img[@class='s-image'])[1]"));
        ilkurun.click();

        // 4- yeni tab'da acilan urunun basligini yazdirin
       String urunbaslik= driver.findElement(By.xpath("//span[@id='productTitle']")).getText();
       System.out.println("urunbaslik = " + urunbaslik);

        // 5- ilk sayfaya gecip url'i yazdırın
        driver.switchTo().window(ilksayfa);
        System.out.println(driver.getCurrentUrl());
    }
}
