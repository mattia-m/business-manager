package mmarella.dao;

import mmarella.models.Product;
import mmarella.models.ProductionBatch;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Transactional
public interface ProductionBatchDao extends CrudRepository<ProductionBatch, Long> {

    public List<ProductionBatch> findAllByProductionDateBetween(Date start, Date end);

    public List<ProductionBatch> findAllByProduct(Product product);

}
