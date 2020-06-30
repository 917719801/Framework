package test_framework;

import app.wework.page.AppBasePage;
import web.wework.page.WebBasePage;


import javax.xml.ws.WebEndpoint;

public class Factory {
    public BasePage create(String driverName){
        if (driverName=="web" || driverName=="selenium"){
            return new WebBasePage();
        }
        if (driverName=="app" || driverName=="appium"){
            return new AppBasePage();
        }
        return null;
    }
}
