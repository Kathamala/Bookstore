package br.ufrn.imd.model;


public class Client {

	private /*@ spec_public @*/ int id;
	private /*@ spec_public @*/ String cpf;
	private /*@ spec_public @*/ String name;
	
	public Client() {
		super();
	}

	public /*@ pure @*/ int getId() {
		return id;
	}

	//@ assignable this.id;
	public void setId(int id) {
		this.id = id;
	}

	public /*@ pure @*/ String getCpf() {
		return cpf;
	}
	
	//@ assignable this.cpf;
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public /*@ pure @*/ String getName() {
		return name;
	}
	
	//@ assignable this.name;
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", cpf=" + cpf + ", name=" + name + "]";
	}
}




