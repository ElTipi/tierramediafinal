package controller.itinerario;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.ItinerarioService;

@WebServlet("/itinerarios/delete.do")
public class DeleteItinerarioServlet extends HttpServlet {

	private static final long serialVersionUID = 1537949074766873118L;
	private ItinerarioService itinerarioService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.itinerarioService = new ItinerarioService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));

		itinerarioService.delete(id);

		resp.sendRedirect("/tierramediafinal/itinerarios/index.do");
	}


}
