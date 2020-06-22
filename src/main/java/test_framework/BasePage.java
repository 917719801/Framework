package test_framework;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.util.HashMap;

//自动化领域建模
public class BasePage {
    public  void click(HashMap<String, Object> stringObjectHashMap){

    }
    public void  find(){

    }
    public  void send(){

    }
    public void  getText(){

    }
    public  void run(UIAuto uiAuto){
        uiAuto.steps.stream().forEach(m->{
            if (m.keySet().contains("click")){
                click((HashMap<String,Object>) (m.get("")));
            }
        });


    }
    public UIAuto load(String path){
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        UIAuto uiAuto= null
                ;
        try {
            uiAuto = mapper.readValue(
                    BasePage.class.getResourceAsStream(path),UIAuto.class
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

        return uiAuto;

    }
}
