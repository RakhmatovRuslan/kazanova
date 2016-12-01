package com.javacodegeeks.drools;

import com.javacodegeeks.drools.Enums.DataType;
import com.javacodegeeks.drools.Enums.Features;

import java.util.Scanner;

/**
 * Created by Ruslan on 11/30/2016.
 * This is a class to ask user for condition values
 */
public  class Condition {
    final static String PRIORITY_MESSAGE = "Что для вас важнее: \n1-performance\n" + "2-size \n3-None";
    final static String DATA_TYPE_MESSAGE = "Type of the processing data: \n1-small data\n" + "2-big data ";


    private Scanner scanner;


    public static Features  inputJsonParserFeatureCondition(){
        System.out.println(PRIORITY_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        Integer feature = scanner.nextInt();
//        Integer feature = 1;
        switch(feature){
            case 1:  {
                return  Features.PERFORMANCE;
            }
            case 2: {
                return Features.SIZE;
            }
            case 3: {
                return Features.NONE;
            }
            default:{
                return Features.NONE;
            }
        }
    }

    public static DataType  inputJsonParserDataTypeCondition(){
        System.out.println(DATA_TYPE_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        Integer dataTypeOption = scanner.nextInt();
//        Integer dataTypeOption = 1;
        switch(dataTypeOption){
            case 1:  {
                return DataType.SMALL_DATA;
            }
            case 2: {
                return DataType.BIG_DATA;
            }
            default:{
                return DataType.NONE;
            }
        }
    }
}
