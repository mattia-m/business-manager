package mmarella.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.StringUtils;

@Entity
@Table(name = "business")
public class Business {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BUSINESS_ID")
	private long id;

	private String businessName;

	private String name;

	private String surname;

	@NotNull
	private String address;

	@NotNull
	private String phoneNumber;

	@NotNull
	private String email;

	@NotNull
	private String vatNumber;

	@NotNull
	private boolean clientFlag;

	@NotNull
	private boolean sellerFlag;
	// CF
	@NotNull
	private String socialSecurity;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getVatNumber() {
		return vatNumber;
	}

	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}

	public String getSocialSecurity() {
		return socialSecurity;
	}

	public void setSocialSecurity(String socialSecurity) {
		this.socialSecurity = socialSecurity;
	}

	public Business(String name, String address, String email, String phoneNumber, String vatNumber,
			String socialSecurity) {
		this.name = name;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.vatNumber = vatNumber;
		this.socialSecurity = socialSecurity;
	}

	public Business() {

	}

	public String getDescription() {
		return StringUtils.isEmpty("businessName") ? name + " " + surname : businessName;
	}

	public String getTaxIdentification() {
		return StringUtils.isEmpty("vatNumber") ? socialSecurity : vatNumber;
	}

	public Business(String businessName, String name, String surname, String address, String phoneNumber,
			String vatNumber, boolean clientFlag, boolean sellerFlag, String socialSecurity) {
		super();
		this.businessName = businessName;
		this.name = name;
		this.email = email;
		this.surname = surname;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.vatNumber = vatNumber;
		this.clientFlag = clientFlag;
		this.sellerFlag = sellerFlag;
		this.socialSecurity = socialSecurity;
	}
}
