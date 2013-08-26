package controllers.com.contactmanager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import models.com.contactmanager.Company;
import models.com.contactmanager.Profile;
import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.contacts;
import views.html.allcompanies;
import views.html.contactrsvp;

public class ReportsController extends Controller {

	public static Result fetchAllContacts() {
		List<Profile> profiles = Profile.findAll();
		String markup = "";
		for (Profile profile : profiles) {
			// Logger.info("Generating output for contact id " + profile.id);
			markup += generateProfileMarkup(profile);
		}
		// Html html new Html(output);
		return ok(contacts.render(markup));
	}

	public static Result fetchContactsByCompany(String id) {
		Logger.info("Getting contacts for company id " + id);
		long company_id = Long.parseLong(id);
		Company company = Company.findById(company_id);
		String markup = "";
		for (Profile profile : company.profiles) {
			// Logger.info("Generating output for contact id " + profile.id);
			markup += generateProfileMarkup(profile);
		}
		return ok(contacts.render(markup));
	}

	public static Result fetchRsvpByProfile(String id) {
		String markup = "hello";
		return ok(contactrsvp.render(markup));
	}

	public static Result fetchAllCompanies() {
		String output = "";
		List<Company> companies = Company.findAll();
		for (Company company : companies) {
			output += "<tr>";
			output += "<td><a href=/companycontacts/" + company.company_id + ">"
					+ company.name + "</a></td>";
			output += "<td>" + company.profiles.size() + "</td>";
			output += "</tr>";
			// Logger.info(company.name + ":" + profiles.size());
		}

		return ok(allcompanies.render(output));
	}

	private static String formatDate(Date date) {
		String formattedDate = "";
		Date parsedDate = null;
		if (date != null) {
			SimpleDateFormat dt1 = new SimpleDateFormat(
					"EEE MMM dd hh:mm:ss zzz yyyy");
			try {
				parsedDate = dt1.parse(date.toString());
				// Logger.debug("Parsed Date: " + parsedDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			SimpleDateFormat dt2 = new SimpleDateFormat("MM/dd/yyyy");
			if (parsedDate != null) {
				formattedDate = dt2.format(parsedDate);
				// Logger.debug("Formatted Date:" + formattedDate);
			}
		}

		return formattedDate;
	}

	private static String generateProfileMarkup(Profile profile) {
		String output = "<tr>";
		output += "<td>" + profile.id + "</td>";
		output += "<td>" + profile.name + "</td>";
		output += "<td>" + profile.login_name + "</td>";
		output += "<td>" + profile.title + "</td>";
		output += "<td><a href=/companycontacts/" + profile.company.company_id + ">"
				+ profile.company.name + "</a></td>";
		output += "<td>" + formatDate(profile.joined_date) + "</td>";
		output += "<td>" + formatDate(profile.last_attended_date) + "</td>";
		output += "<td>" + formatDate(profile.last_visited_date) + "</td>";
		output += "<td>" + (profile.is_intro ? "Yes" : "No") + "</td>";
		output += "<td>" + (profile.is_photo ? "Yes" : "No") + "</td>";
		output += "<td>" + (profile.is_assistant_organizer ? "Yes" : "No")
				+ "</td>";
		output += "<td>" + profile.mailing_list_type + "</td>";
		output += "<td>" + profile.url + "</td>";
		output += "</tr>";
		return output;
	}

}
