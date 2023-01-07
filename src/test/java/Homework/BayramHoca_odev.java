package Homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class BayramHoca_odev extends TestBase {


    @Test
    public void test01(){
        //    Test01 :  1- amazon gidin
        driver.get("https://www.amazon.com");

        //    Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement dropdown=driver.findElement(By.id("searchDropdownBox"));
        Select select=new Select(dropdown);
        System.out.println(select.getOptions().size());

        //    dropdown menude 40 eleman olduğunu doğrulayın
        Assert.assertNotEquals(40,select.getOptions().size());

    }
@Test
    public void test02(){
    //    Test01 :  1- amazon gidin
    driver.get("https://www.amazon.com");

    //    Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
    WebElement dropdown=driver.findElement(By.id("searchDropdownBox"));
    Select select=new Select(dropdown);
    System.out.println(select.getOptions().size());


    //    dropdown menuden elektronik bölümü seçin
    select.selectByVisibleText("Electronics");
   //    arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
    WebElement aramakutusu= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
    aramakutusu.sendKeys("iphone",Keys.ENTER);
    waitFor(3);
    String [] sonuc= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText().split(" ");
    System.out.println(sonuc[3]);

//    sonuc sayisi bildiren yazinin iphone icerdigini test edin
    Assert.assertTrue(driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText().contains("iphone"));

   //    ikinci ürüne relative locater kullanarak tıklayin
     List<WebElement> urunler=driver.findElements(By.xpath("//img[@class='s-image']"));
     urunler.get(2).click();

   //    ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim
  String  baslik=  driver.getTitle();
  String urunfiyati=driver.findElement(By.xpath("(//span[@class='a-offscreen'])[1]")).getText();
  driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();



}


//    Test03
//    yeni bir sekme açarak amazon anasayfaya gidin
//    dropdown’dan bebek bölümüne secin
//    bebek puset aratıp bulundan sonuç sayısını yazdırın
//    sonuç yazsının puset içerdiğini test edin
//5-üçüncü ürüne relative locater kullanarak tıklayin
//6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin  Test 4
//            1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın


//    Bir Class olusturalim KeyboardActions2
//    https://html.com/tags/iframe/ sayfasina gidelim
//    video’yu gorecek kadar asagi inin
//    videoyu izlemek icin Play tusuna basin
//    videoyu calistirdiginizi test edin

//    Keyboard Base Actions
//            Homework
//    Yeni Class olusturun ActionsClassHomeWork
//1- "http://webdriveruniversity.com/Actions" sayfasina gidin  2- Hover over Me First" kutusunun ustune gelin
//    Link 1" e tiklayin
//    Popup mesajini yazdirin
//    Popup'i tamam diyerek kapatin
//            “Click and hold" kutusuna basili tutun
//            7-“Click and hold" kutusunda cikan yaziyi yazdirin
//            8- “Double click me" butonunu cift tiklayin


//    Faker Kutuphanesi HOMEWORK
//    Faker class’i testlerimizi yaparken ihtiyav duydugumuz isim, soyisim, adres vb bilgiler icin fake
//    degerler uretmemize imkan tanir.
//    Faker degerler uretmek icin Faker class’indan bir obje uretir ve var olan method’lari kullaniriz.
//            "https://facebook.com"  Adresine gidin
//“create new account”  butonuna basin
//“firstName” giris kutusuna bir isim yazin
//“surname” giris kutusuna bir soyisim yazin
//“email” giris kutusuna bir email yazin
//“email” onay kutusuna emaili tekrar yazin
//    Bir sifre girin
//    Tarih icin gun secin
//    Tarih icin ay secin
//    Tarih icin yil secin
//    Cinsiyeti secin
//    Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
//            Sayfayi kapatin
}
