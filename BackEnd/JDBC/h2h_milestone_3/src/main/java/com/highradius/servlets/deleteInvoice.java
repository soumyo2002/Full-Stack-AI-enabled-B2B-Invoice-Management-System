package com.highradius.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highradius.implementation.InvoiceDao;
import com.highradius.implementation.InvoiceDaoImpl;



@WebServlet("/deleteInvoice")
public class deleteInvoice extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InvoiceDao inv;
    
    public deleteInvoice() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	
    public void init() throws ServletException {
		inv = new InvoiceDaoImpl();
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int Sl_no;
		String Sl_noParam = request.getParameter("Sl_no");
		Sl_no = Integer.parseInt(Sl_noParam);

		
	    try {
	    PrintWriter out = response.getWriter();
        int result = inv.deleteInvoice(Sl_no);
			if(result == 1) {
				out.println("Record deleted successfully!No of rows deleted is 1");
			}
			else {
				out.println("Record deleted unsuccessfully!No of rows deleted is 0");
			}
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}



