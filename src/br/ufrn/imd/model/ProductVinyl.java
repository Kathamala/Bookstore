package br.ufrn.imd.model;

import br.ufrn.imd.exceptions.BusinessException;

public class ProductVinyl extends Product{

	public ProductVinyl(){
		super();
	}
	
	private /*@ spec_public @*/ String band;
	private /*@ spec_public @*/ Integer year;
	
	//@ ensures \result == this.band;
	public /*@ pure @*/ String getBand() {
		return band;
	}

	//@ assignable this.band;
	//@ ensures this.band == band;
	public void setBand(String band) {
		this.band = band;
	}

	//@ ensures \result == this.year;
	public /*@ pure @*/ Integer getYear() {
		return year;
	}

	//@ assignable this.year;
	//@ ensures this.year == year;
	public void setYear(int year) {
		this.year = year;
	}

	@Override
	//@ ensures \result == getName();
	public String toString() {
		return getName();//"id: "+id+" name: "+name + " barcode: "+barcode;//+" description: "+description+" tags: "+tags+" price: "+price+" author: "+author;
	}

	@Override
	//@ requires this.getBand() != null;
	//@ requires this.getBand().length() < 63;
	//@ requires this.getBand().length() > 1;
	//@ requires this.getYear().intValue() < 2022;
	//@ requires this.getYear().intValue() > 1940;
	public /*@ pure @*/ void validate() throws BusinessException {
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
