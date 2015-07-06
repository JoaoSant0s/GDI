package Entities;

import java.util.Vector;

public class Cliente extends Pessoa {
	private String tipoEmprego;

	// CONSTRUTOR:
	public Cliente(String cPF, String nome, String email, Imagem foto,
			Endereco endereco, String tipoEmprego) {
		super(cPF, nome, email, foto, endereco);
		this.tipoEmprego = tipoEmprego;
	}

	// GETTERS AND SETTERS:
	public String getTipoEmprego() {
		return tipoEmprego;
	}

	public void setTipoEmprego(String tipoEmprego) {
		this.tipoEmprego = tipoEmprego;
	}
	
	
}
