package br.ufrn.imd.data;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.ufrn.imd.data.connection.ConnectionJDBC;
import br.ufrn.imd.exceptions.DataException;
import br.ufrn.imd.model.Product;
import br.ufrn.imd.model.ProductBook;
import br.ufrn.imd.model.Tag;

public class ProductBookDAOJDBC extends ProductDAOJDBC{
	
	private Connection connection;

	public ProductBookDAOJDBC() {
		this.connection= ConnectionJDBC.getInstance().getCon();
	}
	
	@Override
	public void addProduct(Product product) throws DataException {
		ProductBook productBook = (ProductBook) product; 
		String sql="INSERT INTO public.book (description, price, author, name, tags, barcode) VALUES (?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt=connection.prepareStatement(sql);
			//stmt.setInt(1, bo.getId());
			stmt.setString(1, productBook.getDescription());
			stmt.setDouble(2, productBook.getPrice());
			stmt.setString(3, productBook.getAuthor());
			stmt.setString(4, productBook.getName());
			Array tempArray = connection.createArrayOf("INTEGER", productBook.getTagsId().toArray());
			stmt.setArray(5, tempArray);
			stmt.setString(6, productBook.getBarcode());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new DataException("Erro ao tentar inserir o livro no banco de dados \n");
			//e.printStackTrace();
		}
		
	}
	
	@Override
	public void removeProduct(Product product) throws DataException{
		String sql = "DELETE FROM public.book WHERE id="+product.getId();
		try {
			PreparedStatement stmt=connection.prepareStatement(sql);
			stmt.execute();
			stmt.close();
		} catch(Exception e) {
			//e.printStackTrace();
			throw new DataException("Erro ao remover o livro do banco de dados \n");
		}
	}
	
	@Override
	public void updateProduct(Product product) throws DataException{
		ProductBook productBook = (ProductBook) product;
		String sql="UPDATE public.book SET description = (?), price = (?), author = (?), name = (?), tags = (?), barcode = (?) WHERE id="+productBook.getId();
		try {
			PreparedStatement stmt=connection.prepareStatement(sql);
			//stmt.setInt(1, bo.getId());
			stmt.setString(1, productBook.getDescription()); 
			stmt.setDouble(2, productBook.getPrice());
			stmt.setString(3, productBook.getAuthor());
			stmt.setString(4, productBook.getName());
			Array tempArray = connection.createArrayOf("INTEGER", productBook.getTagsId().toArray());
			stmt.setArray(5, tempArray);
			stmt.setString(6, productBook.getBarcode());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new DataException("Erro ao tentar atualizar o livro no banco de dados \n");
			//e.printStackTrace();
		}
	}
	
	@Override
	public List<? extends Product> listProducts() throws DataException{
		ArrayList<Product> listBooks = new ArrayList<Product>();
		
		try {
			TagDAOJDBC tagDAOJDBC = new TagDAOJDBC();
			String sql = "SELECT * FROM public.book";
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			ResultSet resultSet = stmt.executeQuery();
			
			while(resultSet.next()) {
				ProductBook book = new ProductBook();
				
				book.setId(resultSet.getInt("id"));
				book.setName(resultSet.getString("name"));
				book.setAuthor(resultSet.getString("author"));
				book.setDescription(resultSet.getString("description"));
				book.setPrice(resultSet.getDouble("price"));
				book.setBarcode(resultSet.getString("barcode"));
				Integer[] tempArray = (Integer[])resultSet.getArray("tags").getArray();
				ArrayList<Tag> localTags = new ArrayList<Tag>();
				for(Integer i:tempArray) {
					Tag tag = tagDAOJDBC.retrieveTagById(i);
					if(tag != null) {
						localTags.add(tag);
					}
				}
				book.setTags(localTags);
				listBooks.add(book);
			}
			stmt.close();
			
		} catch (Exception e) {
			//e.printStackTrace();
			throw new DataException("Erro ao tentar listar os livros armazenados no banco de dados \n");
		}
		
		return (List<Product>)listBooks;
	}
	
	@Override
	public Product retrieveProductById(int id) throws DataException{
		try {
			TagDAOJDBC tagDAOJDBC = new TagDAOJDBC();
			String bookSql = "SELECT * FROM public.book WHERE id="+id;
			PreparedStatement prepstmt = connection.prepareStatement(bookSql);
			ResultSet result = prepstmt.executeQuery();
			ProductBook book = new ProductBook();
			while(result.next()) {
				book.setId(result.getInt("id"));
				book.setName(result.getString("name"));
				book.setPrice(result.getDouble("price"));
				book.setAuthor(result.getString("author"));
				book.setBarcode(result.getString("barcode"));
				book.setDescription(result.getString("description"));
				Integer[] tempArray = (Integer[])result.getArray("tags").getArray();
				ArrayList<Tag> localTags = new ArrayList<Tag>();
				for(Integer i:tempArray) {
					Tag tag = tagDAOJDBC.retrieveTagById(i);
					if(tag != null) {
						localTags.add(tag);
					}
				}
				book.setTags(localTags);
			}
			
			prepstmt.close();
			return book;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new DataException("Erro ao tentar recuperar o livro usando id \n");
		}
	}

	@Override
	public Product retrieveProductByBarcode(String barcode) throws DataException{
		try {
			TagDAOJDBC tagDAOJDBC = new TagDAOJDBC();
			String bookSql = "SELECT * FROM public.book WHERE barcode='"+barcode+"'";
			PreparedStatement prepstmt = connection.prepareStatement(bookSql);
			ResultSet result = prepstmt.executeQuery();
			ProductBook book = new ProductBook();
			while(result.next()) {
				book.setId(result.getInt("id"));
				book.setName(result.getString("name"));
				book.setPrice(result.getDouble("price"));
				book.setAuthor(result.getString("author"));
				book.setBarcode(result.getString("barcode"));
				book.setDescription(result.getString("description"));
				Integer[] tempArray = (Integer[])result.getArray("tags").getArray();
				ArrayList<Tag> localTags = new ArrayList<Tag>();
				for(Integer i:tempArray) {
					Tag tag = tagDAOJDBC.retrieveTagById(i);
					if(tag != null) {
						localTags.add(tag);
					}
				}
				book.setTags(localTags);
			}
			prepstmt.close();
			return book;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new DataException("Erro ao tentar recuperar o livro usando o c�digo de barras \n");
			//return null;
		}
	}
}
