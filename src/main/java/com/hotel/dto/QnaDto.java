package com.hotel.dto;

import java.sql.Timestamp;

public class QnaDto {
	private String title; 
	private String content;	
	private Timestamp indate;
	private String id; 
	private String reply;
	private String rep;
	private Integer qnaseq;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public void setIndate(Timestamp  indate) {
		this.indate = indate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getRep() {
		return rep;
	}
	public void setRep(String rep) {
		this.rep = rep;
	}
	public Integer getQnaseq() {
		return qnaseq;
	}
	public void setQnaseq(Integer qnaseq) {
		this.qnaseq = qnaseq;
	}
}
