package com.bilalberek.demo.javaadvancedtopics.templates;

import com.bilalberek.demo.javaadvancedtopics.templates.Pair;

import java.util.function.Function;

public class PairIntegerImp implements Pair<Integer,Integer> {

    private Integer key;
    private Integer value;

    public PairIntegerImp(Integer key , Integer value){
        this.key = key;
        this.value = value;
    }
    @Override
    public Integer getKey() {
        return key;
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


