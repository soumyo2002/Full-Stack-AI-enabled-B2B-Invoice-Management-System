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
	
	public Invoice(int Sl_no, int CUSTOMER_ORDER_ID, String SALES_ORG, String DISTRIBUTION_CHANNEL, int COMPANY_CODE,
            String ORDER_CREATION_DATE, String ORDER_CURRENCY, int CUSTOMER_NUMBER, Double AMOUNT_IN_USD,  Double ORDER_AMOUNT) {
		super();
		this.Sl_no = Sl_no;
        this.CUSTOMER_ORDER_ID = CUSTOMER_ORDER_ID;
        this.SALES_ORG = SALES_ORG;
        this.DISTRIBUTION_CHANNEL = DISTRIBUTION_CHANNEL;
        this.COMPANY_CODE = COMPANY_CODE;
        this.ORDER_CREATION_DATE = ORDER_CREATION_DATE;
        this.ORDER_CURRENCY = ORDER_CURRENCY;
        this.CUSTOMER_NUMBER = CUSTOMER_NUMBER;
        this.AMOUNT_IN_USD = AMOUNT_IN_USD;
        this.ORDER_AMOUNT = ORDER_AMOUNT;
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
