package br.ufrn.imd.model;

import java.util.ArrayList;

public class Transaction {
	private /*@ spec_public @*/ int id;
	private /*@ spec_public @*/ double value;
	private /*@ spec_public @*/ int client;
	private /*@ spec_public @*/ ArrayList<Integer> productsId;
	
	
	public Transaction() {
		super();
		this.productsId = new ArrayList<Integer>();
	}
	
	public /*@ pure @*/ int getId() {
		return id;
	}
	
	//@ assignable this.id;
	public void setId(int id) {
		this.id = id;
	}
	
	public /*@ pure @*/ double getValue() {
		return value;
	}
	
	//@ assignable this.value;
	public void setValue(double value) {
		this.value = value;
	}
	
	//@ assignable this.client;
	public void setClient(int client) {
		this.client = client;
	}
	
	public /*@ pure @*/ int getClient() {
		return this.client;
	}
	
	public /*@ pure @*/ ArrayList<Integer> getProductsId() {
		return productsId;
	}
	
	//@ assignable this.productsId;
	public void setProductsId(ArrayList<Integer> products) {
		this.productsId = products;
	}
	
	@Override
	public String toString() {
		return "id: "+id+ " client: " + client + " value: "+value+ " products: "+ productsId;
	}
	
}
