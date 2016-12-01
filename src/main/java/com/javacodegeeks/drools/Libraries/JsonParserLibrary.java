package com.javacodegeeks.drools.Libraries;

/**
 * Created by Ruslan on 11/29/2016.
 */
public class JsonParserLibrary extends Library {

    private Double smallDataPerformance;
    private Double bigDataPerformance;

    public JsonParserLibrary(String name, Double size, Double convenienceScale, Double performanceScale, Double smallDataPerformance, Double bigDataPerformance) {
        super(name, size, convenienceScale, performanceScale);
        this.smallDataPerformance = smallDataPerformance;
        this.bigDataPerformance = bigDataPerformance;
    }

    public Double getSmallDataPerformance() {
        return smallDataPerformance;
    }

    public void setSmallDataPerformance(Double smallDataPerformance) {
        this.smallDataPerformance = smallDataPerformance;
    }

    public Double getBigDataPerformance() {
        return bigDataPerformance;
    }

    public void setBigDataPerformance(Double bigDataPerformance) {
        this.bigDataPerformance = bigDataPerformance;
    }



    @Override
    public String toString() {
        return "JsonParserLibrary{" +
                "name=" + name+
                ", smallDataPerformance=" + smallDataPerformance +
                ", bigDataPerformance=" + bigDataPerformance +
                '}';
    }
}
