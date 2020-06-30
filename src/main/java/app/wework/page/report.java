package app.wework.page;
/*
汇报信息
1.添加日报
 */

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class report extends AppBasePage {


    public report(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    public void adddaily(String content){
        click(By.xpath("//*[@text='汇报']"));
        click(By.xpath("//*[@text='日报']"));
        sendKeys(By.xpath("//android.webkit.WebView[@content-desc=\"日报\"]/android.widget.EditText[1]"),content);
        MobileElement el10 = (MobileElement) driver.findElementByAccessibilityId("提交");
        el10.click();

    }
}
