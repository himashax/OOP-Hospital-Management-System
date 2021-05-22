package Servlets;


import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Doctor;
import Services.DoctorServiceimpl;
import Services.IDoctorService;


/**
 * Servlet implementation class GetDoctor
 */
@WebServlet("/GetDoctor")
public class GetDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDoctor() {
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
	
			String doctorID = request.getParameter("doctorID");

			IDoctorService idoctor = new DoctorServiceimpl();
			Doctor doctor = idoctor.getDoctor(doctorID);
			request.setAttribute("doctor",doctor);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/UpdateDoctor.jsp");
			dispatcher.forward(request, response);
	
		
	}

}
