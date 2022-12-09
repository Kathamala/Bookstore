package br.ufrn.imd.model;

import br.ufrn.imd.exceptions.BusinessException;

//import java.util.HashSet;
public class ProductBook extends Product{

	public ProductBook(){
		super();
	}
	
	private /*@ spec_public @*/ String author;
	
	public /*@ pure @*/ String getAuthor() {
		return author;
	}
	
	//@ assignable this.author;
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Override
	public String toString() {
		return getName();
	}
	
	@Override
	//@ requires getAuthor() != null;
	//@ requires getAuthor().length() < 63;
	//@ requires getAuthor().length() > 1;
	public void validate() throws BusinessException {
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
