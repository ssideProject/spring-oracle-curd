package com.goodt.goodt.member.dto;

public class MemberVO {
	String name;
	String age;
	String id;
	String passwd;
	
	@Override
	public String toString() {
		return "MemberVO [name=" + name + ", age=" + age + ", id=" + id + ", passwd=" + passwd + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

}
