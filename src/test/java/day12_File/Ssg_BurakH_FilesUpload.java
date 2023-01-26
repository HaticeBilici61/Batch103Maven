package day12_File;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Ssg_BurakH_FilesUpload extends TestBase {

// Exercise 3...

    // masaustunde bir deneme dosyası olusturun
    // 'https://the-internet.herokuapp.com/upload' adresine gidiniz
    // 'Dosya Seç' kısmına deneme dosyasını yükleyiniz
    // 'Upload' butonuna basın
    // 'File Uploaded!' yazısının goruntulendigini test edin


  @Test
  public void test01() throws InterruptedException {
    // masaustunde bir deneme dosyası olusturun
    // 'https://the-internet.herokuapp.com/upload' adresine gidiniz
    driver.get("https://the-internet.herokuapp.com/upload");

    // 'Dosya Seç' kısmına deneme dosyasını yükleyiniz
    WebElement dosyaSecButonu=driver.findElement(By.xpath("//input[@id='file-upload']"));
    // "C:\Users\BURAK\Desktop\deneme.txt"
    String farklıKısım=System.getProperty("user.home");
    String ortakKısım="\\Desktop\\deneme.txt";
    String yuklenecekDosya=farklıKısım + ortakKısım;
    dosyaSecButonu.sendKeys(yuklenecekDosya);
    Thread.sleep(3000);

    // 'Upload' butonuna basın
    driver.findElement(By.xpath("//input[@id='file-submit']")).click();

    // 'File Uploaded!' yazısının goruntulendigini test edin
    WebElement fileUploaded= driver.findElement(By.xpath("//h3[text()='File Uploaded!']"));
    Assert.assertTrue(fileUploaded.isDisplayed());
  }


    }


