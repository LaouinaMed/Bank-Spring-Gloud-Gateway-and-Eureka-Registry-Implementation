package com.example.customerservice.web;

import com.example.customerservice.config.GlobalConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope
public class ConfigTestController {
    //premiere solution de la configuration

    //injecter un parametre dans une variable
    @Value("${global.params.p1}")
    private int p1;

    @Value("${global.params.p2}")
    private int p2;
    @Value("${customer.params.x}")
    private  int x;
    @Value("${customer.params.y}")
    private  int y;
    //2eme solution de la configuration
    @Autowired
    private GlobalConfig globalConfig;

    @GetMapping("/testConfig")
    public Map<String,Integer> configTest(){

        return Map.of("a",p1,"p2",p2,"x",x,"y",y);
    }

    @GetMapping("globalConfig")
    public GlobalConfig globalConfig(){
        return globalConfig;
    }
}
