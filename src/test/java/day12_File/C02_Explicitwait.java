package day12_File;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_Explicitwait extends TestBase {
    @Test
    public void explicitWaitTest(){

        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
       //Start buttonuna tıkla
        driver.findElement(By.xpath("//div[@id='start']//button")).click();
       //Hello World! Yazının sitede oldugunu test et
       // WebElement helloworldElement= driver.findElement(By.xpath("//div[@id='finish']//h4"));
       // Assert.assertEquals("Hello World!",helloworldElement.getText());// implicitwait ile test case calismadi,COZUM EXPLICITWAITDE

        //1-exclicitwait olusturmak icin webdwiverwait objesi olustur
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));

        //2-wait objesini kullanarak bekleme problemini cozmeye calis

        WebElement helloWorldElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));
       String helloworldtext= helloWorldElement.getText();
       Assert.assertEquals("Hello World!",helloworldtext);
    }

}
