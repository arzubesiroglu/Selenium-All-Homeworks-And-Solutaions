package HomeWork_29January2024;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class DropDown extends TestBase {
    /*
    ==========Homework 2===========================
    //https://the-internet.herokuapp.com/dropdown adresine gidin
    //1.SelectByIndexTest methodunu oluşturun ve indeksi kullanarak Seçenek 1'i seçin
    //2.SelectByValueTest methodunu oluşturun ve  value ile Seçenek 2'yi seçin
    //3.SelectByVisibleTextTest methodunu olusturun ve görünür metinle Seçenek 1 değerini seç
    //4.printAllTest methodunu olusturun ve tüm seceneklerin metinlerini konsol a yazdirin, secenekler arasinda "Option 2" oldugunu test edin
    //5.yeni bir method olusturun ve default olarak secili olan secenegin "Please select an option" oldugunu test edin
    //6.sizeTest adinda yeni bir method olusturun ve dropdown menudeki secenek sayisinin 3 oldugunu test edin,
     */

    @Test
    public void Test01() {
        // https://the-internet.herokuapp.com/dropdown adresine gidin
        driver.get("https://the-internet.herokuapp.com/dropdown");

        // 1.SelectByIndexTest methodunu oluşturun ve indeksi kullanarak Seçenek 1'i seçin
        WebElement Dropdown = driver.findElement(By.id("dropdown"));
        Dropdown.click();
        Select dropDown = new Select(Dropdown);
        dropDown.selectByIndex(1);

        // 2.SelectByValue methodunu oluşturun ve  value ile Seçenek 2'yi seçin
        dropDown.selectByValue("2");

        // 3.SelectByVisibleText Test methodunu olusturun ve görünür metinle Seçenek 1 değerini seç
        dropDown.selectByVisibleText("Option 1");

        // 4.printAll Test methodunu olusturun ve tüm seceneklerin metinlerini konsol a yazdirin, secenekler arasinda "Option 2" oldugunu test edin
        List<WebElement> konsol = dropDown.getOptions();
        List<String> Opt = new ArrayList<>();

        for (WebElement w : konsol) {
            System.out.println(w.getText());
            Opt.add(w.getText());
        }

        Assertions.assertTrue(Opt.toString().contains("Option 2"));


        // 5.yeni bir method olusturun ve default olarak secili olan secenegin "Please select an option" oldugunu test edin

        for (WebElement w : konsol) {
            if (!w.isEnabled()) {
                System.out.println(w.getText());
                Assertions.assertEquals("Please select an option", w.getText());
            }
        }

        // 6.size Test adinda yeni bir method olusturun ve dropdown menudeki secenek sayisinin 3 oldugunu test edin,
        int actualindexNumber = dropDown.getOptions().size();
        int expectedindexNumber = 3;
        Assertions.assertEquals(expectedindexNumber, actualindexNumber);
        System.out.println(actualindexNumber);

    }

}
