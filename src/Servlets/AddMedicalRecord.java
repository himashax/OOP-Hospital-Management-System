package Servlets;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.MedicalRecord;
import Services.IMedicalRecordService;
import Services.MedicalRecordServiceimpl;

/**
 * Servlet implementation class AddMedicalRecord
 */
@WebServlet("/AddMedicalRecord")
public class AddMedicalRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMedicalRecord() {
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
		
			String doctorID = (String)session.getAttribute("docid");
			System.out.println("check" + doctorID);
			String symptoms = request.getParameter("symptoms");
			String observation = request.getParameter("observation");
			String diagnosis = request.getParameter("diagnosis");
			String notes = request.getParameter("notes");
			String patientID = (String) session.getAttribute("pid");
			
		
			MedicalRecord medRecord = new MedicalRecord();
			medRecord.setDoctorID(doctorID);
			medRecord.setSymptoms(symptoms);
			medRecord.setObservation(observation);
			medRecord.setDiagnosis(diagnosis);
			medRecord.setNotes(notes);
			medRecord.setPatientID(patientID);
		
			IMedicalRecordService imedRecordService = new MedicalRecordServiceimpl();
			imedRecordService.addMedcalRecord(medRecord);
			medRecord = imedRecordService.getMedicalRecords(patientID);
			request.setAttribute("medRecord", medRecord);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/MedicalRecords_doctor.jsp");
			dispatcher.forward(request, response);
		
	}

}
