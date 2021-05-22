package Servlets;


import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.OutPatient;
import Services.IOutPatientService;
import Services.OutPatientServiceimpl;

/**
 * Servlet implementation class GetOutPatientByID
 */
@WebServlet("/GetOutPatientByID")
public class GetOutPatientByID extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetOutPatientByID() {
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
		
			String out_pID = request.getParameter("patientID");
			session.setAttribute("pid", out_pID);

			IOutPatientService iout_patient = new OutPatientServiceimpl();
			OutPatient out_patient = iout_patient.getOutPatientByID(out_pID);
			request.setAttribute("out_patient",out_patient);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/PatientDetails.jsp");
			dispatcher.forward(request, response);
	}

}
