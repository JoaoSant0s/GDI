package br.ufpe.cin.bbt.gdi;

import java.io.IOException;

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
	
	final Label lblEnderecoEstado = new Label("Estado");
	final TextField dialogoEnderecoEstado = new TextField();
	
	final Label lblEnderecoCidade = new Label("Cidade");
	final TextField dialogoEnderecoCidade = new TextField();

	final Label lblEnderecoBairro = new Label("Bairro");
	final TextField dialogoEnderecoBairro = new TextField();
	
	final Label lblEnderecoRua = new Label("Rua");
	final TextField dialogoEnderecoRua = new TextField();
	
	final Label lblEnderecoNumero = new Label("Numero");
	final TextField dialogoEnderecoNumero = new TextField();
	
	final Label lblEnderecoComplemento = new Label("Complemento");
	final TextField dialogoEnderecoComplemento = new TextField();	
	
	
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
	

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage stage) throws Exception {
		/*DBController controller = new DBController();
		controller.createConnection();
		RepositorioCliente repoCliente = new RepositorioCliente(controller.getConnection());
		RepositorioFuncionario repoFuncionario = new RepositorioFuncionario(controller.getConnection());
		*/
			Button btnCliente = new Button("Cadastrar Cliente");
			Button btnFuncionario = new Button("Cadastrar Funcionário");
			Button btnInvestidor = new Button("Cadastrar Investidor");
						
		 EventHandler<MouseEvent> filter1 = new EventHandler<MouseEvent>() {
	            @Override
	            public void handle(MouseEvent event) {
	            	cadastrarCliente();
	            }
				private void cadastrarCliente() {
					Imagem image = null;
					/*try {
						image = new Imagem(imageTexFunc);
					} catch (IOException e) {
						// TODO Auto-generated catch block
					}*/
		            
		            //Endereco novoEndereco = new Endereco(0, enderecoEstado, enderecoCidade, enderecoBairro, enderecoRua, enderecoNumeroCliente , enderecoComplemento);
					
					//Cliente novo = new Cliente(cpf, nomeCliente, email, image, novoEndereco, tipoEmprego);
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
			        HBox hbox2 = new HBox();
			        //hbox2.getChildren().addAll(lblFuncionario, dialogoNomeFuncionario);
		            hbox2.setAlignment(Pos.TOP_LEFT);
		            tabFuncionarioBuscar.setContent(hbox2);
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
					GridPane grid2 = new GridPane();
				        
				       
						
						grid2.setHgap(1);
					    grid2.setVgap(1);
					    
					    grid2.add(lblNomeCliente, 40, 70);
					    grid2.add(dialogoNomeCliente, 65, 70);
					    grid2.add(lblCPFCliente, 40, 100);
					    grid2.add(dialogoCPFCliente, 65, 100);
					    grid2.add(lblEmailCliente, 40, 130);
					    grid2.add(dialogoEmailCliente, 65, 130);
					    grid2.add(lblImageCliente, 40, 160);
					    grid2.add(dialogoImageCliente, 65, 160);
					    grid2.add(lblTipoEmprego, 40, 190);
					    grid2.add(dialogoTipoEmprego, 65, 190);
					    grid2.add(btnCliente, 80, 230);
					    
					    grid2.add(lblEnderecoEstado, 110, 70);
					    grid2.add(dialogoEnderecoEstado, 125, 70);
					    grid2.add(lblEnderecoCidade, 110, 100);
					    grid2.add(dialogoEnderecoCidade, 125, 100);
					    grid2.add(lblEnderecoBairro, 110, 130);
					    grid2.add(dialogoEnderecoBairro, 125, 130);
					    grid2.add(lblEnderecoRua, 110, 160);
					    grid2.add(dialogoEnderecoRua, 125, 160);
					    grid2.add(lblEnderecoNumero, 110, 190);
					    grid2.add(dialogoEnderecoNumero, 125, 190);
					    grid2.add(lblEnderecoComplemento, 110, 210);
					    grid2.add(dialogoEnderecoComplemento, 125, 210);
					   
			            tabClienteCadastrar.setContent(grid2);
			        tabPanCliente.getTabs().add(tabClienteCadastrar);
			        
			        Tab tabClienteBuscar = new Tab();
			        tabClienteBuscar.setText("Buscar");
			        tabClienteBuscar.closableProperty().set(false);
				        HBox hbox4 = new HBox();
				        //hbox4.getChildren().addAll(lblCliente, dialogoNomeCliente);
			            hbox4.setAlignment(Pos.TOP_LEFT);
			            tabClienteBuscar.setContent(hbox4);
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
