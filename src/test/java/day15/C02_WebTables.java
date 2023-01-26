package day15;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C02_WebTables extends TestBase {

    //    https://the-internet.herokuapp.com/tables
    //    Create a class: WebTables
    //    Task 1 : Table1’i print edin
    //    Task 2 : 3. Row’ datalarını print edin
    //    Task 3 : Son row daki dataları print edin
    //    Task 4 : 5. Column datalarini print edin
    //    Task 5 : Iki parametreli bir Java metot oluşturalım: printData
    //    Parameter 1 = row numarasi
    //    Parameter 2 = column numarasi
    //    printData(2,3);  => 2nd row, 3rd column daki datayı print etsin



    @Test
    public void table1Print(){
        driver.get("https://the-internet.herokuapp.com/tables");
        String table1 = driver.findElement(By.xpath("//table[@id='table1']")).getText();
        System.out.println("TABLE 1 VERILERI");
        System.out.println(table1);
        List<WebElement> tumVeriler = driver.findElements(By.xpath("//table[@id='table1']//td"));
//        tumVeriler.forEach(t-> System.out.println(t.getText()));//LAMDA
        for (WebElement veri : tumVeriler){
            System.out.println(veri.getText());
        }

        }

   @Test
    public void row3Print(){

       driver.get("https://the-internet.herokuapp.com/tables");
       //    Task 2 : 3. Row’ datalarını print edin
      List<WebElement> row3element=  driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[3]//td"));
      row3element.forEach(t-> System.out.println(t.getText()));

    }
    @Test
    public void sonrowPrint(){

        driver.get("https://the-internet.herokuapp.com/tables");

        //    Task 3 : Son row daki dataları print edin
        List<WebElement> sonrow=  driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[last()]//td"));
        sonrow.forEach(t-> System.out.println(t.getText()));
    }
    @Test
    public void sutun5(){
        driver.get("https://the-internet.herokuapp.com/tables");
        //    Task 4 : 5. Column datalarini print edin

        List<WebElement> sutun5 = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr//td[5]"));
        sutun5.forEach(t-> System.out.println(t.getText()));
    }


    //    Parameter 1 = row numarasi
//    Parameter 2 = column numarasi
//    printData(2,3);  => 2nd row, 3rd column daki datayı print etsin
    //RESUBLA METHOD
    public void method(int row,int sutun){
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> satirsutun= driver.
                findElements(By.xpath("//table[@id='table1']//tbody//tr[" + row + "]//td[" + sutun + "]"));
        satirsutun.stream().forEach(t -> System.out.println(t.getText()));

        }

    //Ahmet Hoca cozum::::::::::
    public void printData(int satir, int sutun){
        driver.get("https://the-internet.herokuapp.com/tables");
        String myXpath = "//table[@id='table1']//tbody//tr["+satir+"]//td["+sutun+"]";
        System.out.println(driver.findElement(By.xpath(myXpath)).getText());
    }

    @Test
    public void printDataTest(){
        printData(2,3);







    }
    public void printData(String tableName, int row, int column) {
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> columnFiveElements = driver.
                findElements(By.xpath("//table[@id='" + tableName + "']//tbody//tr[" + row + "]//td[" + column + "]"));
        columnFiveElements.stream().forEach(t -> System.out.println(t.getText()));
    }
    }

