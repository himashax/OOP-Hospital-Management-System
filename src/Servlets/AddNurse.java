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
 * Servlet implementation class AddNurse
 */
@WebServlet("/AddNurse")
public class AddNurse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNurse() {
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
			nurse.setNurseID(nurseID);
			nurse.setFirstName(firstName);
			nurse.setLastName(lastName);
			nurse.setAge(age);
			nurse.setGender(gender);
			nurse.setPhone(phone);
			nurse.setEmail(email);
			nurse.setAddress(address);
			nurse.setSalary(salary);
			nurse.setPassword(password);
			
			INurseService iNurse = new NurseServiceimpl();
			iNurse.addNurse(nurse);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/NurseList.jsp");
			dispatcher.forward(request, response);

	}

}
