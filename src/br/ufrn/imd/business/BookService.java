package br.ufrn.imd.business;

import java.util.ArrayList;

import br.ufrn.imd.data.BookDAOJDBC;
import br.ufrn.imd.exceptions.BusinessException;
import br.ufrn.imd.exceptions.DataException;
import br.ufrn.imd.model.Book;
import br.ufrn.imd.model.Tag;

public class BookService implements IBookService {

	@Override
	public void addBook(Book bo) throws BusinessException, DataException {
		String exceptions = "";
		if(retrieveBookByBarcode(bo.getBarcode()).getBarcode() != null) {
			exceptions += "C�digo de barras j� foi cadastrado em outro livro \n";
		}
		if(bo.getName().length() >= 63) {
			exceptions += "Nome do livro muito longo \n";
		}
		else if(bo.getName().length() <= 1) {
			exceptions += "Nome do livro muito curto \n";
		}
		if(bo.getAuthor().length() >= 63) {
			exceptions += "Nome do(a) autor(a) muito longo \n";
		}
		else if(bo.getAuthor().length() <= 1) {
			exceptions += "Nome do(a) autor(a) muito curto \n";
		}
		if(bo.getPrice() < 0) {
			exceptions += "Pre�o do livro n�o pode ser negativo \n";
		}
		ITagService tagService = new TagService();
		for(Tag tag: bo.getTags()) {
			if(tagService.retrieveTagById(tag.getId()).getName() == null) {
				exceptions += "Tag inexistente \n";
			}
		}
		if(!exceptions.equals("")) {
			throw new BusinessException(exceptions);
		}
		new BookDAOJDBC().addBook(bo);
	}

	@Override
	public void removeBook() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateBook(Book bo) throws DataException, BusinessException{
		String exceptions = "";
		Book book = retrieveBookByBarcode(bo.getBarcode());
		if(bo.getId() != book.getId() && book.getBarcode()!= null) {
			System.out.println(retrieveBookById(bo.getId()).getId());
			if(retrieveBookById(bo.getId()).getId()==0) {
				exceptions += "Livro inexistente \n";
			}
			else {
				exceptions += "C�digo de barras j� foi cadastrado em outro livro \n";
			}
		}
		if(bo.getName().length() >= 63) {
			exceptions += "Nome do livro muito longo \n";
		}
		else if(bo.getName().length() <= 1) {
			exceptions += "Nome do livro muito curto \n";
		}
		if(bo.getAuthor().length() >= 63) {
			exceptions += "Nome do(a) autor(a) muito longo \n";
		}
		else if(bo.getAuthor().length() <= 1) {
			exceptions += "Nome do(a) autor(a) muito curto \n";
		}
		if(bo.getPrice() < 0) {
			exceptions += "Pre�o do livro n�o pode ser negativo \n";
		}
		ITagService tagService = new TagService();
		for(Tag tag: bo.getTags()) {
			if(tagService.retrieveTagById(tag.getId()).getName() == null) {
				exceptions += "Tag inexistente \n";
			}
		}
		if(!exceptions.equals("")) {
			throw new BusinessException(exceptions);
		}
		new BookDAOJDBC().updateBook(bo);

	}

	@Override
	public ArrayList<Book> listBooks() throws DataException {
		return new BookDAOJDBC().listBooks();
	}

	@Override
	public Book retrieveBookById(int id) throws BusinessException, DataException {
		if(id < 1) {
			throw new BusinessException("id deve ser um n�mero maior do que 0 \n");
		}
		return new BookDAOJDBC().retrieveBookById(id);
	}

	@Override
	public Book retrieveBookByBarcode(String barcode) throws BusinessException, DataException {
		String exceptions = "";
		if(!barcode.matches("[0-9]+")) {
			exceptions += "O c�digo de barras deve conter somente n�meros \n";
		}
		if(barcode.length()!= 13) {
			exceptions += "O c�digo de barras deve conter exatamente 13 n�meros \n";
		}
		if(!exceptions.equals("")) {
			throw new BusinessException(exceptions);
		}		
		return new BookDAOJDBC().retrieveBookByBarcode(barcode);
	}

}
