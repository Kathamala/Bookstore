package br.ufrn.imd.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.ufrn.imd.controller.Conection;
import br.ufrn.imd.model.Client;

public class ClientDAO {
	private Connection c;
	
	public ClientDAO() {
		this.c= new Conection().getCon();
	}
	
	public void adiciona(Client cl) {
		String sql="INSERT INTO public.client (cpf, name) VALUES (?, ?);";
		try {
			PreparedStatement stmt=c.prepareStatement(sql);
			stmt.setInt(1, cl.getCpf());
			stmt.setString(2, cl.getName());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
