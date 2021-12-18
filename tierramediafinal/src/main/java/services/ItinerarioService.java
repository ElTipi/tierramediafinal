package services;

import java.util.List;

import model.Itinerario;
import persistence.ItinerarioDAO;
//import model.Attraction;
//import persistence.AttractionDAO;
import persistence.commons.DAOFactory;

public class ItinerarioService {

	public List<Itinerario> list() {
		return DAOFactory.getItinerarioDAO().findAll();
	}

	public Itinerario create(String user, Integer attraction_id) {

		Itinerario itinerario = new Itinerario(user, attraction_id);

		if (itinerario.isValid()) {
			ItinerarioDAO itinerarioDAO = DAOFactory.getItinerarioDAO();
			itinerarioDAO.insert(itinerario);
		}

		return itinerario;
	}

	public Itinerario update(Integer id, String user, Integer attraction_id) {

		ItinerarioDAO itinerarioDAO = DAOFactory.getItinerarioDAO();
		Itinerario itinerario = itinerarioDAO.find(id);

		itinerario.setUser(user);
		itinerario.setAttraction_id(attraction_id);
		

		if (itinerario.isValid()) {
			itinerarioDAO.update(itinerario);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return itinerario;
	}

	public void delete(Integer id) {
		Itinerario itinerario = new Itinerario(id, null, null);

		ItinerarioDAO itinerarioDAO = DAOFactory.getItinerarioDAO();
		itinerarioDAO.delete(itinerario);
	}

	public Itinerario find(Integer id) {
		return DAOFactory.getItinerarioDAO().find(id);
	}

}
