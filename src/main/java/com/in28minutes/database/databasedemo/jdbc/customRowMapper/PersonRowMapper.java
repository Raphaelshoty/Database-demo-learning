package com.in28minutes.database.databasedemo.jdbc.customRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.in28minutes.database.databasedemo.entity.Person;

public class PersonRowMapper implements RowMapper<Person> {

	@Override
	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
		Person person = new Person();
		person.setId(rs.getInt("id"));
		person.setName(rs.getString("name"));
		person.setLocation(rs.getString("location"));
		person.setBirt_date(rs.getTimestamp("birth_date"));
		return person;
	}

	

}
