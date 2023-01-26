package day13_SeleniumException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_TimeOutException extends TestBase {

               //    TimeOutException:
    //timeOutException explicit wait kullanildigi zaman ve element bulunamadiginda alinir
    //noSuchElement exception implicit wait kullanildiginda alinir

    //    Explicit wait kullanildiginda, ve element bulunamadiginda alinir.
    //    Explicit wait & yanlis locator-> timeout
    //    Explicit wait & doğru locator & sure yeterli degil -> timeout
    //    Explicit wait & dogru locator & sure yeterli & iframe var ->  time out

    //    Solution:Cozum
    //            -Sureyi arttirmak
    //-Farkli explicit kullanmak: wait visibilityOfElementLocated YERINE presenceOfElementLocated. Yada javascript executor da ki waiter sayfa geçişlerini beklemek icin kullanabilirim
    //-Locatori tekrar kontrol etmek
    //-Frameworkunde hazir reusable method lar var Bu durumda timeoutexception aldigimda hızlıca o metotlar yardımıyla problemi cozebiliyoruz

//    Falsche Location
//    popup, neu Fenster, iframe
//    bei seite ladung probleme und verlangsamung (bei Einladung der Seiten)
//    geheime seiten
//    kontrolliere die richtigkeit der locations
//    mit Manuel Test iframe, neu Fenster, alert..ähnliches.. überprüfe die anwesenheit die elemente
//    Warte probleme kann entstehen
//    implicit wait ist keine lösung für wartezeit
//    in diesem fall kann explicit wait oder fluent waid angewendet werden

    @Test
    public void timeOutExceptionTest(){

        driver.get("https://www.techproeducation.com");
//        Explit wait icin olusturdugumuz methodlardan birini kullanalim
//        Parametre 1: beklemek istedigim element, Parametre 2: Max sure
 //       waitForVisibility(driver.findElement(By.xpath("//input[@type='searchh']")),15).sendKeys("QA"+ Keys.ENTER);

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Yanlis Id")));//timeoutException alinir bu durumda

        /*
TimeOutException explicit wait kullandigimda ve locator bulunamadiginda alirim
 */
    }




    }

