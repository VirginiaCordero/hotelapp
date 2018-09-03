package co.grandcircus.hotel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.hotel.dao.HotelDao;
import co.grandcircus.hotel.entity.Hotel;

@Controller
public class HotelController {

	@Autowired
	private HotelDao hotelDao;
	
	@RequestMapping("/")
	public ModelAndView showAllHotels() {
		ModelAndView mav = new ModelAndView("index");
		List<String> cities = hotelDao.getCityCategories();
		mav.addObject("cities", cities);
		return mav;
	}		
	
	@RequestMapping("/results")
	public ModelAndView showResultsByCity(@RequestParam("selected_city") String city) {
		ModelAndView mav = new ModelAndView("results");
		List<Hotel> hotelsByCity = hotelDao.findByCity(city);
		mav.addObject("hotels", hotelsByCity);
		return mav;
	}

//	@RequestMapping("/products/{id}")
//	public Product getProduct(@PathVariable("id") Long id) {
//		return productDao.findById(id);
//	}
}
