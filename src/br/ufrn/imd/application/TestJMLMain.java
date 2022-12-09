package br.ufrn.imd.application;

import br.ufrn.imd.business.ClientService;
import br.ufrn.imd.exceptions.BusinessException;
import br.ufrn.imd.exceptions.DataException;
import br.ufrn.imd.model.Client;
import br.ufrn.imd.model.ProductBook;
import br.ufrn.imd.model.ProductGame;
import br.ufrn.imd.model.ProductVinyl;

public class TestJMLMain {
	public static void main(String[] args) throws BusinessException, DataException {
		// Client		
		// Product	
		// ProductBook
		testProductBookValidate();
		// ProductGame
		testProductGameValidate();
		// ProductVinyl
		testProductVinykValidate();
		// Tag
		// Transaction
		
		// ClientService
		testAddClientService();
		testRetrieveClientByCpfService();
		
		// ProductService
		// TagService
		// TransactionService
		// RecommendationBook
		// RecommendationGame
		// RecommendationVinyl	
	}
	
	public static void testProductBookValidate() throws BusinessException, DataException {
		ProductBook pb = new ProductBook();
		pb.setBarcode("Barcode");
		pb.setDescription("Description");
		pb.setAuthor("Author");
		pb.setName("Name");
		pb.setPrice(12);
	}
	
	public static void testProductGameValidate() throws BusinessException, DataException {
		ProductGame pg = new ProductGame();
		pg.setPlatform("Platform");
		pg.setPublisher("Publisher");
		pg.setDescription("Description");
		pg.setName("Name");
		pg.setPrice(12);
		pg.validate();
	}	
	
	public static void testProductVinykValidate() throws BusinessException, DataException {
		ProductVinyl pv = new ProductVinyl();
		pv.setBand("Band");
		pv.setYear(2000);
		pv.setDescription("Description");
		pv.setName("Name");
		pv.setPrice(12);
		pv.validate();
	}		
	
	public static void testAddClientService() throws BusinessException, DataException {
		ClientService c = new ClientService();
		Client client = new Client();
		client.setName("Jorge");
		client.setCpf("70925215481");
		//c.addClient(client);
	}
	
	public static void testRetrieveClientByCpfService() {
		ClientService c = new ClientService();
		try {
			c.retrieveClientByCpf("70925215481");
			//c.retrieveClientByCpf("");
		} catch (BusinessException | DataException e) {
			e.printStackTrace();
		}
	}	
}










