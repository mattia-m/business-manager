package mmarella.vm;


import mmarella.dao.ProductionBatchDao;
import mmarella.models.ProductionBatch;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class LottiVM {

    @WireVariable
    private ProductionBatchDao productionBatchDao;


    List<ProductionBatch> batchs = new LinkedList<ProductionBatch>();

    @Init
    public void init() {
        //logger.info("logging init of production batch page");
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 7);
        Date aWeekAgo = Date.from(calendar.toInstant());

        batchs = (List<ProductionBatch>) productionBatchDao.findAllByProductionDateBetween(today,aWeekAgo);
    }

}
