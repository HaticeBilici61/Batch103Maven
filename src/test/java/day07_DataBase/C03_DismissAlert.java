package day07_DataBase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03_DismissAlert  extends TestBase {

    //    Bir metod olusturun: dismissAlert
    //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının “You clicked: Cancel” oldugunu test edin.

    @Test
    public void dismissAlertTest() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //2. butona tıklayın
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        Thread.sleep(5000);

        //uyarıdaki Cancel butonuna tıklayın
        driver.switchTo().alert().dismiss();
        Thread.sleep(5000);

        //result mesajının “You clicked: Cancel” oldugunu test edin.
        String actualresult=driver.findElement(By.id("result")).getText();
        String expectedresult="You clicked: Cancel";
        Assert.assertEquals(expectedresult,actualresult);
    }
}
