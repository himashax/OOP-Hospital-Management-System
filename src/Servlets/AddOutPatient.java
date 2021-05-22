package Servlets;



import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.OutPatient;
import Services.IOutPatientService;
import Services.OutPatientServiceimpl;

/**
 * Servlet implementation class AddOutPatient
 */
@WebServlet("/AddOutPatient")
public class AddOutPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOutPatient() {
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

			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			int age  = Integer.parseInt(request.getParameter("age"));
			String gender = request.getParameter("gender");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String address = request.getParameter("address");
			String password = request.getParameter("password");
			
			OutPatient out_Patient = new OutPatient();
			out_Patient.setFirstName(firstName);
			out_Patient.setLastName(lastName);
			out_Patient.setAge(age);
			out_Patient.setGender(gender);
			out_Patient.setPhone(phone);
			out_Patient.setEmail(email);
			out_Patient.setAddress(address);
			out_Patient.setPassword(password);
			
			IOutPatientService iout_Patient = new OutPatientServiceimpl();
			iout_Patient.AddOutPatient(out_Patient);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Home_Patient.jsp");
			dispatcher.forward(request, response);
		
	}

}
