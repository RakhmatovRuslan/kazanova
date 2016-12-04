package com.javacodegeeks.drools.frameworks;

import com.javacodegeeks.drools.enums.WebApplicationType;

/**
 * Created by RUSLAN on 04.12.2016.
 */
public class WebFramework extends Framework {
    private WebApplicationType webApplicationType;

    public WebFramework(String name, Double rapidAppDevelopment, Double complexity, Double easeOfUse, Double documentationAndCom, Double ecosystem, Double scalability, Double code, Double lookAndFeel, Double total, WebApplicationType webApplicationType) {
        super(name, rapidAppDevelopment, complexity, easeOfUse, documentationAndCom, ecosystem, scalability, code, lookAndFeel, total);
        this.webApplicationType = webApplicationType;
    }

    public WebApplicationType getWebApplicationType() {
        return webApplicationType;
    }

    public void setWebApplicationType(WebApplicationType webApplicationType) {
        this.webApplicationType = webApplicationType;
    }
}
