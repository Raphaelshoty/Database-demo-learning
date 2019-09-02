package com.in28minutes.database.databasedemo.jdbc;



import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.in28minutes.database.databasedemo.entity.Person;

@Repository
public class PersonJDBCDAO {
	// injection of jdbctemplate 
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	// getting all instances of Person object that are stored on database 
	// using the Spring BeanPropertyRowMapper to map the bean properties on the selected object 
	public List<Person> findAll(){
		return jdbcTemplate.query("SELECT * FROM Person", 
				new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public Person findById(int id){
		return (Person) jdbcTemplate.queryForObject("Select * From person Where id = ?", new Object[]{id}, new BeanPropertyRowMapper<Person>(Person.class) );
	}
	
	public Person findByName(String name) {
		return (Person) jdbcTemplate.queryForObject("Select * From person Where name like ? ", new Object[] {name}, new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public int deleteById(int id) {
		return jdbcTemplate.update("Delete From person where id = ?", new Object[] {id});
	}
	
	public int insertPerson(Person person) {
		return jdbcTemplate.update( "Insert into Person(id, name, location, birth_date) Values( ? , ? , ? , ?)", 
				new Object[] {person.getId(), person.getName(), person.getLocation(), new Timestamp(person.getBirt_date().getTime())} );
	}
	
	public int updatePerson(Person person){
		return jdbcTemplate.update( "Update Person Set name = ?, location = ?, birth_date = ? Where id = ?", 
				new Object[] {person.getName(), person.getLocation(), new Timestamp(person.getBirt_date().getTime()), person.getId()} );
	}
}
