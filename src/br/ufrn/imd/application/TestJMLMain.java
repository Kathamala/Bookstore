package br.ufrn.imd.application;

import br.ufrn.imd.business.ClientService;
import br.ufrn.imd.business.ProductService;
import br.ufrn.imd.exceptions.BusinessException;
import br.ufrn.imd.exceptions.DataException;
import br.ufrn.imd.model.Client;
import br.ufrn.imd.model.ProductBook;
import br.ufrn.imd.model.ProductGame;
import br.ufrn.imd.model.ProductVinyl;
import br.ufrn.imd.model.Tag;
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
		testRemoveClient();
		testAddClient();
		testRetrieveClientByCpf();
		testUpdateClient();
		testListClients();
		testRetrieveClientById();
		
		// ProductService
		testRemoveProduct();
		testAddProduct();
		testUpdateProduct();
		testListProducts();
		testRetrieveProductById();
		testRetrieveProductByBarcode();
		
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
	
	public static void testRemoveClient() throws BusinessException, DataException {
		ClientService c = new ClientService();
		Client client = c.retrieveClientByCpf("99999999999");
		c.removeClient(client);
	}
	
	public static void testAddClient() throws BusinessException, DataException {
		ClientService c = new ClientService();
		Client client = new Client();
		client.setName("Jorges");
		client.setCpf("99999999999");
		c.addClient(client);
	}
	
	public static void testRetrieveClientByCpf() {
		ClientService c = new ClientService();
		try {
			c.retrieveClientByCpf("99999999999");
			//c.retrieveClientByCpf("");
		} catch (BusinessException | DataException e) {
			e.printStackTrace();
		}
	}	
	
	public static void testUpdateClient() throws BusinessException, DataException {
		ClientService c = new ClientService();
		Client client = c.retrieveClientByCpf("99999999999");
		client.setName("Jorge");
		c.updateClient(client);
	}		
	
	public static void testListClients() throws DataException {
		ClientService c = new ClientService();
		c.listClients();
	}	
	
	public static void testRetrieveClientById() throws BusinessException, DataException {
		ClientService c = new ClientService();
		c.retrieveClientById(1);
	}		
	
	public static void testRemoveProduct() throws BusinessException, DataException {
		ProductService ps = new ProductService();
		ProductBook pb = (ProductBook) ps.retrieveProductByBarcode("9999999999999");
		ps.removeProduct(pb);
	}		
	
	public static void testAddProduct() throws BusinessException, DataException {
		ProductService ps = new ProductService();
		ProductBook pb = new ProductBook();
		pb.setBarcode("9999999999999");
		pb.setDescription("Description");
		pb.setAuthor("Author");
		pb.setName("Name");
		pb.setPrice(12);
		ps.addProduct(pb);
	}		
	
	public static void testUpdateProduct() throws BusinessException, DataException {
		ProductService ps = new ProductService();
		ProductBook pb = (ProductBook) ps.retrieveProductByBarcode("9999999999999");
		pb.setDescription("Description Up");
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
		ps.retrieveProductByBarcode("7092521548123");
	}
}










