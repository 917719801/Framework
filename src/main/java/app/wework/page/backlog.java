package app.wework.page;
/*
添加待办事项
 */

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class backlog extends AppBasePage {

    private final By taskList = By.id("gw9");
    private final By add = By.id("gym");
    private final By b2k = By.id("b2k");
    private final By xpath = By.xpath("//*[@text='参与人']");


    public backlog(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public backlog addbacklog(String content, String name) {
        if(wait.until(ExpectedConditions.invisibilityOfElementLocated(add))){
            click(add);
        }
        sendKeys(b2k, content);
        click(xpath);
        click(By.id("gyr"));
        sendKeys(By.id("fn5"), name);
        find(By.className("android.widget.ImageView"));
        click(By.id("fq2"));
        click(By.id("fq1"));
        click(By.id("gxq"));

        return this;

    }

    public String getbacklog() {

        return find(By.id("gw9")).getText();
    }

}
