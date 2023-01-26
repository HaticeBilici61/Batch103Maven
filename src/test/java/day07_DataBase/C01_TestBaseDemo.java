package day07_DataBase;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C01_TestBaseDemo extends TestBase {


    /*
   UTILITIES
   -Utilities tekrar tekrar kullanacagimiz class'lari koydugumuz paketin adidir.
        - TestBase
        - Driver -> Sonra
        - ExcelUtil -> Sonra
        - Configuration -> Sonra
   -Utilities Paketinde Test case ler yazilmaz.
   -Sadece tekrar tekrar kullanilabilecek destek siniflari(support Class) olusturulur.
    Bu support Classlar test Case lerin yazilmasini hizlandirir.
 */

    @Test
    public void test01() {
        /*
        *TestBase i abstract yapmamizin sebebi bu sinifin objesini olusturmak istemiyorum
        * TesBase testBase=new TestBase yapilmaz
        * Amacim bu sinifi extends etmek ve icindeki hazir methodlari kullanmak
         */
        //techproeducation anasayfasina git ve title in Bootcamps kelimesi icerdigini test edin

        driver.get("https://techproeducation.com");
        String baslik=  driver.getTitle();
        Assert.assertTrue(baslik.contains("Bootcamps"));
    }
}
