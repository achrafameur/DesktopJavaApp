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

public class iclient extends JFrame {
	JPanel bas = new JPanel(new GridLayout(4,1));
	JButton cc =new JButton("Ajouter Un Compte Courant ");
	JButton ce =new JButton("Ajouter Un Compte Epargne");
	JButton dc =new JButton("Ajouter Une Demande de Carnet de chèque");
	JButton quitter =new JButton("Revenir au menu principale");
	
	ImageIcon i = new ImageIcon("c:/icone/cartes-compte-courant.jpg");
	JLabel titre = new JLabel();
	
	public iclient() {
		titre.setIcon(i);

		this.setVisible(true);
    	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    	this.setTitle("Interface Agent");
    	this.add(titre);
    	bas.add(cc);
    	bas.add(ce);
    	bas.add(dc);
    	bas.add(quitter);
    	this.add(bas,BorderLayout.SOUTH);
    	this.setSize(600,350);	
	
    	cc.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			new ajoutCourant();
			dispose();
			}
    	});
	
    	ce.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new ajoutEpargne();
				dispose();
			}
    	});
    	
    	dc.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new DemandeCarnetC();
				dispose();
			}
    	});
    	
    	quitter.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			new Home();
			dispose();
			}
    	});
	}
	
	
	 public static void main(String[] args) {
	        new iclient() ;
	    }
}
