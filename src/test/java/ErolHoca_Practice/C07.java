package ErolHoca_Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.stream.IntStream;

public class C07 {
    static WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown(){
       // driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        /*
    - ebay sayfasına gidiniz
    - electronics bölümüne tıklayınız
    - Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
    - Her sayfanın sayfa başlığını yazdıralım
    - sayfayı kapatalım

 */     // - ebay sayfasına gidiniz
        driver.get("https://ebay.com");

        // - electronics bölümüne tıklayınız
        driver.findElement(By.xpath("(//*[text()='Electronics'])[2]")).click();

       // - Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
        for (int i=0; i<24 ;i++){
            List<WebElement> images = driver.findElements(By.xpath("//img[@width='225' and @height='225']"));
            images.get(i).click();
            Thread.sleep(2000);
            System.out.println(i+".baslik"+driver.getTitle());
            Thread.sleep(2000);
            driver.navigate().back();


      }
    }
}
