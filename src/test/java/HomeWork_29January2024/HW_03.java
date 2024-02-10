package HomeWork_29January2024;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;
import java.util.List;
import java.util.Set;

public class HW_03 extends TestBase {
    /*
    ==========Homework 3===========================
    - ebay sayfasına gidiniz
    - electronics bölümüne tıklayınız
    - Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
    - Her sayfanın sayfa başlığını yazdıralım
     */

    @Test
    void test01() {
        //==========Homework 3===========================
        //- ebay sayfasına gidiniz
        driver.get("https://ebay.com");

        //- electronics bölümüne tıklayınız
        driver.findElement(By.xpath("(//a[contains(text(),'Electronics')])[2]")).click();

        //- Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım

        List<WebElement> matchingImages = driver.findElements(By.xpath("//img[@width='225' and @height='225']"));
        Actions actions = new Actions(driver);
        for (WebElement image : matchingImages) {
            // Her bir resmin üzerine sağ tıkla
            actions.keyDown(Keys.CONTROL).click(image).keyUp(Keys.CONTROL).perform(); // ctyrl basili tutarak bastigimizda yeni sayfada aciyor
            waitForSecond(1);

        }

        //- Her sayfanın sayfa başlığını yazdıralım
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
            waitForSecond(1);
            System.out.println("Sayfa Basligi: " + driver.getTitle());
        }


    }
}
