package models.com.contactmanager;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import play.data.validation.Constraints;
import play.db.ebean.Model;

@Entity
public class Rsvp extends Model {

	@Id
	public String id;

	@Constraints.Required
	public int total;

	@Constraints.Required
	public int yes;

	@Constraints.Required
	public int no;

	@Constraints.Required
	public int maybe;

	@Constraints.Required
	public int meetups_attended;

	@Constraints.Required
	public int no_shows;

	@OneToOne
	@JoinColumn(name = "rsvp_id")
	public Profile profile;

	public static void save(Rsvp rsvp) {
		rsvp.save();
	}

}
