package br.ufpe.cin.bbt.gdi;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;



public class MainModal extends Application{
	String nome, regiao, fazExe;

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage stage) throws Exception {
			Label lblTitulo = new Label("Questionário Importante");
			Button btnNome = new Button("Entrar com Nome");
			TextField dialogoNome = new TextField();
			RadioButton rbFicticia = new RadioButton();
	 
	        lblTitulo.setFont(Font.font(24));
	        
	        EventHandler<MouseEvent> filter = new EventHandler<MouseEvent>() {
	            @Override
	            public void handle(MouseEvent event) {
	              System.out.println("Teste");
	            }
	        };
	        
	        btnNome.addEventFilter(MouseEvent.MOUSE_PRESSED, filter);
	 
	        //Adicionando dados na tela
	        VBox raiz = new VBox(20);
	        raiz.setAlignment(Pos.CENTER);
	        raiz.getChildren().addAll(lblTitulo, btnNome, dialogoNome, rbFicticia);
	        
	        //criando cena para gerar na tela
	        Scene cena = new Scene(raiz, 450, 250);
	        stage.setTitle("Título");
	        stage.setScene(cena);
	        stage.show();	
	}
	
	public static void deBugString(Object o) {
		System.out.println(o.toString());
	}
	
	
	
}
