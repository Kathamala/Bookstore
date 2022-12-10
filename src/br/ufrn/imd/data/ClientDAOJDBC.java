package br.ufrn.imd.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.ufrn.imd.data.connection.ConnectionJDBC;
import br.ufrn.imd.exceptions.DataException;
import br.ufrn.imd.model.Client;

public class ClientDAOJDBC implements ClientDAO{

	private Connection connection;
	
	public ClientDAOJDBC() {
		this.connection= ConnectionJDBC.getInstance().getCon();
	}

	@Override
	public void addClient(Client client) throws DataException{
		String sql="INSERT INTO public.client (cpf, name) VALUES (?, ?);";
		try {
			PreparedStatement stmt=connection.prepareStatement(sql);
			stmt.setString(1, client.getCpf());
			stmt.setString(2, client.getName());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new DataException("Erro ao tentar inserir o cliente no banco de dados \n");
			//e.printStackTrace();
		}
		//System.out.println("Cliente inserido com sucesso!");
	}

	@Override
	public void removeClient(Client client) throws DataException {
		String sql = "DELETE FROM public.client WHERE id="+client.getId();
		try {
			PreparedStatement stmt=connection.prepareStatement(sql);
			stmt.execute();
			stmt.close();
		} catch(Exception e) {
			//e.printStackTrace();
			throw new DataException("Erro ao remover o cliente do banco de dados \n");
		}
		
	}


	@Override
	public void updateClient(Client client) throws DataException{
		String sql="UPDATE public.client SET cpf = (?), name = (?) WHERE id="+client.getId();
		try {
			PreparedStatement stmt=connection.prepareStatement(sql);
			stmt.setString(1, client.getCpf());
			stmt.setString(2, client.getName());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DataException("Erro ao tentar atualizar o cliente no banco de dados \n");
		}
	}

	@Override
	public /*@ pure @*/ List<Client> listClients() throws DataException {
		
		List<Client> listClients = new ArrayList<Client>();
		
		try {
			String sql = "SELECT * FROM public.client";
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			ResultSet resultSet = stmt.executeQuery();
			
			while(resultSet.next()) {
				Client client = new Client();
				client.setId(resultSet.getInt("id"));
				client.setCpf(resultSet.getString("cpf"));
				client.setName(resultSet.getString("name"));
				listClients.add(client);
			}
			stmt.close();
			
		} catch (Exception e) {
			throw new DataException("Erro ao tentar listar os clientes armazenados no banco de dados \n");
			//e.printStackTrace();
		}
		return listClients;
	}

	@Override
	public /*@ pure @*/ Client retrieveClientById(int id) throws DataException{
		try {
			String clientSql = "SELECT * FROM public.client WHERE id="+id;
			PreparedStatement prepstmt = connection.prepareStatement(clientSql);
			ResultSet result = prepstmt.executeQuery();
			Client client = new Client();
			while(result.next()) {
				client.setId(result.getInt("id"));
				client.setName(result.getString("name"));
				client.setCpf(result.getString("cpf"));
			}
			prepstmt.close();
			return client;
		}
		catch (Exception e) {
			//e.printStackTrace();
			throw new DataException("Erro ao tentar pegar o cliente usando a id \n");
			//return null;
		}
		
	}
	
	@Override
	public /*@ pure @*/ Client retrieveClientByCpf(String cpf) throws DataException {
		try {
			String clientSql = "SELECT * FROM public.client WHERE cpf='"+cpf+"'" ;
			PreparedStatement prepstmt = connection.prepareStatement(clientSql);
			ResultSet result = prepstmt.executeQuery();
			Client client = new Client();
			while(result.next()) {
				client.setId(result.getInt("id"));
				client.setName(result.getString("name"));
				client.setCpf(result.getString("cpf"));
			}
			prepstmt.close();
			return client;
		}
		catch (Exception e) {
			throw new DataException("Erro ao tentar pegar o cliente usando o CPF \n");
			//e.printStackTrace();
			//return null;
		}
		
	}
	
	
	
	
	
}