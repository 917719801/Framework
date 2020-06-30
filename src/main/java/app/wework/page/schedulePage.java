package app.wework.page;
/*
添加日程
 */

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class schedulePage extends AppBasePage {
    private final By taskName = By.id("b2k");
    private final By save = byText("保存");
    private final By taskList = By.id("gg_");
    private By add = By.id("gym");

    public schedulePage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public schedulePage addschedule(String name, String time) {
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        if(wait.until(ExpectedConditions.invisibilityOfElementLocated(add))){
            click(add);
        }


        sendKeys(taskName, name);
        click(save);

        return this;
    }

    public List<String> getschedule(String day) {
        if (day != null) {
            //todo:选择日期
        }
        return driver.findElements(taskList).stream().map(x -> x.getText()).collect(Collectors.toList());
    }


}
