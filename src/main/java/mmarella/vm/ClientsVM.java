package mmarella.vm;

import java.util.LinkedList;
import java.util.List;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Window;

import mmarella.dao.BusinessDao;
import mmarella.models.Business;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class ClientsVM {

	@WireVariable
	private BusinessDao businessDao;

	List<Business> clients = new LinkedList<Business>();

	@Init
	public void init() {
		clients = (List<Business>) businessDao.findAllByClientFlag(true);
	}

	@NotifyChange("clients")
	@Command
	@GlobalCommand
	public void refreshClients() {
		clients = (List<Business>) businessDao.findAllByClientFlag(true);
	}

	@NotifyChange("clients")
	@Command
	public void insertClient() {
		// logger.debug("opening clients modal");
		Window window = (Window) Executions.createComponents("/Aziende/inserisciAzienda.zul", null, null);
		window.doModal();
	}

	public List<Business> getClients() {
		return clients;
	}

	public void setClients(List<Business> clients) {
		this.clients = clients;
	}

}
