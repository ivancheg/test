import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by admin on 4/23/15.
 */
public class GoogleServicesTest {
    private WebDriver driver;

    @Test
    @Parameters("CurrentServices")
    public void playServicesTest(String currentServices){
        driver = new HtmlUnitDriver();
        driver.get("http://www.apkmirror.com/apk/google-inc/google-play-services/");
        Assert.assertEquals(driver.findElement(By.xpath("(.//*[@id='primary']//*[@class='fontBlack'])[1]")).getText().split("\\(")[0], currentServices);
    }


}
