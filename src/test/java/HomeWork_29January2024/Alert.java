package HomeWork_29January2024;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Alert extends TestBase {

    /*
        ==========Homework 1===========================
    -http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
    -Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
    -Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
    -Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
    -Çıkan alert'te iptal butonuna basınız
    -Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
    -Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
    -Çıkan mesajı konsola yazdırınız
    -Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız
     */



    @Test
    public void Test01() {

        // -http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
        driver.get("http://demo.automationtesting.in/Alerts.html");

        //-Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();

        //-Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
        String text1 = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        System.out.println(text1);

        //-Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
        driver.findElement(By.xpath("//a[@href='#CancelTab']")).click();
        waitForSecond(1);
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();


        //-Çıkan alert'te iptal butonuna basınız
        driver.switchTo().alert().dismiss();
        //-Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
        driver.findElement(By.xpath("//a[@href='#Textbox']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();

        //-Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
        driver.switchTo().alert().sendKeys("Arzu");
        driver.switchTo().alert().accept();
        //-Çıkan mesajı konsola yazdırınız
        String ActualText2 = driver.findElement(By.id("demo1")).getText();
        System.out.println(ActualText2);

        //-Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız
        String expectedText2 = "Hello Arzu How are you today";
        Assertions.assertEquals(expectedText2, ActualText2);


    }

}
