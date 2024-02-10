package HomeWork_22January2024;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HW_01 {

        /*
       homework
       https://www.google.com/ adresine gidin
       cookies uyarisi cikarsa kabul ederek kapatin
       Sayfa basliginin “Google” ifadesi icerdigini test edin
       Arama cubuguna “Selenium” yazip aratin
       Bulunan sonuc sayisini yazdirin
       sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
       Sayfayi kapatin
       */

    @Test
    public void test01() throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //https://www.google.com/ adresine gidin
        //cookies uyarisi cikarsa kabul ederek kapatin
        driver.get("https://www.google.com/");
        Thread.sleep(5000);
        //Sayfa basliginin “Google” ifadesi icerdigini test edin
        String expectedTitle="Google";
        String actualTitle = driver.getTitle();
        Assertions.assertTrue(actualTitle.contains(expectedTitle));
        //Arama cubuguna “Selenium” yazip aratin
        WebElement searchBox = driver.findElement(By.xpath("//div/textarea[@autocapitalize='off']"));
        searchBox.sendKeys("Selenium", Keys.ENTER);
        // Bulunan sonuc sayisini yazdirin
        WebElement searchResult= driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println("searchResult.getText() = " + searchResult.getText()); //Yaklaşık 208.000.000 sonuç bulundu
        //Sadece sonuc sayısını yazdırınız
        System.out.println("sadece sonuc sayisi  = " + searchResult.getText().split(" ")[1]);
        //sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        int numberOfResult= Integer.parseInt(searchResult.getText().split(" ")[1].replace(".",""));
        int x=10000000;
        Assertions.assertTrue(numberOfResult>x);
        //sayfayi kapatınız
        driver.quit();




    }
}