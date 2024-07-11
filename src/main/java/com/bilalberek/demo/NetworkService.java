package com.bilalberek.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class NetworkService {

    Environment environment;

    private  Student student;

    // field injection.

    /**
     *     @Autowired
     *     @Qualifier("provideStudent2")
     *    private  Student student;
     */

     // Constructor injection.
            @Autowired
             public NetworkService(@Qualifier("provideStudent3") Student student) {
                   this.student = student;
               }



    // method injection
    /**
     *     @Autowired
     *     public void injectDependencies(@Qualifier("provideStudent3") Student student){
     *         this.student = student;
     *     }
     */

    /**
     *  //setter injection.
     *     @Autowired
     *     public void setStudent(@Qualifier("provideStudent3") Student student) {
     *         this.student = student;
     *     }
     *
     */

    public String SayHelloToTheStudent(){
             return "hello " + student.getName();
    }
    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;

    }

    public Environment getEnvironment() {
        return environment;
    }

    public String getOsName(){
        return environment.getProperty("os.name");
    }

    public String readProperty(){
        return environment.getProperty("my.custom.property");
    }

    public String getJavaVersion(){
        return environment.getProperty("java.version");
    }

    // Always prefer constructor injection!!!
}
