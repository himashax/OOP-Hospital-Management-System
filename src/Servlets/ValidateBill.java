package Servlets;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Bill;
import Services.BillService;

/**
 * Servlet implementation class ValidateBill
 */
@WebServlet("/ValidateBill")
public class ValidateBill extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//loginservlet
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateBill() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String PatientID = request.getParameter("patientid");
		String BillID = request.getParameter("billid");
		
		try {
			Bill bill;
			BillService obj = new BillService();
			bill = (Bill) obj.validate(PatientID, BillID);
			HttpSession session = request.getSession();
			session.setAttribute("patid", bill.getPatienID());
			session.setAttribute("billid", bill.getBillID());
			request.setAttribute("bill", bill);
			RequestDispatcher dis = request.getRequestDispatcher("/Bills.jsp");
			dis.forward(request, response);
			System.out.println(bill.getAmount() + "amm");
			
		}
	
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
