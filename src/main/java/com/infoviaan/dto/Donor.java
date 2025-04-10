package com.infoviaan.dto;

public class Donor {
	private String name;
	private int age;
	private String bloodgroup;
	private boolean diseas;
	private String gender;
	private String mobile;

	public Donor() {
		// TODO Auto-generated constructor stub
	}

	public Donor(String name, int age, String bloodgroup, boolean diseas, String gender, String mobile) {
		this.name = name;
		this.age = age;
		this.bloodgroup = bloodgroup;
		this.diseas = diseas;
		this.gender = gender;
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBloodgroup() {
		return bloodgroup;
	}

	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}

	public boolean isDiseas() {
		return diseas;
	}

	public void setDiseas(boolean diseas) {
		this.diseas = diseas;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}