package HomeWorks_01February2024;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
import java.util.Locale;

public class HW_02 extends TestBase {

    //HomeWork
    //1. "https://facebook.com" Adresine gidin
    //2. “create new account” butonuna basin
    //3. “firstName” giris kutusuna bir isim yazin
    //4. “surname” giris kutusuna bir soyisim yazin
    //5. “email” giris kutusuna bir email yazin
    //6. “email” onay kutusuna emaili tekrar yazin
    //7. Bir sifre girin
    //8. Tarih icin gun secin
    //9. Tarih icin ay secin
    //10. Tarih icin yil secin
    //11. Cinsiyeti secin
    //12. Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edim
    //13. Sayfayi kapatin


    @Test
    public void facebookTest() {

        Faker faker = new Faker(new Locale("TR"));

        //1. "https://facebook.com" Adresine gidin
        driver.get("https://facebook.com");

        //2. "create new account" butonuna basin
        driver.findElement(By.xpath("//a[text()='Create new account']")).click();

        //3. "firstName" giris kutusuna bir isim yazin
        //4. "surname" giris kutusuna bir soyisim yazin
        //5. "email" giris kutusuna bir email yazin
        //6. "email" onay kutusuna emaili tekrar yazin --> email confirm box yok
        driver.findElement(By.xpath("//input[@name='firstname']"))
                .sendKeys(faker.name().firstName(), Keys.TAB,
                        faker.name().lastName(), Keys.TAB,
                        faker.internet().emailAddress(), Keys.TAB,
                        faker.internet().password());

        //8. Tarih icin gun secin
        //9. Tarih icin ay secin
        //10. Tarih icin yil secin
        selectVisibleText(driver.findElement(By.xpath("//select[@id='month']")), "Aug");
        selectVisibleText(driver.findElement(By.xpath("//select[@id='day']")), "4");
        selectVisibleText(driver.findElement(By.xpath("//select[@id='year']")), "1990");

        //11. Cinsiyeti secin
        WebElement genderFemale = driver.findElement(By.xpath("//input[@value='1']"));
        WebElement genderMale = driver.findElement(By.xpath("//input[@value='2']"));
        WebElement genderCustom = driver.findElement(By.xpath("//input[@value='-1']"));
        genderMale.click();

        //12. Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        Assertions.assertTrue(!genderFemale.isSelected() && !genderCustom.isSelected() && genderMale.isSelected());

        //13. Sayfayi kapatin


    }
}
