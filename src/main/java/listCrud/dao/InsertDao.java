package listCrud.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import listCrud.model.Product;

@Component
public class InsertDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void insertlist(Product product)
	{
		this.hibernateTemplate.saveOrUpdate(product);
	}
	
	public List<Product> getList()
	{
		List<Product> Lists = this.hibernateTemplate.loadAll(Product.class);
		return Lists;
	}
	
	@Transactional
	public void deleteList(int pid)
	{
		Product p = this.hibernateTemplate.load(Product.class, pid);
		this.hibernateTemplate.delete(p);
	}
	
	public Product getSingleList(int pid)
	{
		
		return this.hibernateTemplate.load(Product.class, pid);
	}
}
