package com.highradius.implementation;

import java.util.List;

import com.highradius.model.Invoice;

public interface InvoiceDao {
	public List<Invoice> getInvoice(int start,int limit) throws ClassNotFoundException;
	public int insertInvoice(Invoice ob) throws ClassNotFoundException;
	public int updateInvoice(int id,Invoice ob) throws ClassNotFoundException;
	public int deleteInvoice(int id) throws ClassNotFoundException;
}
