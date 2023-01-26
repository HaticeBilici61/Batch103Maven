package Homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class canh_Webtableodev extends TestBase {

    @Test
    public void webtable(){

        //https://www.way2automation.com/angularjs-protractor/webtables/
        driver.get("https://www.way2automation.com/angularjs-protractor/webtables/");

        //tüm E-mail leri yazdırın
       List<WebElement> emails= driver.findElements(By.xpath("//table[@class='smart-table table table-striped']//tbody//tr//td[7]"));
        emails.forEach(t-> System.out.println(t.getText()));
       //Tüm E-maillerin "@" işareti içerdiğini doğrulayin
        emails.forEach(t-> Assert.assertTrue(t.getText().contains("@")));
    }
}
