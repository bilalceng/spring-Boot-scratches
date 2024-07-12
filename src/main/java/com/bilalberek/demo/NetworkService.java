package com.bilalberek.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NetworkService {

    @Value("${my.custom.property}")
    private String myCustomProperty ;

    @Value("${my.custom.id.int}")
    private Integer myCustomId;

    @Value("${my.custom.weight.double}")
    private Double myCustomWeight;

    @Value("${my.custom.height.double}")
    private Double  myCustomHeight;

    @Value("${my.custom.special.dev}")
    private Integer myCustomSpecialDev;

    public Double getMyCustomHeight() {
        return myCustomHeight;
    }

    public Double getMyCustomWeight() {
        return myCustomWeight;
    }

    public Integer getMyCustomId() {
        return myCustomId;
    }

    public String getMyCustomProperty() {
        return myCustomProperty;
    }

    public Integer getMyCustomSpecialDev() {
        return myCustomSpecialDev;
    }
}
