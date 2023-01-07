package day10_Actions;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Actions3 extends TestBase {

    @Test
    public void scrollUpDown(){



     //        https://techproeducation.com a git
        driver.get("https://techproeducation.com");

     //        Sayfanin altına doğru gidelim
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();//sayfayi asagi ittircek
        waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        waitFor(3);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();//bu sekilde de yazilabilir
        actions.sendKeys(Keys.ARROW_DOWN).perform();//arrown down page down dan daha az mesafe aldirir.

        //        Sonra sayfanın üstüne doğru gidelim
        waitFor(3);
        actions.sendKeys(Keys.PAGE_UP).perform();//yukari cikmamizi saglar
        actions.sendKeys(Keys.ARROW_UP).perform();//yukari cikmamizi saglar



    }
}
