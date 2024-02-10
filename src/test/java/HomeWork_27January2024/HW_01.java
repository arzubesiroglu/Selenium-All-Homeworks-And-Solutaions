package HomeWork_27January2024;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
public class HW_01 extends TestBase{
    /*
        //  https://the-internet.herokuapp.com/windows adresine gidin.
    //  ilk sayfasının Handle degerini alın yazdırın
    //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
    //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
    //  "Click Here" butonuna tıklayın.
    //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
    //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
    //  ikinci sayfaya tekrar geçin.
    //  ilk sayfaya tekrar dönün.

     */

        @Test
        public void test01() {
            //1. kısa yol ile çözülecek --> list

            //  https://the-internet.herokuapp.com/windows adresine gidin.
            driver.get("https://the-internet.herokuapp.com/windows");

            //  ilk sayfasının Handle degerini alın yazdırın
            String ilkSayfaHandleDegeri = driver.getWindowHandle();

            //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
            String actualText = driver.findElement(By.xpath("//h3")).getText();
            Assertions.assertEquals("Opening a new window", actualText);

            //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
            Assertions.assertEquals("The Internet", driver.getTitle());

            //  "Click Here" butonuna tıklayın.
            driver.findElement(By.partialLinkText("Click Her")).click();

            waitForSecond(5);
            //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
            List<String> windowsHandle = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(windowsHandle.get(1));
            Assertions.assertEquals("New Window", driver.getTitle());

            waitForSecond(3);
            //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
            driver.switchTo().window(ilkSayfaHandleDegeri);
            Assertions.assertEquals("The Internet", driver.getTitle());

            //  ikinci sayfaya tekrar geçin.
            driver.switchTo().window(windowsHandle.get(1));

            //  ilk sayfaya tekrar dönün.
            driver.switchTo().window(ilkSayfaHandleDegeri);
        }


    @Test
    public void test02() {
        //2. kısa yol ile çözülecek --> toArray()[].toString()

        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfasının Handle degerini alın yazdırın
        String ilkSayfaHandleDegeri = driver.getWindowHandle();

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        Assertions.assertEquals("Opening a new window", actualText);

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        Assertions.assertEquals("The Internet", driver.getTitle());

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.partialLinkText("Click Her")).click();

        waitForSecond(5);
        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        Assertions.assertEquals("New Window", driver.getTitle());

        waitForSecond(3);
        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(ilkSayfaHandleDegeri);
        Assertions.assertEquals("The Internet", driver.getTitle());

        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());

        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(ilkSayfaHandleDegeri);
    }
}
