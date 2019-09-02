package com.in28minutes.database.databasedemo.entity;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;



@Entity
@NamedQuery(name = "find_all_Person",query = "Select person from Person person")
public class Person {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	
	private String name;
	
	private String location;
	
	@Column(name="BIRTH_DATE")
	private Date birtDate;
	
	public Person() {}
	
	public Person(String name, String location, Date birthDate) {
		this.name = name;
		this.location = location;
		this.birtDate = birthDate;
	}
		
	public Person(int id, String name, String location, Date birtDate) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.birtDate = birtDate;
	}	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birtDate == null) ? 0 : birtDate.hashCode());
		result = prime * result + id;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (birtDate == null) {
			if (other.birtDate != null)
				return false;
		} else if (!birtDate.equals(other.birtDate))
			return false;
		if (id != other.id)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "\n Person [id=" + id + ", name=" + name + ", location=" + location + ", birtDate=" + birtDate + "]";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getBirt_date() {
		return birtDate;
	}
	public void setBirt_date(Date birt_date) {
		this.birtDate = birt_date;
	}
	
	
	
}
