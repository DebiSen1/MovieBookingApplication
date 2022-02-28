package com.upgrad.movieapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController /*This class will handle the client's request-->client's request will come to this class*/
@SpringBootApplication
public class MovieappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieappApplication.class, args);



	}
/**When you use the @RequestMapping annotation over a method, your web application will return some response to the user after the
 *  user enters the address mentioned in the parameter passed to the annotation. */
	@RequestMapping(value = "/")
	public String helloStudents(){
		return "Hello Students";
	}

}
