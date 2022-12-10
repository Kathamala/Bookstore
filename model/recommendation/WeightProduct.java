package br.ufrn.imd.model.recommendation;

import br.ufrn.imd.model.Product;

public class WeightProduct implements Comparable<WeightProduct>{
	private /*@ spec_public @*/ int weight;
	private /*@ spec_public @*/ Product product;
	
	//@ assignable this.weight;
	//@ assignable this.product;
	public WeightProduct(int weight, Product product) {
		this.weight = weight;
		this.product = product;
	}
	
	//@ ensures \result == this.weight;
	public /*@ pure @*/ int getWeight() {
		return weight;
	}
	
	//@ assignable this.weight;
	//@ ensures this.weight == weight;
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	//@ ensures \result == this.product;
	public /*@ pure @*/ Product getProduct() {
		return product;
	}
	
	//@ assignable this.product;
	//@ ensures this.product == product;
	public void setProduct(Product product) {
		this.product = product;
	}
	
	@Override
	/*@ requires this.weight>o.weight;
	@ 	ensures \result == 1;
	@ also
	@ 	requires this.weight < o.weight;
	@ 	ensures \result == -1;
	@ also
	@	requires this.weight == o.weight;
	@ 	ensures \result == 0;
	@ */
	public int compareTo(WeightProduct o) {
		if(this.weight>o.weight) {
			return 1;
		}
		else if(this.weight < o.weight) {
			return -1;
		}
		else {
			return 0;
		}
	}
	
	@Override
	public String toString() {
		return "Weight: "+ weight+" Name: "+product.getName();
	}
	
}
