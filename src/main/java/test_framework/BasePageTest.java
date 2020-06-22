package test_framework;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
    }
}