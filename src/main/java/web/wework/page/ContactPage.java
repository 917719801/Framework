package web.wework.page;
/*
实现添加、删除成员
 */

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import test_framework.BasePage;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

public class ContactPage extends WebBasePage {
    By addMember = By.linkText("添加成员");
    By delete = By.linkText("删除");
    By username = By.name("username");

    public ContactPage(RemoteWebDriver driver) {
        super(driver);
    }

    public ContactPage addMember(String username, String acctid, String mobile) {
        // By addMember =By.linkText("添加成员");

        //显式等待，就算可点击也有一定的概率点击不成功
        /*new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(addMember));*/
        while (driver.findElements(addMember).size() > 0) {
            //driver.findElement(addMember).click();
            click(addMember);
        }


        sendKeys(this.username, username);
        sendKeys(By.name("acctid"), acctid);
        sendKeys(By.name("mobile"), mobile);
        click(By.cssSelector(".member_colRight_operationBar:nth-child(3) > .js_btn_save"));
/*        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("acctid")).sendKeys(acctid);
        driver.findElement(By.name("mobile")).sendKeys(mobile);
        driver.findElement(By.cssSelector(".member_colRight_operationBar:nth-child(3) > .js_btn_save")).click();*/
        return this;

    }

    public String getUserName() {
        return driver.findElement(By.cssSelector(".member_display_cover_detail_name")).getText();
    }


    //搜索用户
    public ContactPage search(String keyword) {
        sendKeys(By.id("memberSearchInput"), keyword);
        //driver.findElement(By.id("memberSearchInput")).sendKeys(keyword);
      /*  new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(delete));*/

        return this;
    }

    //删除用户
    public ContactPage delete() {
        //显示等待不行是只能加死等
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(delete);
        click(By.linkText("确认"));
        click(By.id("clearMemberSearchInput"));

        //显示等待不行是只能加死等
      /*  try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        //       driver.findElement(delete).click();
        //      driver.findElement(By.linkText("确认")).click();
        //       driver.findElement(By.id("clearMemberSearchInput")).click();
        return this;

    }


    //导入文件
    public ContactPage importFile(URL path) {
        //System.out.println(path.getPath());
        String path_utf = "";
        try {
            path_utf = URLDecoder.decode(path.getFile(), "UTF-8");
            //System.out.println(path_utf);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        File file = new File(path_utf);
        click(By.cssSelector(".ww_operationBar:nth-child(1) .ww_btn_PartDropdown_left"));
        click(By.linkText("文件导入"));
        upload(By.name("file"),path_utf);
        //driver.findElement(By.name("file")).sendKeys("D:\\IdeaProjects\\Junit5Demo\\src\\main\\resources\\通讯录批量导入模板.xlsx");
        //sendKeys(By.name("file"),"");
        click(By.linkText("确认导入"));
        click(By.linkText("前往查看"));


        return this;
    }

}
