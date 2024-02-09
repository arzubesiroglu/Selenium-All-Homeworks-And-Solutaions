package HomeWorks_07February2024;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class HomeWork6 extends TestBase {

    @Test
    public void ShoppingTest() {

        // https://www.saucedemo.com/ adresine gidin
        driver.get("https://www.saucedemo.com/");

        // Kullanici adini "standard_user" olarak girin
        // Şifreyi "secret_sauce" olarak girin
        // Login buttonuna tiklayin
        driver.findElement(By.xpath("//input[@id='user-name']"))
                .sendKeys("standard_user", Keys.TAB, "secret_sauce", Keys.ENTER);

        // Tum urunleri sepete ekleyin
        driver.findElements(By.xpath("//button[text()='Add to cart']")).forEach(WebElement::click);

        // Sepete tiklayarak gidin
        driver.findElement(By.xpath("//div[@id='shopping_cart_container']")).click();

        // Checkout a tiklayin
        Actions actions = new Actions(driver);
        WebElement checkOut = driver.findElement(By.xpath("//button[@id='checkout']"));
        actions.scrollToElement(checkOut).click(checkOut).perform();

        // FirstName-LastName ve posta code unu doldurun
        driver.findElement(By.xpath("//input[@id='first-name']"))
                .sendKeys("Mustafa", Keys.TAB, "A.", Keys.TAB, "34000");

        // continue butonuna tiklayin
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("//input[@id='continue']")).click();

        // Toplam fiyatın 140,34$ olduğunu dogrulayin
        WebElement totalPrice = driver.findElement(By.xpath("//div[contains(text(), 'Total: $')]"));
        String totalPricestr = totalPrice.getText().split("\\$")[1];//140.34
        Assertions.assertEquals("140.34", totalPricestr);

        // finish e tiklayin
        driver.findElement(By.xpath("//button[@id='finish']")).click();

        // Checkout: Complete! yazisinin görüntülendigini doğrulayiniz
        actions.sendKeys(Keys.PAGE_UP).perform();
        Assertions.assertTrue(driver.findElement(By.xpath("//span[text()='Checkout: Complete!']"))
                .isDisplayed());
    }
}
