package Repositories;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.imageio.ImageIO;

import Entities.Endereco;
import Entities.Funcionario;
import Entities.Imagem;

public class RepositorioFuncionario {
	private Connection con;

	public RepositorioFuncionario(Connection con){
		this.con = con;
	}

	public Vector<Funcionario> getFuncionarios() throws SQLException, IOException{

		Statement st = con.createStatement();

		ResultSet rs;

		Vector<Funcionario> funcionarios = new Vector<Funcionario>();

		String query = "SELECT f.*, f.endereco.id_endereco AS idEndereco, f.endereco.estado AS estado, f.endereco.cidade AS cidade, f.endereco.bairro AS bairro, f.endereco.rua AS rua, f.endereco.numero AS numero f.endereco.complemente AS complemento FROM tb_funcionario f";

		rs = st.executeQuery(query);

		ByteArrayInputStream in = null;
		BufferedImage img = null;
		Blob fotoBlob = null;

		byte bytes[] = null;

		String cpf;
		String nome;
		String email;
		int idEndereco;
		String estado;
		String cidade;
		String bairro;
		String rua;
		int numero;
		String complemento;
		int salario;
		String cargo;
		String cpfGerente;
		String codDepart;

		Endereco  endereco;

		Funcionario funcionario;

		while(rs.next()){
			cpf =  rs.getString("CPF");
			nome = rs.getString("nome");
			email = rs.getString("email");
			
			salario = Integer.parseInt(rs.getString("salario"));
			cargo = rs.getString("cargo");
			cpfGerente = rs.getString("cpf_gerente");
			codDepart = rs.getString("cod_depart");
	

			idEndereco = Integer.parseInt(rs.getString("id_endereco"));
			estado = rs.getString("estado");
			cidade = rs.getString("cidade");
			bairro = rs.getString("bairro");
			rua = rs.getString("rua");
			numero = Integer.parseInt(rs.getString("numero"));
			complemento = rs.getString("complemento");

			endereco = new Endereco(idEndereco, estado, cidade, bairro, rua, numero, complemento);

			fotoBlob = rs.getBlob("foto");

			if(fotoBlob != null){
				bytes = fotoBlob.getBytes(1, (int) fotoBlob.length());
				in = new ByteArrayInputStream(bytes);
				img = ImageIO.read(in);
			}

			Imagem imagem = new Imagem(img);

			funcionario = new Funcionario(cpf, nome, email, imagem, endereco, salario, cargo, cpfGerente, codDepart);

			funcionarios.add(funcionario);	
		}
		
		st.close();
		
		return funcionarios;
	}
	
	public void inserirFuncionario(Funcionario funcionario) throws SQLException, IOException {
		
		String cpf = funcionario.getCPF();
		String nome = funcionario.getNome();
		String email = funcionario.getEmail();

		String rua = funcionario.getEndereco().getRua();
		String complemento = funcionario.getEndereco().getComplemento();
		int numero = funcionario.getEndereco().getNumero();
		String bairro = funcionario.getEndereco().getCidade();
		String cidade = funcionario.getEndereco().getBairro();
		String estado = funcionario.getEndereco().getEstado();
		
		int salario = funcionario.getSalario();
		String cargo = funcionario.getCargo();
		String cpfGerente = funcionario.getCPF();
		String codDepart = funcionario.getDepartamento();

		String sql = "INSERT INTO tb_funcionario VALUES(tp_cliente("+ cpf +", '"+ nome +"', '"+ email +"', TO_DATE('1974/03/19', 'yyyy/mm/dd'), ?, (tp_endereco(seq_id_endereco.nextval, '"+ estado + "', '" + cidade + "', '" + bairro + "Õ, '"+ rua +"', " + numero + ", '"+complemento+"'), tp_fones(tp_telefone(Ô123456788Õ)), " + salario + ", '" + cargo + "' , (SELECT REF(f) FROM tb_funcionario f WHERE f.CPF = '06656437486'), (SELECT REF(d) FROM tb_departamento d WHERE d.id_departamento = 1)))";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		InputStream in = (InputStream) new FileInputStream(funcionario.getFoto().getFile());
		
		ps.setBinaryStream(1, in, funcionario.getFoto().getFile().length());
		
		ps.executeUpdate();
		
		ps.close();
		in.close();
		
		con.commit();
	}
	
	public void removerFuncionario(Funcionario funcionario) throws SQLException {
		Statement st = con.createStatement();
		String sql = "DELETE FROM tb_funcionario WHERE CPF='"+funcionario.getCPF()+"'";
		st.executeUpdate(sql);
		st.close();
	}
	
	public void setFoto(Imagem imagem, Funcionario f) throws SQLException, FileNotFoundException {
		
		String sql = "UPDATE tb_funcionario SET foto = ? WHERE CPF='"+f.getCPF()+"'";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		InputStream in = (InputStream) new FileInputStream(imagem.getFile());

		ps.setBinaryStream(1, in, imagem.getFile().length());
		ps.executeUpdate();
		
		f.setFoto(imagem);
		
		ps.close();
		con.commit();
	}
}
