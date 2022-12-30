package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_DropDown {

    //   Dropdown?
    //    -Acilir menu. Birden fazla seçenegi koyabilecegimiz liste.
    //    Dropdown nasil automate edilir? How to handle dropdown?
    //    Dropdown elementi locate edilir.8 locatordan biri kulllaninbilir.
    //    Select classi kullanilarak bir Select objesi olusturulur. Select select = new Select(dropdownElement);
    //    Select objectini kullanarak ugun methodlarla islem yapilir
    //    selectBylndex(int); index 0 dan baslar
    //    selectByValue(“String”);
    //    selectByVisibleText(“String”);
    //    getOptions(); tum dropdown seçenekleri List<WebElement> olarak return eder
    //    getFirstSelectedOption(); secili olan ilk secenegi(default) return eder.

    WebDriver driver;
    @Before      //eger test sinifinda birden fazla method olusturulmussa before kullanilir,cunku herbir test methodundan once driver i almaliyiz
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1--Given kullanici     https://testcenter.techproeducation.com/index.php?page=dropdown
        driver.get(" https://testcenter.techproeducation.com/index.php?page=dropdown");
    }
    @Test
    public void selectByIndexTest(){

        // 2-- dogum yilini ,ayini ve gununu su sekilde secer 2000 Januar 10
        //1.locate drodown
        WebElement year= driver.findElement(By.xpath("//select[@id='year']"));

       //select objesi olustur
        Select yearDropDown=new Select(year);

        //select object kullanarak 3 farkli sekilde secim yapabilirim
        yearDropDown.selectByIndex(22); //secenek sirasi 0 dan baslar biz 2000 yilini ariyoruz.2000 yili 23.sirada

        //ay secimi
        WebElement ay=driver.findElement(By.xpath("//select[@id='month']"));
        Select ayDropdown=new Select(ay);
        ayDropdown.selectByValue("0");//optionun value degeri ile secim yapilabilir.january seceneginin valuesi 0

        //gun secimi
        WebElement gun=driver.findElement(By.id("day"));
        Select gunDropDown=new Select(gun);
        gunDropDown.selectByVisibleText("10"); //en cok tercih edilen bu yontem //Case sensitive buyuk kucuk harf duyarli
    }

    @Test
    public void printAllTest(){

        //tum eyalet isimlerini consola yazdir
      WebElement state=  driver.findElement(By.xpath("//select[@id='state']"));
        Select stateDropdown=new Select(state);
       List<WebElement> tumStateList= stateDropdown.getOptions();

            for (WebElement w : tumStateList){
                System.out.println(w.getText());
            }

        tumStateList.stream().forEach(t-> System.out.println(t.getText()));
    }

    @Test
    public void getSelectedOptionTest(){
        //bir secenegin secilip secilmedigini nasil return edecegiz (isSelected sadece checkbox ve rutorn da kullanilir,dropdown dakulanilmaz)

        //select a state deki secenegin bu secenegin(select a state) olustugunu verify edelimn
        WebElement state=  driver.findElement(By.xpath("//select[@id='state']"));
        Select secilimi=new Select(state);
        String varsayilanText= secilimi.getFirstSelectedOption().getText();
        Assert.assertEquals("Select a State",varsayilanText);

    }

         @After
        public void tearDown(){
        driver.close();
         }

        //REUSABLE METHOD:Dropdown icin tekrar tekrar




       /*
         1. What is dropdown? Dropdown nedir?
         Dropdown liste olusturmak icin kullanilir.

         2. How to handle dropdown elements? Dropdown nasil automate edilir?
         -Dropdown'i Locate ederiz
         -Select objecti'i olustururum
         -Select objecti'i ile istedigim secenegi secerim
         NOT: Select object'i olusturma nedenim, dropdownlarin Select class'i ile olusturulmasi

         3. Tum dropdown seceneklerini nasil print ederiz
         - - tum dropdown elementlerini getOptions() methodu ile listeye koyariz
         sonra secenekleri loop ile yazdirabilir

           4. Bir secenegin secili oldugunu otomate etmek icin ne yapilir?
        rnek: Gun olarak 10 i secdik ama ya secilmediyse?
        etFirstSelectedOption() secili olan secenegi return eder

     */



}
