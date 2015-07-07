package Entities;

import java.util.Vector;

public class Funcionario extends Pessoa {
	
	private int salario;
	private String cargo;
	private String gerente;
	private String departamento;
	
	// CONSTRUTOR:
	public Funcionario(String cpf, String nome, String email, Imagem foto,
			Endereco endereco, int salario,
			String cargo, String gerente, String departamento) {
		super(cpf, nome, email, foto, endereco);
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

	public String getGerente() {
		return gerente;
	}

	public void setGerente(String gerente) {
		this.gerente = gerente;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
}
