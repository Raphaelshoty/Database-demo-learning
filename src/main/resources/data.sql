
/*
CREATE TABLE
	person ( id INTEGER NOT NULL,
	name VARCHAR(255) NOT NULL,
	location VARCHAR(255),
	birth_date TIMESTAMP,
	PRIMARY KEY (id) );
*/
	
insert into person(ID, NAME, LOCATION, BIRTH_DATE) 
	VALUES(1, 'Raphael Lima', 'Contagem', parsedatetime('29-08-1988', 'dd-MM-yyyy'));
	
insert into person(ID, NAME, LOCATION, BIRTH_DATE) 
	VALUES(2, 'Josyas', 'Contagem', parsedatetime('01-01-1988', 'dd-MM-yyyy'));
	
insert into person(ID, NAME, LOCATION, BIRTH_DATE) 
	VALUES(3, 'Josete', 'Contagem', parsedatetime('08-08-1988', 'dd-MM-yyyy'));
	
insert into person(ID, NAME, LOCATION, BIRTH_DATE) 
	VALUES(4, 'Isayas', 'Contagem', parsedatetime('07-11-1988', 'dd-MM-yyyy'));
	