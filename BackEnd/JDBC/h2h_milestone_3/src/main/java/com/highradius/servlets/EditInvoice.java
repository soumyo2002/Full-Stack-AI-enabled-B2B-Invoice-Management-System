package com.highradius.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.highradius.implementation.InvoiceDao;
import com.highradius.implementation.InvoiceDaoImpl;
import com.highradius.model.Invoice;


@WebServlet("/EditInvoice")
public class EditInvoice extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InvoiceDao inv;
       
    
    public EditInvoice() {
        super();
        // TODO Auto-generated constructor stub
    }
	 
    public void init() throws ServletException {
		inv = new InvoiceDaoImpl();
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int Sl_no,CUSTOMER_ORDER_ID,COMPANY_CODE,CUSTOMER_NUMBER;
		double AMOUNT_IN_USD,ORDER_AMOUNT;
		
//		String Sl_noParam = request.getParameter("Sl_no");
//	    if (Sl_noParam != null && !Sl_noParam.isEmpty()) {
//	        Sl_no = Integer.parseInt(Sl_noParam);
//	    }else {
//	    	Sl_no = 0;
//	    }
//
//	    String customerOrderIdParam = request.getParameter("CUSTOMER_ORDER_ID");
//	    if (customerOrderIdParam != null && !customerOrderIdParam.isEmpty()) {
//	       CUSTOMER_ORDER_ID = Integer.parseInt(customerOrderIdParam);
//	    }else {
//	    	CUSTOMER_ORDER_ID = 0;
//	    }
		
		
		String Sl_noParam = request.getParameter("Sl_no");
		if (Sl_noParam != null && !Sl_noParam.isEmpty()) {
		    Sl_no = Integer.parseInt(Sl_noParam);
		} else {
		    Sl_no = 0;
		}

		String customerOrderIdParam = request.getParameter("CUSTOMER_ORDER_ID");
		if (customerOrderIdParam != null && !customerOrderIdParam.isEmpty()) {
		    CUSTOMER_ORDER_ID = Integer.parseInt(customerOrderIdParam);
		} else {
		    CUSTOMER_ORDER_ID = 0;
		}

	    String SALES_ORG = request.getParameter("SALES_ORG");
	    String DISTRIBUTION_CHANNEL = request.getParameter("DISTRIBUTION_CHANNEL");
	    
	    String companyCodeParam = request.getParameter("COMPANY_CODE");
	    if (companyCodeParam != null && !companyCodeParam.isEmpty()) {
	        COMPANY_CODE = Integer.parseInt(companyCodeParam);
	    }else {
	    	COMPANY_CODE = 0;
	    }
	    
	    String ORDER_CREATION_DATE = request.getParameter("ORDER_CREATION_DATE");
	    
	    String orderAmountParam = request.getParameter("ORDER_AMOUNT");
	    if (orderAmountParam != null && !orderAmountParam.isEmpty()) {
	        ORDER_AMOUNT = Double.parseDouble(orderAmountParam);
	    }else {
	    	ORDER_AMOUNT = 0.0;
	    }
	    
	    String ORDER_CURRENCY = request.getParameter("ORDER_CURRENCY");

//	    String customerNumberParam = request.getParameter("CUSTOMER_NUMBER");
//	    if (customerNumberParam != null && !customerNumberParam.isEmpty()) {
//	        CUSTOMER_NUMBER = Integer.parseInt(customerNumberParam);
//	    }else {
//	    	CUSTOMER_NUMBER = 0;
//	    }
	    
	    String customerNumberParam = request.getParameter("CUSTOMER_NUMBER");
	    if (customerNumberParam != null && !customerNumberParam.isEmpty()) {
	        CUSTOMER_NUMBER = Integer.parseInt(customerNumberParam);
	    } else {
	        CUSTOMER_NUMBER = 0;
	    }

	    String amountInUsdParam = request.getParameter("AMOUNT_IN_USD");
	    if (amountInUsdParam != null && !amountInUsdParam.isEmpty()) {
	        AMOUNT_IN_USD = Double.parseDouble(amountInUsdParam);
	    }else {
	    	AMOUNT_IN_USD = 0.0;
	    }
	    
	    try {
	    PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        Invoice ob = new Invoice(Sl_no,CUSTOMER_ORDER_ID,SALES_ORG,DISTRIBUTION_CHANNEL,COMPANY_CODE,ORDER_CREATION_DATE,ORDER_AMOUNT,ORDER_CURRENCY,CUSTOMER_NUMBER,AMOUNT_IN_USD); 
        	int result = inv.updateInvoice(Sl_no,ob);
			if(result == 1) {
				out.println("Record updated successfully!No of rows updated is 1");
			}
			else {
				out.println("Record updated unsuccessfully!No of rows updated is 0");
			}
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
