package HomeWork_17January2024;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class HW_01 {
    public static void main(String[] args) {
            /*
            Yeni bir class olusturalim (Homework)
            ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “Facebook” icerdigini dogrulayin (verify),
            degilse dogru basligi yazdirin.
            Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i yazdirin.
            https://www.walmart.com/ sayfasina gidin.
            Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
            Tekrar “facebook” sayfasina donun
            Sayfayi yenileyin
            sayfayi tam sayfa (maximize) yapin
            Sayfayi kapatin
            */

        //Yeni bir class olusturalim (Homework)
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //ChromeDriver kullanarak, facebook sayfasina gidin
        driver.get("https://facebook.com");

        // sayfa basliginin (title) “Facebook” icerdigini dogrulayin (verify),
        //degilse dogru basligi yazdirin.
        if (driver.getTitle().contains("Facebook")){
            System.out.println("Test Passed : Facebook iceriyor");//Test Passed
        }else System.out.println("Test Failed : Facebook icermiyor");

        //Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i yazdirin.
        if (driver.getCurrentUrl().contains("facebook")){
            System.out.println("Test Passed : facebook iceriyor");//Test Passed
        }else System.out.println(driver.getCurrentUrl());

        //https://www.walmart.com/ sayfasina gidin.
        driver.get("https://www.walmart.com/");

        //Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        if (driver.getTitle().contains("Walmart.com")){
            System.out.println("Test Passed : Walmart iceriyor");
        }else System.out.println("Test Failed : Walmart icermiyor"); //Test Failed

        //Tekrar “facebook” sayfasina donun
        driver.navigate().back();

        //Sayfayi yenileyin
        driver.navigate().refresh();

        //sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();

        //Sayfayi kapatin
        driver.quit();


        //Browser'i istenen konuma tasi
        //driver.manage().window().setPosition(new Point(80, 0));

        //Browser'i istenen konuma getir
        //driver.manage().window().setSize(new Dimension(800, 600));

    }
}


