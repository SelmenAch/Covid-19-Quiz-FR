package QuizGame;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame {

    JPanel bannerPanel;
    JLabel bannerLabel;

    JPanel buttonsPanel;
    JPanel playGameButtonPanel;
    JPanel aboutGameButtonPanel;
    JPanel exitGameButtonPanel;
    JButton playGameButton;
    JButton aboutGameButton;
    JButton exitGameButton;

    public Home() {
        super("Quiz Covid-19");
        chargerInterface();
    }

    public void chargerInterface() {
        BannerPanel();
        ButtonsPanel();

        this.setLayout(new BorderLayout());
        this.add(bannerPanel, BorderLayout.NORTH);
        this.add(buttonsPanel, BorderLayout.SOUTH);

        this.pack();
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    public void BannerPanel() {
        bannerLabel = new JLabel();
        bannerLabel.setIcon(new ImageIcon(getClass().getResource("/images/banner.jpg")));
        bannerPanel = new JPanel();
        bannerPanel.add(bannerLabel);
        bannerPanel.setPreferredSize(new Dimension(800, 350));
        bannerPanel.setBackground(Color.WHITE);
    }
        
    public void ButtonsPanel() {
        playGameButton = new JButton("Jouer");
        playGameButton.setFont(new Font("Dialog",Font.PLAIN,24));
        playGameButton.setBackground(new Color(245,245,245));
        playGameButton.setFocusPainted(false);
        
        playGameButton.addMouseListener(new java.awt.event.MouseAdapter() {
        	public void mouseEntered(java.awt.event.MouseEvent evt) {
        		playGameButton.setBackground(new Color(2,162,160));
        		playGameButton.setForeground(Color.WHITE);
            }
        	public void mouseExited(java.awt.event.MouseEvent evt) {
        		playGameButton.setBackground(new Color(245,245,245));
        		playGameButton.setForeground(Color.BLACK);
            }
        });
        
        playGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (playGameButton == e.getSource()) {
                	 new Quiz();
                	 dispose();
                }
            }
            
        });
        
        playGameButtonPanel = new JPanel(new GridLayout(1, 1));
        playGameButtonPanel.setBorder(BorderFactory.createEmptyBorder(40, 50, 40, 25));
        playGameButtonPanel.add(playGameButton);
        
        
        aboutGameButton = new JButton("A propos");
        aboutGameButton.setFont(new Font("Dialog",Font.PLAIN,24));
        aboutGameButton.setBackground(new Color(245,245,245));
        aboutGameButton.setFocusPainted(false);
        
        aboutGameButton.addMouseListener(new java.awt.event.MouseAdapter() {
        	public void mouseEntered(java.awt.event.MouseEvent evt) {
        		aboutGameButton.setBackground(new Color(2,162,160));
        		aboutGameButton.setForeground(Color.WHITE);
            }
        	public void mouseExited(java.awt.event.MouseEvent evt) {
        		aboutGameButton.setBackground(new Color(245,245,245));
        		aboutGameButton.setForeground(Color.BLACK);
            }
        });
        
        aboutGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (aboutGameButton == e.getSource()) {
                	new About();
                    dispose();
                }
            }
            
        });
        
   
        aboutGameButtonPanel = new JPanel(new GridLayout(1, 1));
        aboutGameButtonPanel.setBorder(BorderFactory.createEmptyBorder(40, 25, 40, 25));
        aboutGameButtonPanel.add(aboutGameButton);
        
        
        
        
        exitGameButton = new JButton("Quitter");
        exitGameButton.setFont(new Font("Dialog",Font.PLAIN,24));
        exitGameButton.setBackground(new Color(245,245,245));
        exitGameButton.setFocusPainted(false);
        
        exitGameButton.addMouseListener(new java.awt.event.MouseAdapter() {
        	public void mouseEntered(java.awt.event.MouseEvent evt) {
        		exitGameButton.setBackground(new Color(2,162,160));
        		exitGameButton.setForeground(Color.WHITE);
            }
        	public void mouseExited(java.awt.event.MouseEvent evt) {
        		exitGameButton.setBackground(new Color(245,245,245));
        		exitGameButton.setForeground(Color.BLACK);
            }
        });
        
        exitGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (exitGameButton == e.getSource()) {
                    System.exit(0);
                }
            }
            
        });
        
   
        exitGameButtonPanel = new JPanel(new GridLayout(1, 1));
        exitGameButtonPanel.setBorder(BorderFactory.createEmptyBorder(40, 25, 40, 50));
        exitGameButtonPanel.add(exitGameButton);


        buttonsPanel = new JPanel(new GridLayout(1, 2));
        buttonsPanel.setPreferredSize(new Dimension(600, 150));
        buttonsPanel.add(playGameButtonPanel);
        buttonsPanel.add(aboutGameButtonPanel);
        buttonsPanel.add(exitGameButtonPanel);
    }

}