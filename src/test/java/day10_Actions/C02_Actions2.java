package day10_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions2 extends TestBase {

    @Test
    public void hoverOverTest(){

      /*
      MANUAL:
      1. Amazon home sayfasina git
      2. Account & list e uzerinde bekle hoverover yap ya da maus over yap
      3.Acilan pencerede Account linkine tokla
      4.Acilan sayfanin Title inin, your Account oldugunu dogrula
       */

       //        Amazon a gidelim https://www.amazon.com/
              driver.get("https://www.amazon.com/");

       //        Sag ust bolumde bulunan “Account & Lists” menüsüne git uzerinde bekle
              Actions actions=new Actions(driver);//ACTIONS OBJECT
        waitFor(1);
              WebElement accountlisti= driver.findElement(By.id("nav-link-accountList"));//elemani bul
        waitFor(2);
              actions.moveToElement(accountlisti).perform();//uygun action methodunu kullan...

        //        “Account” secenegine tikka
         driver.findElement(By.linkText("Account")).click();

        //        Acilan sayfanin Title in “Your Account” icerdigini dogrula
        Assert.assertTrue(driver.getTitle().contains("Your Account"));












    }
}
