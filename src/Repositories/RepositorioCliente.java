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

import Entities.Cliente;
import Entities.Endereco;
import Entities.Imagem;

public class RepositorioCliente {
	private Connection con;

	public RepositorioCliente(Connection con){
		this.con = con;
	}

	public Vector<Cliente> getClientes() throws SQLException, IOException{

		Statement st = con.createStatement();

		ResultSet rs;

		Vector<Cliente> clientes = new Vector<Cliente>();

		String query = "SELECT c.*, c.endereco.id_endereco AS idEndereco, c.endereco.estado AS estado, c.endereco.cidade AS cidade, c.endereco.bairro AS bairro, c.endereco.rua AS rua, c.endereco.numero AS numero c.endereco.complemente AS complemento FROM tb_cliente c";

		rs = st.executeQuery(query);

		ByteArrayInputStream in = null;
		BufferedImage img = null;
		Blob fotoBlob = null;

		byte bytes[] = null;

		String cpf;
		String nome;
		String email;
		String tipoEmprego;
		int idEndereco;
		String estado;
		String cidade;
		String bairro;
		String rua;
		int numero;
		String complemento;

		Endereco  endereco;

		Cliente cliente;

		while(rs.next()){
			cpf =  rs.getString("CPF");
			nome = rs.getString("nome");
			email = rs.getString("email");
			tipoEmprego = rs.getString("tipo_emprego");

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

			cliente = new Cliente(cpf, nome, email, imagem, endereco, tipoEmprego);

			clientes.add(cliente);	
		}
		
		st.close();
		
		return clientes;
	}
	
	public void inserirCliente(Cliente cliente) throws SQLException, IOException {
		
		String cpf = cliente.getCPF();
		String nome = cliente.getNome();
		String email = cliente.getEmail();

		String rua = cliente.getEndereco().getRua();
		String complemento = cliente.getEndereco().getComplemento();
		int numero = cliente.getEndereco().getNumero();
		String bairro = cliente.getEndereco().getCidade();
		String cidade = cliente.getEndereco().getBairro();
		String estado = cliente.getEndereco().getEstado();
		
		String tipoEmprego = cliente.getTipoEmprego();

		String sql = "INSERT INTO tb_cliente VALUES(tp_cliente("+ cpf +", '"+ nome +"', '"+ email +"', TO_DATE('1974/03/19', 'yyyy/mm/dd'), ?, (tp_endereco(seq_id_endereco.nextval, '"+ estado + "', '" + cidade + "', '" + bairro + "Õ, '"+ rua +"', " + numero + ", '"+complemento+"'), tp_fones(tp_telefone(Ô123456788Õ)), '" + tipoEmprego + "'))";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		InputStream in = (InputStream) new FileInputStream(cliente.getFoto().getFile());
		
		ps.setBinaryStream(1, in, cliente.getFoto().getFile().length());
		
		ps.executeUpdate();
		
		ps.close();
		in.close();
		
		con.commit();
	}
	
	public void removerCliente(Cliente cliente) throws SQLException {
		Statement st = con.createStatement();
		String sql = "DELETE FROM tb_cliente WHERE CPF='"+cliente.getCPF()+"'";
		st.executeUpdate(sql);
		st.close();
	}
	
	public void setFoto(Imagem imagem, Cliente c) throws SQLException, FileNotFoundException {
		
		String sql = "UPDATE tb_cliente SET foto = ? WHERE CPF='"+c.getCPF()+"'";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		InputStream in = (InputStream) new FileInputStream(imagem.getFile());

		ps.setBinaryStream(1, in, imagem.getFile().length());
		ps.executeUpdate();
		
		c.setFoto(imagem);
		
		ps.close();
		con.commit();
	}
}
