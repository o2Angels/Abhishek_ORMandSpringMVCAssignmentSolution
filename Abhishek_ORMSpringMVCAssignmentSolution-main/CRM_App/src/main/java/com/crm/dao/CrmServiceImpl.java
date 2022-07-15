package com.crm.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crm.entity.Customer;
import com.crm.service.CrmServices;

/**
 * This is the Repository class and handles all Data Access job
 * 
 * @author Shain Joy
 */
@Repository
public class CrmServiceImpl implements CrmServices {

	//Session
	private SessionFactory sessionFactory;
	private Session session;

	@Autowired
	CrmServiceImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
	}
	
	@Override
	public void save(Customer customer) {
		Transaction txn = session.beginTransaction();
		session.saveOrUpdate(customer);
		txn.commit();
	}

	@Override
	public Customer searchById(int id) {
		return session.get(Customer.class, id);
	}

	@Override
	public void deleteById(int id) {
		Customer mCust = session.get(Customer.class, id);
		Transaction txn = session.beginTransaction();
		session.delete(mCust);
		txn.commit();
	}

	@Override
	public List<Customer> listAll() {
		List<Customer> customers = session.createQuery("from Customer").list();
		return customers;
	}

}
