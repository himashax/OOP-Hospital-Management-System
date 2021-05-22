package Servlets;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.BillService;

/**
 * Servlet implementation class DeleteBill
 */
@WebServlet("/DeleteBill")
public class DeleteBill extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//delUserservlet
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBill() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String billid = request.getParameter("billid");
		
		BillService util = new BillService();
		
		int result = util.delUser(billid);
		
	
		
		System.out.println(result);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Receptionist_Page.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
