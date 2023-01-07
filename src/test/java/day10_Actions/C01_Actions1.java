package day10_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions1 extends TestBase {

    @Test
    public void rightClick(){
            //  1.Adım: Actions class’ta bir object oluşturulur.
                Actions actions=new Actions(driver);

            //  https://the-internet.herokuapp.com/context_menu  sitesine gidin
                driver.get("https://the-internet.herokuapp.com/context_menu");

            //  2. Adım: Üzerinde çalışmak istediğiniz WebElement öğesini bulunur.
            //  WebElement element = driver.findElement(locator);
                WebElement kutu= driver.findElement(By.id("hot-spot"));

            //  Kutuya sag tıklayın
            //  TUM ACTIONS LAR action OBJESIYLE BASLAR perform() ile biter.
            //  3.Adim : perform() kullanarak bu webelement üzerinde action gerçekleştirilir.
                actions.contextClick(kutu).perform();

            //  Alert’te cikan yazinin “You selected a context menu” oldugunu    test edin
                Assert.assertEquals( "You selected a context menu", driver.switchTo().alert().getText());

            //  Tamam diyerek alert’i kapatın
                driver.switchTo().alert().accept();






    }
}
