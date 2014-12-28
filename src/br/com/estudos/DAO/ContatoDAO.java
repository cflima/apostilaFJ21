package br.com.estudos.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.estudos.modelo.Contato;

public class ContatoDAO {

	Connection connection;
	Conexao con;

	public void inserir(Contato contato) {

		try {
			
			this.connection = con.getConnection();

			String query = "INSERT INTO contato (nome,email,endereco,dtNascimento) VALUES(?,?,?,?)";

			PreparedStatement stmt;
			stmt = connection.prepareStatement(query);

			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setString(4,contato.getDtNascimento());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public List<Contato> lista() {

		List<Contato> listaContatos = new ArrayList<Contato>();

		try {
			this.connection = con.getConnection();

			String query = "SELECT * FROM contato";

			PreparedStatement stmt = connection.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Contato contato = new Contato();
				contato.setId(rs.getInt("contato_id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				listaContatos.add(contato);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return listaContatos;
	}

	public void alterarContato(Contato contato) {

		try {
			this.connection = con.getConnection();

			String query = "UPDATE  contato set nome=?, email=?, endereco=? WHERE contato_id =? ";

			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setInt(1, contato.getId());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setInt(4, contato.getId());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void excluirContato(Integer id) {

		try {
			this.connection = con.getConnection();

			String query = "DELETE from contato WHERE contato_id = ?";

			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setInt(1, id);

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
