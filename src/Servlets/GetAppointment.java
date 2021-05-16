package Servlets;

//IT19128696

import java.io.IOException;





import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Model.Appointments;
import Services.AppointmentServiceimpl;
import Services.IAppointmentService;

/**
 * Servlet implementation class GetAppointment
 */
@WebServlet("/GetAppointment")
public class GetAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAppointment() {
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

			String appID = request.getParameter("appID");
			
			IAppointmentService iappService = new AppointmentServiceimpl();
			Appointments appointment = iappService.getAppointments(appID);
			request.setAttribute("appointment", appointment);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/UpdateAppointment.jsp");
			dispatcher.forward(request, response);
	
	}

}
