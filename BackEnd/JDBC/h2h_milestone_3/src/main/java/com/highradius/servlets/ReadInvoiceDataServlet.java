package com.highradius.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highradius.connection.DatabaseConnection;
import com.highradius.implementation.InvoiceDao;
import com.highradius.implementation.InvoiceDaoImpl;
import com.highradius.model.Invoice;
import com.google.gson.Gson;
import java.io.*;
@WebServlet("/readInvoiceData")
public class ReadInvoiceDataServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private InvoiceDao invoiceDao;

    public void init() {
        invoiceDao = new InvoiceDaoImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
        	String jsonResponse = new String();
    		@SuppressWarnings("unused")
    		PrintWriter out = response.getWriter();
    		System.out.println();
    		List<Invoice> invoices = invoiceDao.getAllInvoices();
    		
    		Gson gson = new Gson();
    		jsonResponse = gson.toJson(invoices);
    		
    		response.setHeader("Access-Control-Allow-Origin", "*");
    		response.setContentType("application/json");
    		response.setCharacterEncoding("UTF-8");
    		response.getWriter().write(jsonResponse);
    }
        catch (Exception e) {
          e.printStackTrace();
          // Set the response status code and error message
          response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
          response.getWriter().write("{\"error\": \"An error occurred while retrieving invoice data.\"}");
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Allow only GET requests for this servlet
        response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }
}

    
//  List<Invoice> invoiceData = invoiceDao.getAllInvoices();
//
//  // Convert the invoiceData to JSON format
//  Gson gson = new Gson();
//  String jsonData = gson.toJson(invoiceData);
//
//  // Set the response content type to JSON
//  response.setContentType("application/json");
//
//  // Write the JSON data to the response
//  response.getWriter().write(jsonData);
//} catch (Exception e) {
//  e.printStackTrace();
//  // Set the response status code and error message
//  response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//  response.getWriter().write("{\"error\": \"An error occurred while retrieving invoice data.\"}");
//}
