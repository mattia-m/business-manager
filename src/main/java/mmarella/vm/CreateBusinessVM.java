package mmarella.vm;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;

import mmarella.dao.BusinessDao;
import mmarella.models.Business;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class CreateBusinessVM {

	private String businessName;
	private String name;
	private String surname;
	private String address;
	private String phoneNumber;
	private String vatNumber;
	private String email;
	private boolean clientFlag;
	private boolean sellerFlag;
	private String socialSecurity;

	@WireVariable
	private BusinessDao businessDao;

	@NotifyChange()
	@Command
	public void insertBusiness() {
		if (businessDao.findByVatNumber(vatNumber) != null) {
			// TODO notify the user he is inserting the same product!
			Clients.showNotification("l'azienda esiste gia", true);
		} else {
			Business business = new Business(businessName, name, surname, address, phoneNumber, vatNumber, clientFlag,
					sellerFlag, socialSecurity);
			businessDao.save(business);
			Clients.showNotification("Azienda inserita");

		}
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}

	public boolean isClientFlag() {
		return clientFlag;
	}

	public void setClientFlag(boolean clientFlag) {
		this.clientFlag = clientFlag;
	}

	public boolean isSellerFlag() {
		return sellerFlag;
	}

	public void setSellerFlag(boolean sellerFlag) {
		this.sellerFlag = sellerFlag;
	}

	public String getSocialSecurity() {
		return socialSecurity;
	}

	public void setSocialSecurity(String socialSecurity) {
		this.socialSecurity = socialSecurity;
	}

}
