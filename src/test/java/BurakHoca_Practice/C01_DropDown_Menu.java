package BurakHoca_Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01_DropDown_Menu {

        // ...Exercise 1...

    // https://www.amazon.com/ sayfasina gidin
    // dropdown'dan "Books" secenegini secin
    // arama cubuguna "Java" aratın
    // arama sonuclarinin Java icerdigini test edin

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
        driver.close();
    }

    @Test
    public void test01() {
         // https://www.amazon.com/ sayfasina gidin
         driver.get("https://www.amazon.com/");

         // dropdown'dan "Books" secenegini secin
       WebElement dropMenu= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
       Select select=new Select(dropMenu);
       select.selectByVisibleText("Books");
       //select.selectByValue("search-alias=stripbooks");//value ile alinca value sini buluruz
       //select.selectByIndex(12);

       // arama cubuguna "Java" aratın
       driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Java", Keys.ENTER);

       // arama sonuclarinin Java icerdigini test edin
       WebElement aramaCubuk= driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
       String aramamenuyazisi= aramaCubuk.getText();
       Assert.assertTrue(aramamenuyazisi.contains("Java"));
    }
}
