package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Itinerario;
import persistence.AttractionDAO;
import persistence.ItinerarioDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;

public class ItinerarioDAOImpl implements ItinerarioDAO {

	public List<Itinerario> findAll() {
		try {
			String sql = "SELECT * FROM ITINERARIO, ATTRACTIONS WHERE ITINERARIO.ATTRACTION_ID = ATTRACTIONS.ID";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			List<Itinerario> itinerario = new LinkedList<Itinerario>();
			while (resultados.next()) {
				itinerario.add(toItinerario(resultados));
			}

			return itinerario;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public Itinerario find(Integer id) {
		try {
			String sql = "SELECT * FROM ITINERARIO WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			
			ResultSet resultados = statement.executeQuery();

			Itinerario itinerario = null;
			if (resultados.next()) {
				itinerario = toItinerario(resultados);
			}

			return itinerario;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	
	//////////////////////////////////////////
	private Itinerario toItinerario(ResultSet itinerarioRegister) throws SQLException {
		return new Itinerario(itinerarioRegister.getInt(1), itinerarioRegister.getString(2),
				itinerarioRegister.getInt(3));
	}
	////////////////////////////////////////////

	@Override
	public int insert(Itinerario itinerario) {
		try {
			String sql = "INSERT INTO ITINERARIO (USER, ATTRACTION_ID) VALUES (?, ?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			int i = 1;
			statement.setString(i++, itinerario.getUser());
			statement.setInt(i++, itinerario.getAttraction_id());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int update(Itinerario itinerario) {
		try {
			String sql = "UPDATE ITINERARIO SET USER = ?, ATTRACTION_ID = ? WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			int i = 1;
			statement.setString(i++, itinerario.getUser());
			statement.setInt(i++, itinerario.getAttraction_id());
			statement.setInt(i++, itinerario.getId());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int delete(Itinerario itinerario) {
		try {
			String sql = "DELETE FROM ITINERARIO WHERE ID = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, itinerario.getId());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int countAll() {
		try {
			String sql = "SELECT COUNT(1) AS TOTAL FROM ITINERARIO";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			resultados.next();
			int total = resultados.getInt("TOTAL");

			return total;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}



}
