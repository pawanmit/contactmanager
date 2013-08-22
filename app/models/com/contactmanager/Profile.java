package models.com.contactmanager;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import play.data.validation.Constraints;

@Entity
public class Profile {

	@Id
	public String id;
	@Constraints.Required
	
	public String name;
	@Constraints.Required
	public String user_id;
	
	public String title;
	
	@Constraints.Required
	public String company_id;
	
	//@OneToOne
	//@JoinColumn(name="id")
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

}
