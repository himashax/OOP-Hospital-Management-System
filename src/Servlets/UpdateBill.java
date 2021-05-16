package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Services.BillService;

/**
 * Servlet implementation class UpdateBill
 */
@WebServlet("/UpdateBill")
public class UpdateBill extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//updatebill
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBill() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int amount = Integer.parseInt(request.getParameter("ammou"));
		HttpSession session = request.getSession();
		String patid = (String) session.getAttribute("patid");
		String billid = (String) session.getAttribute("billid");
		
		BillService util = new BillService();
		int result = util.updateBill(amount, billid);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Receptionist_Page.jsp");
		dispatcher.forward(request, response);
		System.out.println(result);
		
	}

}
