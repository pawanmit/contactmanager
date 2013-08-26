package models.com.contactmanager;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import play.data.validation.Constraints;
import play.db.ebean.Model;

@Entity
public class Profile extends Model {

	@Id
	public String id;
	@Constraints.Required
	public String name;
	@Constraints.Required
	public String login_name;

	public String title;

	@OneToOne(optional=false)
	@JoinColumn(name="rsvp_id")
	 public Rsvp rsvp;

	@Constraints.Required
	public Date joined_date;

	@Constraints.Required
	public Date last_visited_date;

	public Date last_attended_date;

	@Constraints.Required
	public boolean is_intro;

	@Constraints.Required
	public boolean is_photo;

	@Constraints.Required
	public boolean is_assistant_organizer;

	@Constraints.Required
	public String mailing_list_type;

	public String url;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="company_id")
	public Company company;
	
	public static Model.Finder<Long, Profile> find = new Finder<Long, Profile>(
			Long.class, Profile.class);

	public static List<Profile> findAll() {
		return find.all();
	}
}
