package Team21_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class P03 {
    // https://the-internet.herokuapp.com/dropdown adresine gidin.
    // 1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    // 2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    // 3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    // 4.Tüm dropdown değerleri(value) yazdırın
    // 5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.


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
      // https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

      // 1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
     WebElement option1= driver.findElement(By.xpath("//select[@id='dropdown']"));
     Select secenek1=new Select(option1);
     secenek1.selectByIndex(1);
     System.out.println(secenek1.getFirstSelectedOption().getText());

     // 2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        WebElement option2= driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select secenek2=new Select(option2);
        secenek2.selectByValue("2");
        System.out.println(secenek2.getFirstSelectedOption().getText());

      // 3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement options= driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select secenek=new Select(options);
        secenek.selectByVisibleText("Option 1");
        System.out.println(secenek.getFirstSelectedOption().getText());

     // 4.Tüm dropdown değerleri(value) yazdırın
      List<WebElement> list= secenek.getOptions();
      for (WebElement w:list){
          System.out.println(w.getText());
      }

     // 5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
       int actualsayi= list.size();
       int expectedSayi=4;

        Assert.assertFalse(actualsayi>4);
        String sonuc =expectedSayi==4 ? "true" : "false" ;
        System.out.println(sonuc);
    }

    @After
    public void tearDown() {
        driver.close();

    }
}
