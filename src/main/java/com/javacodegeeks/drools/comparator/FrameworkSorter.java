package com.javacodegeeks.drools.comparator;

import com.javacodegeeks.drools.enums.Features;
import com.javacodegeeks.drools.libraries.Framework;

import java.util.List;

/**
 * Created by Ruslan on 12/4/2016.
 */
public class FrameworkSorter {


    public static void sortFrameworkByFeatures(List<Framework> webFrameworkList){
                webFrameworkList.sort((Framework f1, Framework f2)->f2.getRapidAppDevelopment().intValue()-f1.getRapidAppDevelopment().intValue());
                webFrameworkList.sort((Framework f1, Framework f2)->f2.getTotal().intValue()-f1.getTotal().intValue());
                webFrameworkList.sort((Framework f1, Framework f2)->f2.getEaseOfUse().intValue()-f1.getEaseOfUse().intValue());
    }
}
