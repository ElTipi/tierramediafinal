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

@WebServlet("/itinerarios/edit.do")
public class EditItinerarioServlet extends HttpServlet {

	private static final long serialVersionUID = 7598291131560345626L;
	private ItinerarioService itinerarioService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.itinerarioService = new ItinerarioService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));

		Itinerario itinerario = itinerarioService.find(id);
		req.setAttribute("itinerario", itinerario);

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/views/itinerario/edit.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		String user = req.getParameter("user");
		Integer attraction_id = Integer.parseInt(req.getParameter("attraction_id"));
		// Integer cost = req.getParameter("cost").trim() == "" ? null : Integer.parseInt(req.getParameter("cost"));
		

		Itinerario tmp_itinerario = itinerarioService.update(id, user, attraction_id);

		if (tmp_itinerario.isValid()) {
			resp.sendRedirect("/tierramediafinal/itinerarios/index.do");
		} else {
			req.setAttribute("itinerario", tmp_itinerario);

			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/views/itinerarios/edit.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
