package mmarella.vm;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;

import mmarella.dao.ProductDao;
import mmarella.models.Product;
import org.zkoss.zul.Window;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class CreaProdottoVM {


	private String barcode;

	private String name;

	private String weight;

	private boolean organic;

	private boolean showDialog = true;

	@WireVariable
	private ProductDao productDao;

	@NotifyChange("showDialog")
	@Command
	public void inserisciProdotto() {
		if (productDao.findByBarcode(barcode) != null) {

			Clients.showNotification("Si sta inserendo un prodotto già esistente");
		} else {
			Product product = new Product(barcode, name, organic);
			product.setWeight(weight);
			productDao.save(product);
			this.setShowDialog(false);
			BindUtils.postGlobalCommand(null, null, "refreshProducts",null);

		}
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public boolean getShowDialog() {
		return showDialog;
	}

	public void setShowDialog(boolean showDialog) {
		this.showDialog = showDialog;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getOrganic() {
		return organic;
	}

	public void setOrganic(boolean organic) {
		this.organic = organic;
	}

}
