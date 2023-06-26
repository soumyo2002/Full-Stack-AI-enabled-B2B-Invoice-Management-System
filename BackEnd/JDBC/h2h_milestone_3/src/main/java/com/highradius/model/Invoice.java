package com.highradius.model;

public class Invoice {
	private int Sl_no;
	private int CUSTOMER_ORDER_ID;
    private String SALES_ORG;
    private String DISTRIBUTION_CHANNEL;
    private int COMPANY_CODE;
    private String ORDER_CREATION_DATE;
    private Double ORDER_AMOUNT;
    private String ORDER_CURRENCY;
    private int CUSTOMER_NUMBER;
    private Double AMOUNT_IN_USD;
	public Invoice(int sl_no, int cUSTOMER_ORDER_ID, String sALES_ORG, String dISTRIBUTION_CHANNEL, int cOMPANY_CODE,
			String oRDER_CREATION_DATE, Double oRDER_AMOUNT, String oRDER_CURRENCY, int cUSTOMER_NUMBER,
			Double aMOUNT_IN_USD) {
		super();
		Sl_no = sl_no;
		CUSTOMER_ORDER_ID = cUSTOMER_ORDER_ID;
		SALES_ORG = sALES_ORG;
		DISTRIBUTION_CHANNEL = dISTRIBUTION_CHANNEL;
		COMPANY_CODE = cOMPANY_CODE;
		ORDER_CREATION_DATE = oRDER_CREATION_DATE;
		ORDER_AMOUNT = oRDER_AMOUNT;
		ORDER_CURRENCY = oRDER_CURRENCY;
		CUSTOMER_NUMBER = cUSTOMER_NUMBER;
		AMOUNT_IN_USD = aMOUNT_IN_USD;
	}
	public int getSl_no() {
		return Sl_no;
	}
	public void setSl_no(int sl_no) {
		Sl_no = sl_no;
	}
	public int getCUSTOMER_ORDER_ID() {
		return CUSTOMER_ORDER_ID;
	}
	public void setCUSTOMER_ORDER_ID(int cUSTOMER_ORDER_ID) {
		CUSTOMER_ORDER_ID = cUSTOMER_ORDER_ID;
	}
	public String getSALES_ORG() {
		return SALES_ORG;
	}
	public void setSALES_ORG(String sALES_ORG) {
		SALES_ORG = sALES_ORG;
	}
	public String getDISTRIBUTION_CHANNEL() {
		return DISTRIBUTION_CHANNEL;
	}
	public void setDISTRIBUTION_CHANNEL(String dISTRIBUTION_CHANNEL) {
		DISTRIBUTION_CHANNEL = dISTRIBUTION_CHANNEL;
	}
	public int getCOMPANY_CODE() {
		return COMPANY_CODE;
	}
	public void setCOMPANY_CODE(int cOMPANY_CODE) {
		COMPANY_CODE = cOMPANY_CODE;
	}
	public String getORDER_CREATION_DATE() {
		return ORDER_CREATION_DATE;
	}
	public void setORDER_CREATION_DATE(String oRDER_CREATION_DATE) {
		ORDER_CREATION_DATE = oRDER_CREATION_DATE;
	}
	public Double getORDER_AMOUNT() {
		return ORDER_AMOUNT;
	}
	public void setORDER_AMOUNT(Double oRDER_AMOUNT) {
		ORDER_AMOUNT = oRDER_AMOUNT;
	}
	public String getORDER_CURRENCY() {
		return ORDER_CURRENCY;
	}
	public void setORDER_CURRENCY(String oRDER_CURRENCY) {
		ORDER_CURRENCY = oRDER_CURRENCY;
	}
	public int getCUSTOMER_NUMBER() {
		return CUSTOMER_NUMBER;
	}
	public void setCUSTOMER_NUMBER(int cUSTOMER_NUMBER) {
		CUSTOMER_NUMBER = cUSTOMER_NUMBER;
	}
	public Double getAMOUNT_IN_USD() {
		return AMOUNT_IN_USD;
	}
	public void setAMOUNT_IN_USD(Double aMOUNT_IN_USD) {
		AMOUNT_IN_USD = aMOUNT_IN_USD;
	}
	
	
	
	
}
