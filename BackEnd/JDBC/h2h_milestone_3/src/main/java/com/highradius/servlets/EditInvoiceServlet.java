package com.highradius.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highradius.implementation.InvoiceDao;
import com.highradius.implementation.InvoiceDaoImpl;
import com.highradius.model.Invoice;
import com.google.gson.Gson;

@WebServlet("/editInvoice")
public class EditInvoiceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private InvoiceDao invoiceDao;

    public void init() {
        invoiceDao = new InvoiceDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Retrieve the invoice details from the request parameters
            int custOrderID = Integer.parseInt(request.getParameter("custOrderID"));
            String salesOrg = request.getParameter("salesOrg");
            String distributionChannel = request.getParameter("distributionChannel");
            int custNumber = Integer.parseInt(request.getParameter("custNumber"));
            int companyCode = Integer.parseInt(request.getParameter("companyCode"));
            double orderCurrency = Double.parseDouble(request.getParameter("orderCurrency"));
            double amount_in_USD = Double.parseDouble(request.getParameter("amount_in_USD"));
            double amount = Double.parseDouble(request.getParameter("amount"));
            String creationDate = request.getParameter("creationDate");

            // Create an invoice object with the retrieved details
            Invoice invoice = new Invoice(companyCode, custOrderID, salesOrg, distributionChannel, custNumber, companyCode, orderCurrency, amount_in_USD, amount, creationDate);

            // Update the invoice in the database
            invoiceDao.updateInvoice(custOrderID, invoice);

            // Convert the updated invoice to JSON format
            Gson gson = new Gson();
            String jsonData = gson.toJson(invoice);

            // Set the response content type to JSON
            response.setContentType("application/json");

            // Write the JSON data to the response
            response.getWriter().write(jsonData);
        } catch (Exception e) {
            e.printStackTrace();
            // Set the response status code and error message
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"error\": \"An error occurred while updating the invoice.\"}");
        }
    }
}
