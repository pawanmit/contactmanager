package models.com.contactmanager;

import javax.persistence.Entity;

import play.data.validation.Constraints;

@Entity
public class Rsvp {

	@Constraints.Required
	public String id;

	@Constraints.Required
	public int total;

	@Constraints.Required
	public int rsvp_yes;

	@Constraints.Required
	public int rsvp_no;

	@Constraints.Required
	public int rsvp_maybe;

	@Constraints.Required
	public int meetups_attended;

	@Constraints.Required
	public int no_shows;

}
