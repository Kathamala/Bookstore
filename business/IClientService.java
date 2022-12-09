package br.ufrn.imd.business;

import java.util.List;

import br.ufrn.imd.exceptions.BusinessException;
import br.ufrn.imd.exceptions.DataException;
import br.ufrn.imd.model.Client;

public interface IClientService {
	
	//@ requires client.getCpf() != null;
	//@ requires client.getName() != null;
	//@ requires client.getName().length() >= 2;
	//@ requires client.getName().length() <= 64;
	public void addClient(Client client) throws BusinessException, DataException;
	
	public void removeClient(Client client) throws BusinessException, DataException;
	
	public void updateClient(Client client) throws DataException, BusinessException;
	
	public List<Client> listClients() throws DataException;
	
	public Client retrieveClientById(int id) throws DataException, BusinessException;
	
	//@ requires cpf != null;
	//@ requires cpf != "";
	//@ requires cpf.matches("[0-9]+");
	//@ requires cpf.length() == 11;
	public Client retrieveClientByCpf(String cpf) throws DataException, BusinessException;
}
