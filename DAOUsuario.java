package controllers;

import controllers.Usuario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

public class DAOUsuario {
	private ConexaoBD conexao;

	public DAOUsuario() {
		this.conexao = new ConexaoBD();
	}

	public void criarUsuario(Usuario U) {
		conexao.conectar();

		try {
			PreparedStatement pst = conexao.getConexao().prepareStatement("insert into bd.usuario(id_usuario,nome,idade,data_nasc,sexo,profissao,email,senha) values(?,?,?,?,?,?,?,?)");
			pst.setInt(1, U.getid_usuario());
			pst.setString(2, U.getnome());
			pst.setInt(3, U.getidade());
			pst.setString(4, U.getdata_nasc());
			pst.setString(5, U.getsexo());
			pst.setString(6, U.getprofissao());
			pst.setString(7, U.getemail());
			pst.setInt(8, U.getsenha());
			pst.execute();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			conexao.desconectar();
		}

	}

	public Usuario buscarPessoa(String email) {
		conexao.conectar();
		ResultSet resultado = conexao.executarSQL("select * from bd.usuario where email= \'" + email + "\'");
		Usuario usuario = null;

		try {
			while (resultado.next()) {
				int id_usuario = resultado.getInt(1);
				String nome = resultado.getString(2);
				int idade = resultado.getInt(3);
				String data_nasc = resultado.getString(4);
				String sexo = resultado.getString(5);
				String profissao = resultado.getString(6);
				String email1 = resultado.getString(7);
				int senha = resultado.getInt(8);

				usuario = new Usuario(email1, senha, nome, id_usuario, idade, data_nasc, profissao, sexo);
			}
			resultado.next();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			conexao.desconectar();
		}
		return usuario;
	}

	public void excluirPessoa(int id_usuario) {
		conexao.conectar();

		try {
			PreparedStatement stm = conexao.getConexao().prepareStatement("delete from bd.usuario where id_usuario = \'" + id_usuario + "\'");
			stm.execute();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			conexao.desconectar();
		}
	}

	public void editarPessoa(String email, int senha, String nome, int id_usuario, int idade, String data_nasc,
			String profissao, String sexo) {
		conexao.conectar();

		try {

			PreparedStatement stm = conexao.getConexao().prepareStatement(
					"update bd.usuario set email = ?, senha = ?, nome = ?, idade = ?, data_nasc = ?, profissao = ?, sexo = ? "
							+ "where id_usuario = \'" + id_usuario + "\'");
			stm.setString(1, email);
			stm.setInt(2, senha);
			stm.setString(3, nome);
			stm.setInt(4, idade);
			stm.setString(5, data_nasc);
			stm.setString(6, profissao);
			stm.setString(7, sexo);
			stm.execute();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			conexao.desconectar();
		}
	}

	public ArrayList<Usuario> verTodos() {
		ArrayList<Usuario> pessoas = new ArrayList<>();

		conexao.conectar();
		ResultSet resultado = conexao.executarSQL("select * from Usuario");

		try {
			while (resultado.next()) {
				String email = resultado.getString("email");
				int senha = resultado.getInt("senha");
				String nome = resultado.getString("nome");
				int id_usuario = resultado.getInt("id_usuario: ");
				int idade = resultado.getInt("idade");
				String data_nasc = resultado.getString("data_nasc");
				String profissao = resultado.getString("profissao");
				String sexo = resultado.getString("sexo");
				pessoas.add(new Usuario(email, senha, nome, id_usuario, idade, data_nasc, profissao, sexo));
			}
			resultado.next();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			conexao.desconectar();
		}
		return pessoas;
	}

	public Usuario login(String email, int senha) {
		Usuario teste = null;

		conexao.conectar();
		ResultSet resultado = conexao
				.executarSQL("select * from bd.usuario where email= '" + email + "' and senha= " + senha);
		try {
			resultado.next();
			int id_usuario = resultado.getInt("id_usuario");
			String nome = resultado.getString("nome");
			int idade = resultado.getInt("idade");
			String data_nasc = resultado.getString("data_nasc");
			String sexo = resultado.getString("sexo");
			String profissao = resultado.getString("profissao");
			String email1 = resultado.getString("email");
			int senha1 = resultado.getInt("senha");

			teste = new Usuario(email1, senha1, nome, id_usuario, idade, data_nasc, profissao, sexo);
		} catch (Exception e) {
			System.out.println("Usuário ou senha incorretos. Tente novamente.");
		} finally {
			conexao.desconectar();
		}
		return teste;

	}

	public void addamigo(int id_usuario, int id_amigo) {
		conexao.conectar();

		try {
			PreparedStatement pst = conexao.getConexao()
					.prepareStatement("insert into bd.amigos(id_usuario,id_amigo) values(?,?)");
			pst.setInt(1, id_usuario);
			pst.setInt(2, id_amigo);
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		conexao.desconectar();
	}
}
