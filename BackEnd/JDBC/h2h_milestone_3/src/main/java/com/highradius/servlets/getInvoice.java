package com.highradius.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.highradius.implementation.InvoiceDao;
import com.highradius.implementation.InvoiceDaoImpl;
import com.highradius.model.Invoice;




@WebServlet("/getInvoice")
public class getInvoice extends HttpServlet {
	private static final long serialVersionUID = 1L;
	InvoiceDao inv;
    
    public getInvoice() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException {
		inv = new InvoiceDaoImpl();
	}
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		int start = Integer.parseInt(request.getParameter("start"));
		int limit = Integer.parseInt(request.getParameter("limit"));
		try {
			List<Invoice> invlist = inv.getInvoice(start,limit);
//			List<Invoice> invlist = inv.getInvoice();
			String jsonresult = gson.toJson(invlist);
			out.println(jsonresult);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
