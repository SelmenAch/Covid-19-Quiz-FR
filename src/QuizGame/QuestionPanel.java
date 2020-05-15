package QuizGame;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;

public class QuestionPanel extends JPanel implements ActionListener{
	
	Quiz quiz;	 //objet quiz
	QuestionModel questionModel;
	
	//questions
	JPanel questionsPanel=new JPanel();
	
	//réponses
	JPanel reponsesPanel=new JPanel();
	JRadioButton[] reponses;
	ButtonGroup group=new ButtonGroup();
	
	//menu
	JPanel menuPanel=new JPanel();
	JButton suivant=new JButton("Suivant");
	JButton terminer=new JButton("Terminer");
	
	public QuestionPanel(Quiz quiz, QuestionModel questionModel){
		
		//banner image
	    JLabel bannerLabel;
		bannerLabel = new JLabel();
        bannerLabel.setIcon(new ImageIcon(getClass().getResource("/images/header.jpg")));
        bannerLabel.setPreferredSize(new Dimension(800, 220));
        
		this.quiz=quiz;
		this.questionModel=questionModel;
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		//question
		JLabel q = new JLabel(this.questionModel.question);
		q.setFont(new Font("Dialog",Font.BOLD,20));
		questionsPanel.add(bannerLabel);
		questionsPanel.add(q);
		add(questionsPanel);
		
		//réponse
		reponses=new JRadioButton[this.questionModel.options.length];
		for(int i=0;i<this.questionModel.options.length;i++){
			reponses[i]=new JRadioButton(this.questionModel.options[i]);
			reponses[i].setFont(new Font("Dialog",Font.PLAIN,20));
			reponses[i].addActionListener(this);
			group.add(reponses[i]);
			reponsesPanel.add(reponses[i]);
		}
		add(reponsesPanel);
		
		//menu
		suivant.addActionListener(this);
		suivant.setFont(new Font("Dialog",Font.PLAIN,20));
		suivant.setBackground(new Color(245,245,245));
		suivant.setFocusPainted(false);
        
		suivant.addMouseListener(new java.awt.event.MouseAdapter() {
        	public void mouseEntered(java.awt.event.MouseEvent evt) {
        		suivant.setBackground(new Color(102, 153, 204));
        		suivant.setForeground(Color.WHITE);
            }
        	public void mouseExited(java.awt.event.MouseEvent evt) {
        		suivant.setBackground(new Color(245,245,245));
        		suivant.setForeground(Color.BLACK);
            }
        });
		
		terminer.addActionListener(this);
		terminer.setFont(new Font("Dialog",Font.PLAIN,20));
		terminer.setBackground(new Color(245,245,245));
		terminer.setFocusPainted(false);
        
		terminer.addMouseListener(new java.awt.event.MouseAdapter() {
        	public void mouseEntered(java.awt.event.MouseEvent evt) {
        		terminer.setBackground(new Color(102, 153, 204));
        		terminer.setForeground(Color.WHITE);
            }
        	public void mouseExited(java.awt.event.MouseEvent evt) {
        		terminer.setBackground(new Color(245,245,245));
        		terminer.setForeground(Color.BLACK);
            }
        });
		
		menuPanel.add(suivant);
		menuPanel.add(terminer);
		add(menuPanel);
	}
	
	public void actionPerformed(ActionEvent e){
		Object src=e.getSource();
		
		//bouton suivant
		if(src.equals(suivant)){
			afficherResultat();
			if(this.questionModel.choix==this.questionModel.reponse){
				this.questionModel.utilisee=true;
				quiz.suivant();
			}
		}
		
		//bouton terminer
		if(src.equals(terminer)){
			quiz.afficherResultat();
		}
		
		//boutons radio
		for(int i=0;i<reponses.length;i++){
			if(src==reponses[i]){
				this.questionModel.choix=i;
			}
		}
	}
	
	public void afficherResultat(){
		String text=reponses[this.questionModel.choix].getText();
		quiz.total++;
		if(this.questionModel.choix==this.questionModel.reponse){
			JLabel msg = new JLabel(text+" est correct! Bien joué. +1 point");
			msg.setFont(new Font("Arial", Font.PLAIN, 18));
			JOptionPane.showMessageDialog(null,msg);
		}
		else
		{
			quiz.nbEchecs++;
			JLabel msg = new JLabel(text+" est incorrect! Désolé. -1 point");
			msg.setFont(new Font("Arial", Font.PLAIN, 18));
			JOptionPane.showMessageDialog(null,msg);
		}
	}
}