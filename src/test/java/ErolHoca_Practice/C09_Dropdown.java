package ErolHoca_Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C09_Dropdown extends TestBase {
    @Test
    public void test01(){

        //amazon sayfasina gidelim
        driver.get("https://amazon.com");

        //dropdown menuden baby secelim
        WebElement dropdown= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(dropdown);
        select.selectByVisibleText("Baby");
        for (WebElement w : select.getOptions()){
            System.out.println(w.getText());//bu sekilde de tum lidsteyi gorebilirim
        }
        //bu sekilde de yapabilirz
       List< WebElement> dropdow= driver.findElements(By.xpath("//select[@id='searchDropdownBox']"));
       dropdow.forEach(t-> System.out.println(t.getText()));

        //baby secelim ..  //arama bolumunde milk aratalim
        driver.findElement(By.xpath("//select[@id='searchDropdownBox']")).sendKeys("Baby",
                Keys.TAB,"Milk",Keys.ENTER);




        }
    @Test
    public void test02() throws InterruptedException {
         //    go to url :http://demo.automationtesting.in/Alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");

        //    click  "Alert with OK" and click 'click the button to display an alert box:'
       // driver.findElement(By.xpath("//a[text()='Alert with OK ']")).click();
        WebElement alert=driver.findElement(By.xpath("//*[@onclick='alertbox()']"));
        alert.click();
        Thread.sleep(2000);

        //    accept Alert(I am an alert box!) and print alert on console
        Thread.sleep(2000);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
        driver.findElement(By.xpath("(//*[@class='analystic'])[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@onclick='confirmbox()']")).click();

        //    cancel Alert  (Press a Button !)
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();

        //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
        driver.findElement(By.xpath("//*[text()='Alert with Textbox ']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[onclick='promptbox()']")).click();
        //    and then sendKeys 'TechProEducation' (Please enter your name)
        Thread.sleep(2000);
        driver.switchTo().alert().sendKeys("TechProEducation");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        //    finally print on console this message "Hello TechProEducation How are you today"
        System.out.println(driver.findElement(By.xpath("//p[@id='demo1']")).getText());

          //    aseertion these message
        String message=  driver.findElement(By.xpath("//p[@id='demo1']")).getText();
        String expectedbaslik="Hello TechProEducation How are you today";
        Assert.assertEquals(expectedbaslik,message);
    }
}
