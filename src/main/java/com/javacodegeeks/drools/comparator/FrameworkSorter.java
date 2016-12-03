package com.javacodegeeks.drools.comparator;

import com.javacodegeeks.drools.frameworks.Framework;

import java.util.List;

/**
 * Created by RUSLAN on 04.12.2016.
 */
public class FrameworkSorter {

    public static void sortByOverallFeatures(List<Framework> webFrameworkList){
        webFrameworkList.sort((Framework f1, Framework f2)->f2.getTotal().intValue()-f1.getTotal().intValue());
    }

    public static void sortByRapidAppDevFeature(List<Framework> webFrameworkList){
        webFrameworkList.sort((Framework f1, Framework f2)->f2.getRapidAppDevelopment().intValue()-f1.getRapidAppDevelopment().intValue());
    }

    public static void sortByComplexityFeature(List<Framework> webFrameworkList){
        webFrameworkList.sort((Framework f1, Framework f2)->f2.getComplexity().intValue()-f1.getComplexity().intValue());
    }

    public static void sortByEaseOfUseFeature(List<Framework> webFrameworkList){
        webFrameworkList.sort((Framework f1, Framework f2)->f2.getEaseOfUse().intValue()-f1.getEaseOfUse().intValue());
    }

    public static void sortByDocAndCommunityFeature(List<Framework> webFrameworkList){
        webFrameworkList.sort((Framework f1, Framework f2)->f2.getDocumentationAndCom().intValue()-f1.getDocumentationAndCom().intValue());
    }

    public static void sortByEcosystemFeature(List<Framework> webFrameworkList){
        webFrameworkList.sort((Framework f1, Framework f2)->f2.getEcosystem().intValue()-f1.getEcosystem().intValue());
    }

    public static void sortByScalabilityFeature(List<Framework> webFrameworkList){
        webFrameworkList.sort((Framework f1, Framework f2)->f2.getScalability().intValue()-f1.getScalability().intValue());
    }

    public static void sortByCodeFeature(List<Framework> webFrameworkList){
        webFrameworkList.sort((Framework f1, Framework f2)->f2.getCode().intValue()-f1.getCode().intValue());
    }

    public static void sortByLookAndFeelFeature(List<Framework> webFrameworkList){
        webFrameworkList.sort((Framework f1, Framework f2)->f2.getLookAndFeel().intValue()-f1.getLookAndFeel().intValue());
    }
}
