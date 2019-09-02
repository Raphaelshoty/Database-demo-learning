package com.in28minutes.database.databasedemo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.in28minutes.database.databasedemo.entity.Person;

// Repository
// Transaction
@Repository
@Transactional
public class PersonJpaRepository {

	// connect to database
	@PersistenceContext
	EntityManager entityManager;
	
	// using HQL
//	public List<Person> findAll(){
//		String qlString = "From Person";
//		Query qry = entityManager.createQuery(qlString);
//		return qry.getResultList();
//	}
	public List<Person> findAll(){
		TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_Person", Person.class);
		return namedQuery.getResultList();
	}
	
	
	public Person findById(int id) {
		return entityManager.find(Person.class, id);// JPA
	}
	
	public Person update(Person person) {
		return entityManager.merge(person);
	}
	
	public Person insert(Person person) {
		return entityManager.merge(person);
	}
	
	public void deleteById(int id) {
		Person person = this.findById(id);
		entityManager.remove(person);
	}
	
}
