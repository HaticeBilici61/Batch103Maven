package Team21_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P04_sonraTekrar_Bakilacak {
     //1-https://books-pwakit.appspot.com/ adresine gidin.
     //2-"BOOKS" başlığının görünür olduğunu doğrulayın
     //3-Arama çubuğunda "Selenium" u aratın.
     // 4-Arama sonuçlarındaki ilk ürün isminin "Selenium" içerdiğini doğrulayın.

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() {
        //1-https://books-pwakit.appspot.com/ adresine gidin.
        driver.get("https://books-pwakit.appspot.com/");

        //2-"BOOKS" başlığının görünür olduğunu doğrulayın

    }
}
