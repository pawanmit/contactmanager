drop table profile;

drop table company;

drop table rsvp;

CREATE TABLE rsvp (
	id INT NOT NULL AUTO_INCREMENT,
	total SMALLINT UNSIGNED NOT NULL DEFAULT 0,
	yes SMALLINT UNSIGNED NOT NULL DEFAULT 0,
	no SMALLINT UNSIGNED NOT NULL DEFAULT 0,
	maybe SMALLINT UNSIGNED NOT NULL DEFAULT 0,
	meetups_attended SMALLINT UNSIGNED NOT NULL DEFAULT 0,
	no_shows SMALLINT UNSIGNED NOT NULL DEFAULT 0,
	PRIMARY KEY (id)
 );	
 
 CREATE TABLE company (
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(255) NOT NULL,
	PRIMARY KEY (id)
	);	

	CREATE UNIQUE INDEX company_name_idx ON company (name);
	
	CREATE TABLE profile (
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(255) NOT NULL,
	login_name  VARCHAR(255) NOT NULL,
	title VARCHAR(255),
	company_id INT NOT NULL,
	rsvp_id INT NOT NULL,
	joined_date DATE NOT NULL,
	last_visited_date DATE NOT NULL,
	last_attended_date DATE,
	is_intro BOOLEAN NOT NULL DEFAULT 0,
	is_photo BOOLEAN NOT NULL DEFAULT 0,
	is_assistant_organizer BOOLEAN NOT NULL DEFAULT 0,
	mailing_list_type VARCHAR(30) NOT NULL,
	url VARCHAR(255),
	PRIMARY KEY (id),
	FOREIGN KEY (company_id) REFERENCES company(id),
	FOREIGN KEY (rsvp_id) REFERENCES rsvp(id)
 );