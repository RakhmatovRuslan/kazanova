package com.javacodegeeks.drools.comparator;

import com.javacodegeeks.drools.enums.WebApplicationType;
import com.javacodegeeks.drools.frameworks.Framework;
import com.javacodegeeks.drools.frameworks.WebFramework;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RUSLAN on 04.12.2016.
 */
public class FrameworkSorter {

    public static void sortByOverallFeatures(List<Framework> frameworks){
        frameworks.sort((Framework f1, Framework f2)->f2.getTotal().intValue()-f1.getTotal().intValue());
    }

    public static void sortByRapidAppDevFeature(List<Framework> frameworks){
        frameworks.sort((Framework f1, Framework f2)->f2.getRapidAppDevelopment().intValue()-f1.getRapidAppDevelopment().intValue());
    }

    public static void sortByComplexityFeature(List<Framework> frameworks){
        frameworks.sort((Framework f1, Framework f2)->f2.getComplexity().intValue()-f1.getComplexity().intValue());
    }

    public static void sortByEaseOfUseFeature(List<Framework> frameworks){
        frameworks.sort((Framework f1, Framework f2)->f2.getEaseOfUse().intValue()-f1.getEaseOfUse().intValue());
    }

    public static void sortByDocAndCommunityFeature(List<Framework> frameworks){
        frameworks.sort((Framework f1, Framework f2)->f2.getDocumentationAndCom().intValue()-f1.getDocumentationAndCom().intValue());
    }

    public static void sortByEcosystemFeature(List<Framework> frameworks){
        frameworks.sort((Framework f1, Framework f2)->f2.getEcosystem().intValue()-f1.getEcosystem().intValue());
    }

    public static void sortByScalabilityFeature(List<Framework> frameworks){
        frameworks.sort((Framework f1, Framework f2)->f2.getScalability().intValue()-f1.getScalability().intValue());
    }

    public static void sortByCodeFeature(List<Framework> frameworks){
        frameworks.sort((Framework f1, Framework f2)->f2.getCode().intValue()-f1.getCode().intValue());
    }

    public static void sortByLookAndFeelFeature(List<Framework> frameworks){
        frameworks.sort((Framework f1, Framework f2)->f2.getLookAndFeel().intValue()-f1.getLookAndFeel().intValue());
    }

    public static void sortByPopularity(List<Framework> frameworks){
        frameworks.sort((Framework f1, Framework f2)->f2.getPopularity().intValue()-f1.getPopularity().intValue());
    }
//laziness to write rules
    public static List<Framework> getWebFrameworksByType(List<Framework> frameworks, WebApplicationType webApplicationType){
        List<Framework> webFrameworks = new ArrayList<>();
        frameworks.forEach(webFramework->{
            if(((WebFramework)webFramework).getWebApplicationType() == webApplicationType)
                webFrameworks.add(webFramework);
        });
        return webFrameworks;
    }
}
