package web.wework.page;
/*
将公共方法提取
 */

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test_framework.BasePage;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class WebBasePage extends BasePage {

    WebDriverWait wait;
    RemoteWebDriver driver;

    public WebBasePage(RemoteWebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, 10);

    }


    public WebBasePage() {
        driver = new ChromeDriver();
        //隐式等待5秒
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    public void quit() {
        driver.quit();
    }

    public void click(By by) {

        wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();

    }

    public void sendKeys(By by, String content) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).sendKeys(content);

    }
    public  void  upload(By by,String path){
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        driver.findElement(by).sendKeys(path);

    }

    @Override
    public void action(HashMap<String, Object> map) {
        super.action(map);
        if(map.get("action").toString().toLowerCase().equals("get")){
            driver.get(map.get("url").toString());
        }else {
            System.out.println("出问题了！");
        }
    }
    @Override
    public void click(HashMap<String, Object> map) {
        super.click(map);
        String key = (String) map.keySet().toArray()[0];
        String value = (String) map.values().toArray()[0];
        By by = null;
        if (key.toLowerCase().equals("id") ) {
            by = By.id(value);
        }
        if (key.toLowerCase().equals("linkText".toLowerCase())) {
            by = By.linkText(value);
        }
        if (key.toLowerCase().equals("partialLinkText".toLowerCase())) {
            by = By.partialLinkText(value);
        }
        click(by);
    }
}
