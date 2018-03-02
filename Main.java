package controllers;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		DAOUsuario conexao = new DAOUsuario();
		Usuario U = new Usuario("larryce@hotmail", 123, "larryce", 1323, 16, "31/10", "estudante", "feminino");
		//conexao.criarUsuario(U);
		//conexao.editarPessoa("larryce",232,"larryce", 1323,16,"31/10/2001", "estudante", "feminino");
		Usuario aux = conexao.login("larryce@hotmail", 123);
		
		if (aux == null){
			System.out.println("Você não está logado!");
		}
		else {
			System.out.println("Você está logado!");
			Usuario buscandousuario = conexao.buscarPessoa("lucas@gmail.com"); 
			System.out.println(buscandousuario.toString());
			conexao.addamigo(aux.getid_usuario(), buscandousuario.getid_usuario());
			conexao.verTodos(buscandousuario.getid_usuario());
			conexao.excluirPessoa(buscandousuario.getid_usuario());
		}
		
		
		
	}
}
