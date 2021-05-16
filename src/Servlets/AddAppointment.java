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

import Model.Appointments;
import Services.AppointmentServiceimpl;
import Services.IAppointmentService;

/**
 * Servlet implementation class AddAppointment
 */
@WebServlet("/AddAppointment")
public class AddAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAppointment() {
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
		
			String patientID = (String)session.getAttribute("id");
			String doctorID = request.getParameter("doctorID");
			String date = request.getParameter("date");
			
			Appointments appointment  = new Appointments();
			appointment.setOut_patientID(patientID);
			appointment.setDoctorID(doctorID);
			appointment.setDate(date);
			
			IAppointmentService iappService = new AppointmentServiceimpl();
			iappService.addAppointment(appointment);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/AppointmentList.jsp");
			dispatcher.forward(request, response);
			
		
	}

}
