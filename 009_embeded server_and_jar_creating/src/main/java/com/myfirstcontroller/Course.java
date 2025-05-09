package com.myfirstcontroller;

public class Course {
	
	private long id;
	private String cname;
	private String tutor;
	
	
	public Course(long id, String cname, String tutor) {
		super();
		this.id = id;
		this.cname = cname;
		this.tutor = tutor;
	}
	public long getId() {
		return id;
	}
	public String getCname() {
		return cname;
	}
	public String getTutor() {
		return tutor;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", cname=" + cname + ", tutor=" + tutor + "]";
	}
	
	

	
}
