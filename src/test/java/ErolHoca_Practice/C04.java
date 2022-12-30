package ErolHoca_Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04 {
    // http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
    // Add Element butonuna 100 defa basınız
    // 100 defa basıldığını test ediniz

    // 90 defa basıldığını doğrulayınız
    // Sayfayı kapatınız
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        // Add Element butonuna 100 defa basınız
        WebElement buton = driver.findElement(By.xpath("//*[@onclick='addElement()']"));

        for (int i = 0; i < 100; i++) {
            buton.click();
        }
        // 100 defa basıldığını test ediniz
        List<WebElement> deletesayisi = driver.findElements(By.xpath("//*[@onclick='deleteElement()']"));
        Assert.assertEquals(100,deletesayisi.size());

        // 90 defa delete butonuna basınız

        for (int i = 0; i < 90; i++) {
            driver.findElement(By.xpath("//*[@onclick='addElement()']"));
        }

        // 90 defa basıldığını doğrulayınız
        List<WebElement> deletesayi = driver.findElements(By.xpath("//*[@onclick='deleteElement()']"));
        // Assert.assertEquals(deletesayisi.size(), 90);

        //lambda ile cozum
        deletesayi.stream().skip(10).limit(90).forEach(t->t.click());

        //diger cozum
        // 90 defa basıldığını doğrulayınız
        List<WebElement> kalanDeleteButtons = driver.findElements(By.xpath("//*[@onclick='deleteElement()']"));
        int kalan = (int) kalanDeleteButtons.stream().count();
        System.out.println(kalan);
        Assert.assertEquals(10, kalan);

        driver.quit();

    }
}