package br.ufrn.imd.model;

import java.util.ArrayList;

public class Transaction {
	private /*@ spec_public @*/ int id;
	private /*@ spec_public @*/ double value;
	private /*@ spec_public @*/ int client;
	private /*@ spec_public @*/ ArrayList<Integer> productsId;
	
	//@ public invariant productsId != null;
	
	public Transaction() {
		super();
		this.productsId = new ArrayList<Integer>();
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
	
	//@ ensures \result == this.value;
	public /*@ pure @*/ double getValue() {
		return value;
	}
	
	//@ assignable this.value;
	//@ ensures this.value == value;
	public void setValue(double value) {
		this.value = value;
	}
	
	//@ assignable this.client;
	//@ ensures this.client == client;
	public void setClient(int client) {
		this.client = client;
	}
	
	//@ ensures \result == this.client;
	public /*@ pure @*/ int getClient() {
		return this.client;
	}
	
	//@ ensures \result == this.productsId;
	public /*@ pure @*/ ArrayList<Integer> getProductsId() {
		return productsId;
	}
	
	//@ assignable this.productsId;
	//@ ensures this.productsId == products;
	public void setProductsId(ArrayList<Integer> products) {
		this.productsId = products;
	}
	
	@Override
	public /*@ pure @*/ String toString() {
		return "id: "+id+ " client: " + client + " value: "+value+ " products: "+ productsId;
	}
	
}
