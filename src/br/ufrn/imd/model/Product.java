package br.ufrn.imd.model;

import java.util.ArrayList;

import br.ufrn.imd.exceptions.BusinessException;

public abstract class Product {
	private /*@ spec_public @*/ int id;
	private /*@ spec_public @*/ String name;
	private /*@ spec_public @*/ String description;
	private /*@ spec_public @*/ ArrayList<Tag> tags;
	private /*@ spec_public @*/ double price;
	private /*@ spec_public @*/ String barcode;
	
	public Product() {
		this.tags = new ArrayList<Tag>();
	}
	
	//@ requires getName() != null;
	//@ requires getName().length() < 63;
	//@ requires getName().length() > 1;
	//@ requires getPrice() >= 0;
	public abstract void validate() throws BusinessException;

	public /*@ pure @*/ int getId() {
		return id;
	}

	//@ assignable this.id;
	public void setId(int id) {
		this.id = id;
	}

	public /*@ pure @*/ String getName() {
		return name;
	}

	//@ assignable this.name;
	public void setName(String name) {
		this.name = name;
	}

	public /*@ pure @*/ String getDescription() {
		return description;
	}

	//@ assignable this.description;
	public void setDescription(String description) {
		this.description = description;
	}

	public /*@ pure @*/ ArrayList<Tag> getTags() {
		return tags;
	}

	//@ assignable this.tags;
	public void setTags(ArrayList<Tag> tags) {
		this.tags = tags;
	}

	public /*@ pure @*/ double getPrice() {
		return price;
	}

	public /*@ pure @*/ ArrayList<Integer> getTagsId() {
		ArrayList<Integer> tempArray = new ArrayList<Integer>();
		for (Tag tag : tags) {
			tempArray.add(tag.getId());
		}
		return tempArray;
	}
	
	//@ assignable this.price;
	public void setPrice(double price) {
		this.price = price;
	}

	public /*@ pure @*/ String getBarcode() {
		return barcode;
	}

	//@ assignable this.barcode;
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Product) {
			return this.getId() == ((Product)obj).getId();
		}
		return super.equals(obj);
	}
	
}
