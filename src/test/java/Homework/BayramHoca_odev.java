package Homework;

import com.github.javafaker.Faker;
import day06.C06_DropDown_REusable;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

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
    WebElement firstProduct = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-base'])[1]"));
    WebElement secondProductByRelativeLocate = driver.findElement(with(By.tagName("div")).toRightOf(firstProduct));
    secondProductByRelativeLocate.click();

   //    ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim
    String  baslik=  driver.getTitle();
    System.out.println(baslik);
    waitFor(2);
    String urunfiyati=driver.findElement(By.xpath("(//span[@class='a-offscreen'])[1]")).getText();
    System.out.println(urunfiyati);
    driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();



}
@Test
    public void test03(){

//    yeni bir sekme açarak amazon anasayfaya gidin


    driver.switchTo().newWindow(WindowType.WINDOW);
    driver.get("https://www.amazon.com");
//    dropdown’dan bebek bölümüne secin
    WebElement dropdown=driver.findElement(By.id("searchDropdownBox"));
    Select select=new Select(dropdown);
    select.selectByVisibleText("Baby");
//    bebek puset aratıp bulundan sonuç sayısını yazdırın
    WebElement aramakutusu= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
    aramakutusu.sendKeys("bebek puset",Keys.ENTER);
    String [] sonuc=  driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText().split(" ");
    String sncsayisi=sonuc[3];
    String yazi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();

//   4- sonuç yazsının puset içerdiğini test edin
   Assert.assertTrue(yazi.contains("puset"));

//   5-üçüncü ürüne relative locater kullanarak tıklayin
    WebElement ikinciurun = driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-fixed-height'])[4]"));
     driver.findElement(with(By.tagName("div")).below(ikinciurun)).click();

//   6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
    String actualbaslik=driver.getTitle();
    System.out.println(actualbaslik);
    waitFor(1);
    WebElement fiyat= driver.findElement(By.xpath("(//span[@class='a-offscreen'])[4]"));
    System.out.println(fiyat.getText());
    driver.findElement(By.id("add-to-cart-button")).click();

//   7-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
    WebElement sepeturun=driver.findElement(By.xpath("(//a[@class='a-link-normal sw-product-image-link'])[18]"));
    Assert.assertNotEquals(ikinciurun,sepeturun);

    WebElement sepeturunFiyat=driver.findElement(By.xpath("(//span[@class='a-price _smart-wagon-card_style_priceToPay__2sIS2'])[13]"));
    Assert.assertNotEquals(ikinciurun,sepeturunFiyat);
    waitFor(1);


}

@Test
    public void keyboardAction(){

    //    https://html.com/tags/iframe/ sayfasina gidelim
    driver.get("https://html.com/tags/iframe/");
    //    video’yu gorecek kadar asagi inin


    Actions actions=new Actions(driver);
    actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.ARROW_DOWN).perform();
    //    videoyu izlemek icin Play tusuna basin
    WebElement iframe = driver.findElement(By.xpath("(//div[@class='render'])[1]//iframe"));
    driver.switchTo().frame(iframe);
    driver.findElement(By.xpath("//div[@class='ytp-impression-link-logo']")).click();
    //    videoyu calistirdiginizi test edin
    WebElement video= driver.findElement(By.xpath("(//a[@class='ytp-suggestion-link'])[1]"));
    Assert.assertTrue(video.isDisplayed());

    //videoyu calistirdiginizi test edin  2.yolla
    waitFor(4);
    WebElement pauseButton = driver.findElement(By.xpath("//button[@title='Pause (k)']"));
    Assert.assertTrue(pauseButton.isEnabled());

}

@Test
    public void ActionsClassHomeWork(){

    //  1- "http://webdriveruniversity.com/Actions" sayfasina gidin
    driver.get("http://webdriveruniversity.com/Actions");

    //  2- Hover over Me First" kutusunun ustune gelin
   WebElement link1= driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
   hoverOverOnElementActions(link1);
    //    Link 1" e tiklayin
    driver.findElement(By.xpath("(//a[text()='Link 1'])[1]")).click();

    //    Popup mesajini yazdirin
    driver.switchTo().alert().getText();

    //    Popup'i tamam diyerek kapatin
    driver.switchTo().alert().accept();
    waitFor(1);
    //    “Click and hold" kutusuna basili tutun
    Actions actions=new Actions(driver);
   WebElement clikandHold= driver.findElement(By.xpath("//div[@id='click-box']"));
    actions.clickAndHold(clikandHold).perform();


    //    7-“Click and hold" kutusunda cikan yaziyi yazdirin
   String clickandholdYazi= clikandHold.getText();
    System.out.println(clickandholdYazi);
    waitFor(2);

    //     8- “Double click me" butonunu cift tiklayin
  WebElement doubleclickme= driver.findElement(By.xpath("//h2"));
    doubleClick(doubleclickme);

}

@Test
    public void fakerTest() {

     //    Faker Kutuphanesi HOMEWORK
     //    Faker class’i testlerimizi yaparken ihtiyav duydugumuz isim, soyisim, adres vb bilgiler icin fake
     //    degerler uretmemize imkan tanir.
     //    Faker degerler uretmek icin Faker class’indan bir obje uretir ve var olan method’lari kullaniriz.
     //            "https://facebook.com"  Adresine gidin
         driver.get("https://facebook.com");
     //“create new account”  butonuna basin
    driver.findElement(By.xpath("//button[text()='Temel ve isteğe bağlı çerezlere izin ver']")).click();//cookies icin
    driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
     waitFor(2);

     //“firstName” giris kutusuna bir isim yazin
     Faker faker=new Faker();
     String name=faker.name().firstName();
     System.out.println(name);
     driver.findElement(By.name("firstname")).sendKeys(name);
     waitFor(2);

     //“surname” giris kutusuna bir soyisim yazin
     String lastname=faker.name().lastName();
     driver.findElement(By.name("lastname")).sendKeys(lastname);
     waitFor(2);

     //“email” giris kutusuna bir email yazin
     String email=faker.internet().emailAddress();
     driver.findElement(By.name("reg_email__")).sendKeys(email);

     //“email” onay kutusuna emaili tekrar yazin
     driver.findElement(By.name("reg_email_confirmation__")).sendKeys(email);

     //    Bir sifre girin
     String password=faker.internet().password();
     driver.findElement(By.name("reg_passwd__")).sendKeys(password);

     //    Tarih icin gun secin
     int day=faker.number().numberBetween(1,31);
     String days= String.valueOf(day);
     driver.findElement(By.name("birthday_day")).sendKeys(days);

     //    Tarih icin ay secin
    int month=faker.number().numberBetween(1,12);
    String months=String.valueOf(month);
    driver.findElement(By.name("birthday_month")).sendKeys(months);

     //    Tarih icin yil secin
     int year=faker.number().numberBetween(2000,2023);
     String years=String.valueOf(year);
     driver.findElement(By.name("birthday_year")).sendKeys(years);

      //    Cinsiyeti secin
    WebElement weiblich = driver.findElement(By.xpath("//input[@id='u_3_4_7T']"));
    weiblich.click();

    //Cinsiyeti secin
    int randomIndex = faker.number().numberBetween(1, 3);
    WebElement cinsiyet = driver.findElement(By.xpath("(//*[@class='_8esa'])[" + randomIndex + "]"));
    cinsiyet.click();


    //    Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
    Assert.assertTrue(weiblich.isSelected());
    WebElement männlich = driver.findElement(By.xpath("//input[@id='u_3_5_w2']"));
    Assert.assertTrue(!männlich.isSelected());




      //            Sayfayi kapatin
}



}
