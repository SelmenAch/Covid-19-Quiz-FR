package QuizGame;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class QuestionModel {
	String question; 
	String options[];
	int reponse; //indice de la bonne réponse
	int choix;   //indice de la réponse choisie
	boolean utilisee;  //indique si la question a été utilisée ou non
	
	public QuestionModel(String question, String[] options, int rep){
		this.question=question;
		this.reponse=rep;
		this.options=options;		
	}
}
