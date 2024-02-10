package HomeWork_26January2024;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

public class HW_01 extends TestBase {

        /*
        //homework
        //https://html.com/tags/iframe/ sayfasina gidiniz
        // sayfada bulunan youtube videosunu baslatiniz
        */


    @Test
    public void test01() {

        //https://html.com/tags/iframe/ sayfasina gidiniz
        driver.get("https://html.com/tags/iframe/");

        // sayfada bulunan youtube videosunu baslatiniz
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//button[@title='Oynat']")).click();
        waitForSecond(3);

        /* başka çözüm yolu

        driver.get("https://html.com/tags/iframe/");
        waitForSecond(2);
        // İframe'e geçiş yapılır
        driver.switchTo().frame(0);
       // WebElement iframeElement = driver.findElement(By.xpath("(//iframe)[1]"));

        waitForSecond(2);
        // sayfada bulunan youtube videosunu baslatiniz
        // iframe içindeki YouTube video button elementi bulunur.
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();

       //iframeden çıkılabilir
        driver.switchTo().defaultContent();
    }
}
         */


    }
}