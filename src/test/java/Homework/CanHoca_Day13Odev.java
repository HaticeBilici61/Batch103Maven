package Homework;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class CanHoca_Day13Odev extends TestBase {
    @Test
    public void Odev(){

     //sahibinden.com a gidin
        driver.get("https://www.sahibinden.com");
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();//cerez handle

     //anasayfada oldugunuzu dogrulayin
     //detayli arama tiklayin
     //detayli arama sayfasina geldiginizi dogrulatin
     //emlak-konut-satilik seceneklerini secip
     //altta cikan butun filtre seceneklerine en az bir filtre degeri girip en sonundaki arama yap tusuna tiklayin
     //filtreler için sağıdakilere benzer methodlar oluşturun
            // detayli_Arama_Adres("izmir", "bayrakli", "adalet mah.");
            // detayli_Arama_Fiyat("4.000","4.000.000","USD");
            // detayli_Arama_Brut("180","400");
            // detayli_Arama_Oda_Sayisi("10 Üzeri");//0-43 arasi

     //cikan sonuc sayisini veya sonuc yoksa bunu bildiren yaziyi konsolda yazdirin
    }
}
