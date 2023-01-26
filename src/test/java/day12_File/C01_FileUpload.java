package day12_File;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_FileUpload extends TestBase {

    @Test
    public void fileUploadTest(){
        //    https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload ");

        //    chooseFile butonuna basalim
       WebElement dosyasecbutonu= driver.findElement(By.id("file-upload"));

        //    Yuklemek istediginiz dosyayi secelim.
        String dosyaYolu=System.getProperty("user.home")+"/Desktop/logo.jpeg";
        dosyasecbutonu.sendKeys(dosyaYolu);
        waitFor(5);
        /*
        DOSYASEC BUTONUNA YUKLEMEK ISTEDIGIM DOSYANIN PATH INI GONDEREREK SECTIM
         */

        //    Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

        //“File Uploaded!” textinin goruntulendigini test edelim.
        String uploadedyazisi=  driver.findElement(By.xpath("//h3[text()='File Uploaded!']")).getText();
        Assert.assertEquals("File Uploaded!",uploadedyazisi);
        waitFor(5);

    }
}
