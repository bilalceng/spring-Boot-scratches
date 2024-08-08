package com.bilalberek.demo;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


class FunctionalInterface<T,R>{

    public List<R> convertElements(List<T> list, Function<T, R> apply){
        return list.stream().map(apply).collect(Collectors.toList());
    }

}


