package Servlets;


import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Prescription;
import Services.IPrescriptionService;
import Services.PrescriptionServiceimpl;

/**
 * Servlet implementation class GetPrescription
 */
@WebServlet("/GetPrescription")
public class GetPrescription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPrescription() {
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
		HttpSession session = request.getSession();
		
		String presID = request.getParameter("presID");
		
		session.setAttribute("presID", presID);
		IPrescriptionService iPrescription = new PrescriptionServiceimpl();
		Prescription prescription = iPrescription.getPrescription(presID);
		request.setAttribute("prescription", prescription);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/UpdatePrescription.jsp");
		dispatcher.forward(request, response);
	}

}
