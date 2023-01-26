package day16_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C01_ExcelRead {

    @Test
    public void readExcelTest() throws IOException {
//  WORKBOOK > WORKSHEET/SHEET (SAYFA) > ROW (SATIR) > CELL (VERI HUCRESI)

//        Excel Okuma
//        Excelden veriyi okumak icin hangi sırayla gitmem gerekir
//        workbook > sheet > row > cell
//        Bir exceldeki top satir sayısı nasıl bulunur?
//                getLastROwNumber
//        Yada
//        getPhysicalNumberOfRows- toplam kullanılan satir sayısı
//        Excel Yazdırma
//        Microsoft dosyalari ile iletişime gecmek icin apache poi dependency’s kullanılır
//        Su anki projende exceli nasil kullandin?
//        Test caselerimde çeşitli datalar kullanıyorum. Ornegin kullanıcı adi, kullanıcı şifresi gibi dataları excelde tutuyoruz. Bu datalari test caselerde kullanmak icin excelden çekiyorum ve test caselerimde kullanıyorum.
//        Datalari excelde tutmanı faydası, dataların derli toplu bir yerde olması, data güvenliği, data kayıplarına engel olmak.
//


        String path="./src/test/java/Resources/Capitals.xlsx";
        FileInputStream fileinputstream=new FileInputStream(path);//dosya yi actik

        //Excel dosaysini ac/ worbook ac
        Workbook workbook= WorkbookFactory.create(fileinputstream);

        //sayfayi ac/ Sheet1
      //  Sheet sheet1=workbook.getSheetAt(0);
        Sheet sheet1=workbook.getSheet("Sheet1");//iki sekilde sayfaya dosyaya gidebiliriz sheet1 isimli sayfayi ac

        //ilk satira gidelim/Row
         Row row1= sheet1.getRow(0);   //------ilk satira gittik

        //ilk satirdaki ilk veriyi al
        Cell cell1= row1.getCell(0);  //----------ilk hucredeki datayi verir

        //o veriyi yazdir
        System.out.println(cell1);

        //1.satir 2.sutun
       Cell cell2= sheet1.getRow(0).getCell(1);
        System.out.println(cell2);


        //3.satir 1.sutun yazdir ve o verinin France oldugunu test et
        String cell3=sheet1.getRow(2).getCell(0).toString();
        System.out.println(cell3);

        Assert.assertEquals("France",cell3);

        //excel deki toplam kullanilan satir sayisini bul.
       int toplamSatirSayisi= sheet1.getLastRowNum()+1 ;//SON SATIR  NUMARASI indeks 0 dan basladigi icin +1 dedik
        System.out.println(toplamSatirSayisi);

          //kullanilan satir sayisini bulalim yani bu 11 satir icerisinde bos olan satirlar olabilir
        int kullanilanToplamSatirSayisi=sheet1.getPhysicalNumberOfRows(); //fiziksel satir sayisi demek,aktif olan
        System.out.println(kullanilanToplamSatirSayisi);// 1 den basliyor bu method


        //COUNTRY ,CAPITALS key ve valualari map a alip print et
        //        {{USA, D.C},{FRANCE, PARIS},...}

//        Variable olusturalim. Bu variable exceldeki country,capital verilerini tutacak
        Map<String,String> ulkeBaskentleri = new HashMap<>();


        for (int satirSayisi=1;satirSayisi<kullanilanToplamSatirSayisi;satirSayisi++){
            String country = sheet1.getRow(satirSayisi).getCell(0).toString();
            String capital = sheet1.getRow(satirSayisi).getCell(1).toString();
            ulkeBaskentleri.put(country,capital);
        }
        System.out.println(ulkeBaskentleri);

    }
}
