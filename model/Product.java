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
	public /*@ pure @*/ abstract void validate() throws BusinessException;

	//@ ensures \result == this.id;
	public /*@ pure @*/ int getId() {
		return id;
	}

	//@ assignable this.id;
	//@ ensures this.id == id;
	public void setId(int id) {
		this.id = id;
	}

	//@ ensures \result == this.name;
	public /*@ pure @*/ String getName() {
		return name;
	}

	//@ assignable this.name;
	//@ ensures this.name == name;
	public void setName(String name) {
		this.name = name;
	}

	//@ ensures \result == this.description;
	public /*@ pure @*/ String getDescription() {
		return description;
	}

	//@ assignable this.description;
	//@ ensures this.description == description;
	public void setDescription(String description) {
		this.description = description;
	}

	//@ ensures \result == this.tags;
	public /*@ pure @*/ ArrayList<Tag> getTags() {
		return tags;
	}

	//@ assignable this.tags;
	//@ ensures this.tags == tags;
	public void setTags(ArrayList<Tag> tags) {
		this.tags = tags;
	}

	//@ ensures \result == this.price;
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
	//@ ensures this.price == price;
	public void setPrice(double price) {
		this.price = price;
	}

	//@ ensures \result == this.barcode;
	public /*@ pure @*/ String getBarcode() {
		return barcode;
	}

	//@ assignable this.barcode;
	//@ ensures this.barcode == barcode;
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	
	/*@ requires obj instanceof Product;
	@	ensures \result == (this.getId() == ((Product)obj).getId());
	@ also
	@ 	requires !(obj instanceof Product);
	@	ensures \result == super.equals(obj);
	@ */
	public boolean equals(Object obj) {
		if(obj instanceof Product) {
			return this.getId() == ((Product)obj).getId();
		}
		return super.equals(obj);
	}
}






