package day10_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Actions4 extends TestBase {

    @Test
    public void dragAndDropTest(){

//EN FAZLA SURUKLEMEK ICIN KULLANILAN METHOD

       // Given user is on https://jqueryui.com/droppable/
        driver.get(" https://jqueryui.com/droppable/");

        // And user moves the target element(Drag me to my target) in to  destination(Drop here)
        //kucuk kutucugu buyuk kutucuga surukleyecegiz
        driver.switchTo().frame(0);//ilk iframe e swich yaptik cunku kaynak ve hedef elementi iframe icinde
        WebElement kaynak=driver.findElement(By.id("draggable"));//1.kutuk locatio
        WebElement hedef= driver.findElement(By.id("droppable"));//2.kutucuk locati

        Actions actions=new Actions(driver);
        actions.dragAndDrop(kaynak,hedef).perform();//kucuk kutuyu buyuk kutuya tasima islemi
  //dragAndDrop surukleme islemi yaptirir
    }

    //yukaridaki soruyu farkli yolla cozme yontemi
    @Test
    public void clickAndHoldTest(){
        // Given user is on https://jqueryui.com/droppable/
        driver.get(" https://jqueryui.com/droppable/");

        // And user moves the target element(Drag me to my target) in to  destination(Drop here)
        //kucuk kutucugu buyuk kutucuga surukleyecegiz
        driver.switchTo().frame(0);//ilk iframe e swich yaptik cunku kaynak ve hedef elementi iframe icinde
        WebElement kaynak=driver.findElement(By.id("draggable"));//1.kutuk locatio
        WebElement hedef= driver.findElement(By.id("droppable"));//2.kutucuk locati


        Actions actions=new Actions(driver);
        actions.clickAndHold(kaynak).//kaynak i tut
                moveToElement(hedef).//hedefe koy
                release().//kaynagi birak
                build().//onceki methodlarin iliskisini kur guclendir.kullanilmasi tercih edilir
                perform();           //islemi gerceklestir

    }
    @Test
    public void moveByOffSetTest(){
        // Given user is on https://jqueryui.com/droppable/
        driver.get(" https://jqueryui.com/droppable/");

        // And user moves the target element(Drag me to my target) in to  destination(Drop here)
        //kucuk kutucugu buyuk kutucuga surukleyecegiz
        driver.switchTo().frame(0);//ilk iframe e swich yaptik cunku kaynak ve hedef elementi iframe icinde
        WebElement kaynak=driver.findElement(By.id("draggable"));//1.kutuk locatio

        Actions actions=new Actions(driver);
        actions.clickAndHold(kaynak).moveByOffset(430,30).release().build().perform();


    }
}
