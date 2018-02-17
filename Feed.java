package controllers;
import java.util.ArrayList;
import java.util.List;

public class Feed {
		private int id_usuario;
		private String nome;
		private String email;
		private String postagem;


	static List <Feed> postagens = new ArrayList<>();
	List <String> postagensenviadas = new ArrayList<>();
	
	public Feed (String email, String nome,int id_usuario, String postagem) {
		this.email = email;
		this.senha = senha;
		this.nome = nome;
		this.id_usuario = id_usuario;
		this.idade = idade;
		this.postagem = postagem;
		Feed.this.postar(this);
	}
public Feed(){}

public int getId_usuario() {
	return id_usuario;
}
public void setId_usuario(int id_usuario) {
	this.id_usuario = id_usuario;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPostagem() {
	return postagem;
}
public void setPostagem(String postagem) {
	this.postagem = postagem;
}
public static List<Feed> getPostagens() {
	return postagens;
}
public static void setPostagens(List<Feed> postagens) {
	Feed.postagens = postagens;
}

public void postar() {
	for (Feed x : postagens) {
		System.out.println(x);
	
}
}
}
