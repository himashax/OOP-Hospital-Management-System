package Servlets;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.IOutPatientService;
import Services.OutPatientServiceimpl;

/**
 * Servlet implementation class DeleteOutPatient
 */
@WebServlet("/DeleteOutPatient")
public class DeleteOutPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteOutPatient() {
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
		
		String out_pID = request.getParameter("outPatientID");
		
		IOutPatientService iout_patient = new OutPatientServiceimpl();
		iout_patient.deleteOutPatient(out_pID);
		System.out.println("del" + out_pID);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ListOutPatients.jsp");
		dispatcher.forward(request, response);
	}

}
