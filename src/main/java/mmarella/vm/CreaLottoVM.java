package mmarella.vm;

import mmarella.dao.ProductionBatchDao;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class CreaLottoVM {

    @WireVariable
    private ProductionBatchDao productionBatchDao;

}
