package BurakHoca_Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Sssg_BurakH_FilesDowloads extends TestBase {

// Exercise 2...


    //1. 'https://the-internet.herokuapp.com/download' adresine gidiniz
    //2. myfile.txt dosyasini indirelim
    //3. dosyanin bilgisayarınızda downloads'a basariyla indirilip indirilmedigini test ediniz


    @Test
    public void test01() throws InterruptedException {
        //1. 'https://the-internet.herokuapp.com/download' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");

        //2. LambdaTest.txt dosyasini indirelim
        driver.findElement(By.xpath("//a[text()='myfile.txt']")).click();
        Thread.sleep(2000);

        //3. dosyanin bilgisayarınızda downloads'a basariyla indirilip indirilmedigini test ediniz
        //   "C:\Users\BURAK\Downloads\myfile.txt"
        // Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\BURAK\\Downloads\\myfile.txt")));  Bu işlemi daha dinamik hale getirelim
        String farklıKısım = System.getProperty("user.home");
        String ortakKısım = "\\Downloads\\myfile.txt";
        String dosyaYolu = farklıKısım + ortakKısım;
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
