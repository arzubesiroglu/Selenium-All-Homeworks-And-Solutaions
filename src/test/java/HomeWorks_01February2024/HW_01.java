package HomeWorks_01February2024;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class HW_01 extends TestBase {

/*
       ÖDEV:
       //google sayfasına gidelim
       //Arama kutusuna "Selenium" yazın ve Enter tuşuna basın
       //Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim
       //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım
        */


    // Yontem 1 :
    @Test
    public void test01() {

        //google sayfasına gidelim
        driver.get("https://www.google.com");

        //Arama kutusuna "Selenium" yazın ve Enter tuşuna basın
        WebElement searchBox = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        searchBox.sendKeys("Selenium", Keys.ENTER);

        //Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim
        searchBox = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        searchBox.sendKeys(Keys.CONTROL, "A", "X");

        //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım
        driver.get("https://www.google.com");

        searchBox = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        searchBox.sendKeys(Keys.CONTROL, "V", Keys.ENTER);

    }


    // Yontem 2 :
    @Test
    public void test02() {

        Actions actions = new Actions(driver);

        //google sayfasına gidelim
        driver.get("https://www.google.com");

        //Arama kutusuna "Selenium" yazın ve Enter tuşuna basın
        actions.sendKeys("Selenium", Keys.ENTER).perform();

        //Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim
        WebElement searchBox = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        actions.keyDown(Keys.CONTROL).sendKeys(searchBox, "A", "X").perform();

        //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım
        driver.get("https://www.google.com");
        actions.keyDown(Keys.CONTROL).sendKeys("V", Keys.ENTER).perform();

    /*Not:
    1-Google'a ilk  gidislerimizde, aktif element "searchBox" oldugu icin locate etmeden senKeys yapabildik
    2-Ctrl+A= tumunu secer, Ctrl+X= keser
    3-ikinci search icin yeniden Google'a gidin denildigi icin gittik, mevcut pencerede de search yapabilirdik*/

    }
}