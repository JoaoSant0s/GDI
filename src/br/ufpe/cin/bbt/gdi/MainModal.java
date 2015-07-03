package br.ufpe.cin.bbt.gdi;

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
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;



public class MainModal extends Application{
	String nome, regiao, fazExe;

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage stage) throws Exception {
			Label lblFuncionario = new Label("Funcionario Nome");
			Label lblCliente = new Label("Cliente Nome");
			Label lblInvestidor = new Label("Investidor Nome");
			
			Button btnNome = new Button("Entrar com Nome");
			
			TextField dialogoNomeFuncionario = new TextField();
			TextField dialogoNomeCliente = new TextField();
			TextField dialogoNomeInvestidor = new TextField();
			
			RadioButton rbFicticia = new RadioButton();
	        
	        EventHandler<MouseEvent> filter = new EventHandler<MouseEvent>() {
	            @Override
	            public void handle(MouseEvent event) {
	              System.out.println("Teste");
	            }
	        };
	        
	        btnNome.addEventFilter(MouseEvent.MOUSE_PRESSED, filter);
	        
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
			        HBox hbox1 = new HBox();
			        //hbox1.getChildren().addAll();
		            hbox1.setAlignment(Pos.CENTER);
		            tabFuncionarioCadastrar.setContent(hbox1);
		        tabPanFuncionario.getTabs().addAll(tabFuncionarioCadastrar);
		        
		        Tab tabFuncionarioBuscar = new Tab();
		        tabFuncionarioBuscar.setText("Buscar");
		        tabFuncionarioBuscar.closableProperty().set(false);
			        HBox hbox2 = new HBox();
			        hbox2.getChildren().addAll(lblFuncionario, dialogoNomeFuncionario);
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
				        HBox hbox3 = new HBox();
				        //hbox3.getChildren().addAll();
			            hbox3.setAlignment(Pos.CENTER);
			            tabClienteCadastrar.setContent(hbox3);
			        tabPanCliente.getTabs().add(tabClienteCadastrar);
			        
			        Tab tabClienteBuscar = new Tab();
			        tabClienteBuscar.setText("Buscar");
			        tabClienteBuscar.closableProperty().set(false);
				        HBox hbox4 = new HBox();
				        hbox4.getChildren().addAll(lblCliente, dialogoNomeCliente);
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
			        hbox6.getChildren().addAll(lblInvestidor, dialogoNomeInvestidor);
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
