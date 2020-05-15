package QuizGame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

public class Quiz extends JFrame {
	JPanel quizPanel=new JPanel();
	CardLayout cards=new CardLayout();
	int nbQuestions;
	int nbEchecs=0;
	int total=0;
	
	QuestionPanel questionPanels[] = new QuestionPanel [20];
	
	ArrayList<QuestionModel> questions = new ArrayList<QuestionModel>();
	
	String[][] reponses = new String[20][4] ;
	
	void init() {
		try {
			
		InputStreamReader data = new InputStreamReader(getClass().getResourceAsStream("/data.txt"),StandardCharsets.UTF_8);
			
		List <String> lignes = new BufferedReader(data).lines().collect(Collectors.toList());
			
		for(int i=0,ind=0;i<lignes.size();i+=6,ind++) {
			for(int j=0;j<4;j++) {		
				reponses[ind][j]=lignes.get(i+j+1);
			}
			QuestionModel q = new QuestionModel(lignes.get(i),reponses[ind],Integer.parseInt(lignes.get(i+5)));
			questions.add(q);
		}
		
		}
		
		catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public Quiz(){
		super("Jeu Quiz");
		setResizable(false);
		setSize(820,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
		
        init();
        nbQuestions=questions.size();
        for(int i=0;i<nbQuestions;i++){
        	questionPanels[i]= new QuestionPanel(this,questions.get(i));
		}
        
        quizPanel.setLayout(cards);
		for(int i=0;i<nbQuestions;i++){
			quizPanel.add(questionPanels[i],"q"+i);
		}
		Random r=new Random();
		int i=r.nextInt(nbQuestions);
		cards.show(quizPanel,"q"+i);
		add(quizPanel);
		setVisible(true);
	}
	
	public void suivant(){
		if((total-nbEchecs)==nbQuestions){
			afficherResultat();
		}
		else
		{
			Random r=new Random();
			boolean trouve=false;
			int i=0;
			while(!trouve){
				i=r.nextInt(nbQuestions);
				if(!questions.get(i).utilisee){
					trouve=true;
				}
			}
			cards.show(quizPanel,"q"+i);
		}
	}
	
	public void afficherResultat(){
		JLabel[] msg = {new JLabel("Merci d'avoir joué! Les résultats de votre quiz :"),
						new JLabel("\n"),
						new JLabel("Réponses incorrectes : "+nbEchecs),
						new JLabel("Réponses correctes : "+(total-nbEchecs)),
						new JLabel("Points obtenus : "+(total- 2 * nbEchecs))			
		};
		for(int i=0;i<msg.length;i++)
			msg[i].setFont(new Font("Arial", Font.PLAIN, 18));
		
		JOptionPane.showMessageDialog(null,msg);
		
		new Home();
		dispose();
	}
}