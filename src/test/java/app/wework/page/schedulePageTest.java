package app.wework.page;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class schedulePageTest {

    private static Wework wework;

    @BeforeAll
    static void beforeall() {
        wework = new Wework();
    }


    @Test
    void addschedule() {
        assertTrue(wework.schedule().addschedule("上班打卡", "8点").getschedule(null).contains("上班打卡"));
        wework.back();
    }


    @Test
    void addbacklog() {
        assertTrue(wework.backlog().addbacklog("我要成长", "张三").getbacklog().contains("我要成长"));
        wework.back();
    }

    @Test
    void adddaily() {
        wework.report().adddaily("各位同学打架好");
        wework.back();
    }


}