package br.ufrn.imd.application;

import br.ufrn.imd.business.ClientService;
import br.ufrn.imd.business.ProductService;
import br.ufrn.imd.exceptions.BusinessException;
import br.ufrn.imd.exceptions.DataException;
import br.ufrn.imd.model.Client;
import br.ufrn.imd.model.ProductBook;
import br.ufrn.imd.model.ProductGame;
import br.ufrn.imd.model.ProductVinyl;
import br.ufrn.imd.model.recommendation.WeightProduct;

public class TestJMLMain {
	public static void main(String[] args) throws BusinessException, DataException {
		// Client		
		// Product	
		testProductEquals();
		// ProductBook
		testProductBookValidate();
		// ProductGame
		testProductGameValidate();
		// ProductVinyl
		testProductVinykValidate();
		// Tag
		// Transaction
		// WeightProduct
		testWeightProductCompareTo();
		// WeightTag		
		
		// ClientService
		testAddClient();
		testRetrieveClientByCpf();
		testUpdateClient();
		testListClients();
		testRetrieveClientById();
		
		// ProductService
		//testAddProduct();
		//testUpdateProduct();
		testListProducts();
		testRetrieveProductById();
		//testRetrieveProductByBarcode();
		
		// TagService
		// TransactionService
		// RecommendationBook
		// RecommendationGame
		// RecommendationVinyl	
	}
	
	public static void testProductEquals() throws BusinessException, DataException {
		ProductBook pb = new ProductBook();
		ProductBook pb2 = new ProductBook();
		pb.equals(pb);
		pb.equals(pb2);
	}
	
	public static void testProductBookValidate() throws BusinessException, DataException {
		ProductBook pb = new ProductBook();
		pb.setBarcode("7092521548123");
		pb.setDescription("Description");
		pb.setAuthor("Author");
		pb.setName("Name");
		pb.setPrice(12);
		pb.validate();
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
	
	public static void testWeightProductCompareTo() throws BusinessException, DataException {
		WeightProduct wp = new WeightProduct(12, new ProductBook());
		WeightProduct wp2 = new WeightProduct(23, new ProductBook());
		wp.compareTo(wp2);
		
		wp = new WeightProduct(23, new ProductBook());
		wp2 = new WeightProduct(12, new ProductBook());
		wp.compareTo(wp2);
		
		wp = new WeightProduct(12, new ProductBook());
		wp.compareTo(wp2);			
	}
	
	public static void testAddClient() throws BusinessException, DataException {
		ClientService c = new ClientService();
		Client client = new Client();
		client.setName("Jorge");
		client.setCpf("70925215481");
		//c.addClient(client);
	}
	
	public static void testRetrieveClientByCpf() {
		ClientService c = new ClientService();
		try {
			c.retrieveClientByCpf("70925215481");
			//c.retrieveClientByCpf("");
		} catch (BusinessException | DataException e) {
			e.printStackTrace();
		}
	}	
	
	public static void testUpdateClient() {
		ClientService c = new ClientService();
		Client client = new Client();
		client.setCpf("12345678912");
		client.setName("Jorge");
		try {
			c.updateClient(client);
		} catch (BusinessException | DataException e) {
			e.printStackTrace();
		}
	}		
	
	public static void testListClients() throws DataException {
		ClientService c = new ClientService();
		c.listClients();
	}	
	
	public static void testRetrieveClientById() throws BusinessException, DataException {
		ClientService c = new ClientService();
		c.retrieveClientById(1);
	}		
	
	public static void testAddProduct() throws BusinessException, DataException {
		ProductService ps = new ProductService();
		ProductBook pb = new ProductBook();
		pb.setBarcode("7092521548123");
		pb.setDescription("Description");
		pb.setAuthor("Author");
		pb.setName("Name");
		pb.setPrice(12);
		ps.addProduct(pb);
	}		
	
	public static void testUpdateProduct() throws BusinessException, DataException {
		ProductService ps = new ProductService();
		ProductBook pb = new ProductBook();
		pb.setBarcode("7092521548123");
		pb.setDescription("Description");
		pb.setAuthor("Author");
		pb.setName("Name");
		pb.setPrice(12);
		ps.updateProduct(pb);
	}	
	
	public static void testListProducts() throws BusinessException, DataException {
		ProductService ps = new ProductService();
		ps.listProducts();
	}

	public static void testRetrieveProductById() throws BusinessException, DataException {
		ProductService ps = new ProductService();
		ps.retrieveProductById(1);
	}
	
	public static void testRetrieveProductByBarcode() throws BusinessException, DataException {
		ProductService ps = new ProductService();
		ps.retrieveProductByBarcode("Barcode");
	}
}










