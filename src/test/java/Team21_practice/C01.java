package Team21_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01 {
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void nameAlktions(){
        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
      WebElement anasayfabaslik= driver.findElement(By.cssSelector("[src='/static/images/home/logo.png']"));
        Assert.assertTrue(anasayfabaslik.isDisplayed());

        //4. 'Kaydol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.cssSelector("[href='/login']")).click();

        //5. "Hesabınıza giriş yapın"ın göründüğünü doğrulayın
       WebElement hesabagiris= driver.findElement(By.xpath(("(//*[@class='col-sm-4'])[2]")));
       Assert.assertTrue(hesabagiris.isDisplayed());

        //6. Doğru e-posta adresini ve şifreyi girin
        WebElement name = driver.findElement(By.cssSelector("[type='text']"));
        name.sendKeys("hatice");
        WebElement mail = driver.findElement(By.cssSelector("[data-qa='signup-email']"));
        mail.sendKeys("bilicihatice1987@gmail.com");

        //7. 'Giriş' düğmesine tıklayın
        driver.findElement(By.xpath("(//*[@type='submit'])[2]")).click();


        //mr tıkla
        driver.findElement(By.xpath("(//*[@type='radio'])[1]")).click();

        //Sırayla butun bilgileri giriniz?
        driver.findElement(By.xpath("//*[@id='name']"));
        driver.findElement(By.xpath("//*[@id='email']"));
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Aminelif61.");

        WebElement gun= driver.findElement(By.xpath("//*[@id='days']"));
        Select gunDrow=new Select(gun);
        gunDrow.selectByVisibleText("30");



        WebElement ay= driver.findElement(By.xpath("//*[@id='months']"));
        Select ayDrow=new Select(ay);
        ayDrow.selectByVisibleText("March");

        WebElement yil= driver.findElement(By.xpath("//*[@id='years']"));
        Select yilDrow=new Select(yil);
        yilDrow.selectByVisibleText("1987");

        driver.findElement(By.xpath("//*[@id='first_name']")).sendKeys("htc");
        driver.findElement(By.xpath("//*[@id='last_name']")).sendKeys("blc");
        driver.findElement(By.xpath("//*[@id='company']")).sendKeys("trb");
        driver.findElement(By.xpath("//*[@id='address1']")).sendKeys("abc");
        driver.findElement(By.xpath("//*[@id='address2']")).sendKeys("ab");

    }


    }

