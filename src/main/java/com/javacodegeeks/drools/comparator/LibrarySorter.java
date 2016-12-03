package com.javacodegeeks.drools.comparator;

import com.javacodegeeks.drools.libraries.JsonParserLibrary;
import com.javacodegeeks.drools.libraries.Library;

import java.util.List;

/**
 * Created by Ruslan on 11/29/2016.
 */
public class LibrarySorter {

    public static void sortBySizeAsc(List<Library> sortingList){
        sortingList.sort((Library l1,Library l2)->l1.getSize().intValue()-l2.getSize().intValue());
    }
    public static void sortBySizeDesc(List<Library> sortingList){
        sortingList.sort((Library l1,Library l2)->l2.getSize().intValue()-l1.getSize().intValue());
    }
    public static void sortByConvenienceAsc(List<Library> sortingList){
        sortingList.sort((Library l1,Library l2)->l1.getConvenienceScale().intValue()-l2.getConvenienceScale().intValue());
    }
    public static void sortByConvenienceDesc(List<Library> sortingList){
        sortingList.sort((Library l1,Library l2)->l2.getConvenienceScale().intValue()-l1.getConvenienceScale().intValue());
    }
    public static void sortByPerformanceAsc(List<Library> sortingList){
        sortingList.sort((Library l1,Library l2)->l1.getPerformanceScale().intValue()-l2.getPerformanceScale().intValue());
    }
    public static void sortByPerformanceDesc(List<Library> sortingList){
        sortingList.sort((Library l1,Library l2)->l2.getPerformanceScale().intValue()-l1.getPerformanceScale().intValue());
    }
    public static void sortByJsonBigDataPerDesc(List<JsonParserLibrary> sortingList){
        sortingList.sort((JsonParserLibrary l1,JsonParserLibrary l2)->l2.getBigDataPerformance().intValue()-l1.getBigDataPerformance().intValue());
    }
    public static void sortByJsonSmallDataPerDesc(List<JsonParserLibrary> sortingList){
        sortingList.sort((JsonParserLibrary l1,JsonParserLibrary l2)->l2.getSmallDataPerformance().intValue()-l1.getSmallDataPerformance().intValue());
    }

}
