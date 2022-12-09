package br.ufrn.imd.model;

import br.ufrn.imd.exceptions.BusinessException;

public class ProductGame extends Product{
	
	private /*@ spec_public @*/ String publisher;
	private /*@ spec_public @*/ String platform;
	
	public ProductGame() {
		super();
	}
	
	public /*@ pure @*/ String getPublisher() {
		return publisher;
	}

	//@ assignable this.publisher;
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public /*@ pure @*/ String getPlatform() {
		return platform;
	}

	//@ assignable this.platform;
	public void setPlatform(String platform) {
		this.platform = platform;
	}

	@Override
	public String toString() {
		return getName();//"id: "+id+" name: "+name + " barcode: "+barcode;//+" description: "+description+" tags: "+tags+" price: "+price+" author: "+author;
	}


	@Override
	//@ requires getPublisher() != null;
	//@ requires getPlatform() != null;	
	//@ requires getPublisher().length() < 63;
	//@ requires getPublisher().length() > 1;
	//@ requires getPlatform().length() < 63;
	//@ requires getPlatform().length() > 1;
	public void validate() throws BusinessException {
		/*
		String exceptions ="";
		if(getName().length() >= 63) {
			exceptions += "Nome do Jogo muito longo \n";
		}
		else if(getName().length() <= 1) {
			exceptions += "Nome do Jogo muito curto \n";
		}
		if(getPublisher().length() >= 63) {
			exceptions += "Nome da editora muito longo \n";
		}
		else if(getPublisher().length() <= 1) {
			exceptions += "Nome da editora muito curto \n";
		}
		if(getPlatform().length() >= 63) {
			exceptions += "Nome da plataforma muito longo \n";
		}
		else if(getPlatform().length() <= 1) {
			exceptions += "Nome da plataforma muito curto \n";
		}
		if(getPrice() < 0) {
			exceptions += "Preço do Jogo não pode ser negativo \n";
		}
		if(!exceptions.equals("")) {
			throw new BusinessException(exceptions);
		}*/
	}

}
