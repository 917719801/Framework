package test_framework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactoryTest {

    @Test
    void create() {
        BasePage web = Factory.create("web");
        UIAuto uiAuto = web.load("webuiauto.yml");
        web.run(uiAuto);
    }
}