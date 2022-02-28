package com.upgrad.movieapp;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("myProfiles")
@Profile("dev") /*Instantiated only when dev profile is activated*/
public class MyProfiles {
    public void method(){
        System.out.println("This is a method.");
    }
}
