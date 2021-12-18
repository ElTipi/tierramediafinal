package model;

import java.util.HashMap;
import java.util.Map;

public class Itinerario {

	private Integer id;
	private String user;
	private Integer attraction_id;
	
	private Map<String, String> errors;
	
	//modificado parametro description
	
	public Itinerario(String user, Integer attraction_id) {
		super();
		this.user = user;
		this.attraction_id = attraction_id;
	}
	
	public Itinerario(Integer id, String user, Integer attraction_id) {
		this(user, attraction_id);
		this.id = id;
	}
	
	
	public boolean isValid() {
		validate();
		return errors.isEmpty();
	}
	
	
	public void validate() {
		errors = new HashMap<String, String>();

		if (id <= 0) {
			errors.put("id", "Debe ser positivo");
		}
	}
	
	
	
	public Map<String, String> getErrors() {
		return errors;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	public Integer getAttraction_id() {
		return attraction_id;
	}

	public void setAttraction_id(Integer attraction_id) {
		this.attraction_id = attraction_id;
	}


	@Override
	public String toString() {
		return "Itinerario [id=" + id + ", user=" + user + ", atraction Id=" + attraction_id + "]";
	}

	/*
	public boolean canHost(int i) {
		return capacity >= i;
	}

	public void host(int i) {
		this.capacity -= i;
	}
	*/
	
	
}
