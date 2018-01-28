package mmarella.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import mmarella.models.Product;

@Transactional
public interface ProductDao extends CrudRepository<Product, Long> {

	public Product findByName(String name);

	public Product findByBarcode(String barcode);
}
