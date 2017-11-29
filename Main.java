package controllers;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		Usuario Pedro = new Usuario("pedro@gmail.com",1661,"Pedro",789,13,"20/04/2004","Estudante","Masculino");

		Pedro.mostrarCadastrados();
		
	ConexaoBD conexao = new ConexaoBD();
	conexao.conectar();
	conexao.desconectar();
	
	DAOUsuario usuario = new DAOUsuario();
	usuario.criarUsuario(Pedro);
	
		
	}

	
}