package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class TestBase {
    /*
      TestBase,testlerden once ve sonra tekrar tekrar kullandigimiz kodlari icerir.Before ve after gibi.
     */

    //driver objesini olustur.Driver ya public ya da Protected olmali.Sebebi child class larda gorulebilir olmasi
    protected static WebDriver driver;

    //setUp
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }
    @After
    public void tearDown() {
   //  driver.quit();
    }

}
