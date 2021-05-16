package Servlets;

//IT19128696

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
 * Servlet implementation class AddPrescription
 */
@WebServlet("/AddPrescription")
public class AddPrescription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPrescription() {
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
		
		String drugName = request.getParameter("name");
		String dose = request.getParameter("dose");
		String docID = (String) session.getAttribute("docid");
		String patient_id = (String) session.getAttribute("pid");
		
		Prescription prescription = new Prescription();
		prescription.setName(drugName);
		prescription.setDose(dose);
		prescription.setDoctorID(docID);
		prescription.setPatientID(patient_id);
		
		IPrescriptionService iprescription_Service = new PrescriptionServiceimpl();
		iprescription_Service.AddPrescription(prescription);
		request.setAttribute("prescription", prescription);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Prescriptions_doctor.jsp");
		dispatcher.forward(request, response);
		
	}

}
