package com.bilalberek.demo.javaadvancedtopics.templates;

import com.bilalberek.demo.javaadvancedtopics.templates.PairWithDescription;

import java.util.function.Function;

public class PairIntegerWithDescriptionImp implements PairWithDescription<Integer,Integer,String> {

    private Integer key;
    private Integer value;
    private String description;

    public PairIntegerWithDescriptionImp(Integer key, Integer value, String description ){
        this.key = key;
        this.value = value;
        this.description = description;
    }
    @Override
    public Integer getKey() {
        return key;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setValue(Integer integer) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public void setKey(Integer key) {
        this.key = key;
    }

    @Override
    public <R extends Number> R transformValue(Function<Integer, R> apply) {
        return apply.apply(this.value);
    }

    @Override
    public String printAsCoordinate() {
        return "(" + key + "," + value + ")";
    }
}


