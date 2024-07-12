package com.bilalberek.demo;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Service;

@Service
@PropertySources({
        @PropertySource("classpath:custom.properties"),
        @PropertySource("classpath:custom2.properties")
})
public class NetworkService {
    @Value("${my.property}")
    private  String  myProperty;

    @Value("${my.property2}")
    private String myProperty2;

    @Value("${my.integerProperty.int}")
    private Integer intProperty;  // Java can cast the value come from .properties file to  the type declared
                                  // so be aware of wht type you declared the variable and its corresponding value
                                  // in the .properties file.
                                  // Both of them must be same type!!!  do this:  my.integerProperty.int=2345 do not make like this: my.integerProperty.int=2345odeıueıeu
                                  // it will give error.


    public String getMyProperty() {
        return myProperty;
    }

    public String getMyProperty2() {
        return myProperty2;
    }

    public int getIntProperty() {
        return intProperty;
    }

}
