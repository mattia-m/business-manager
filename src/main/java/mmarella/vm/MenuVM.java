package mmarella.vm;

import org.zkoss.bind.annotation.Command;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Window;

public class MenuVM {

	@Command
	public void creaProdotto() {
		// create a window programmatically and use it as a modal dialog.
		Window window = (Window) Executions.createComponents("/Prodotti/creaProdotto.zul", null, null);
		window.doModal();
		// Executions.getCurrent().sendRedirect("/Prodotti/creaProdotto.zul");
	}

	@Command
	public void productCatalogs() {
		Executions.getCurrent().sendRedirect("/Prodotti/prodotti.zul");
	}

	@Command
	public void visualizzaClienti() {
		Executions.getCurrent().sendRedirect("/Aziende/clienti.zul");
	}

	@Command
	public void visualizzaFornitori() {
		Executions.getCurrent().sendRedirect("/Aziende/fornitori.zul");
	}




	@Command
	public void createBusiness() {
		Window window = (Window) Executions.createComponents("/Aziende/inserisciAzienda.zul", null, null);
		window.doModal();
	}
}
