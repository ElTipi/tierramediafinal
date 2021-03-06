package model;

import java.util.HashMap;
import java.util.Map;

public class Attraction {

	private Integer id;
	private String name;
	private String description;
	private Integer cost;
	private Double duration;
	private Integer capacity;
	private String tipo_atraccion;
	
	private Map<String, String> errors;
	
	//modificado parametro description
	
	public Attraction(String name, Integer cost, Double duration, Integer capacity, String tipo_atraccion, String description) {
		super();
		this.name = name;
		this.cost = cost;
		this.duration = duration;
		this.capacity = capacity;
		this.tipo_atraccion = tipo_atraccion;
		this.description = description;
	}
	
	public Attraction(Integer id, String name, Integer cost, Double duration, Integer capacity, String tipo_atraccion, String description) {
		this(name, cost, duration, capacity, tipo_atraccion, description);
		this.id = id;
	}
	
	public boolean isValid() {
		validate();
		return errors.isEmpty();
	}
	
	public void validate() {
		errors = new HashMap<String, String>();

		if (cost <= 0) {
			errors.put("cost", "Debe ser positivo");
		}
		if (duration <= 0) {
			errors.put("duration", "Debe ser positivo");
		}
		if (duration > 60) {
			errors.put("duration", "Excede el tiempo máximo");
		}
		if (capacity <= 0) {
			errors.put("capacity", "Debe ser positivo");
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	
	
	//
	
	public String getTipo_atraccion() {
		return tipo_atraccion;
	}

	public void setTipo_atraccion(String tipo_atraccion) {
		this.tipo_atraccion = tipo_atraccion;
	}
	
	
	//
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

	@Override
	public String toString() {
		return "Attraction [id=" + id + ", name=" + name + ", cost=" + cost + ", duration=" + duration + ", capacity="
				+ capacity + ", tipo atraccion=" + tipo_atraccion + ", description=" + description + "]";
	}

	public boolean canHost(int i) {
		return capacity >= i;
	}

	public void host(int i) {
		this.capacity -= i;
	}

	
	
}
