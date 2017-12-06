package controllers;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		DAOUsuario conexao = new DAOUsuario();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite seu e-mail: ");
		String email = sc.next();
		
		int senha = 0;
		boolean senhaInvalida = true;
		
		while(senhaInvalida) {
		
		try{
			System.out.println("Digite sua senha: ");
			senha = sc.nextInt();
			sc.next();
			senhaInvalida = false;
		} catch(InputMismatchException e){
			System.out.println("Senha inválida! Digite apenas números.");
			System.out.println("Digite sua senha: ");
			sc.next();
		}
		System.out.println("Digite seu nome: ");
		String nome = sc.next();
		System.out.println("Digite seu id de usuário: ");
		int id_usuario = sc.nextInt();
		System.out.println("Digite sua idade: ");
		int idade = sc.nextInt();
		System.out.println("Digite sua data de nascimento: ");
		String data_nasc = sc.next();
		System.out.println("Digite sua profissão: ");
		String profissao = sc.next();
		System.out.println("Digite seu sexo: ");
		String sexo = sc.next();
		
		Usuario U = new Usuario(email, senha, nome, id_usuario, idade, data_nasc, profissao, sexo);
		conexao.criarUsuario(U);
		U.mostrarCadastrados();	
	}
}
}