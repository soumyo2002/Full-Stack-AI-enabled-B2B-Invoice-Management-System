
//import java.util.List;
//import com.highradius.model.Invoice;
//
//import java.util.ArrayList;
//
//public class DatabaseConnection {
//	static List<Invoice> invoiceLst = new ArrayList<Invoice>();
//
//	public static List<Invoice> getAllInvoices() {
//		return invoiceLst;
//	}
//
//	public static void addInvoice(Invoice i) {
//		invoiceLst.add(i);
//	}
//}
package com.highradius.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.highradius.model.Invoice;

public class DatabaseConnection {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/hrc_db";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "nitya";

    public static Connection connect() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
//    static List<Invoice> invoiceLst = new ArrayList<Invoice>();

//	public static List<Invoice> getInvoices() {
//		return invoiceLst;
//	}
//
//	public static void addInvoice(Invoice i) {
//		invoiceLst.add(i);
//	}
}
