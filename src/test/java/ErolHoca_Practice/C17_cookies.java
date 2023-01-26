package ErolHoca_Practice;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C17_cookies extends TestBase {
    @Test
    public void cokies() throws InterruptedException {
        /*
                                    Cookies(Çerezler)
        "Cookie" ler, bir web sitesi tarafından tarayıcıya depolanan küçük veri parçacıklarıdır.
    Tarayıcı, herhangi bir web sayfasına gittiğinde, o sayfanın cookie'lerini saklar ve
    daha sonra o sayfaya geri döndüğünde, o cookie'leri tekrar gönderir. Bu sayede, web sitesi,
    kullanıcının daha önce o sayfada ne yaptığını veya ne seçtiğini hatırlayabilir.
     */
        //Techproeducation adresine gidiniz
        driver.get("https://techproeducation.com");
        Thread.sleep(5000);

        //Sayfadaki cookie lerin sayısını yazdırınız
        Set<Cookie> cookies=driver.manage().getCookies();
        System.out.println(cookies.size());

        //Sayfadaki cookie lerin isim ve değerlerini yazdırınız
        for (Cookie w:cookies){
            System.out.println(w.getName()+w.getValue());
        }

        cookies.stream().forEach(t-> System.out.println(t.getName()+t.getValue()));
        //Yeni bir cookie ekleyiniz
        Cookie myCookie=new Cookie("myCookie","12345");
        driver.manage().addCookie(myCookie);

        //Yeni cookie eklendikten sonra cookie sayısını ve isimlerini yazdırınız
        Set<Cookie> cookiess=driver.manage().getCookies();
        System.out.println("cookiess.size() = " + cookiess.size());

        cookiess.stream().forEach(t-> System.out.println(t.getName()+t.getValue()));

        //Oluşturduğumuz cookie'i silelim
        driver.manage().deleteCookie(myCookie);

        //Tüm cookieleri
        driver.manage().deleteAllCookies();
        Set<Cookie> cookies3=driver.manage().getCookies();
        System.out.println(cookies3.size());

    }
}
