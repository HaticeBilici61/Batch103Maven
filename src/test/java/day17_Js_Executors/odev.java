package day17_Js_Executors;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class odev extends TestBase {

//  1)getValueTest metotu olustur
//	2)https://www.priceline.com/ a git
//  3)Tarih kısmındaki Yazili metinleri al ve yazdır


    @Test
    public void getValue(){
      driver.get("https://www.priceline.com/");

      //2.javascript excuter objesi olustur
      getValueByJS("hotelDates");


    }


}
