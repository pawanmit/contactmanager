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
	@JoinColumn(name = "id")
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

	@Override
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		}
		if (object == this) {
			return true;
		}
		if (!(object instanceof Company)) {
			return false;
		}
		Company company = (Company) object;
		if (company.name != null
				&& company.name.trim().equalsIgnoreCase(this.name)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		if (this.name != null && this.name.length() > 0) {
			return this.name.length();
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {
		System.out.println(findAll());
	}
}
