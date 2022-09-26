package service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import entity.Customer;

@Service
public class CustomerService {

	private SessionFactory factory;
	private Session session;

	public CustomerService(SessionFactory factory) {
		this.factory = factory;
		try {
			this.session = factory.getCurrentSession();
		} catch (Exception e) {
			this.session = factory.openSession();
		}

		System.out.println("Session Created");
		System.out.println(this.session);
	}

	@Transactional
	public void saveorUpdate(Customer customer) {

		Transaction tx = session.beginTransaction();

		session.saveOrUpdate(customer);

		tx.commit();
	}

	@Transactional
	public boolean delete(int id) {

		try {
			Transaction tx = session.beginTransaction();

			Customer c1 = session.get(Customer.class, id);
			session.delete(c1);

			tx.commit();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Transactional
	public Customer findCustomerById(int id) {
		Transaction tx = session.beginTransaction();

		Customer customer = session.get(Customer.class, id);

		tx.commit();
		return customer;
	}

	@Transactional
	public List<Customer> findAllCustomers() {

		Transaction tx = session.beginTransaction();

		List<Customer> customers = session.createQuery("from Customer").list();

		tx.commit();
		return customers;
	}
}
