package Entities;

import java.util.Vector;

public class Pessoa {
	private String CPF;
	private String nome;
	private String email;
	//private String data_nascimento;
	private Imagem foto;
	private Endereco endereco;
	//private Vector<Telefone> telefones;
	
	// CONSTRUTORES
	public Pessoa(String cPF, String nome, String email, Imagem foto,
			Endereco endereco) {
		super();
		CPF = cPF;
		this.nome = nome;
		this.email = email;
		this.foto = foto;
		this.endereco = endereco;
		//this.telefones = telefones;
	}

	// GETTERS AND SETTERS:
	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
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

	public Imagem getFoto() {
		return foto;
	}

	public void setFoto(Imagem foto) {
		this.foto = foto;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

//	public Vector<String> getTelefones() {
//		return telefones;
//	}
//
//	public void setTelefones(Vector<String> telefones) {
//		this.telefones = telefones;
//	}
}
