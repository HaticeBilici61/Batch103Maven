package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class odev_CanHoca {


    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
        driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");

    }

    @After
    public void tearDown() {

        driver.close();
    }



//     ~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
//     ~ click on Phones & PDAs
//     ~ get the brandName of phones
//     ~ click on add to button for all elements
//     ~ click on black total added cart button
//     ~ get the names of list from the cart
//     ~ compare the names from displaying list and cart list
//
//     clickAllElements
//     getName
//     compareTwoList




    //Http://tutorialsninja.com/demo/index.php?route=common/home adresine gidin.
    //     ~ Telefonlara ve PDA'lara tıklayın.... ~ click on Phones & PDAs
    //     ~ Telefonların BrandN adını alın...  ~ get the brandName of phones
    //     ~ Tüm öğeler için düğmeye ekle düğmesine tıklayın...  ~ click on add to button for all elements
    //     ~ Siyah Toplam Eklenen Sepet düğmesine tıklayın.... ~ click on black total added cart button
    //     ~ Sepetten listenin adlarını alın....... ~ get the names of list from the cart
    //     ~ Görüntüleme listesi ve sepet listesinden adları karşılaştırın... ~ compare the names from displaying list and cart list

    @Test
    public void test01(){

        //    ~ click on Phones & PDAs...  ~ Telefonlara ve PDA'lara tıklayın
        driver.findElement(By.xpath("//*[text()='Phones & PDAs']")).click();

        // ~ get the brandName of phones...   ~ Telefonların BrandN adını alın
        List<String> brandNames = isimler(driver);
        System.out.println("brandNames = " + brandNames);

        //    ~ click on black total added cart button.... ~ Tüm öğeler için düğmeye ekle düğmesine tıklayın
        clickAll(driver);

        //    ~ click on black total added cart button... Siyah Toplam Eklenen Sepet düğmesine tıklayın
        driver.findElement(By.xpath("//*[@class=\"btn btn-inverse btn-block btn-lg dropdown-toggle\"]")).click();

        //    ~ get the names of list from the cart...~ Sepetten listenin adlarını alın..
        List<String> namesCart=cartIsimleri(driver);
        System.out.println("namesCart = " + namesCart);

        //~ compare the names from displaying list and cart list.. ~ Görüntüleme listesi ve sepet listesinden adları karşılaştırın.
        compare(brandNames,namesCart);

    }
    public  List<String> isimler(WebDriver driver){
        List<WebElement> brandNames = driver.findElements(By.xpath("//h4"));
        List<String> Names = new ArrayList<>();
        brandNames.stream().forEach(t-> Names.add(t.getText()));
        Collections.sort(Names);
        return Names;
    }
    public  void clickAll(WebDriver a){
        List<WebElement> tikla = a.findElements(By.xpath("//*[text()='Add to Cart']"));
        tikla.stream().forEach(t-> t.click());
    }
    public  List<String>  cartIsimleri(WebDriver driver){
        List<WebElement> names = driver.findElements(By.xpath("//*[@class='text-left']"));
        List<String> sNames = new ArrayList<>();
        names.forEach(t-> sNames.add(t.getText()));
        Collections.sort(sNames);
        return sNames;
    }
    public void compare(List<String>a,List<String>b){
        String sonuc=a.equals(b)? "eslesme basarili" :"eslesme basarisiz";
        System.out.println("sonuc = " + sonuc);
    }

}

