package controllers;

import controllers.Usuario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

public class DAOUsuario {
	
	private ConexaoBD conexao;
	
	public DAOUsuario() {
		// cria o objeto para conexão com banco, porém não o inicializa
		// a conexão deve ser aberta e, consequentemente, fechada durante o envio de comandos
		// ao banco
		this.conexao = new ConexaoBD();
	}
	
	public void criarUsuario(Usuario U) {
		// abrindo a conexão com o BD
		conexao.conectar();

		try {
			// usando um PreparedStatement com valores externos como parâmetros (representados pelo '?')
			PreparedStatement pst = conexao.getConexao().prepareStatement("insert into bd.usuario(id_usuario,nome,idade,data_nasc,sexo,profissao,email,senha) values(?,?,?,?,?,?,?,?)");
			// os métodos set devem ser escolhidos de acordo com os tipos dos atributos da entidade que está
			// sendo acessada. A sequência é determinada por índices, iniciando do valor 1.
			pst.setInt(1, U.getid_usuario());
			pst.setString(2, U.getnome());
			pst.setInt(3, U.getidade());
			pst.setString(4, U.getdata_nasc());
			pst.setString(5, U.getsexo());
			pst.setString(6, U.getprofissao());
			pst.setString(7, U.getemail());
			pst.setInt(8, U.getsenha());
			// solicitação da execução da query, após seu preparo
			pst.execute();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			// o banco deve ser desconectado, mesmo quando a exceção é lançada
			conexao.desconectar();
		}
		
	}
	
	
	 //busca de pessoas por seu código de identificação no banco (id)
	public Usuario buscarPessoa(int id_usuario) {
		// abrindo a conexão com o BD
		conexao.conectar();
		// busca utilizando o método de consulta do objeto ConexaoBD
		ResultSet resultado = conexao.executarSQL("select * from Usuario where id_usuario = \'" + id_usuario + "\'");
		Usuario U = new Usuario();
		
		try {
			resultado.next();
			// os métodos get devem ser escolhidos de acordo com os tipos dos atributos da entidade que está
			// sendo acessada
			id_usuario = resultado.getInt("id_usuario");
			String nome = resultado.getString("nome");
			int idade = resultado.getInt("idade");
			U.setid_usuario(id_usuario);
			U.setnome(nome);
			U.setidade(idade);
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			// o banco deve ser desconectado, mesmo quando a exceção é lançada
			conexao.desconectar();
		}
		return U;
	}
	
	public void excluirPessoa(int id_usuario) {
		// abrindo a conexão com o BD
		conexao.conectar();
		
		try {
			PreparedStatement stm = conexao.getConexao().prepareStatement("delete from Usuario where id_usuario = \'" + id_usuario + "\'");
			stm.execute();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			// o banco deve ser desconectado, mesmo quando a exceção é lançada
			conexao.desconectar();
		}
	}

	public void editarPessoa(int id_usuario, String nome, int idade) {
		// abrindo a conexão com o BD
		conexao.conectar();
		
		try {
			PreparedStatement stm = conexao.getConexao().prepareStatement("update Usuario set nome = ?, idade = ? "
					+ "where cod_pessoa = \'" + id_usuario + "\'");
			stm.setString(1, nome);
			stm.setInt(2, idade);
			stm.execute();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			// o banco deve ser desconectado, mesmo quando a exceção é lançada
			conexao.desconectar();
		}
	}
	
	public ArrayList<Usuario> verTodos() {
		ArrayList<Usuario> pessoas = new ArrayList<>();
		
		// abrindo a conexão com o BD
		conexao.conectar();
		ResultSet resultado = conexao.executarSQL("select * from Usuario");
		
		try {
			// para iterar sobre os resultados de uma consulta, deve-se utilizar o método next()
			while (resultado.next()) {
				int id_usuario = resultado.getInt("id_usuario");
				String nome = resultado.getString("nome");
				int idade = resultado.getInt("idade");
				Usuario.add(new Usuario(int id_usuario,String nome, int idade));
			}
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
		// o banco deve ser desconectado, mesmo quando a exceção é lançada
			conexao.desconectar();		}
		return Usuario;
	}

}