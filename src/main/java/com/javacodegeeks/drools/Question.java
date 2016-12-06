package com.javacodegeeks.drools;

import java.util.List;

/**
 * Created by Ruslan on 12/7/2016.
 */
public class Question {
    private String definition;
    private List<String> variations;
    private Integer answer;
    private boolean isAny;

    public Question(String definition, List<String> variations) {
        this.definition = definition;
        this.variations = variations;
        isAny = false;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public List<String> getVariations() {
        return variations;
    }

    public void setVariations(List<String> variations) {
        this.variations = variations;
    }

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }

    public boolean hasAny() {
        return isAny;
    }

    public void setAny(boolean any) {
        isAny = any;
    }
}
