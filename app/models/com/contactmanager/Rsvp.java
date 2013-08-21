package models.com.contactmanager;

import javax.persistence.Entity;

import play.data.validation.Constraints;

@Entity
public class Rsvp {

	@Constraints.Required
	String id;

	@Constraints.Required
	int total;

	@Constraints.Required
	int rsvp_yes;

	@Constraints.Required
	int rsvp_no;

	@Constraints.Required
	int rsvp_maybe;

	@Constraints.Required
	int meetups_attended;

	@Constraints.Required
	int no_shows;

}
