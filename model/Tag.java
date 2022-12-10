package br.ufrn.imd.model;

public class Tag {
	
	private /*@ spec_public @*/ int id;
	private /*@ spec_public @*/ String name;
	
	public Tag() {
		super();
	}
	
	//@ ensures \result == this.id;
	public /*@ pure @*/ int getId() {
		return id;
	}
	
	//@ assignable this.id;
	//@ ensures this.id == id;
	public void setId(int id) {
		this.id = id;
	}
	
	//@ ensures \result == this.name;
	public /*@ pure @*/ String getName() {
		return name;
	}
	
	//@ assignable this.name;
	//@ ensures this.name == name;
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "id:"+id+" name: "+name;
	}
	
}
