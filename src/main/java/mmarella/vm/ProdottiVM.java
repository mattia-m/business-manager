package mmarella.vm;

import java.util.LinkedList;
import java.util.List;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Window;

import mmarella.dao.ProductDao;
import mmarella.models.Product;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class ProdottiVM {

	@WireVariable
	private ProductDao productDao;

	List<Product> products = new LinkedList<Product>();

	@Init
	public void init() {
		products = (List<Product>) productDao.findAll();
	}

	@NotifyChange("products")
	@Command
	public void deleteProduct(@BindingParam("prodotto") Product prodotto) {
		products.remove(prodotto);
		productDao.delete(prodotto);
	}

	@NotifyChange("products")
	@Command
	public void refresh() {
		products = (List<Product>) productDao.findAll();
	}

	@NotifyChange("products")
	@Command
	public void createProduct() {
		Window window = (Window) Executions.createComponents("/Prodotti/creaProdotto.zul", null, null);
		window.doModal();
		products = (List<Product>) productDao.findAll();
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
