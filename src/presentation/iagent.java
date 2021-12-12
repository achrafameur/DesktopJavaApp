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

public class iagent extends JFrame {
	JPanel bas = new JPanel(new GridLayout(4,2));
	JButton tc =new JButton("Operations sur les Comptes Courants ");
	JButton te =new JButton("Operations sur les Comptes Epargnes");
	JButton rc =new JButton("Rechercher Un Compte Courant (code) ");
	JButton re =new JButton("Rechercher Un Compte Epargne (code)");
	JButton v =new JButton("Effectuer un Virement (C.C)");
	JButton v1 =new JButton("Effectuer un Virement (C.E)");
	JButton d =new JButton("Consulter la liste des demandes");
	JButton quitter =new JButton("Revenir au menu principale");
	
	ImageIcon i = new ImageIcon("c:/icone/1edc05fca8d46ba2698ddb02e7e9e43f.jpg");
	JLabel titre = new JLabel();
	
	public iagent() {
		titre.setIcon(i);

		this.setVisible(true);
    	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    	this.setTitle("Interface Agent");
    	this.add(titre);
    	bas.add(tc);
    	bas.add(te);
    	bas.add(rc);
    	bas.add(re);
    	bas.add(v);
    	bas.add(v1);
    	bas.add(d);
    	bas.add(quitter);
    	this.add(bas,BorderLayout.SOUTH);
    	this.setSize(500,400);	
	
    	tc.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			new voirCourant();
			dispose();
			}
    	});
	
    	te.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new voirEpargne();
				dispose();
			}
    	});
  
    	rc.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			new rechCourant();
			dispose();
			}
    	});
	
    	re.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new rechEpargne();
				dispose();
			}
    	});

    	v.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new VirementC();
				dispose();
			}
    	});
    	
    	v1.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new VirementE();
				dispose();
			}
    	});
    
    	d.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new VoirDemandes();
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
	        new iagent() ;
	    }
}