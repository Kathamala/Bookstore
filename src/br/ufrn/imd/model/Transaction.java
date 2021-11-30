package br.ufrn.imd.model;

import java.util.ArrayList;

public class Transaction {
	private int id;
	private double value;
	private ArrayList<Book> books;
	
	
	public Transaction() {
		super();
		this.books = new ArrayList<Book>();
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public ArrayList<Book> getBooks() {
		return books;
	}
	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}
	
	
}
