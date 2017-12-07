package com.forever.tesistas.web.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class ProductoDAO extends BaseHibernateDAO {
	@SuppressWarnings("unchecked")
	public List<Producto> getAllProductos() {
		return (List<Producto>) (Object) findAll(Producto.class);
	}

	/*
	public List<Object> getByMarca(String marca) {
		Criteria criteria = getSession().createCriteria(Licor.class).add(Restrictions.eq("marca", marca));
		return findByCriteria(criteria);
	}

	public List<Object> getByMarcaAprox(String marca) {
		Criteria criteria = getSession().createCriteria(Licor.class)
				.add(Restrictions.ilike("marca", marca, MatchMode.ANYWHERE));

		return findByCriteria(criteria);
	}
	*/
	public Producto getById(Integer id) {
		return (Producto) findById(Producto.class, id);
	}

	public void saveProducto(Producto producto) {
		super.save(producto);
	}

	public void updateProducto(Producto producto) {
		super.saveOrUpdate(producto);
	}
	
	public void deleteProducto(Producto producto) {
		super.delete(producto);
	}

}
