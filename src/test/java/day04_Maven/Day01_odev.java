package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Day01_odev {
    public static void main(String[] args) {
     //C01_TekrarTesti isimli bir class olusturun
     //2 https://www.google.com/ adresine gidin
     //3 cookies uyarisini kabul ederek kapatin
     //4 Sayfa basliginin "Google" ifadesi icerdigini test edin
     //5 Arama cubuguna "Nutella" yazip aratin
     //6 Bulunan sonuc sayisini yazdirin
     //7 sonuc sayisinin 10 milyon'dan fazla oldugunu test edin
     //8 Sayfayi kapatin

       WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2 https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        //3 cookies uyarisini kabul ederek kapatin
        driver.findElement(By.xpath("//*[@id='L2AGLb']")).click();

    //4 Sayfa basliginin "Google" ifadesi icerdigini test edin
       String actueltitle=driver.getTitle();
        String expectedTitle="Google";
        if(actueltitle.contains(expectedTitle)){
            System.out.println(" title test passed");
        }else{
            System.out.println("title test failed");
        }
     //5 Arama cubuguna "Nutella" yazip aratin
       driver.findElement(By.cssSelector("input[class='gLFyf']")).sendKeys("Nutella", Keys.ENTER);
     //6 Bulunan sonuc sayisini yazdirin
     WebElement w=driver.findElement(By.xpath("//*[@id='result-stats']"));
        System.out.println("sonuc yazisi="+w.getText());
    //7 sonuc sayisinin 10 milyon'dan fazla oldugunu test edin
       String [] sonucYzisi=w.getText().split(" ");
        System.out.println(sonucYzisi[1]);



        int a= (int)( Integer.parseInt(sonucYzisi[1]));
        if(a>10000000){
            System.out.println("sayi testi passed");
        }else{
            System.out.println("sayi tesyi failed");
        }
       //8 Sayfayi kapatin
    }
}





