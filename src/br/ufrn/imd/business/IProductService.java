package br.ufrn.imd.business;

import java.util.List;

import br.ufrn.imd.exceptions.BusinessException;
import br.ufrn.imd.exceptions.DataException;
import br.ufrn.imd.model.Product;

public interface IProductService {
	//@ requires ((retrieveProductByBarcode(product.getBarcode())).getBarcode() == null);
	public void addProduct(Product product) throws BusinessException, DataException;
	
	public void removeProduct(Product product) throws DataException, BusinessException;
	
	//@ requires product.getId() == retrieveProductByBarcode(product.getBarcode()).getId() || retrieveProductByBarcode(product.getBarcode()).getBarcode() == null;
	public void updateProduct(Product product)throws DataException, BusinessException;
	
	public /*@ pure @*/ List<? extends Product> listProducts()throws DataException;
	
	//@ requires id >= 1;
	public /*@ pure @*/ Product retrieveProductById(int id)throws BusinessException, DataException;
	
	//@ requires barcode != null;
	//@ requires barcode.matches("[0-9]+");
	//@ requires barcode.length() == 13;
	public /*@ pure @*/ Product retrieveProductByBarcode(String barcode)throws BusinessException, DataException;
}
