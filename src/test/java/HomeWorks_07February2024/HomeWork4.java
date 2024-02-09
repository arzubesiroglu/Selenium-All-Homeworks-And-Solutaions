package HomeWorks_07February2024;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class HomeWork4 extends TestBase {

    @Test
    public void dynamicWaitTest() {

        //https://testpages.herokuapp.com/styled/challenges/growing-clickable.html adresine gidiniz
        driver.get("https://testpages.herokuapp.com/styled/challenges/growing-clickable.html");

        //click me buttonu na tiklayiniz
        //Butona tikladigimizda sonuc alabilmek icin tam olarak buyumesini beklemek lazim.
        //Beklemeyi dinamik yapabilmek icin; kucuk ve buyuk halinde value'su degisen bir attribute'u sectik
        //buton buyudugunde aldigi deger ile locate aldik. Ve Locate edilebilene kadar beklettik
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//button[@class='styled-click-button showgrow grown']"))).click();

        //"Event Triggered" yazisinin görüntülendigini dogrulayiniz
        String actuelText = driver.findElement(By.xpath("//p[@id='growbuttonstatus']")).getText();
        String expectedText = "Event Triggered";
        Assertions.assertEquals(expectedText, actuelText, "Text test is fail");
    }
}