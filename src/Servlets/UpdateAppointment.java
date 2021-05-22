package Servlets;

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
 * Servlet implementation class UpdateAppointment
 */
@WebServlet("/UpdateAppointment")
public class UpdateAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAppointment() {
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
			String appID = request.getParameter("appId");
			System.out.println(appID);
			String doctorID = request.getParameter("doctorID");
			String date_time = request.getParameter("date_time");
			
			Appointments appointment = new Appointments();
			appointment.setOut_patientID(patientID);
			appointment.setDoctorID(doctorID);
			appointment.setDate(date_time);
			appointment.setAppID(appID);
			
			IAppointmentService iappService = new AppointmentServiceimpl();
			iappService.updateAppointment(appID, appointment);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/AppointmentList.jsp");			
			dispatcher.forward(request, response);
		
	}

}
