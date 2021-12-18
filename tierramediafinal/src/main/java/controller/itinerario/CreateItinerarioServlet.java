package controller.itinerario;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Itinerario;
import services.ItinerarioService;

@WebServlet("/itineario/create.do")
public class CreateItinerarioServlet extends HttpServlet {

	private static final long serialVersionUID = 3455721046062278592L;
	private ItinerarioService itinerarioService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.itinerarioService = new ItinerarioService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/itinerarios/create.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = req.getParameter("user");
		Integer attraction_id = Integer.parseInt(req.getParameter("attraction_id"));
		//String tipo_atraccion = req.getParameter("tipo_atraccion");
		//String name = req.getParameter("name");

		Itinerario itinerario = itinerarioService.create(user, attraction_id);
		
		if (itinerario.isValid()) {
			resp.sendRedirect("/tierramediafinal/itinerarios/index.do");
		} else {
			req.setAttribute("itinerario", itinerario);

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/itinerarios/create.jsp");
			dispatcher.forward(req, resp);
		}

	}

}
