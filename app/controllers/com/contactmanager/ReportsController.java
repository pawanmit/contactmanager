package controllers.com.contactmanager;

import java.util.List;

import models.com.contactmanager.Profile;
import play.Logger;
import play.api.templates.Html;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.contacts;

public class ReportsController extends Controller {
	
	public static Result fetchAllContacts() {
		List<Profile> profiles = Profile.findAll();
		String output = "";
		output= 
		for(Profile profile : profiles) {
			Logger.info("Generating output for contact id " + profile.id);
			output += "<tr>";
			output += "<td>" + profile.id + "</td>";
			output += "<td>" + profile.name + "</td>";
			output += "<td>" + profile.login_name + "</td>";
			output += "<td>" + profile.title + "</td>";
			output += "<td>" + profile.joined_date + "</td>";
			output += "<td>" + profile.last_attended_date + "</td>";
			output += "<td>" + profile.last_visited_date + "</td>";
			output += "<td>" + profile.is_intro + "</td>";
			output += "<td>" + profile.is_photo + "</td>";
			output += "<td>" + profile.is_assistant_organizer + "</td>";
			output += "<td>" + profile.mailing_list_type + "</td>";
			output += "<td>" + profile.url + "</td>";
			output += "</tr></table>";
		}
		//Html html new Html(output);
		return ok(contacts.render(output));
	}

}
