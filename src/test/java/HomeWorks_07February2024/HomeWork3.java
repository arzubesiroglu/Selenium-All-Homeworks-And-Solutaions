package HomeWorks_07February2024;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HomeWork3 extends TestBase {

    @Test
    public void fileDownloadAndExsistTest() {

        //https://testpages.herokuapp.com/ adresine gidiniz
        driver.get("https://testpages.herokuapp.com/");

        //File Downloads a tiklayiniz
        driver.findElement(By.xpath("//a[@id='download']")).click();

        //Acilan sayfada Server Download a tiklayiniz
        String filePath = System.getProperty("user.home") + "\\Downloads\\textfile.txt";
        try {
            Files.delete(Paths.get(filePath));
            System.out.println("Download oncesinde, benzer isim ve uzantidaki dosya silindi");
        } catch (IOException e) {
            System.out.println("Download oncesinde, benzer isim ve uzantidaki dosya yoktu");
        }

        driver.findElement(By.xpath("//button[@id='server-download']")).click();

        waitForFileExists(filePath, 60);// Max 60sn icinde, 50ms araliklarla check edecegiz

        //Dosyanin basariyla indirildigini test ediniz
        Assertions.assertTrue(Files.exists(Paths.get(filePath)));

    }

    //Download isleminde dinamik bekleme suresi icin kullaniyoruz
    public void waitForFileExists(String Filepath, long maxSec) {
        long ms = maxSec * 1000;

        do {
            try {
                Thread.sleep(50);
                ms -= 50;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (ms <= 0) {
                System.out.println("Tanimlanan sure yetersiz kaldi");
            }
        } while (!Files.exists(Paths.get(Filepath)) && ms > 0);

        System.out.println("Islem suresi : " + (maxSec * 1000 - ms) + "ms");
    }
}