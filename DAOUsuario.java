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
	
	public ArrayList<Usuario> buscarPessoa(String n) {
		conexao.conectar();
		ResultSet resultado = conexao.executarSQL("select * from Usuario where nome = \'" + n + "\'");
		ArrayList<Usuario> usuario = new ArrayList<>();
		
		try {
			while (resultado.next()){
				String email = resultado.getString(1);
				int senha = resultado.getInt(2);
				String nome = resultado.getString(3);
				int id_usuario = resultado.getInt(4);
				int idade = resultado.getInt(5);
				String data_nasc = resultado.getString(6);
				String profissao = resultado.getString(7);
				String sexo = resultado.getString(8);
				Usuario u = new Usuario(email, senha, nome, id_usuario, idade, data_nasc, profissao, sexo);
				usuario.add(u);
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
			PreparedStatement stm = conexao.getConexao().prepareStatement("delete from Usuario where id_usuario = \'" + id_usuario + "\'");
			stm.execute();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			conexao.desconectar();
		}
	}

	public void editarPessoa(String email, int senha, String nome, int id_usuario, int idade, String data_nasc, String profissao, String sexo) {
		conexao.conectar();
		
		try {
			while (resultado.next()){
				PreparedStatement stm = conexao.getConexao().prepareStatement("update Usuario set email = ?, senha = ?, nome = ?, idade = ?, data_nasc = ?, profissao = ?, sexo = ? "
						+ "where id_pessoa = \'" + id_usuario + "\'");
				stm.setString(1, email);
				stm.setInt(2, senha);
				stm.setInt(3, nome);
				stm.setInt(4, id_usuario);
				stm.setInt(5, idade);
				stm.setInt(6, data_nasc);
				stm.setInt(7, profissao);
				stm.setInt(8, sexo);
				stm.set
				stm.execute();
			}
			resultado.next();
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
				String email = resultado.getString("email:");
				int senha = resultado.getInt("senha:");
				String nome = resultado.getString("nome:");
				int id_usuario = resultado.getInt("id usuario:");
				int idade = resultado.getInt("idade:");
				String data_nasc = resultado.getString("data de nascimento:");
				String profissao = resultado.getString("profissao:");
				String sexo = resultado.getString("sexo:");
				pessoas.add(new Usuario(email, senha, nome, id_usuario, idade, data_nasc, profissao, sexo));
			}
			resultado.next();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			conexao.desconectar();		}
		return pessoas;
	}
}
