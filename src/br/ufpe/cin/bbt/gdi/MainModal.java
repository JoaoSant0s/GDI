package br.ufpe.cin.bbt.gdi;

import java.io.IOException;
import java.sql.SQLException;

import Entities.Cliente;
import Entities.Endereco;
import Entities.Funcionario;
import Entities.Imagem;
import Repositories.DBController;
import Repositories.RepositorioCliente;
import Repositories.RepositorioFuncionario;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;



public class MainModal extends Application{
	//Campos para cadastro do Cliente
	final Label lblNomeCliente = new Label("Nome do Cliente");
	final TextField dialogoNomeCliente = new TextField();
	
	final Label lblCPFCliente = new Label("CPF do CLiente");
	final TextField dialogoCPFCliente = new TextField();
		
	final Label lblEmailCliente = new Label("Email do Cliente");
	final TextField dialogoEmailCliente = new TextField();
	
	final Label lblImageCliente = new Label("Imagem do Cliente");
	final TextField dialogoImageCliente = new TextField();
							
	final Label lblTipoEmprego = new Label("Tipo Emprego");
	final TextField dialogoTipoEmprego = new TextField();
	
	final Label lblEnderecoEstadoCliente = new Label("Estado");
	final TextField dialogoEnderecoEstadoCliente = new TextField();
	
	final Label lblEnderecoCidadeCliente = new Label("Cidade");
	final TextField dialogoEnderecoCidadeCliente = new TextField();

	final Label lblEnderecoBairroCliente = new Label("Bairro");
	final TextField dialogoEnderecoBairroCliente = new TextField();
	
	final Label lblEnderecoRuaCliente = new Label("Rua");
	final TextField dialogoEnderecoRuaCliente = new TextField();
	
	final Label lblEnderecoNumeroCliente = new Label("Numero");
	final TextField dialogoEnderecoNumeroCliente = new TextField();
	
	final Label lblEnderecoComplementoCliente = new Label("Complemento");
	final TextField dialogoEnderecoComplementoCliente = new TextField();	
	
	//Dados para mostragem na busca cliente
	final Label lblBuscaNomeCliente = new Label("Busca por Nome");
	final TextField dialogoBuscaNomeCliente = new TextField();	
	
	final Label lblDadosNomeCliente = new Label();
	final Label lblDadosCPFCliente = new Label();
	final Label lblDadosEmailCliente = new Label();
	final ImageView imageCliente = new ImageView();
	final Label lblDadosTipoEmpregoCliente = new Label();
	
	final Label lblDadosEnderecoEstadoCliente = new Label();
	final Label lblDadosEnderecoCidadeCliente = new Label();
	final Label lblDadosEnderecoBairroCliente = new Label();
	final Label lblDadosEnderecoRuaCliente = new Label();
	final Label lblDadosEnderecoNumeroCliente = new Label();
	final Label lblDadosEnderecoComplementoCliente = new Label();
	
	
	//Campos para cadastro do Funcionario
	final Label lblNomeFuncionario = new Label("Nome do Funcionário");
	final TextField dialogoNomeFuncionario = new TextField();
	
	final Label lblCPFFuncionario = new Label("CPF do Funcionário");
	final TextField dialogoCPFFuncionario = new TextField();
	
	final Label lblEmailFuncionario = new Label("Email do Funcionário");
	final TextField dialogoEmailFuncionario = new TextField();
	
	final Label lblImageFuncionario = new Label("Imagem do funcionário");
	final TextField dialogoImageFuncionario = new TextField();
	
	final Label lblSalarioFuncionario = new Label("Salário do funcionário");
	final TextField dialogoSalarioFuncionario = new TextField();
	
	final Label lblCargoFuncionario = new Label("Cargo do funcionário");
	final TextField dialogoCargoFuncionario = new TextField();
	
	final Label lblGerenteFuncionario = new Label("Gerente do funcionário");
	final TextField dialogoGerenteFuncionario = new TextField();
	
	final Label lblDepartamentoFuncionario = new Label("Departamento do funcionário");
	final TextField dialogoDepartamentoFuncionario = new TextField();					
	
	final Label lblEnderecoEstadoFuncionario = new Label("Estado");
	final TextField dialogoEnderecoEstadoFuncionario = new TextField();
	
	final Label lblEnderecoCidadeFuncionario = new Label("Cidade");
	final TextField dialogoEnderecoCidadeFuncionario = new TextField();

	final Label lblEnderecoBairroFuncionario = new Label("Bairro");
	final TextField dialogoEnderecoBairroFuncionario = new TextField();
	
	final Label lblEnderecoRuaFuncionario = new Label("Rua");
	final TextField dialogoEnderecoRuaFuncionario = new TextField();
	
	final Label lblEnderecoNumeroFuncionario = new Label("Numero");
	final TextField dialogoEnderecoNumeroFuncionario = new TextField();
	
	final Label lblEnderecoComplementoFuncionario = new Label("Complemento");
	final TextField dialogoEnderecoComplementoFuncionario = new TextField();	
	
	//Dados para mostragem na busca Funcionario
		final Label lblBuscaNomeFuncionario = new Label("Busca por Nome");
		final TextField dialogoBuscaNomeFuncionario = new TextField();	
		
		final Label lblDadosNomeFuncionario = new Label();
		final Label lblDadosCPFFuncionario= new Label();
		final Label lblDadosEmailFuncionario = new Label();
		final ImageView imageFuncionario = new ImageView();
		final Label lblDadosTipoEmpregoFuncionario = new Label();
		
		final Label lblDadosEnderecoEstadoFuncionario = new Label();
		final Label lblDadosEnderecoCidadeFuncionario = new Label();
		final Label lblDadosEnderecoBairroFuncionario = new Label();
		final Label lblDadosEnderecoRuaFuncionario = new Label();
		final Label lblDadosEnderecoNumeroFuncionario = new Label();
		final Label lblDadosEnderecoComplementoFuncionario = new Label();
	
	//Botoes para cadastros gerais
	final Button btnCliente = new Button("Cadastrar Cliente");
	final Button btnFuncionario = new Button("Cadastrar Funcionário");
	final Button btnInvestidor = new Button("Cadastrar Investidor");
	

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage stage) throws Exception {
		/*DBController controller = new DBController();
		controller.createConnection();
		final RepositorioCliente repoCliente = new RepositorioCliente(controller.getConnection());
		RepositorioFuncionario repoFuncionario = new RepositorioFuncionario(controller.getConnection());*/
		
			
						
		 EventHandler<MouseEvent> filter1 = new EventHandler<MouseEvent>() {
	            @Override
	            public void handle(MouseEvent event) {
	            	cadastrarCliente();
	            }
				private void cadastrarCliente() {
					/*Imagem image = null;
					// TODO Como pegar imagem?
					try {
						image = new Imagem(dialogoImageCliente.getText());
					} catch (IOException e) {
						// TODO Auto-generated catch block
					}
		            Endereco novoEndereco = new Endereco(0, dialogoEnderecoEstado.getText(), dialogoEnderecoCidade.getText(), dialogoEnderecoBairro.getText(), dialogoEnderecoRua.getText(), Integer.parseInt(dialogoEnderecoNumero.getText()) , dialogoEnderecoComplemento.getText());
					
					Cliente novo = new Cliente(dialogoCPFCliente.getText(), dialogoNomeCliente.getText(), dialogoEmailCliente.getText(), image, novoEndereco, dialogoTipoEmprego.getText());
					
					try {
						repoCliente.inserirCliente(novo);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
				}
	        };
	        
        EventHandler<MouseEvent> filter2 = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	cadastrarFuncionario();
            }
			private void cadastrarFuncionario() {
				Imagem image = null;
				
				/*try {
					image = new Imagem(imageTextCliente);
				} catch (IOException e) {
					// TODO Auto-generated catch block
				}
	            */
	            //Endereco novoEndereco = new Endereco(0, enderecoEstado, enderecoCidade, enderecoBairro, enderecoRua, enderecoNumeroFuncionario , enderecoComplemento);
				
				//Funcionario novo = new Funcionario(cpf, nomeFuncionario, email, image, novoEndereco, Integer.parseInt(salarioFuncionario), cargoFuncionario, cpfGerente, cpfdepartamento);
			}
        };
	        
	        btnCliente.addEventFilter(MouseEvent.MOUSE_PRESSED, filter1);
		    btnFuncionario.addEventFilter(MouseEvent.MOUSE_PRESSED, filter2);
	        
	        //BEGIN TABPANE
	        TabPane tabPaneGeral = new TabPane();
	        tabPaneGeral.setMinSize(800, 600);
	        //END TABPANE
	        
	        //BEGIN FUNCIONARIO
	        Tab tabFuncionario = new Tab();
	        tabFuncionario.setText("Funcionario");
	        
	        HBox hboxFuncionario = new HBox();
	        //BEGIN PAN_FUNCIONARIO_INTERNO
		        TabPane tabPanFuncionario = new TabPane();
		        tabPanFuncionario.setMinSize(800, 500);
		        
		        Tab tabFuncionarioCadastrar = new Tab();
		        tabFuncionarioCadastrar.setText("Cadastrar");
		        tabFuncionarioCadastrar.closableProperty().set(false);
					GridPane grid1 = new GridPane();
					
					grid1.setHgap(1);
				    grid1.setVgap(1);
				    
				    grid1.add(lblNomeFuncionario, 40, 70);
				    grid1.add(dialogoNomeFuncionario, 65, 70);
				    grid1.add(lblCPFFuncionario, 40, 100);
				    grid1.add(dialogoCPFFuncionario, 65, 100);
				    grid1.add(lblEmailFuncionario, 40, 130);
				    grid1.add(dialogoEmailFuncionario, 65, 130);
				    grid1.add(lblImageFuncionario, 40, 160);
				    grid1.add(dialogoImageFuncionario, 65, 160);
				    
				    grid1.add(lblSalarioFuncionario, 40, 190);
				    grid1.add(dialogoSalarioFuncionario, 65, 190);
				    grid1.add(lblCargoFuncionario, 40, 220);
				    grid1.add(dialogoCargoFuncionario, 65, 220);
				    
				    grid1.add(lblGerenteFuncionario, 40, 250);
				    grid1.add(dialogoGerenteFuncionario, 65, 250);
				    grid1.add(lblDepartamentoFuncionario,40, 280);
				    grid1.add(dialogoDepartamentoFuncionario, 65, 280);
				    
				    grid1.add(btnFuncionario, 125, 250);
				    
				    grid1.add(lblEnderecoEstadoFuncionario, 110, 70);
				    grid1.add(dialogoEnderecoEstadoFuncionario, 125, 70);
				    grid1.add(lblEnderecoCidadeFuncionario, 110, 100);
				    grid1.add(dialogoEnderecoCidadeFuncionario, 125, 100);
				    grid1.add(lblEnderecoBairroFuncionario, 110, 130);
				    grid1.add(dialogoEnderecoBairroFuncionario, 125, 130);
				    grid1.add(lblEnderecoRuaFuncionario, 110, 160);
				    grid1.add(dialogoEnderecoRuaFuncionario, 125, 160);
				    grid1.add(lblEnderecoNumeroFuncionario, 110, 190);
				    grid1.add(dialogoEnderecoNumeroFuncionario, 125, 190);
				    grid1.add(lblEnderecoComplementoFuncionario, 110, 210);
				    grid1.add(dialogoEnderecoComplementoFuncionario, 125, 210);

		            tabFuncionarioCadastrar.setContent(grid1);
		        tabPanFuncionario.getTabs().addAll(tabFuncionarioCadastrar);
		        
		        Tab tabFuncionarioBuscar = new Tab();
		        tabFuncionarioBuscar.setText("Buscar");
		        tabFuncionarioBuscar.closableProperty().set(false);
		        GridPane grid2 = new GridPane();
		        
				grid2.setHgap(1);
			    grid2.setVgap(1);
			    
			    grid2.add(lblBuscaNomeFuncionario, 20, 20);
			    grid2.add(dialogoBuscaNomeFuncionario, 40, 20);
		        
		        int con = 0;
			    //for (Cliente cliente : repoCliente.getClientes()) {
				    lblDadosNomeFuncionario.setText("Nome Aqui");
				    lblDadosCPFFuncionario.setText("CPF Aqui");
				    lblDadosEmailFuncionario.setText("Email Aqui");
				    lblDadosTipoEmpregoFuncionario.setText("Emprego Aqui");
				    lblDadosEnderecoEstadoFuncionario.setText("Estado Aqui");
				    lblDadosEnderecoCidadeFuncionario.setText("Cidade Aqui");
				    lblDadosEnderecoBairroFuncionario.setText("Bairro Aqui");
				    lblDadosEnderecoRuaFuncionario.setText("Rua Aqui");
				    lblDadosEnderecoNumeroFuncionario.setText("Numero Aqui");
				    lblDadosEnderecoComplementoFuncionario.setText("complemento Aqui");
				    
				    grid2.add(imageFuncionario, 40, 40 + con);
				    grid2.add(lblDadosNomeFuncionario, 60, 40 + con);
				    grid2.add(lblDadosCPFFuncionario, 80, 40 + con);
				    grid2.add(lblDadosEmailFuncionario, 100, 40 + con);
				    grid2.add(lblDadosTipoEmpregoFuncionario, 120, 40 + con);
				    
				    grid2.add(lblDadosEnderecoEstadoFuncionario, 40, 50 + con);
				    grid2.add(lblDadosEnderecoCidadeFuncionario, 60, 50 + con);
				    grid2.add(lblDadosEnderecoBairroFuncionario, 80, 50 + con);
				    grid2.add(lblDadosEnderecoRuaFuncionario, 100, 50 + con);
				    grid2.add(lblDadosEnderecoNumeroFuncionario, 120, 50 + con);
				    grid2.add(lblDadosEnderecoComplementoFuncionario, 140, 50 + con);
				    con = con + 30;
				    //}
			        
		            tabFuncionarioBuscar.setContent(grid2);
		        tabPanFuncionario.getTabs().add(tabFuncionarioBuscar);
		        
		    //END PAN_FUNCIONARIO_INTERNO
		    hboxFuncionario.getChildren().addAll(tabPanFuncionario);
		    hboxFuncionario.setAlignment(Pos.CENTER);
	        tabFuncionario.setContent(hboxFuncionario);
	        tabFuncionario.closableProperty().set(false);
	        tabPaneGeral.getTabs().add(tabFuncionario);

	        //END FUNCIONARIO
	        
	        //BEGIN CLIENTE
	        Tab tabCliente = new Tab();
	        tabCliente.setText("Cliente");
	        HBox hboxCliente = new HBox();
	        //BEGIN PAN_CLIENTE_INTERNO
		        TabPane tabPanCliente = new TabPane();
		        tabPanCliente.setMinSize(800, 500);
		        
			        Tab tabClienteCadastrar = new Tab();
			        tabClienteCadastrar.setText("Cadastrar");
			        tabClienteCadastrar.closableProperty().set(false);
					GridPane grid3 = new GridPane();
				        
						grid3.setHgap(1);
						grid3.setVgap(1);
					    
						grid3.add(lblNomeCliente, 40, 70);
						grid3.add(dialogoNomeCliente, 65, 70);
						grid3.add(lblCPFCliente, 40, 100);
						grid3.add(dialogoCPFCliente, 65, 100);
						grid3.add(lblEmailCliente, 40, 130);
						grid3.add(dialogoEmailCliente, 65, 130);
						grid3.add(lblImageCliente, 40, 160);
						grid3.add(dialogoImageCliente, 65, 160);
						grid3.add(lblTipoEmprego, 40, 190);
					    grid3.add(dialogoTipoEmprego, 65, 190);
					    grid3.add(btnCliente, 80, 230);
					    
					    grid3.add(lblEnderecoEstadoCliente, 110, 70);
					    grid3.add(dialogoEnderecoEstadoCliente, 125, 70);
					    grid3.add(lblEnderecoCidadeCliente, 110, 100);
					    grid3.add(dialogoEnderecoCidadeCliente, 125, 100);
					    grid3.add(lblEnderecoBairroCliente, 110, 130);
					    grid3.add(dialogoEnderecoBairroCliente, 125, 130);
					    grid3.add(lblEnderecoRuaCliente, 110, 160);
					    grid3.add(dialogoEnderecoRuaCliente, 125, 160);
					    grid3.add(lblEnderecoNumeroCliente, 110, 190);
					    grid3.add(dialogoEnderecoNumeroCliente, 125, 190);
					    grid3.add(lblEnderecoComplementoCliente, 110, 210);
					    grid3.add(dialogoEnderecoComplementoCliente, 125, 210);
					   
			            tabClienteCadastrar.setContent(grid3);
			        tabPanCliente.getTabs().add(tabClienteCadastrar);
			        
			        Tab tabClienteBuscar = new Tab();
			        tabClienteBuscar.setText("Buscar");
			        tabClienteBuscar.closableProperty().set(false);
				        GridPane grid4 = new GridPane();
				        
				        grid4.setHgap(1);
				        grid4.setVgap(1);
					    
				        grid4.add(lblBuscaNomeCliente, 20, 20);
				        grid4.add(dialogoBuscaNomeCliente, 40, 20);
					    
					    con = 0;
					    //for (Cliente cliente : repoCliente.getClientes()) {
						    lblDadosNomeCliente.setText("Nome Aqui");
						    lblDadosCPFCliente.setText("CPF Aqui");
						    lblDadosEmailCliente.setText("Email Aqui");
						    lblDadosTipoEmpregoCliente.setText("Emprego Aqui");
						    lblDadosEnderecoEstadoCliente.setText("Estado Aqui");
						    lblDadosEnderecoCidadeCliente.setText("Cidade Aqui");
						    lblDadosEnderecoBairroCliente.setText("Bairro Aqui");
						    lblDadosEnderecoRuaCliente.setText("Rua Aqui");
						    lblDadosEnderecoNumeroCliente.setText("Numero Aqui");
						    lblDadosEnderecoComplementoCliente.setText("complemento Aqui");
						    
						    grid4.add(imageCliente, 40, 40 + con);
						    grid4.add(lblDadosNomeCliente, 60, 40 + con);
						    grid4.add(lblDadosCPFCliente, 80, 40 + con);
						    grid4.add(lblDadosEmailCliente, 100, 40 + con);
						    grid4.add(lblDadosTipoEmpregoCliente, 120, 40 + con);
						    
						    grid4.add(lblDadosEnderecoEstadoCliente, 40, 50 + con);
						    grid4.add(lblDadosEnderecoCidadeCliente, 60, 50 + con);
						    grid4.add(lblDadosEnderecoBairroCliente, 80, 50 + con);
						    grid4.add(lblDadosEnderecoRuaCliente, 100, 50 + con);
						    grid4.add(lblDadosEnderecoNumeroCliente, 120, 50 + con);
						    grid4.add(lblDadosEnderecoComplementoCliente, 140, 50 + con);
						    con = con + 30;
						//}
					    
			        tabClienteBuscar.setContent(grid4);
			        tabPanCliente.getTabs().add(tabClienteBuscar);
		    //END PAN_CLIENTE_INTERNO
		        
			hboxCliente.getChildren().addAll(tabPanCliente);
			hboxCliente.setAlignment(Pos.CENTER);
            tabCliente.setContent(hboxCliente);
	        tabCliente.closableProperty().set(false);
	        tabPaneGeral.getTabs().add(tabCliente);

	        //END CLIENTE
	        
	        //BEGIN INVESTIDOR
	        Tab tabInvestidor = new Tab();
	        tabInvestidor.setText("Investidor");
	        HBox hboxInvestidor = new HBox();
	        //BEGIN PAN_INVESTIDOR_INTERNO
		        TabPane tabPanInvestidor = new TabPane();
		        tabPanInvestidor.setMinSize(800, 500);
		        
		        Tab tabInvestidorCadastrar = new Tab();
		        tabInvestidorCadastrar.setText("Cadastrar");
		        tabInvestidorCadastrar.closableProperty().set(false);
			        HBox hbox5 = new HBox();
			        //hbox5.getChildren().addAll();
		            hbox5.setAlignment(Pos.CENTER);
		            tabInvestidorCadastrar.setContent(hbox5);
		        tabPanInvestidor.getTabs().add(tabInvestidorCadastrar);
		        
		        Tab tabInvestidorBuscar = new Tab();
		        tabInvestidorBuscar.setText("Buscar");
		        tabInvestidorBuscar.closableProperty().set(false);
			        HBox hbox6 = new HBox();
			        //hbox6.getChildren().addAll(lblInvestidor, dialogoNomeInvestidor);
		            hbox6.setAlignment(Pos.TOP_LEFT);
		            tabInvestidorBuscar.setContent(hbox6);
		        tabPanInvestidor.getTabs().add(tabInvestidorBuscar);
		        
		    //END PAN_INVESTIDOR_INTERNO
		    hboxInvestidor.getChildren().addAll(tabPanInvestidor);
		    hboxInvestidor.setAlignment(Pos.CENTER);
            tabInvestidor.setContent(hboxInvestidor);
	        tabInvestidor.closableProperty().set(false);
	        tabPaneGeral.getTabs().add(tabInvestidor);
	        
	        //END INVESTIDOR
	        
	        //lblTitulo, btnNome, dialogoNome, rbFicticia
	        
	        //Adicionando dados na tela
	        VBox raiz = new VBox(20);
	        raiz.setAlignment(Pos.CENTER);
	        raiz.getChildren().addAll(tabPaneGeral);
	        
	        //criando cena para gerar na tela
	        Scene cena = new Scene(raiz, 800, 600);
	        stage.setTitle("Título");
	        stage.setScene(cena);
	        stage.show();	
	}
	
	public static void deBugString(Object o) {
		System.out.println(o.toString());
	}
	
	
	
}
