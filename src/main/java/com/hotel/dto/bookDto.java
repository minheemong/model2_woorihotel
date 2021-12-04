package com.hotel.dto;

import java.sql.Timestamp;

public class bookDto {
	
	private String id;
	private int booknum;
	private String kind;
	private int usernum;
	private Timestamp checkin;
	private Timestamp checkout;
	private String result;
	private int price;
	
	// 추가
	private String name;
	private int bdseq;
	private int hotelnum;
	
	
	
	
	public int getHotelnum() {
		return hotelnum;
	}
	public void setHotelnum(int hotelnum) {
		this.hotelnum = hotelnum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBdseq() {
		return bdseq;
	}
	public void setBdseq(int bdseq) {
		this.bdseq = bdseq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getBooknum() {
		return booknum;
	}
	public void setBooknum(int booknum) {
		this.booknum = booknum;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public int getUsernum() {
		return usernum;
	}
	public void setUsernum(int usernum) {
		this.usernum = usernum;
	}
	public Timestamp getCheckin() {
		return checkin;
	}
	public void setCheckin(Timestamp checkin) {
		this.checkin = checkin;
	}
	public Timestamp getCheckout() {
		return checkout;
	}
	public void setCheckout(Timestamp checkout) {
		this.checkout = checkout;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
