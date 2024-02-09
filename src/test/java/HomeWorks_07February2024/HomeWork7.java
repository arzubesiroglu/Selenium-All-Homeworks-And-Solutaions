package HomeWorks_07February2024;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class HomeWork7 extends TestBase {

    @Test
    public void dragAndDropTest() {

        //https://demo.guru99.com/test/drag_drop.html adresine gidin
        driver.get("https://demo.guru99.com/test/drag_drop.html");

        //Sayfayi kesfederek turuncu webelementleri uygun kutulara sürükleyin
        WebElement positive5000 = driver.findElement(By.xpath("//li[@data-id='2']"));
        WebElement bank = driver.findElement(By.xpath("//li[@data-id='5']"));
        WebElement sales = driver.findElement(By.xpath("//li[@data-id='6']"));

        WebElement debitAccountBox = driver.findElement(By.xpath("//ol[@id='bank']"));
        WebElement debitAmountBox = driver.findElement(By.xpath("//ol[@id='amt7']"));
        WebElement creditAccountBox = driver.findElement(By.xpath("//ol[@id='loan']"));
        WebElement creditAmountBox = driver.findElement(By.xpath("//ol[@id='amt8']"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(positive5000, debitAmountBox)
                .dragAndDrop(positive5000, creditAmountBox)
                .dragAndDrop(bank, debitAccountBox)
                .dragAndDrop(sales, creditAccountBox).perform();

        //Perfect! yazisinin görüntülendigini test edin
        Assertions.assertTrue(driver.findElement(By.xpath("//a[text()='Perfect!']")).isDisplayed());
    }
}
