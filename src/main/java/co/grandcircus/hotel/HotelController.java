package co.grandcircus.hotel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.grandcircus.hotel.dao.HotelDao;
import co.grandcircus.hotel.entity.Hotel;

@Controller
public class HotelController {

	@Autowired
	private HotelDao hotelDao;
	
	@RequestMapping("/hotels")
	public List<Hotel> listHotels(@RequestParam(value="name", required=false) String name) {
		if (name != null && !name.isEmpty()) {
			return hotelDao.findByName(name);
		} else {
		return hotelDao.findAll();
		}
	}
	
}
