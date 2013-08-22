package controllers.com.contactmanager;

import models.com.contactmanager.Company;
import play.mvc.Controller;
import play.mvc.Result;
import util.com.contactmanager.InputFileReader;
import views.html.index;
import exception.com.contactmanager.ApplicationException;

public class UploadContactsController extends Controller {

	public static Result index() {

		// Extract csv contents as array list
		// Create Model Objects
		// Insert Model into database

		// Company comp = new Company("google");
		// comp.save();

		// List<Company> companies = Company.findAll();
		String output = "";
		// for (Company company : companies) {
		// output += company.toString();
		// }
		try {
			InputFileReader.getUserList("/Users/pmittal/Desktop/contacts.csv");
		} catch (ApplicationException e) {
			output = e.getMessage();
		}
		return ok(index.render("Output:" + output));

	}

	private void saveProfile() {

		Company comp = new Company("google");
		comp.save();
		// profile.
	}
}
