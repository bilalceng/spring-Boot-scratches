package com.bilalberek.demo.javaadvancedtopics;

import java.util.function.Function;

public interface PairWithDescription <K, V , D>  extends Pair<K, V> {

    V getValue();
    K getKey();

    D getDescription();

    void setValue(V v);
    void setKey(K k);


    <R extends Number> R transformValue(Function<V, R> apply);

    String printAsCoordinate();
}
