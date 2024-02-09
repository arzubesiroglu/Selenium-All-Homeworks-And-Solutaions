package HomeWorks_07February2024;

import org.junit.jupiter.api.Test;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.interactions.Actions;
        import utilities.TestBase;

public class HomeWork1 extends TestBase {

    @Test
    public void drawingWithActionsClassTest() {

        //- http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");

        //- Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        WebElement touchpad = driver.findElement(By.xpath("//div[@class='signature-pad--body']"));
        Actions actions = new Actions(driver);

        actions.clickAndHold(touchpad).moveByOffset(0, 100)
                .moveByOffset(100, 0)
                .moveByOffset(0, -100)
                .moveByOffset(-100, 0).release().perform();

        //- Çizimden sonra clear butonuna basınız
        driver.findElement(By.xpath("//button[text()='Clear']")).click();
        waitForSecond(2);
        //- Sayfayi kapatiniz
    }
}