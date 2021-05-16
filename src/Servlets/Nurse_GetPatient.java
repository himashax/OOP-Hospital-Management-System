package Servlets;

import java.io.IOException;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Model.OutPatient;
import Services.IOutPatientService;
import Services.OutPatientServiceimpl;

/**
 * Servlet implementation class Nurse_GetPatient
 */
@WebServlet("/Nurse_GetPatient")
public class Nurse_GetPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Nurse_GetPatient() {
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
		
		String pid = request.getParameter("pid");
		
		IOutPatientService iPatient = new OutPatientServiceimpl();
		OutPatient patient = iPatient.getOutPatientByID(pid);
		request.setAttribute("outpatient", patient);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Nurse_PatientDetails.jsp");
		dispatcher.forward(request, response);
	}

}
