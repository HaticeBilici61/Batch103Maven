package ErolHoca_Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02 {
         /*
     //go to url : https://www.techlistic.com/p/selenium-practice-form.html
     //fill the firstname
     //fill the lastname
     //check the gender
     //check the experience
     //fill the date
     //choose your profession -> Automation Tester
     //choose your tool -> Selenium Webdriver
     //choose your continent -> Antartica
     //choose your command  -> Browser Commands
     //click submit button

     */

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

      // //go to url : https://www.techlistic.com/p/selenium-practice-form.html
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

        // //fill the firstname...ilk adi doldurun
        //fill the firstname
        //fill the lastname
        //check the gender
        //check the experience
        //fill the date
        //choose your profession -> Automation Tester
        //choose your tool -> Selenium Webdriver
        //choose your continent -> Antartica
        //choose your command  -> Browser Commands
        //click submit button
       WebElement firstName= driver.findElement(By.xpath("//*[@name='firstname']"));
       firstName.sendKeys("Hatice", Keys.TAB,"Bilici",//  //fill the firstname
       Keys.TAB,Keys.ARROW_RIGHT,Keys.SPACE,// //check the gender
       Keys.TAB,Keys.ARROW_RIGHT,Keys.ARROW_RIGHT,Keys.ARROW_RIGHT,//  //check the experience
       Keys.TAB,"15/01/22",    //fill the date
       Keys.TAB,Keys.TAB,Keys.SPACE,
       Keys.TAB,Keys.TAB,Keys.TAB,Keys.SPACE,
       Keys.TAB,"Afrika",
       Keys.TAB,Keys.LEFT_CONTROL,Keys.SPACE,
       Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.SPACE,Keys.TAB,Keys.TAB,Keys.TAB,Keys.ENTER);


       // firstName.submit();
    }
}
