package QuizGame;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About extends JFrame {

    JPanel bannerPanel;
    JLabel bannerLabel;

    JPanel buttonsPanel;

    JPanel homeGameButtonPanel;
    JButton homeGameButton;
    

    public About() {
        super("Covid-19 A propos");
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
        bannerLabel.setIcon(new ImageIcon(getClass().getResource("/images/about.jpg")));
        bannerPanel = new JPanel();
        bannerPanel.add(bannerLabel);
        bannerPanel.setPreferredSize(new Dimension(800, 350));
        bannerPanel.setBackground(Color.WHITE);
    }
        
    public void ButtonsPanel() {
        homeGameButton = new JButton("Accueil");
        homeGameButton.setFont(new Font("Dialog",Font.PLAIN,24));
        homeGameButton.setBackground(new Color(245,245,245));
        homeGameButton.setFocusPainted(false);
        
        homeGameButton.addMouseListener(new java.awt.event.MouseAdapter() {
        	public void mouseEntered(java.awt.event.MouseEvent evt) {
        		homeGameButton.setBackground(new Color(2,162,160));
        		homeGameButton.setForeground(Color.WHITE);
            }
        	public void mouseExited(java.awt.event.MouseEvent evt) {
        		homeGameButton.setBackground(new Color(245,245,245));
        		homeGameButton.setForeground(Color.BLACK);
            }
        });
        
        homeGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (homeGameButton == e.getSource()) {
                    new Home();
                    dispose();
                }
            }
            
        });
        
   
        homeGameButtonPanel = new JPanel(new GridLayout(1, 1));
        homeGameButtonPanel.setBorder(BorderFactory.createEmptyBorder(40, 295, 40, 295));
        homeGameButtonPanel.add(homeGameButton);


        buttonsPanel = new JPanel(new GridLayout(1, 2));
        buttonsPanel.setPreferredSize(new Dimension(600, 150));
        buttonsPanel.add(homeGameButtonPanel);

    }

}