package controllers.com.contactmanager;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import model.com.contactmanager.Company;

public class UploadContactsController extends Controller {

	public static Result index() {
		return ok(index.render("FILE UPLOADED SUCCESSFULLY"));

		// Extract csv contents as array list
		// Create Model Objects
		// Insert Model into database

	}
}
