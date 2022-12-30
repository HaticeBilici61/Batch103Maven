package day07_DataBase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C04_PromptAlert extends TestBase {
       //Bir metod olusturun: sendKeysAlert
       // 3.butona tıklayın, n,uyarıdaki metin kutusuna isminizi yazi
       // OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğru

    @Test
    public void promportAlertTest() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        // butona tıklayın
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Thread.sleep(5000);

        //uyarıdaki metin kutusuna isminizi yazin
        driver.switchTo().alert().sendKeys("Hatice");
        Thread.sleep(5000);

        // // OK butonuna tıklayın
        driver.switchTo().alert().accept();
        Thread.sleep(5000);

        //result mesajında isminizin görüntülendiğini doğrulayin
        String actualresult=driver.findElement(By.id("result")).getText();
        String expectedresult="Hatice";
        Assert.assertTrue(actualresult.contains(expectedresult));
        Thread.sleep(5000);
    }
}
