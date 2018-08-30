package co.grandcircus.hotel.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.grandcircus.hotel.entity.Hotel;


@Repository
@Transactional
public class HotelDao {

	@PersistenceContext
	
	private EntityManager em;

	public List<Hotel> findByName(String name) {
		return em.createQuery("from Hotel where name = :n", Hotel.class)
				.setParameter("n", name)
				.getResultList();
	}	
	
	public List<Hotel> findAll() {
		return em.createQuery("from Hotel", Hotel.class).getResultList();
	}
	
}
