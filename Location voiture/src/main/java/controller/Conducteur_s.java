package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.Conducteur;

/**
 * Servlet implementation class Conducteur_s
 */
@WebServlet("/conducteur")
public class Conducteur_s extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConducteurDao cDao= new ConducteurDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Conducteur_s() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("tableau", cDao.read());
		if(request.getParameter("id")!=null && request.getParameter("action").equals("suppr")){cDao.delete(cDao.findById(Integer.parseInt(request.getParameter("id"))));
		response.sendRedirect(request.getContextPath()+"/conducteur");}
		else {request.getRequestDispatcher("conducteur.jsp").forward(request, response);}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("nom", request.getParameter("nom"));
		request.setAttribute("prenom", request.getParameter("prenom"));

		if (request.getParameter("id") != null && request.getParameter("action").equals("modif")) {
			Conducteur condu = new Conducteur(Integer.parseInt(request.getParameter("id")), request.getParameter("nom"),
					request.getParameter("prenom"));
			cDao.update(condu, request.getParameter("nom"), request.getParameter("prenom"),
					Integer.parseInt(request.getParameter("id")));
			response.sendRedirect(request.getContextPath() + "/conducteur");
		}
		else {
			Conducteur condu = new Conducteur(request.getParameter("nom"), request.getParameter("prenom"));
			request.setAttribute("ajout",cDao.create(condu));
			doGet(request, response);
		}
	}

}
