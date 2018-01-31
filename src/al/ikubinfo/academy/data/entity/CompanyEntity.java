package al.ikubinfo.academy.data.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the company database table.
 * 
 */
@Entity
@Table(name="company")
@NamedQuery(name="CompanyEntity.findAll", query="SELECT c FROM CompanyEntity c")
public class CompanyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int companyId;

	@Column(name="`CompanyName varchar`")
	private String companyName_varchar;

	@Column(name="`Nipt varchar`")
	private String nipt_varchar;

	private byte validity;

	//bi-directional many-to-one association to ContactEntity
	@ManyToOne
	@JoinColumn(name="ContactId")
	private ContactEntity contact;

	
	
	public CompanyEntity() {
	}

	public int getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName_varchar() {
		return this.companyName_varchar;
	}

	public void setCompanyName_varchar(String companyName_varchar) {
		this.companyName_varchar = companyName_varchar;
	}

	public String getNipt_varchar() {
		return this.nipt_varchar;
	}

	public void setNipt_varchar(String nipt_varchar) {
		this.nipt_varchar = nipt_varchar;
	}

	public byte getValidity() {
		return this.validity;
	}

	public void setValidity(byte validity) {
		this.validity = validity;
	}

	public ContactEntity getContact() {
		return this.contact;
	}

	public void setContact(ContactEntity contact) {
		this.contact = contact;
	}


}