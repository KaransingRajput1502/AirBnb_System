package com.admin;

public class CreditCardDetails {
	
	private int cardNo;
	private double bal;
	
	private String cardValFrom;
	private String cardValTo;
	public double getBal() {
		return bal;
	}
	public void setBal(double d) {
		this.bal = d;
	}
	public int getCardNo() {
		return cardNo;
	}
	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}
	public String getCardValFrom() {
		return cardValFrom;
	}
	public void setCardValFrom(String cardValFrom) {
		this.cardValFrom = cardValFrom;
	}
	public String getCardValTo() {
		return cardValTo;
	}
	public void setCardValTo(String cardValTo) {
		this.cardValTo = cardValTo;
	}
	

}
