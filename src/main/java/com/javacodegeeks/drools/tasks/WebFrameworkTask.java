package com.javacodegeeks.drools.tasks;

import com.javacodegeeks.drools.enums.Features;
import com.javacodegeeks.drools.enums.WebApplicationType;

/**
 * Created by Ruslan on 12/3/2016.
 */
public class WebFrameworkTask extends Task {
    private WebApplicationType webApplicationType;

    public WebFrameworkTask() {
        featurePriority = Features.NONE;
        webApplicationType = WebApplicationType.NONE;
    }

    public WebApplicationType getWebApplicationType() {
        return webApplicationType;
    }

    public void setWebApplicationType(WebApplicationType webApplicationType) {
        this.webApplicationType = webApplicationType;
    }
}
