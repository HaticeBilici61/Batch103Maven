package day11;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {
    /*
      Class : FileExistTest
      Method : isExist
      Masa ustunden bir dosyanın varligini test et

     */

    @Test
    public void isExisttest(){
        String userDIR=System.getProperty("user.dir");
        System.out.println(userDIR);//C:\Users\zafer\IdeaProjects\Batch103_Maven_Junit

        String userHome=System.getProperty("user.home");
        System.out.println(userHome);//C:\Users\zafer

        //logo.jpeg indirip masaustune kaydedelim bu dosyanin varligini test ediyoruz
        //Logo masaustunde :
        String dosyaYolu=userHome+"/Desktop/logo.jpeg";
        System.out.println(dosyaYolu);

        boolean isExsist=  Files.exists(Paths.get(dosyaYolu));//dosaya var ise true ,yok ise false retiurn edecek
        Assert.assertTrue(isExsist);

    }


}
