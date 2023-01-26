package day16_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {

    @Test
    public void writeExcelTest() throws IOException {
        //  WORKBOOK > WORKSHEET/SHEET (SAYFA) > ROW (SATIR) > CELL (VERI HUCRESI)
       //    WORKBOOK > SHEET  > ROW  > CELL > YAZ > KAYDET
        String path="./src/test/java/Resources/Capitals.xlsx";
        FileInputStream fileinputstream=new FileInputStream(path);//dosya yi actik

        //Excel dosaysini ac/ worbook ac
        Workbook workbook= WorkbookFactory.create(fileinputstream);

        //sayfayi ac/ Sheet1
        //  Sheet sheet1=workbook.getSheetAt(0);
        Sheet sheet1=workbook.getSheet("Sheet1");//iki sekilde sayfaya dosyaya gidebiliriz sheet1 isimli sayfayi ac

        //ilk satira gidelim/Row
        Row row1= sheet1.getRow(0);   //------ilk satira gittik

        //ilk satir 3.sutunu create et
       Cell cell3= row1.createCell(2);

       //o satira nufus yazalim
        cell3.setCellValue("NUFUS");

        //2,satir 3.sutuna 450000 yazdiralimn
        sheet1.getRow(1).createCell(2).setCellValue("450000");


        //3.satir 3.sutuna 350000 yazdiralim
        sheet1.getRow(2).createCell(2).setCellValue("350000");


        //kaydet
        FileOutputStream fileOutputStream=new FileOutputStream(path);
        workbook.write(fileOutputStream);




    }
}
