package al.ikubinfo.academy.data.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the contact database table.
 * 
 */
@Entity
@Table(name="contact")
@NamedQuery(name="ContactEntity.findAll", query="SELECT c FROM ContactEntity c")
public class ContactEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int contactId;

	private String address;

	private int contactNumber;

	private byte validity;

	//bi-directional many-to-one association to CompanyEntity
	@OneToMany(mappedBy="contact")
	private List<CompanyEntity> companies;

	public ContactEntity() {
	}

	public int getContactId() {
		return this.contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getContactNumber() {
		return this.contactNumber;
	}

	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}

	public byte getValidity() {
		return this.validity;
	}

	public void setValidity(byte validity) {
		this.validity = validity;
	}

	public List<CompanyEntity> getCompanies() {
		return this.companies;
	}

	public void setCompanies(List<CompanyEntity> companies) {
		this.companies = companies;
	}

	public CompanyEntity addCompany(CompanyEntity company) {
		getCompanies().add(company);
		company.setContact(this);

		return company;
	}

	public CompanyEntity removeCompany(CompanyEntity company) {
		getCompanies().remove(company);
		company.setContact(null);

		return company;
	}

}