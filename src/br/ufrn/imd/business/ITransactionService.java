package br.ufrn.imd.business;

import java.util.ArrayList;
import java.util.List;

import br.ufrn.imd.exceptions.BusinessException;
import br.ufrn.imd.exceptions.DataException;
import br.ufrn.imd.model.Transaction;

public interface ITransactionService {
	//@ requires transaction.value > 0;
	//@ requires transaction.getProductsId().size() > 0;
	public void addTransaction(Transaction transaction) throws DataException, BusinessException;
	
	public void removeTransaction();
	
	//@ requires retrieveTransactionById(transaction.getId()).getId() != 0;
	public void updateTransaction(Transaction transaction) throws DataException, BusinessException;
	
	public /*@ pure @*/ List<Transaction> listTransactions() throws DataException;
	//@ requires client > 0;
	public /*@ pure @*/ ArrayList<Transaction> retrieveTransactionsByClient(int client) throws BusinessException, DataException;
	//@ requires id > 0;
	//@ ensures \result != null;
	public /*@ pure @*/ Transaction retrieveTransactionById(int id) throws BusinessException, DataException;	
}
