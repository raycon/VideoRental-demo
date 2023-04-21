package video.rental.demo.infrastructure;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import video.rental.demo.domain.Customer;
import video.rental.demo.domain.Repository;
import video.rental.demo.domain.Video;

public class RepositoryDBImpl implements Repository {

	/*
	 * Database Access private methods
	 */

	// JPA EntityManager
	private static final EntityManager em = PersistenceManager.INSTANCE.getEntityManager();

	@Override
	public void saveCustomer(Customer customer) {
		try {
			getEm().getTransaction().begin();
			getEm().persist(customer);
			getEm().getTransaction().commit();
		} catch (PersistenceException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void saveVideo(Video video) {
		try {
			getEm().getTransaction().begin();
			getEm().persist(video);
			getEm().getTransaction().commit();
		} catch (PersistenceException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public List<Customer> findAllCustomers() {
		TypedQuery<Customer> query = getEm().createQuery("SELECT c FROM Customer c", Customer.class);
		return query.getResultList();
	}

	@Override
	public List<Video> findAllVideos() {
		TypedQuery<Video> query = getEm().createQuery("SELECT c FROM Video c", Video.class);
		return query.getResultList();
	}

	@Override
	public Customer findCustomerById(int code) {
		Customer value = null;
		try {
			getEm().getTransaction().begin();
			value = getEm().find(Customer.class, code);
			getEm().getTransaction().commit();
		} catch (PersistenceException ex) {
			ex.printStackTrace();
		}
		return value;
	}

	@Override
	public Video findVideoByTitle(String title) {
		Video value = null;
		try {
			getEm().getTransaction().begin();
			value = getEm().find(Video.class, title);
			getEm().getTransaction().commit();
		} catch (PersistenceException ex) {
			ex.printStackTrace();
		}
		return value;
	}

	static EntityManager getEm() {
		return em;
	}

}
