package com.gms.web.domain;

import java.io.Serializable;

public class MemberBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id, password, name, ssn, regdate, phone, email, major, subject, profile;
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public void setId (String id){
		this.id =id;
	}
	public void setPassword (String password){
			this.password =password;
	}
	public void setSsn (String ssn){
			this.ssn =ssn;
	}
	public String getName(){
			return name;
	}
	public String getId(){
			return id;
	}
	public String getPassword(){
			return password;
	}
	public String getSsn(){
			return ssn;
	}
	public String toString(){
			return "이름: "+name+" 아이디: "+id+" 비밀번호: "+password+" 주민번호: "+ssn+regdate+"\n";
	}
	}
