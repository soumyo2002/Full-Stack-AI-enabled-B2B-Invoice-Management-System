package com.highradius.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highradius.implementation.InvoiceDao;
import com.highradius.implementation.InvoiceDaoImpl;

@WebServlet("/deleteInvoice")
public class DeleteInvoiceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private InvoiceDao invoiceDao;

    public void init() {
        invoiceDao = new InvoiceDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Retrieve the customerOrderID from the request parameter
            int custOrderID = Integer.parseInt(request.getParameter("custOrderID"));

            // Delete the invoice from the database
            invoiceDao.deleteInvoice(custOrderID);

            // Set the response status code and success message
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write("{\"message\": \"Invoice deleted successfully.\"}");
        } catch (Exception e) {
            e.printStackTrace();
            // Set the response status code and error message
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"error\": \"An error occurred while deleting the invoice.\"}");
        }
    }
}
