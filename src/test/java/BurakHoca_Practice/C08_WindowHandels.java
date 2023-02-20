package BurakHoca_Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C08_WindowHandels extends TestBase {
    @Test
    public void test01(){

        // 'https://www.n11.com' adresine gidin
        driver.get("https://www.n11.com");
       //   String sayfa1Handle=driver.getWindowHandle();

        // arama motoruna 'oppo' yazıp aratın
        driver.findElement(By.xpath("//input[@id='searchData']")).sendKeys("oppo"+ Keys.ENTER);

        // ilk ürüne tıklayın
        driver.findElement(By.xpath("(//img[@class='lazy cardImage'])[1]")).click();

        // Basligin 'Oppo' icerdigini test edin.
        List<String> pencereler=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pencereler.get(1));
        String ikincisayfa= driver.getTitle();
        Assert.assertTrue(ikincisayfa.contains("Oppo"));


        //        //diger yol
        //       Set<String> windowHandleSeti=driver.getWindowHandles();
        //       String sayfa2Handle="";
        //       for (String each:windowHandleSeti) {
        //       if(!each.equals(sayfa1Handle)){
        //
        //       sayfa2Handle=each;




        // ilk sayfaya donun ve Title'ını yazdırın
        driver.switchTo().window(pencereler.get(0));
        System.out.println(driver.getTitle());

    }
}
