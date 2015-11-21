package com.rest.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;




@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Bankdb {
	@Id
	private long account_no ;
	private long account_pass;
	private long blance;
	private String account_name;
	
	
	public long getBlance() {
		return blance;
	}
	public void setBlance(long blance) {
		this.blance = blance;
	}
	public long getAccount_pass() {
		return account_pass;
	}
	public void setAccount_pass(long account_pass) {
		this.account_pass = account_pass;
	}
	public long getAccount_no() {
		return account_no;
	}
	public void setAccount_no(long acc_no) {
		this.account_no = acc_no;
	}
	public String getAccount_name() {
		return account_name;
	}
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	
	
}
