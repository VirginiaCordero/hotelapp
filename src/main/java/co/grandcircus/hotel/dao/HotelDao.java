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

	public List<Hotel> findByName(String name) { //xq se usa returntype listhotel y no string?
		return em.createQuery("from Hotel where name = :n", Hotel.class)
				.setParameter("n", name)
				.getResultList();
	}	
	
	public List<Hotel> findAll() {
		return em.createQuery("FROM Hotel", Hotel.class).getResultList();
	}

	public List<Hotel> findByCity(String city) { 
		return em.createQuery("from Hotel where city = :c", Hotel.class)
				.setParameter("c", city)
				.getResultList();
	}
	
	public List<String> getCityCategories(){
		List<String> cityList = em.createQuery("SELECT DISTINCT city from Hotel", String.class).getResultList();
		return cityList;
	}	
}
