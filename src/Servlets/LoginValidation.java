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

import Services.Login;

/**
 * Servlet implementation class LoginValidation
 */
@WebServlet("/LoginValidation")
public class LoginValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginValidation() {
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
			
			Login login = new Login();
			String destination = "/LoginPage.jsp";
			HttpSession session = request.getSession();
		
				String userName = request.getParameter("userName");
				String password = request.getParameter("password");
				String userType;
				
				if(userName.startsWith("OPD")) {
					userType = "patient";
					if(login.ValidateUser(userName, password,userType)) {
						session.setAttribute("id",userName);
						destination = "/Home_Patient.jsp";
					}
				}
				
				else if(userName.startsWith("DOC")){
					userType = "doctor";
					if(login.ValidateUser(userName, password,userType)) {
						session.setAttribute("docid", userName);
						destination = "/Home_Doctor.jsp";	
					}
				}
				
				else if(userName.startsWith("N")){
					userType = "nurse";	
					if(login.ValidateUser(userName, password,userType)) {
						session.setAttribute("nurseid", userName);
						destination = "/NursePage.jsp";	
					}
				}
				
				else if(userName.startsWith("R")){
					userType = "receptionist";	
					if(login.ValidateUser(userName, password,userType)) {
						session.setAttribute("recepid", userName);
						destination = "/ReceptionistProfile.jsp";	
					}
				}
				
				else if(userName.startsWith("AD")){
					System.out.println("admin login");
				}
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(destination);
				dispatcher.forward(request, response);
				
		}
}
