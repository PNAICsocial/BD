package controllers;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private int id_usuario;
	private String nome;
	private String email;
	private int senha;
	private int idade;
	private String data_nasc;
	private String profissao;
	private String sexo;


static List <Usuario> Cadastrados = new ArrayList<>();
List <String> Mensagens = new ArrayList<>();
List <String> MensagensEnviadas = new ArrayList<>();
List <Usuario> Amigos = new ArrayList<>();

public Usuario(String email,int senha,String nome,int id_usuario,int idade,String data_nasc,String profissao,String sexo) {
	this.email = email;
	this.senha = senha;
	this.nome = nome;
	this.id_usuario = id_usuario;
	this.idade = idade;
	this.data_nasc = data_nasc;
	this.profissao = profissao;
	this.sexo = sexo;
	Usuario.this.cadastrar(this);
}

public Usuario(){}

public String getnome() {
	return nome;
}

public void setnome(String nome) {
	this.nome = nome;
}

public String getemail() {
	return email;
}

public void setemail(String email) {
	this.email = email;
}

public int getsenha() {
	return senha;
}

public void setsenha(int senha) {
	this.senha = senha;
}

public int getid_usuario() {
	return id_usuario;
}

public void setid_usuario(int id_usuario) {
	this.id_usuario = id_usuario;
}

public int getidade() {
	return idade;
}

public void setidade(int idade) {
	this.idade = idade;
}

public String getdata_nasc() {
	return data_nasc;
}

public void setdata_nasc(String data_nasc) {
	this.data_nasc = data_nasc;
}

public String getprofissao() {
	return profissao;
}

public void setprofissao(String profissao) {
	this.profissao = profissao;
}

public String getsexo() {
	return sexo;
}

public void setsexo(String sexo) {
	this.sexo = sexo;
}

public void cadastrar(Usuario x) {
	Cadastrados.add(x);
}

public void mostrarCadastrados() {
	for (Usuario x : Cadastrados) {
		System.out.println(x);
	
}

}
public String toString() {
	return "\nE-Mail: " + email + "\nSenha: "+ senha + "\nNome:" + nome + "\nid_usuario:" + id_usuario + "\nIdade:" + idade;
	
}

public static void add(Usuario usuario) {
	// TODO Auto-generated method stub
	
}

}