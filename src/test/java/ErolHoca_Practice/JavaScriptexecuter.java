package ErolHoca_Practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class JavaScriptexecuter extends TestBase {

       /*
                                -- JavascriptExecutor --
        -- ID'si ILE LOCATE
        WebElement element = (WebElement)
                js.executeScript("return document.getElementById('twotabsearchtextbox');");
          js.executeScript("return document.getElementById('twotabsearchtextbox');") kodu, JavaScriptExecutor
       aracılığıyla belirli bir ID değerine sahip bir web elementini locate etmek için kullanılan bir koddur.
       Bu kod, JavaScriptExecutor aracılığıyla tarayıcıda çalıştırılır ve getElementById()
       metodu kullanılarak 'twotabsearchtextbox' ID değerine sahip bir elementi locate eder.
       Bu kodun döndürdüğü sonuç, locate edilen elementi temsil eden bir WebElement nesnesidir.
       Bu WebElement nesnesi, daha sonra Selenium komutları ile bu element üzerinde işlem yapmak için kullanılabilir.
        -- XPATH ILE LOCATE
        WebElement element = (WebElement) js.executeScript
                ("return document.evaluate(\"//*[@id='twotabsearchtextbox']\", " +
                        "document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null ).singleNodeValue;");
        --CSS SELECTOR ILE LOCATE
        WebElement element = (WebElement)
                js.executeScript("return document.querySelector('input[id=twotabsearchtextbox]');");
        */
    /*
    -- Amazon sayfasına gidiniz
    -- Arama bölümünde selenium aratınız
    -- Back to top bölümüne kadar scroll yapınız
    -- Back to top bölümüne tıklayınız
     */

    @Test
    public void test01() throws InterruptedException {
        JavascriptExecutor js=(JavascriptExecutor)driver;
//        -- Amazon sayfasına gidiniz
        driver.get("https://www.amazon.com/");

//        -- Arama bölümünde selenium aratınız
      //  typeWithJS();

        WebElement searchBox = (WebElement)
                js.executeScript("return document.querySelector('input[id=twotabsearchtextbox]');");
        js.executeScript("arguments[0].value='selenium'",searchBox);
        searchBox.submit();

        typeWithJS(searchBox,"Selenium");


        //Back to top bölümüne kadar scroll yapınız
        // WEB ELEMENTİ CLASSNAME İLE LOCATE ETTİK
        WebElement backToTop = (WebElement)
                js.executeScript("return document.getElementsByClassName('navFooterBackToTopText')[0];");
        js.executeScript("arguments[0].scrollIntoView(true);",backToTop);

//        -- Back to top bölümüne tıklayınız
        clickByJS(driver.findElement(By.className("navFooterBackToTopText")));

        //erol h cozum
        // WEB ELEMENTİ CLASSNAME İLE LOCATE ETTİK
        WebElement backToTop1 = (WebElement)
                js.executeScript("return document.getElementsByClassName('navFooterBackToTopText')[0];");
        js.executeScript("arguments[0].scrollIntoView(true);",backToTop1);
        Thread.sleep(3000);
        //Back to top bölümüne tıklayınız

        try {
            backToTop1.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();",backToTop1);
        }

    }





}






