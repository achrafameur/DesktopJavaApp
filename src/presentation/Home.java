package presentation;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Home extends JFrame {
	JPanel bas = new JPanel(new GridLayout(3,1));
	JButton client =new JButton("Accés en tant que Client");
	JButton agent =new JButton("Accés en tant que agent de la banque");
	JButton quitter =new JButton("Quitter");
	
	ImageIcon i = new ImageIcon("c:/icone/dessin-anime-retro-banque-palais-justice-illustration-colonnes-isolee-blanc_53562-8133.jpg");
	JLabel titre = new JLabel();
	
	public Home() {
		titre.setIcon(i);
		this.setVisible(true);
    	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    	this.setTitle("Page Home");
    	this.add(titre);
    	bas.add(client);
    	bas.add(agent);
    	bas.add(quitter);
    	this.add(bas,BorderLayout.SOUTH);
    	this.setSize(600,600);	
	
    	client.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			new iclient();
			dispose();
			}
    	});
	
    	agent.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new iagent();
				dispose();
			}
    	});
    	quitter.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			System.exit(0);
			}
    	});
	}
	
	
	 public static void main(String[] args) {
	        new Home() ;
	    }
}


