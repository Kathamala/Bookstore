package br.ufrn.imd.model;

import br.ufrn.imd.exceptions.BusinessException;

public class ProductVinyl extends Product{

	public ProductVinyl(){
		super();
	}
	
	private /*@ spec_public @*/ String band;
	private /*@ spec_public @*/ Integer year;
	
	public /*@ pure @*/ String getBand() {
		return band;
	}

	//@ assignable this.band;
	public void setBand(String band) {
		this.band = band;
	}

	public /*@ pure @*/ Integer getYear() {
		return year;
	}

	//@ assignable this.year;
	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return getName();//"id: "+id+" name: "+name + " barcode: "+barcode;//+" description: "+description+" tags: "+tags+" price: "+price+" author: "+author;
	}

	@Override
	//@ requires getBand() != null;
	//@ requires getBand().length() < 63;
	//@ requires getBand().length() > 1;
	//@ requires getYear().intValue() < 2022;
	//@ requires getYear().intValue() > 1940;
	public void validate() throws BusinessException {
		/*
		String exceptions ="";
		if(getName().length() >= 63) {
			exceptions += "Nome do livro muito longo \n";
		}
		else if(getName().length() <= 1) {
			exceptions += "Nome do livro muito curto \n";
		}
		if(getBand().length() >= 63) {
			exceptions += "Nome da banda muito longo \n";
		}
		else if(getBand().length() <= 1) {
			exceptions += "Nome da banda muito curto \n";
		}
		if(getPrice() < 0) {
			exceptions += "Preço do vinil não pode ser negativo \n";
		}
		if(getYear() >= 2022 || getYear() <= 1940) {
			exceptions += "Ano invalido, precisa ser entre 1940-2022 \n";
		}
		if(!exceptions.equals("")) {
			throw new BusinessException(exceptions);
		}*/
	}

}
