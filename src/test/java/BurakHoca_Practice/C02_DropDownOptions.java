package BurakHoca_Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class C02_DropDownOptions {

     // ...Exercise 2...


     // https://www.amazon.com/ sayfasina gidin
     // dropdown'dan "Baby" secenegini secin
     // sectiginiz option'i yazdirin
     // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin

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

      // dropdown'dan "Baby" secenegini secin
      WebElement secenek=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
      Select select=new Select(secenek);
      select.selectByVisibleText("Baby");

        // sectiginiz option'i yazdirin
      String sectigimOption=select.getFirstSelectedOption().getText();
        System.out.println("sectigimOption = " + sectigimOption);


      // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
      List<WebElement> tumOptionlar=  select.getOptions();
      int actualOptionSayisi=tumOptionlar.size();
      int expectedOptinonSayisi=28;
        Assert.assertEquals(28,actualOptionSayisi);

        //lambda ile
    // List<WebElement> options=  tumOptionlar.stream().collect(Collectors.toList());
    //  Assert.assertTrue(options.size()==28);
    }
}
