package com.in28minutes.database.databasedemo;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.database.databasedemo.entity.Person;
import com.in28minutes.database.databasedemo.jpa.PersonJpaRepository;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		logger.info("User id 2 -> {}", repository.findById(2));
		
		logger.info("inserting Adilson on database {}", 
				repository.insert( 
				new Person("Adilson","Neves",new SimpleDateFormat("dd/MM/yyyy").parse("26/05/1986") ) 
				) );
		// recuperando entidade para atualização
		Person jessica = repository.findById(3);
		jessica.setName("Jessica Machado");	
		logger.info("Update Josete para Jessica Machado id 3 -> {}", repository.update(jessica));
		
		logger.info("delete User id 4 -> {}", repository.findById(4)); 
		repository.deleteById(4);
		
		logger.info("List of Person -> {}",repository.findAll());
		
	}
}
