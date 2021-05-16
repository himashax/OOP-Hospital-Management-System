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
 * Servlet implementation class UpdateDoctor
 */
@WebServlet("/UpdateDoctor")
public class UpdateDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDoctor() {
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
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			int age  = Integer.parseInt(request.getParameter("age"));
			String gender = request.getParameter("gender");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String address = request.getParameter("address");
			Double salary = Double.parseDouble(request.getParameter("salary"));
			String password = request.getParameter("password");
				
			Doctor doctor = new Doctor();
			doctor.setFirstName(firstName);
			doctor.setLastName(lastName);
			doctor.setAge(age);
			doctor.setGender(gender);
			doctor.setPhone(phone);
			doctor.setEmail(email);
			doctor.setAddress(address);
			doctor.setSalary(salary);
			doctor.setPassword(password);
			doctor.setDoctorID(doctorID);
	
			IDoctorService iDoctor = new DoctorServiceimpl();
			iDoctor.updateDoctor(doctorID, doctor);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/DoctorList.jsp");			
			dispatcher.forward(request, response);
		}

}
