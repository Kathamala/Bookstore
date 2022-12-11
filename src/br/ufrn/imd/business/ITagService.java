package br.ufrn.imd.business;

import java.util.List;

import br.ufrn.imd.exceptions.BusinessException;
import br.ufrn.imd.exceptions.DataException;
import br.ufrn.imd.model.Tag;

public interface ITagService {

	//@ requires retrieveTagByName(tag.getName()).getName()==null;
	public void addTag(Tag tag) throws BusinessException, DataException;
	//@ requires tag.getId() > 0;
	public void removeTag(Tag tag) throws BusinessException, DataException;
	//@ requires tag.getId() > 0;
	//@ requires retrieveTagByName(tag.getName()).getName()==null;
	public void updateTag(Tag tag)throws BusinessException, DataException;
	
	public /*@ pure @*/ List<Tag> listTags() throws DataException;
	
	//@ requires id > 0;
	public /*@ pure @*/ Tag retrieveTagById(int id) throws DataException, BusinessException;
	//@ requires name.length() > 0;
	//@ requires name.length() <= 32;
	public /*@ pure @*/ Tag retrieveTagByName(String name) throws DataException, BusinessException;
}
