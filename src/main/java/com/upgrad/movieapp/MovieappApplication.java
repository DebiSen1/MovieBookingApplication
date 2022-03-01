package com.upgrad.movieapp;

import com.upgrad.movieapp.dao.CustomerDao;
import com.upgrad.movieapp.dao.MovieDao;
import com.upgrad.movieapp.entities.Customer;
import com.upgrad.movieapp.entities.Movie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController /*This class will handle the client's request-->client's request will come to this class*/
@SpringBootApplication
public class MovieappApplication implements CommandLineRunner {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(MovieappApplication.class, args);

		CustomerDao customerDao = context.getBean(CustomerDao.class);

		Customer customer = new Customer();

		customer.setCid(4);
		customer.setFirstName("Bina");
		customer.setLastName("Malik");
		customer.setSalary(55000.00);
		customer.setDateOfBirth(LocalDateTime.of(1994,10,06,2,5));

		System.out.println("Before saving : "+customer);

		Customer savedCustomer = customerDao.save(customer);

		System.out.println("After saving : "+savedCustomer);

		/*Customer retrievedCustomer = customerDao.findById(savedCustomer.getCid());
		System.out.println("Retrieved Customer : "+retrievedCustomer);

		customer.setFirstName("Nilesh");
		customer.setLastName("Saha");

		Customer updatedCustomer = customerDao.update(customer);

		System.out.println("Retrieved Customer : "+updatedCustomer);*/

		MovieDao movieDao = context.getBean(MovieDao.class);

		Movie movie = new Movie();

		movie.setMovieName("Gangubai");
		movie.setDescription("It is drama movie");
		movie.setDuration(150.00);
		movie.setReleaseDate(LocalDateTime.of(2022,6,13,0,0));

		Movie savedMovie = movieDao.save(movie);
		System.out.println("saved movie:"+savedMovie);

		Movie retrievedMovie = movieDao.findById(savedMovie.getMovieId()).orElse(null);
		System.out.println("saved movie:"+retrievedMovie);

		movie.setDuration(180.30);
		Movie updatedMovie = movieDao.save(movie);
		System.out.println("saved movie:"+updatedMovie);

		movieDao.delete(movie);
	}
/**When you use the @RequestMapping annotation over a method, your web application will return some response to the user after the
 *  user enters the address mentioned in the parameter passed to the annotation. */
	@RequestMapping(value = "/")
	public String helloStudents(){
		return "Hello Students";
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Will it run??");
	}
}
