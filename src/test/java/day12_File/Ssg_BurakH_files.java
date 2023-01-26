package day12_File;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Ssg_BurakH_files {

    // Exercise 1...

    // masaustunde bir text dosyası olusturun


    // masaustundeki text dosyasının varlıgını test edin


    @Test
    public void test01() {

        //   "C:\Users\BURAK                          \Desktop\text.txt"


        //  Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\BURAK\\Desktop\\text.txt"))); // bu islemi dinamik hale getirelim


        String farklıKısım = System.getProperty("user.home");
        String ortakKısım = "\\Desktop\\text.txt";
        String dosyaYolu = farklıKısım + ortakKısım;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }
}