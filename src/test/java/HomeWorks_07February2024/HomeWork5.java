package HomeWorks_07February2024;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class HomeWork5 extends TestBase {

    @Test
    public void fileUploadTest() {

        //https://testpages.herokuapp.com/styled/basic-html-form-test.html adresine gidin.
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

        //Username adını, Password ve textArea bolumlerini faker ile doldurun
        Faker faker = new Faker();
        driver.findElement(By.xpath("//input[@name='username']"))
                .sendKeys(faker.name().firstName(), Keys.TAB,
                        faker.internet().password(), Keys.TAB,
                        faker.lorem().paragraph(), Keys.TAB);

        //Bir dosya seçin ve yükleyin
        String filePath = System.getProperty("user.home") + "\\Desktop\\DersNotlari.txt";
        driver.findElement(By.xpath("//input[@name='filename']")).sendKeys(filePath);

        //Tüm checkbox lari secin (Secili degil ise tiklayacagiz)
        driver.findElements(By.xpath("//input[@name='checkboxes[]']"))
                .stream().filter(t -> !t.isSelected()).forEach(WebElement::click);

        //Radio button da radio 1 i secin
        driver.findElement(By.xpath("//input[@value='rd1']")).click();

        //Dropdown menü den 2'yi seçin
        WebElement ddm = driver.findElement(By.xpath("//select[@name='dropdown']"));
        selectValue(ddm, "dd2");

        //submit'e tıklayın
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //Yüklenen dosyanin Form bilgilerinde yer aldığını doğrulayın
        String actuelData = driver.findElement(By.xpath("//li[text()='DersNotlari.txt']")).getText();
        String expectedData = "DersNotlari.txt";
        Assertions.assertEquals(expectedData, actuelData, "File upload test is fail");
    }
}
