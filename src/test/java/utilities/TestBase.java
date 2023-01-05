package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

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

    //MULTIPLE WINDOW

    //1 parametre alir:gecis yapmak istedigim sayfanin Title(targetTitle girmek istedoigimiz sayfanin adi niteliginde
    //ORNEK:
    //driver.get("https://the-internet.herokuapp.com/windows");
    //switchToWindow("New Window");
    //switchToWindow("The Internet")
    public static void switchToWindow(String targetTitle){
        String origin=driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()){
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(targetTitle)){
                return;
            }

        }
        driver.switchTo().window(origin);
    }
    //windowNumber sıfır (0)'dan başlıyor.
    //index numarasini parametre olarak alir
    //ve o indexli pencereye gecis yapar
    public static void switchToWindow(int windowNumber){
        List<String> list = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(list.get(windowNumber));
    }

    /*   HARD WAIT:
  @param : second
*/
    public static void waitFor(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
