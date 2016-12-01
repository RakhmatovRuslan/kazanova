package com.javacodegeeks.drools.Libraries;

/**
 * Created by Ruslan on 11/29/2016.
 */
public class Library {
    protected String name;
    protected Double size;
    protected Double convenienceScale;
    protected Double performanceScale;

    public Library() {
    }

    public Library(String name, Double size, Double convenienceScale) {
        this.name = name;
        this.size = size;
        this.convenienceScale = convenienceScale;
    }

    public Library(String name, Double size, Double convenienceScale, Double performanceScale) {
        this.name = name;
        this.size = size;
        this.convenienceScale = convenienceScale;
        this.performanceScale = performanceScale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public Double getConvenienceScale() {
        return convenienceScale;
    }

    public void setConvenienceScale(Double convenienceScale) {
        this.convenienceScale = convenienceScale;
    }

    public Double getPerformanceScale() {
        return performanceScale;
    }

    public void setPerformanceScale(Double performanceScale) {
        this.performanceScale = performanceScale;
    }

    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", convenienceScale=" + convenienceScale +
                ", performanceScale=" + performanceScale +
                '}';
    }
}
