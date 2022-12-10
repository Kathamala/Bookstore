package br.ufrn.imd.model;


public class Client {

	private /*@ spec_public @*/ int id;
	private /*@ spec_public @*/ String cpf;
	private /*@ spec_public @*/ String name;
	
	public Client() {
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

	//@ ensures \result == this.cpf;
	public /*@ pure @*/ String getCpf() {
		return cpf;
	}
	
	//@ assignable this.cpf;
	//@ ensures this.cpf == cpf;
	public void setCpf(String cpf) {
		this.cpf = cpf;
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
		return "Client [id=" + id + ", cpf=" + cpf + ", name=" + name + "]";
	}
}




