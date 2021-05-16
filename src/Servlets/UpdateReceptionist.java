package Servlets;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Receptionist;
import Services.IReceptionistService;
import Services.ReceptionistServiceimpl;



/**
 * Servlet implementation class UpdateReceptionist
 */
@WebServlet("/UpdateReceptionist")
public class UpdateReceptionist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateReceptionist() {
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
			
			String recepID = request.getParameter("recepID");
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			int age  = Integer.parseInt(request.getParameter("age"));
			String gender = request.getParameter("gender");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String address = request.getParameter("address");
			Double salary = Double.parseDouble(request.getParameter("salary"));
			String password = request.getParameter("password");
				
			Receptionist receptionist = new Receptionist();
			receptionist.setFirstName(firstName);
			receptionist.setLastName(lastName);
			receptionist.setAge(age);
			receptionist.setGender(gender);
			receptionist.setPhone(phone);
			receptionist.setEmail(email);
			receptionist.setAddress(address);
			receptionist.setSalary(salary);
			receptionist.setPassword(password);
			receptionist.setReceptionistID(recepID);
		
			
			IReceptionistService iReceptionist = new ReceptionistServiceimpl();
			iReceptionist.updateReceptionist(recepID, receptionist);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ReceptionistList.jsp");			
			dispatcher.forward(request, response);
			}catch(Exception e) {
				System.out.println(e);
			}
	}

}
