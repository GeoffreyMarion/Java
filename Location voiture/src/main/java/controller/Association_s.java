package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.Association;
import modele.Conducteur;
import modele.Vehicule;

/**
 * Servlet implementation class Association_s
 */
@WebServlet("/association")
public class Association_s extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConducteurDao cDao= new ConducteurDao();
	private VehiculeDao vDao= new VehiculeDao();
	private AssociationDao aDao= new AssociationDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Association_s() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("tableau_a", aDao.read());
		request.setAttribute("tableau_c", cDao.read());
		request.setAttribute("tableau_v", vDao.read());

		if (request.getParameter("id_a") != null && request.getParameter("action").equals("suppr")) {
			aDao.delete(aDao.findById(Integer.parseInt(request.getParameter("id_a"))));
			response.sendRedirect(request.getContextPath()+"/association");}
		else{request.getRequestDispatcher("association.jsp").forward(request, response);}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("id_c", request.getParameter("id_c"));
		request.setAttribute("id_v", request.getParameter("id_v"));

		if (request.getParameter("id_a") != null && request.getParameter("action").equals("modif")) {
			Association asso = new Association(Integer.parseInt(request.getParameter("id_a")),
					cDao.findById(Integer.parseInt(request.getParameter("id_c"))),
					vDao.findById(Integer.parseInt(request.getParameter("id_v"))));
			aDao.update(asso,cDao.findById(Integer.parseInt(request.getParameter("id_c"))),
					vDao.findById(Integer.parseInt(request.getParameter("id_v"))),
					Integer.parseInt(request.getParameter("id_a")));
			response.sendRedirect(request.getContextPath() + "/association");
		} 
		else {
			Association asso = new Association(cDao.findById(Integer.parseInt(request.getParameter("id_c"))),
					vDao.findById(Integer.parseInt(request.getParameter("id_v"))));
			aDao.create(asso);
			doGet(request, response);
		}

	}

}
