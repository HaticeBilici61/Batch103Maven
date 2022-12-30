package BurakHoca_Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_DropDown {
    // https://the-internet.herokuapp.com/dropdown adresine gidin.
    // Index kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
    // Value kullanarak Option 2 seçin ve sectiginiz option'u yazdırın
    // Visible Text kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
    // Tüm option'ları yazdırın
    // dropdown'daki optionlarin toplam sayısının 3'e esit oldugunu test edin


    static WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    @Ignore
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test01() {
        // https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

        // Index kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
        WebElement secenek = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select obj1 = new Select(secenek);
        obj1.selectByIndex(1);
        System.out.println(obj1.getFirstSelectedOption().getText());

        // Value kullanarak Option 2 seçin ve sectiginiz option'u yazdırın
        obj1.selectByValue("2");
        System.out.println(obj1.getFirstSelectedOption().getText());

        // Visible Text kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
        obj1.selectByVisibleText("Option 1");
        System.out.println(obj1.getFirstSelectedOption().getText());

        // Tüm option'ları yazdırın
        List<WebElement> options = obj1.getOptions();
        for (WebElement w : options) {
            System.out.println(w.getText());

            //lambda ile
            options.forEach(t-> System.out.println(t.getText()));

        // dropdown'daki optionlarin toplam sayısının 3'e esit oldugunu test edin
        int actual = options.size();
        int expected = 3;
        Assert.assertEquals(expected,actual);
        }
    }
}
