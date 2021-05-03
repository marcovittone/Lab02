package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.alien.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInsert;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnClearText;

    @FXML
    void handleClear(ActionEvent event) {
    	
    	this.model.reset();

    }

    @FXML
    void handleTranslate(ActionEvent event) {
    	
    	String s=this.txtInsert.getText();
    	
    	System.out.println(s);
    	
    	if(s.equals(""))
    		{
    			this.txtResult.setText("HAI LASCIATO VUOTO");
    			return;
    		}
    	
    	String [] array = s.split(" ");
    	
    	if(array.length==1)
    	{
    		char[] arrayChar = array[0].toCharArray();
    		for(char c: arrayChar)
    		{
    			if(!Character.isLetter(c))
    			{
    				this.txtResult.setText("INSERISCI UNA STRINGA DI SOLE LETTERE");
    				return;
    			}
    		}
    		
    		String traduzione= model.traduci(array);
    		if(traduzione==null)
    			this.txtResult.setText("PAROLA NON RITROVATA");
    		else
    			this.txtResult.setText(traduzione);
    	
    	}
    	else if(array.length==2)
    	{
    		char[] arrayChar = array[0].toCharArray();
    		char[] arrayChar2 = array[1].toCharArray();
    		for(char c: arrayChar)
    		{
    			if(!Character.isLetter(c))
    			{
    				this.txtResult.setText("INSERISCI UNA STRINGHE DI SOLE LETTERE");
    				return;
    			}
    		}
    		for(char c: arrayChar2)
    		{
    			if(!Character.isLetter(c))
    			{
    				this.txtResult.setText("INSERISCI UNA STRINGHE DI SOLE LETTERE");
    				return;
    			}
    		}
    		
    		model.aggiungiParola(array);
    	}
    	
    	else
    	{
    		this.txtResult.setText("DEVI INSERIRE SOLO DUE PAROLE");
			return;
    	}
    	
    }
    	
    

    @FXML
    void initialize() {
        assert txtInsert != null : "fx:id=\"txtInsert\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClearText != null : "fx:id=\"btnClearText\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model=model;
    }
}
