package Entities;

import java.util.Vector;

public class Funcionario extends Pessoa {
	
	private double salario;
	private String cargo;
	private Gerente gerente;
	private Departamento departamento;
	
	// CONSTRUTOR:
	public Funcionario(String cPF, String nome, String email, Imagem foto,
			Endereco endereco, Vector<String> telefones, int salario,
			String cargo, Gerente gerente, Departamento departamento) {
		super(cPF, nome, email, foto, endereco, telefones);
		this.salario = salario;
		this.cargo = cargo;
		this.gerente = gerente;
		this.departamento = departamento;
	}

	//GETTERS AND SETTERS:
	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
}
