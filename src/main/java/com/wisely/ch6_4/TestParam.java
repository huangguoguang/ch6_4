package com.wisely.ch6_4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "test")
public class TestParam {
    @Autowired
    private PayProperties payProperties;

    @RequestMapping(value = "param")
    public String getParam() {
        return payProperties.getLocalkey() + "   " + payProperties.getMerchno();
    }
}
