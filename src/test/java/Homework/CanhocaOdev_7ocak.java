package Homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;
import java.util.Set;

public class CanhocaOdev_7ocak extends TestBase {

    //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
    //2. "Hover over Me First" kutusunun ustune gelin
    //3. "Link 1" e tiklayin
    //4. Popup mesajini yazdirin
    //5. Popup'i tamam diyerek kapatin
    //6. "Click and hold" kutusuna basili tutun
    //7. "Click and hold" kutusunda cikan yaziyi yazdirin
    //8. "Double click me" butonunu cift tiklayin
    //9. "Double click me" butonunun renk değiştridiğini doğrulayın

    @Test
    public void hoverOver(){

        //1. "http://webdriveruniversity.com/Actions" sayfasina gidin







    }


    @Test
    public void ulkelerTest(){
  /*
   #url'ye gidin: http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
  #Ülkeye göre başkentleri doldurun
 */
       //  #url'ye gidin: http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
        driver.get(" http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");


      List<WebElement> baskentler=driver.findElements(By.xpath("//div"));
      for (WebElement w :baskentler){
          System.out.println(w.getText());

          //Kaynak Elementler:
          WebElement oslo = driver.findElement(By.id("box1"));
          WebElement stokholm = driver.findElement(By.id("box2"));
          WebElement washington = driver.findElement(By.id("box3"));
          WebElement kopenhag = driver.findElement(By.id("box4"));
          WebElement seul = driver.findElement(By.id("box5"));
          WebElement roma = driver.findElement(By.id("box6"));
          WebElement madrid = driver.findElement(By.id("box7"));

          //Hedef Elementler:
          WebElement norvec = driver.findElement(By.id("box101"));
          WebElement isvec = driver.findElement(By.id("box102"));
          WebElement ABD = driver.findElement(By.id("box103"));
          WebElement danimarka = driver.findElement(By.id("box104"));
          WebElement guneyKore = driver.findElement(By.id("box105"));
          WebElement italya = driver.findElement(By.id("box106"));
          WebElement ispanya = driver.findElement(By.id("box107"));

          Actions actions=new Actions(driver);
          actions.dragAndDrop(oslo,norvec).perform();
          waitFor(3);
          actions.dragAndDrop(stokholm, isvec).perform();
          waitFor(3);
          actions.dragAndDrop(washington, ABD).perform();
          waitFor(3);
          actions.dragAndDrop(kopenhag, danimarka).perform();
          waitFor(3);
          actions.dragAndDrop(seul, guneyKore).perform();
          waitFor(3);
          actions.dragAndDrop(roma, italya).perform();
          waitFor(3);
          actions.dragAndDrop(madrid, ispanya).perform();
          waitFor(3);
      }
      }

}



