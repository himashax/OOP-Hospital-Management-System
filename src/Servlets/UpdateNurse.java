package Servlets;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Nurse;
import Services.INurseService;
import Services.NurseServiceimpl;



/**
 * Servlet implementation class UpdateNurse
 */
@WebServlet("/UpdateNurse")
public class UpdateNurse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNurse() {
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
		
		try {
			String nurseID = request.getParameter("nurseID");
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			int age  = Integer.parseInt(request.getParameter("age"));
			String gender = request.getParameter("gender");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String address = request.getParameter("address");
			Double salary = Double.parseDouble(request.getParameter("salary"));
			String password = request.getParameter("password");
				
			Nurse nurse = new Nurse();
			nurse.setFirstName(firstName);
			nurse.setLastName(lastName);
			nurse.setAge(age);
			nurse.setGender(gender);
			nurse.setPhone(phone);
			nurse.setEmail(email);
			nurse.setAddress(address);
			nurse.setSalary(salary);
			nurse.setPassword(password);
			nurse.setNurseID(nurseID);
	
			INurseService iNurse = new NurseServiceimpl();
			iNurse.updateNurse(nurseID, nurse);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/NurseList.jsp");			
			dispatcher.forward(request, response);
			}catch(Exception e) {
				System.out.println(e);
			}
	}

}
