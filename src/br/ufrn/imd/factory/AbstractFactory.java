package br.ufrn.imd.factory;

import br.ufrn.imd.data.ProductDAOJDBC;
import br.ufrn.imd.data.connection.ConnectionStrings;

public interface AbstractFactory {

	ProductDAOJDBC createProductDAO();
	ConnectionStrings createConnectionStrings();
	//When created add the method for creating the base GUI.
	//Recommendation won't need one because it's already based on the Window being called.
}
