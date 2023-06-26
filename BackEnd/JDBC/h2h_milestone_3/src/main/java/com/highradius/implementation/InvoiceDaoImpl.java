package com.highradius.implementation;

import com.highradius.connection.DatabaseConnection;
import com.highradius.model.Invoice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDaoImpl implements InvoiceDao {

//    public Connection connect() {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            return DriverManager.getConnection("jdbc:mysql://localhost:3306/hrc_db", "root", "nitya");
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
	private DatabaseConnection databaseConnection;
	public InvoiceDaoImpl() {
		 databaseConnection = new DatabaseConnection();
	};
    public void insertInvoice(Invoice i) {
//        DatabaseConnection.addInvoice(i);
    }

    public void updateInvoice(int customerOrderID, Invoice i) {
        // Implement your update logic here
    }

    public void deleteInvoice(int customerOrderID) {
        // Implement your delete logic here
    }

    public List<Invoice> getAllInvoices() {
        List<Invoice> invoices = new ArrayList<>();

        try (Connection connection = DatabaseConnection.connect();
        		
             Statement preparedStatement = connection.createStatement();
             ResultSet resultSet = preparedStatement.executeQuery("SELECT * FROM h2h_oap")) {

            while (resultSet.next()) {
                int Sl_no = resultSet.getInt("Sl_no");
                int CUSTOMER_ORDER_ID = resultSet.getInt("CUSTOMER_ORDER_ID");
                String SALES_ORG = resultSet.getString("SALES_ORG");
                String DISTRIBUTION_CHANNEL = resultSet.getString("DISTRIBUTION_CHANNEL");
                int COMPANY_CODE = resultSet.getInt("COMPANY_CODE");
                String ORDER_CREATION_DATE = resultSet.getString("ORDER_CREATION_DATE");
                String ORDER_CURRENCY = resultSet.getString("ORDER_CURRENCY");                
                int CUSTOMER_NUMBER = resultSet.getInt("CUSTOMER_NUMBER");
                double AMOUNT_IN_USD = resultSet.getDouble("AMOUNT_IN_USD");
                double ORDER_AMOUNT = resultSet.getDouble("ORDER_AMOUNT");
                
                Invoice invoice = new Invoice(Sl_no,CUSTOMER_ORDER_ID,SALES_ORG,DISTRIBUTION_CHANNEL,
                COMPANY_CODE,
                ORDER_CREATION_DATE,
             ORDER_CURRENCY,
                CUSTOMER_NUMBER,
            AMOUNT_IN_USD,
            ORDER_AMOUNT);
                invoice.setSl_no(Sl_no);
                invoice.setCUSTOMER_ORDER_ID(CUSTOMER_ORDER_ID);
                invoice.setSALES_ORG(SALES_ORG);
                invoice.setDISTRIBUTION_CHANNEL(DISTRIBUTION_CHANNEL);
                invoice.setCUSTOMER_NUMBER(CUSTOMER_NUMBER);
                invoice.setCOMPANY_CODE(COMPANY_CODE);
                invoice.setORDER_CURRENCY(ORDER_CURRENCY);
                invoice.setAMOUNT_IN_USD(AMOUNT_IN_USD);
                invoice.setORDER_AMOUNT(ORDER_AMOUNT);
                invoice.setORDER_CREATION_DATE(ORDER_CREATION_DATE);
                invoices.add(invoice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return invoices;
    }
}