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
 * Servlet implementation class UpdatePrescription
 */
@WebServlet("/UpdatePrescription")
public class UpdatePrescription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePrescription() {
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
		
		String presID = (String) session.getAttribute("presID");
		String doctorID = (String) session.getAttribute("docid");
		String patientID = (String) session.getAttribute("pid");
		String name = request.getParameter("name");
		String dose = request.getParameter("dose");
		
		Prescription prescription = new Prescription();
		prescription.setName(name);
		prescription.setDose(dose);
		prescription.setDoctorID(doctorID);
		prescription.setPatientID(patientID);
		prescription.setPrescriptionID(presID);
		
		IPrescriptionService iprescription = new PrescriptionServiceimpl();
		iprescription.UpdatePrescription(presID, prescription);
		request.setAttribute("prescription", prescription);
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Prescriptions_doctor.jsp");			
		dispatcher.forward(request, response);
	}

}
