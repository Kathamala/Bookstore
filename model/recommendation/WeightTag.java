package br.ufrn.imd.model.recommendation;

import br.ufrn.imd.model.Tag;

public class WeightTag {
	private /*@ spec_public @*/ int weight;
	private /*@ spec_public @*/ Tag tag;
	
	//@ assignable this.tag;
	//@ assignable this.weight;
	public WeightTag(Tag tag) {
		this.tag = tag;
		this.weight = 1;
	}
	
	//@ ensures \result == this.tag;
	public /*@ pure @*/ Tag getTag() {
		return tag;
	}

	//@ assignable this.tag;
	//@ ensures this.tag == tag;
	public void setTag(Tag tag) {
		this.tag = tag;
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
	
	@Override
	public String toString() {
		return "Weight: "+weight+ " id: "+tag.getId();
	}
}
