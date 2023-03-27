package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {

	/** Módulo de conexão **/
	// Parâmetros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/agenda";
	private String user = "root";
	private String password = "root123";

	// método de conexão
	private Connection conectar() {
		Connection con = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	// teste de conexão
	public void testeConexao() {
		try {
			Connection con = conectar();
			System.out.println(con);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// CRUD CREATE
	public void inserirContato(Cliente contato) {

		String create = "insert into contatos (nome,fone,email) values (?,?,?)";

		try {

			// abrir conexao
			Connection con = conectar();

			// preparar a query para execução do bd
			PreparedStatement pst = con.prepareStatement(create);

			// substituir os (?) por conteudo
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());

			// executar a query
			pst.executeUpdate();

			// encerrar a conexão com o banco
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// CRUD READ
	public ArrayList<Cliente> listarContatos() {

		// criando um array para acessar os objetos
		ArrayList<Cliente> contatos = new ArrayList<>();
		// definindo a query
		String read = "select * from contatos order by nome";

		try {
			// abrindo a conexao
			Connection con = conectar();

			// lib para preparar a query
			PreparedStatement pst = con.prepareStatement(read);

			// executando a query
			ResultSet rs = pst.executeQuery();

			// recebendo os dados dos objetos
			while (rs.next()) {
				// pegando cada coluna do objeto
				String idcon = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);
				// populando o arraylist
				contatos.add(new Cliente(idcon, nome, fone, email));
			}

			// fechando a conexao
			con.close();

			// retornando o arraylist
			return contatos;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	// SELECT
	public void selecionarContato(Cliente cliente) {

		// definindo a query
		String select = "select * from contatos where idcon = ?";

		try {
			// abrindo a conexao
			Connection con = conectar();

			// lib para preparar a query
			PreparedStatement pst = con.prepareStatement(select);
			pst.setString(1, cliente.getIdcon());

			// executando a query
			ResultSet rs = pst.executeQuery();

			// recebendo a linha do bd
			while (rs.next()) {
				// adicionando os atributos no objeto
				cliente.setIdcon(rs.getString(1));
				cliente.setNome(rs.getString(2));
				cliente.setFone(rs.getString(3));
				cliente.setEmail(rs.getString(4));
			}

			// fechando a conexao
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// CRUD UPDATE
	public void alterarContato(Cliente cliente) {

		// definindo a query
		String update = "update contatos set nome=?, fone=?, email=? where idcon=?";

		try {
			// abrindo a conexao
			Connection con = conectar();

			// lib para preparar a query
			PreparedStatement pst = con.prepareStatement(update);

			// substituir os (?) por conteudo
			pst.setString(1, cliente.getNome());
			pst.setString(2, cliente.getFone());
			pst.setString(3, cliente.getEmail());
			pst.setString(4, cliente.getIdcon());

			// executando a query
			pst.executeUpdate();

			// fechando a conexao
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// CRUD DELETE
	public void deletarContato(Cliente cliente) {

		// definindo a query
		String delete = "delete from contatos where idcon=?";

		try {
			// abrindo a conexao
			Connection con = conectar();

			// lib para preparar a query
			PreparedStatement pst = con.prepareStatement(delete);

			// substituir os (?) por conteudo
			pst.setString(1, cliente.getIdcon());

			// executando a query
			pst.executeUpdate();

			// fechando a conexao
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
