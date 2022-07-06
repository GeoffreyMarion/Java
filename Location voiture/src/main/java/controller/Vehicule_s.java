package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.Conducteur;
import modele.Vehicule;

/**
 * Servlet implementation class Vehicule_s
 */
@WebServlet("/vehicule")
public class Vehicule_s extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VehiculeDao vDao = new VehiculeDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Vehicule_s() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("tableau", vDao.read());
		if(request.getParameter("id")!=null && request.getParameter("action").equals("suppr")) {vDao.delete(vDao.findById(Integer.parseInt(request.getParameter("id"))));
		response.sendRedirect(request.getContextPath()+"/vehicule");}
		else{request.getRequestDispatcher("vehicule.jsp").forward(request, response);}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("marque", request.getParameter("marque"));
		request.setAttribute("modele", request.getParameter("modele"));
		request.setAttribute("couleur", request.getParameter("couleur"));
		request.setAttribute("immatriculation", request.getParameter("immatriculation"));

		if (request.getParameter("id") != null && request.getParameter("action").equals("modif")) {
			Vehicule vehi = new Vehicule(Integer.parseInt(request.getParameter("id")), request.getParameter("marque"),
					request.getParameter("modele"), request.getParameter("couleur"),
					request.getParameter("immatriculation"));
			vDao.update(vehi, request.getParameter("marque"), request.getParameter("modele"),
					request.getParameter("couleur"), request.getParameter("immatriculation"),
					Integer.parseInt(request.getParameter("id")));
			response.sendRedirect(request.getContextPath() + "/vehicule");
		} 
		else {
			Vehicule vehi = new Vehicule(request.getParameter("marque"), request.getParameter("modele"),
					request.getParameter("couleur"), request.getParameter("immatriculation"));
			vDao.create(vehi);
			doGet(request, response);
		}
	}
}
