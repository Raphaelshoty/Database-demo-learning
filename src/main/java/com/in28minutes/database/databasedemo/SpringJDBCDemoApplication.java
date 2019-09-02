package com.in28minutes.database.databasedemo;



import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;


import com.in28minutes.database.databasedemo.entity.Person;
import com.in28minutes.database.databasedemo.jdbc.PersonJDBCDAO;

//@SpringBootApplication
public class SpringJDBCDemoApplication implements CommandLineRunner {
	
	private Logger logger =  LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJDBCDAO personDAO;

	public static void main(String[] args) {
		SpringApplication.run(SpringJDBCDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/// showing the data on the console via log4j
		logger.info("Person from the h2 -> {}" , personDAO.findAll());
		
		logger.info("First on database -> {}", personDAO.findById(1));
		
		logger.info("Person called Josete -> {}", personDAO.findByName("Josete"));
		
		logger.info("Delete person wich id = 4 \n deleting person -> ", personDAO.deleteById(4));
		
		Person pessoa = new Person(5,"Adilson","ibirité", new Date());
		
		logger.info("inserting Adilson on database {}", personDAO.insertPerson(pessoa));
		
		Person pessoaJosete = personDAO.findByName("Josete");
		pessoaJosete.setName("Jessica Machado");
		pessoaJosete.setBirt_date(new SimpleDateFormat("dd/MM/yyyy").parse("09/08/1995"));
		pessoaJosete.setLocation("Belo Horizonte");
		
		logger.info("Update person Josete -> {}",personDAO.updatePerson(pessoaJosete));
		
		
	}

}
