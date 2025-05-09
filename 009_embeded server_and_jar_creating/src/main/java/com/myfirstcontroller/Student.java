package com.myfirstcontroller;

public class Student {
	long id;
	String Name;
	String enroll;
	public Student(long id, String name, String enroll) {
		super();
		this.id = id;
		this.Name = name;
		this.enroll = enroll;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}
	/**
	 * @return the enroll
	 */
	public String getEnroll() {
		return enroll;
	}
	/**
	 * @param enroll the enroll to set
	 */
	public void setEnroll(String enroll) {
		this.enroll = enroll;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", Name=" + Name + ", enroll=" + enroll + "]";
	}
	
	

}
