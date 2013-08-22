package controllers.com.contactmanager;

import java.util.List;

import models.com.contactmanager.Profile;
import play.mvc.Controller;
import play.mvc.Result;

import views.html.contacts;

public class ReportsController extends Controller {
	
	public static Result fetchAllContacts() {
		List<Profile> profiles = Profile.findAll();
		return ok(contacts.render());
	}

}
