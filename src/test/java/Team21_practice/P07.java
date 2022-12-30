package Team21_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P07 {
    //   // go to url :http://demo.automationtesting.in/Alerts.html
    //    click  "Alert with OK" and click 'click the button to display an alert box:'
    //"Alert with OK" butonuna tıklayın ve "click the button to display an  alert box:" 'a tıklayın
    //    accept Alert(I am an alert box!) and print alert on console
    //Alert(I am an alert box!) konsolda yazdırın ve Alert'ü kabul edin.
    //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
    //"Alert with OK & Cancel" butonuna tıklayın ve"click the button to display a confirm box " butonuna tıklayın
    //    cancel Alert  (Press a Button !)
    //Alert'ü kapatın
    //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
    //"Alert with Textbox" butonuna tıklayın ve "click the button to demonstrate the prompt box " butonuna tıklayın.
    //    and then sendKeys 'TechProEducation' (Please enter your name)
    //Açılan alert e 'TechProEducation' (Lütfen İsminizi girin).
    //Gönderdiğiniz metnin isminizi içerdiğini doğrulayın
    //    finally print on console this mesaaje "Hello TechproEducation How are you today"
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
        //   // go to url :http://demo.automationtesting.in/Alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");

        //   click  "Alert with OK" and click 'click the button to display an alert box:'
   driver.findElement(By.xpath("(//*[@class='analystic'])[1]")).click();
   driver.findElement(By.xpath("//*[@class='btn btn-danger']")).click();


        //Alert(I am an alert box!) konsolda yazdırın ve Alert'ü kabul edin.
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        //"Alert with OK & Cancel" butonuna tıklayın ve"click the button to display a confirm box " butonuna tıklayın
        driver.findElement(By.xpath("(//*[@class='analystic'])[2]")).click();
        driver.findElement(By.xpath("//*[text()='click the button to display a confirm box ']")).click();

        //Alert'ü kapatın
        driver.switchTo().alert().dismiss();

        //"Alert with Textbox" butonuna tıklayın ve "click the button to demonstrate the prompt box " butonuna tıklayın.
        driver.findElement(By.xpath("(//*[@class='analystic'])[3]")).click();
        driver.findElement(By.xpath("//*[text()='click the button to demonstrate the prompt box ']")).click();

        // //Açılan alert e 'TechProEducation' (Lütfen İsminizi girin).
        driver.switchTo().alert().sendKeys("Hatice");
        driver.switchTo().alert().accept();

        // //Gönderdiğiniz metnin isminizi içerdiğini doğrulayın
        WebElement AA =driver.findElement(By.xpath("//p[@id='demo1']"));
        String actual = AA.getText();
        System.out.println(actual);
        String beklenen = "Hava";
        Assert.assertTrue(actual.contains(beklenen));
    }

    }
