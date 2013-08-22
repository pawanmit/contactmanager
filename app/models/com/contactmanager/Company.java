package models.com.contactmanager;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import play.data.validation.Constraints;
import play.db.ebean.Model;

@Entity
public class Company extends Model {

	@Id
	public String id;

	@Constraints.Required
	public String name;
	
	@ManyToOne
	@JoinColumn(name="id")
	public Profile profile;

	public Company(String companyName) {
		this.name = companyName;
	}

	public static Model.Finder<Long, Company> find = new Finder<Long, Company>(
			Long.class, Company.class);

	public static List<Company> findAll() {
		return find.all();
	}

	public static void save(Company company) {
		company.save();
	}

	public String toString() {
		return name;
	}

	public static void main(String[] args) {
		System.out.println(findAll());
	}
}
