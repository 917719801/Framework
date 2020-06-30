package test_framework;

import app.wework.page.AppBasePage;
import web.wework.page.WebBasePage;


import javax.xml.ws.WebEndpoint;

public class Factory {
    public static BasePage create(String driverName){
        if (driverName=="web" || driverName=="selenium"){
            return new WebBasePage();
        }
        if (driverName=="app" || driverName=="appium"){
            return new AppBasePage();
        }
        if (driverName=="uiautomator"){

        }
        if (driverName=="atx"){

        }
        if (driverName=="macaca"){

        }
        return null;
    }
}
