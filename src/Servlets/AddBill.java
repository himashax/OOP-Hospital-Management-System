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
 * Servlet implementation class AddBill
 */
@WebServlet("/AddBill")
public class AddBill extends HttpServlet {
	
	//customerinsert
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBill() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String pid = request.getParameter("patientid");	
			String bid = request.getParameter("billid");
			int Amount = Integer.parseInt(request.getParameter("amount"));
			
			System.out.println(pid);
			
			int isTrue = 0;
			
			BillService c1 = new BillService();
			
			isTrue = c1.insertbill(pid, bid, Amount);
			System.out.println(isTrue);
				
				RequestDispatcher dis = request.getRequestDispatcher("/Receptionist_Page.jsp");
				dis.forward(request, response);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.fillInStackTrace();
		}
		
	}

}
