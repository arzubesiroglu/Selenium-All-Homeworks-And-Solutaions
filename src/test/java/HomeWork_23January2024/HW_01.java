package HomeWork_23January2024;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import static org.junit.Assert.assertEquals;

public class HW_01 {

    WebDriver driver;

    @Before
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() throws InterruptedException {

        //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        // "Add Element" butonuna 100 kez basiniz
        for (int i = 0; i < 100; i++) {
            WebElement addElementButton = driver.findElement(By.cssSelector("button[onclick]"));
            addElementButton.click();
        }

        Thread.sleep(2000);

        // "Delete" butonuna 90 kez basiniz
        for (int i = 0; i < 90; i++) {
            WebElement deleteButton = driver.findElement(By.cssSelector("button[class='added-manually']"));
            deleteButton.click();
        }

        Thread.sleep(2000);

        // "Delete" butonuna 90 kez basıldığını kontrol ediniz
        int deleteButtonCount = driver.findElements(By.cssSelector("button[class='added-manually']")).size();
        assertEquals(10, deleteButtonCount);

        // Eğer "Add Element" butonuna 100 kez basılıp,
        // ardından "Delete" butonuna 90 kez basılıyorsa,
        // başlangıçtaki 1 buton hariç, eklenen toplam 90 buton silinir ve geriye 10 "Delete" butonu kalır.
        // Eğer deleteButtonCount değişkeni 10'a eşitse, test başarılıdır; aksi halde test başarısız olur
    }

    @After
    public void tearDown() throws InterruptedException {
        // WebDriver'ı kapatiniz
        driver.quit();

       /* veya bu şekilde de çözülebilir

        @Test
        public void test01() throws InterruptedException {
        /*
        ÖDEV:
        https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        Add Element butonuna basin 100 kez basınız
        Delete butonuna 90 kez basınız
        Ve 90 kez basıldığını doğrulayınız
        */
            /*
            WebDriver driver =new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

            //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
            driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

            //Add Element butonuna basin 100 kez basınız
            for (int i=0;i<100;i++){
                WebElement addElement=driver.findElement(By.xpath("//button[@onclick='addElement()']"));
                addElement.click();
            }

            Thread.sleep(3000);
            //Delete butonuna 90 kez basınız
            int counter=0;
            for (int i = 0; i <90 ; i++) {
                WebElement deleteButton= driver.findElement(By.xpath("//button[text()='Delete']"));
                deleteButton.click();
                counter++;
            }
            Thread.sleep(3000);
            //Ve 90 kez basıldığını doğrulayınız
            int actualData=counter;
            int expectedData=90;

            Assertions.assertTrue(counter==90);

            driver.quit();


        }
    }
        */




    }
}

