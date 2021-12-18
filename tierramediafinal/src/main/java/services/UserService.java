package services;

import java.util.List;

import model.Attraction;
import model.User;
import persistence.AttractionDAO;
import persistence.commons.DAOFactory;

public class UserService {

	public List<User> list() {
		return DAOFactory.getUserDAO().findAll();
	}

	public User create(String username, String password, Integer coins, Double time, String preferencia) {
		User user = new User(-1, username, password, coins, time, preferencia, false);
		user.setPassword(password);

		if (user.isValid()) {
			DAOFactory.getUserDAO().insert(user);
		} 

		return user;
	}

	public User find(int id) {
		return DAOFactory.getUserDAO().find(id);
	}

	public User update(int id, String username, String password, Integer coins, Double time, String preferencia) {
		User user = new User(id, username, password, coins, time, preferencia, false);
		user.setPassword(password);
		if (user.isValid()) {
			DAOFactory.getUserDAO().update(user);
		}
		return user;
	}

	public void delete(int id) {
		User user=DAOFactory.getUserDAO().find(id);
		DAOFactory.getUserDAO().delete(user);
	}
}
