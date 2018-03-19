package mmarella.vm;

import mmarella.dao.BusinessDao;
import mmarella.models.Business;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Window;

import java.util.LinkedList;
import java.util.List;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class FornitoriVM {

    private static final Logger logger = LogManager.getLogger(FornitoriVM.class);

    @WireVariable
    private BusinessDao businessDao;

    List<Business> suppliers = new LinkedList<Business>();

    @Init
    public void init() {
        logger.info("logging init of suppliers page");
        suppliers = (List<Business>) businessDao.findAllBySellerFlag(true);
    }

    @NotifyChange("suppliers")
    @Command
    @GlobalCommand
    public void refreshSuppliers() {
        suppliers = (List<Business>) businessDao.findAllBySellerFlag(true);
    }

    @NotifyChange("suppliers")
    @Command
    public void insertSupplier() {
        // logger.debug("opening clients modal");
        Window window = (Window) Executions.createComponents("/Aziende/inserisciAzienda.zul", null, null);
        window.doModal();
    }

    public List<Business> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<Business> clients) {
        this.suppliers = clients;
    }

}
