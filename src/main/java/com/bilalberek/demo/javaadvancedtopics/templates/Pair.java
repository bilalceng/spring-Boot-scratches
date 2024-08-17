package com.bilalberek.demo.javaadvancedtopics.templates;

import java.util.function.Function;

interface Pair <K,V> {
    V getValue();
    K getKey();

     void setValue(V v);
     void setKey(K k);

     <R extends Number> R transformValue(Function<V, R> apply);
    String printAsCoordinate();
 }
