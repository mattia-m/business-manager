package mmarella.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import mmarella.models.Business;

@Transactional
public interface BusinessDao extends CrudRepository<Business, Long> {

	public Business findByName(String name);

	public Business findByVatNumber(String vatNumber);

	public List<Business> findAllByClientFlag(boolean flag);

	public List<Business> findAllBySellerFlag(boolean flag);
}
