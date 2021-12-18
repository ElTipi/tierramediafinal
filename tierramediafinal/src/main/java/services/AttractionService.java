package services;

import java.util.List;

import model.Attraction;
import persistence.AttractionDAO;
import persistence.commons.DAOFactory;

public class AttractionService {

	public List<Attraction> list() {
		return DAOFactory.getAttractionDAO().findAll();
	}

	public Attraction create(String name, Integer cost, Double duration, Integer capacity, String tipo_atraccion, String description) {

		Attraction attraction = new Attraction(name, cost, duration, capacity, tipo_atraccion, description);

		if (attraction.isValid()) {
			AttractionDAO attractionDAO = DAOFactory.getAttractionDAO();
			attractionDAO.insert(attraction);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return attraction;
	}

	public Attraction update(Integer id, String name, Integer cost, Double duration, Integer capacity, 
			String tipo_atraccion, String description) {

		AttractionDAO attractionDAO = DAOFactory.getAttractionDAO();
		Attraction attraction = attractionDAO.find(id);

		attraction.setName(name);
		attraction.setCost(cost);
		attraction.setDuration(duration);
		attraction.setCapacity(capacity);
		attraction.setTipo_atraccion(tipo_atraccion);
		attraction.setDescription(description);
		

		if (attraction.isValid()) {
			attractionDAO.update(attraction);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return attraction;
	}

	public void delete(Integer id) {
		Attraction attraction = new Attraction(id, null, null, null, null, null, null);

		AttractionDAO attractionDAO = DAOFactory.getAttractionDAO();
		attractionDAO.delete(attraction);
	}

	public Attraction find(Integer id) {
		return DAOFactory.getAttractionDAO().find(id);
	}

}
