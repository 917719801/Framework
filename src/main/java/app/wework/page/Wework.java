package app.wework.page;
/*
主页
 */

import org.openqa.selenium.By;

public class Wework extends AppBasePage {
    public Wework() {
        super("com.tencent.wework", ".launch.WwMainActivity");
    }
    public schedulePage schedule(){
        click(By.xpath("//*[@text='日程']"));
        return new schedulePage(driver);

    }
    public backlog backlog(){
        click(By.xpath("//*[@text='待办']"));
        return new backlog(driver);
    }


    public  report  report(){
        click(By.xpath("//*[@text='工作台']"));
        return new report(driver);
    }
    public  void back(){
        do{
            click(By.id("gyb"));
        }while (driver.findElements(By.xpath("//*[@text='工作台']")).size() <= 0 );
        click(By.xpath("//*[@text='消息']"));

    }

}
