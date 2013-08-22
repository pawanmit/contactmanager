package controllers.com.contactmanager;

import java.util.ArrayList;
import java.util.List;

import models.com.contactmanager.Company;
import models.com.contactmanager.Profile;
import models.com.contactmanager.Rsvp;
import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;
import util.com.contactmanager.InputFileReader;
import viewobject.com.contactmanager.User;
import views.html.index;
import views.html.upload;
import exception.com.contactmanager.ApplicationException;

public class UploadContactsController extends Controller {

	public static Result index() {

		// return ok(index.render("Output:" + output));
		return ok(upload.render());

	}

	public static Result uploadCsv() {
		String error = "";

		List<User> users = new ArrayList<User>();
		try {
			users = InputFileReader
					.getUserList("/Users/pmittal/Desktop/contacts.csv");
		} catch (ApplicationException e) {
			error = e.getMessage();
		}

		if (error.length() > 0) {

		} else {
			saveUsers(users);
		}

		return ok(upload.render());
	}

	private static void saveUsers(List<User> users) {
		List<Company> existingCompanies = Company.findAll();
		for (User user : users) {

			Company company = new Company(user.company);
			if (!existingCompanies.contains(company)) {
				existingCompanies.add(company);
				company.save();
			} else {
				company = existingCompanies.get(existingCompanies
						.indexOf(company));
			}

			Rsvp rsvp = new Rsvp();
			rsvp.total = user.rsvp_total;
			rsvp.yes = user.rsvp_yes;
			rsvp.no = user.rsvp_no;
			rsvp.maybe = user.rsvp_maybe;
			rsvp.meetups_attended = user.meetups_attended;
			rsvp.no_shows = user.no_shows;
			rsvp.save();

			Profile profile = new Profile();
			profile.id = user.member_id;
			profile.login_name = user.user_id;
			profile.title = user.title;
			profile.name = user.name;
			profile.company_id = company.id;
			profile.rsvp_id = rsvp.id;
			profile.joined_date = user.joined_date;
			profile.last_attended_date = user.last_attended_date;
			profile.last_visited_date = user.last_visited_date;
			profile.is_intro = user.is_intro;
			profile.is_assistant_organizer = user.is_assistant_organizer;
			profile.is_photo = user.is_photo;
			profile.url = user.url;
			profile.mailing_list_type = user.mailing_list_type;
			try {
				profile.save();
			} catch (Exception e) {
				Logger.error(e.getMessage());
				rsvp.delete();
				company.delete();
			}
		}
	}
}
