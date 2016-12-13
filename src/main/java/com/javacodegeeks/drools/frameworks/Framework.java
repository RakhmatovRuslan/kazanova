package com.javacodegeeks.drools.frameworks;

/**
 * Created by Ruslan on 12/3/2016.
 */
public class Framework {
    protected String name;
    protected Double rapidAppDevelopment;
    protected Double complexity;
    protected Double easeOfUse;
    protected Double documentationAndCom;
    protected Double ecosystem;
    protected Double scalability;
    protected Double code;
    protected Double lookAndFeel;
    protected Double total;
    protected Double popularity;

    public Framework() {
    }

    public Framework(String name, Double rapidAppDevelopment, Double complexity, Double easeOfUse, Double documentationAndCom, Double ecosystem, Double scalability, Double code, Double lookAndFeel, Double total) {
        this.name = name;
        this.rapidAppDevelopment = rapidAppDevelopment;
        this.complexity = complexity;
        this.easeOfUse = easeOfUse;
        this.documentationAndCom = documentationAndCom;
        this.ecosystem = ecosystem;
        this.scalability = scalability;
        this.code = code;
        this.lookAndFeel = lookAndFeel;
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRapidAppDevelopment() {
        return rapidAppDevelopment;
    }

    public void setRapidAppDevelopment(Double rapidAppDevelopment) {
        this.rapidAppDevelopment = rapidAppDevelopment;
    }

    public Double getComplexity() {
        return complexity;
    }

    public void setComplexity(Double complexity) {
        this.complexity = complexity;
    }

    public Double getEaseOfUse() {
        return easeOfUse;
    }

    public void setEaseOfUse(Double easeOfUse) {
        this.easeOfUse = easeOfUse;
    }

    public Double getDocumentationAndCom() {
        return documentationAndCom;
    }

    public void setDocumentationAndCom(Double documentationAndCom) {
        this.documentationAndCom = documentationAndCom;
    }

    public Double getEcosystem() {
        return ecosystem;
    }

    public void setEcosystem(Double ecosystem) {
        this.ecosystem = ecosystem;
    }

    public Double getScalability() {
        return scalability;
    }

    public void setScalability(Double scalability) {
        this.scalability = scalability;
    }

    public Double getCode() {
        return code;
    }

    public void setCode(Double code) {
        this.code = code;
    }

    public Double getLookAndFeel() {
        return lookAndFeel;
    }

    public void setLookAndFeel(Double lookAndFeel) {
        this.lookAndFeel = lookAndFeel;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    @Override
    public String toString() {
        return "Framework{" +
                "name='" + name + '\'' +
                ", rapidAppDevelopment=" + rapidAppDevelopment +
                ", complexity=" + complexity +
                ", easeOfUse=" + easeOfUse +
                ", documentationAndCom=" + documentationAndCom +
                ", ecosystem=" + ecosystem +
                ", scalability=" + scalability +
                ", code=" + code +
                ", lookAndFeel=" + lookAndFeel +
                ", total=" + total +
                ", popularity=" + popularity +
                '}';
    }
}
