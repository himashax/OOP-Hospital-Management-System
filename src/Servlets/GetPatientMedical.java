package Servlets;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.MedicalRecord;
import Services.IMedicalRecordService;
import Services.MedicalRecordServiceimpl;

/**
 * Servlet implementation class GetPatientMedical
 */
@WebServlet("/GetPatientMedical")
public class GetPatientMedical extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPatientMedical() {
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
		
		IMedicalRecordService imedicalService = new MedicalRecordServiceimpl();
		MedicalRecord medical_records = imedicalService.getMedicalRecords(pid);
		request.setAttribute("med_records", medical_records);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Nurse_MedicalDetails.jsp");
		dispatcher.forward(request, response);
	}

}
