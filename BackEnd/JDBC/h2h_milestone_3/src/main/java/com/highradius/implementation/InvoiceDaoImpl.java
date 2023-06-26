package com.highradius.implementation;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import com.highradius.connection.DatabaseConnection;
import com.highradius.model.Invoice;

public class InvoiceDaoImpl implements InvoiceDao  {
	
	@Override
	public List<Invoice> getInvoice(int start,int limit) throws ClassNotFoundException{
		// TODO Auto-generated method stub
		Connection con = DatabaseConnection.connect();
		List<Invoice> invoice = new ArrayList<Invoice>();
		
		String query = null;
		
		try {
			query = "SELECT * from h2h_oap LIMIT ?,?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, start);
			ps.setInt(2, limit);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Invoice ob = new Invoice(0,0,null,null,0,null,0.0,null,0,0.0);
				int Sl_no = rs.getInt("Sl_no");
                int CUSTOMER_ORDER_ID = rs.getInt("CUSTOMER_ORDER_ID");
                String SALES_ORG = rs.getString("SALES_ORG");
                String DISTRIBUTION_CHANNEL = rs.getString("DISTRIBUTION_CHANNEL");
                int COMPANY_CODE = rs.getInt("COMPANY_CODE");
                String ORDER_CREATION_DATE = rs.getString("ORDER_CREATION_DATE");
                String ORDER_CURRENCY = rs.getString("ORDER_CURRENCY");                
                int CUSTOMER_NUMBER = rs.getInt("CUSTOMER_NUMBER");
                double AMOUNT_IN_USD = rs.getDouble("AMOUNT_IN_USD");
                double ORDER_AMOUNT = rs.getDouble("ORDER_AMOUNT");
                
                ob.setSl_no(Sl_no);
                ob.setCUSTOMER_ORDER_ID(CUSTOMER_ORDER_ID);
                ob.setSALES_ORG(SALES_ORG);
                ob.setDISTRIBUTION_CHANNEL(DISTRIBUTION_CHANNEL);
                ob.setCOMPANY_CODE(COMPANY_CODE);
                ob.setORDER_CREATION_DATE(ORDER_CREATION_DATE);
                ob.setORDER_CURRENCY(ORDER_CURRENCY);
                ob.setCUSTOMER_NUMBER(CUSTOMER_NUMBER);
                ob.setAMOUNT_IN_USD(AMOUNT_IN_USD);
                ob.setORDER_AMOUNT(ORDER_AMOUNT);
                
                invoice.add(ob);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return invoice;
	}

	@Override
	public int insertInvoice(Invoice ob) throws ClassNotFoundException {
		Connection con = DatabaseConnection.connect();
		
		String query = null;
		int result = 0;
		
		try {
			query = "INSERT INTO h2h_oap(Sl_no, CUSTOMER_ORDER_ID, SALES_ORG, DISTRIBUTION_CHANNEL,COMPANY_CODE, ORDER_CREATION_DATE, ORDER_AMOUNT,ORDER_CURRENCY,CUSTOMER_NUMBER, AMOUNT_IN_USD) VALUES(?,?,?,?,?,?,?,?,?,?)";
			
				int Sl_no = ob.getSl_no();
                int CUSTOMER_ORDER_ID = ob.getCUSTOMER_ORDER_ID();
                String SALES_ORG = ob.getSALES_ORG();
                String DISTRIBUTION_CHANNEL = ob.getDISTRIBUTION_CHANNEL();
                int COMPANY_CODE = ob.getCOMPANY_CODE();
                String ORDER_CREATION_DATE = ob.getORDER_CREATION_DATE();
                String ORDER_CURRENCY = ob.getORDER_CURRENCY();         
                int CUSTOMER_NUMBER = ob.getCUSTOMER_NUMBER();
                double AMOUNT_IN_USD = ob.getAMOUNT_IN_USD();
                double ORDER_AMOUNT = ob.getORDER_AMOUNT();
                
                
    			PreparedStatement ps = con.prepareStatement(query);
    			
    			ps.setInt(1, Sl_no);
    			ps.setInt(2, CUSTOMER_ORDER_ID);
    			ps.setString(3, SALES_ORG);
    			ps.setString(4, DISTRIBUTION_CHANNEL);
    			ps.setInt(5, COMPANY_CODE);
    			ps.setString(6, ORDER_CREATION_DATE);
    			ps.setString(7, ORDER_CURRENCY);
    			ps.setInt(8, CUSTOMER_NUMBER);
    			ps.setDouble(9,AMOUNT_IN_USD);
    			ps.setDouble(10,ORDER_AMOUNT);
    			
    			
                result = ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateInvoice(int id, Invoice ob) throws ClassNotFoundException {
		Connection con = DatabaseConnection.connect();
		
		String query = null;
		int result = 0;
		
		try {
//			query = "UPDATE h2h_oap SET Sl_no=?, CUSTOMER_ORDER_ID=?, SALES_ORG=?, DISTRIBUTION_CHANNEL=?,COMPANY_CODE=?, ORDER_CREATION_DATE=?, ORDER_AMOUNT=?,ORDER_CURRENCY=?,CUSTOMER_NUMBER=?, AMOUNT_IN_USD=? where Sl_no = ?";
			query = "UPDATE h2h_oap SET COMPANY_CODE=?,ORDER_CURRENCY=?,DISTRIBUTION_CHANNEL=? where Sl_no = ?";
			
				int Sl_no = ob.getSl_no();
                int CUSTOMER_ORDER_ID = ob.getCUSTOMER_ORDER_ID();
                String SALES_ORG = ob.getSALES_ORG();
                String DISTRIBUTION_CHANNEL = ob.getDISTRIBUTION_CHANNEL();
                int COMPANY_CODE = ob.getCOMPANY_CODE();
                String ORDER_CREATION_DATE = ob.getORDER_CREATION_DATE();
                double ORDER_AMOUNT = ob.getORDER_AMOUNT();
                String ORDER_CURRENCY = ob.getORDER_CURRENCY(); 
                int CUSTOMER_NUMBER = ob.getCUSTOMER_NUMBER();
                double AMOUNT_IN_USD = ob.getAMOUNT_IN_USD();
                
                
                
    			PreparedStatement ps = con.prepareStatement(query);
    			
//    			ps.setInt(1, Sl_no);
//    			ps.setInt(2, CUSTOMER_ORDER_ID);
//    			ps.setString(3, SALES_ORG);
//    			ps.setString(4, DISTRIBUTION_CHANNEL);
//    			ps.setInt(5, COMPANY_CODE);
//    			ps.setString(6, ORDER_CREATION_DATE);
//    			ps.setString(7, ORDER_CURRENCY);
//    			ps.setInt(8, CUSTOMER_NUMBER);
//    			ps.setDouble(9,AMOUNT_IN_USD);
//    			ps.setDouble(10,ORDER_AMOUNT);
//    			ps.setInt(11, id);
    			
    			
    			ps.setInt(1, COMPANY_CODE);
    			ps.setString(2, ORDER_CURRENCY);
    			ps.setString(3, DISTRIBUTION_CHANNEL);
    			ps.setInt(4, id);
    			
    			
                result = ps.executeUpdate();
                System.out.println(ob.getSl_no());
                System.out.println(id);
                
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteInvoice(int id) throws ClassNotFoundException {
		Connection con = DatabaseConnection.connect();
		
		String query = null;
		int result = 0;
		
		try {
			query = "DELETE FROM h2h_oap WHERE CUSTOMER_ORDER_ID = ?";
				PreparedStatement ps = con.prepareStatement(query);
    			
    			ps.setInt(1, id);
    			result = ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
