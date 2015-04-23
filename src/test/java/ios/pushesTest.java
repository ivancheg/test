package ios;

import com.google.api.client.util.DateTime;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.testng.annotations.Test;
import phones.PhoneUtil;

import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by admin on 2/9/15.
 */
public class pushesTest
{
    private IOSDriver driver;
    private AndroidDriver aDriver;
    private static final String     url    = "http://127.0.0.1:4723/wd/hub";

    @Test
    public void startTest() throws MalformedURLException, InterruptedException {

        aDriver = PhoneUtil.createAndroidDriver("GT_I9300", url);
        //aDriver = PhoneUtil.createAndroidWebDriver("GT_I9192", url);
        //aDriver.get("htpps://google.com");
        Thread.sleep(5000);
        //aDriver.get("http://ya.ru");
        for(int i=0; i<140; i++)
        {
            System.out.println(getCurrentTimeStamp());
            aDriver.findElementByXPath("(//*[@class='android.widget.ImageView'])[2]").click();
            Thread.sleep(600000);
        }
        Thread.sleep(3000);
        aDriver.quit();
    }

    private String getCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }
}
