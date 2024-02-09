package HomeWorks_07February2024;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class HomeWork2 extends TestBase {

    @Test
    public void dropDownTest() {

        //https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement ddm = driver.findElement(By.xpath("//select[@id='dropdown']"));
        selectIndex(ddm, 1);

        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        selectValue(ddm, "2");

        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        selectVisibleText(ddm, "Option 1");

        //4.Tüm dropdown değerleri(value) yazdırın( Deger var ise yazdiriyoruz !isEmpty)
        new Select(ddm).getOptions().stream().filter(t-> !t.getAttribute("value").isEmpty())
                .forEach(t -> System.out.println("ddm value : " + t.getAttribute("value")));

        //5.Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
        int ddmSize = new Select(ddm).getOptions().size();
        System.out.println("DDM Size : " + ddmSize);
        System.out.println(ddmSize == 4 ? "True" : "False");
    }
}