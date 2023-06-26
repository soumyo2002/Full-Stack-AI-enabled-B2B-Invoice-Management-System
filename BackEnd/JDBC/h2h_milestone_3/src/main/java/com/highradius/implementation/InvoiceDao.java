package com.highradius.implementation;
import java.util.List;

import com.highradius.model.Invoice;

public interface InvoiceDao {
	public void insertInvoice(Invoice i);
	public void updateInvoice(int customerOrderID, Invoice i);
	public void deleteInvoice(int customerOrderID);
	public List<Invoice> getAllInvoices();
}
