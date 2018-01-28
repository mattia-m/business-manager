package mmarella.vm;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;

import mmarella.dao.ProductDao;
import mmarella.models.Product;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class CreaProdottoVM {

	private String barcode;

	private String name;

	private boolean organic;

	@WireVariable
	private ProductDao productDao;

	@NotifyChange()
	@Command
	public void inserisciProdotto() {
		if (productDao.findByBarcode(barcode) != null) {
			// TODO notify the user he is inserting the same product!
			Clients.showNotification("il prodotto esiste gia", true);
		} else {
			Product product = new Product(barcode, name, organic);
			productDao.save(product);
			Clients.showNotification("prodotto inserito");
			barcode = null;
			name = null;
			organic = false;
		}
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
