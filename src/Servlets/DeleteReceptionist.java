package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.IReceptionistService;
import Services.ReceptionistServiceimpl;

/**
 * Servlet implementation class DeleteReceptionist
 */
@WebServlet("/DeleteReceptionist")
public class DeleteReceptionist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteReceptionist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String recepID = request.getParameter("recepID");
		
		IReceptionistService iReceptionist = new ReceptionistServiceimpl();
		iReceptionist.deleteReceptionist(recepID);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ReceptionistList.jsp");
		dispatcher.forward(request, response);
			
	}

}
