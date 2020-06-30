package test_framework;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BasePageTest {

    private static BasePage basePage;

    @BeforeAll
    static void  beforeall(){
        basePage =
                new BasePage();
    }


    @Test
    void load() throws JsonProcessingException {
        UIAuto uiAuto =basePage.load("uiauto.yml");
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(uiAuto));

    }

    @Test
    void run() {
        UIAuto uiauto=basePage.load("uiauto.yml");
        basePage.run(uiauto);
    }
}