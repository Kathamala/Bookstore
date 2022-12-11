package br.ufrn.imd.model;

import br.ufrn.imd.exceptions.BusinessException;

//import java.util.HashSet;
public class ProductBook extends Product{

	public ProductBook(){
		super();
	}
	
	private /*@ spec_public @*/ String author;
	
	//@ ensures \result == this.author;
	public /*@ pure @*/ String getAuthor() {
		return author;
	}
	
	//@ assignable this.author;
	//@ ensures this.author == author;
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Override
	//@ ensures \result == getName();
	public /*@ pure @*/ String toString() {
		return getName();
	}
	
	@Override
	//@ requires this.getAuthor() != null;
	//@ requires this.getAuthor().length() < 63;
	//@ requires this.getAuthor().length() > 1;
	public /*@ pure @*/ void validate() throws BusinessException {
		/*
		String exceptions ="";
		if(getName().length() >= 63) {
			exceptions += "Nome do livro muito longo \n";
		}
		else if(getName().length() <= 1) {
			exceptions += "Nome do livro muito curto \n";
		}
		if(getAuthor().length() >= 63) {
			exceptions += "Nome do(a) autor(a) muito longo \n";
		}
		else if(getAuthor().length() <= 1) {
			exceptions += "Nome do(a) autor(a) muito curto \n";
		}
		if(getPrice() < 0) {
			exceptions += "Preço do livro não pode ser negativo \n";
		}
		if(!exceptions.equals("")) {
			throw new BusinessException(exceptions);
		}*/
	}
}
