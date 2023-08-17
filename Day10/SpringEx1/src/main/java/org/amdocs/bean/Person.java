package org.amdocs.bean;

public class Person {

	
	private int personid;
	private String personname;
	private Address address;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}

	
	
	public Person(String personname) {
		super();
		this.personname = personname;
	}


	public Person(int personid) {
		//super();
		this.personid = personid;
	}


	
	public Person(int personid, String personname) {
		
		this.personid = personid;
		this.personname = personname;
	}

	

	public Person(int personid, String personname, Address address) {
		
		this.personid = personid;
		this.personname = personname;
		this.address = address;
	}


	@Override
	public String toString() {
		return "Person [personid=" + personid + ", personname=" + personname + ", address=" + address + "]";
	}

	
	
}
