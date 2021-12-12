package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


import dao.Gestion;
import dao.IGestion;
import metier.entity.CompteCourant;


public class voirCourant extends JFrame{

	JPanel p1 = new JPanel(new GridLayout(1,1));
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel(new GridLayout(3,1));
	JPanel p4 = new JPanel();
	JPanel p5 = new JPanel();
	JPanel p6 = new JPanel();
	
	JButton quitter1 = new JButton ("Quitter");
	JButton quitter = new JButton ("Revenir Au menu Précédent");
	
    JLabel id = new JLabel("Saisir le code du compte :");
    JTextField tid = new JTextField(10);
	JLabel retirer = new JLabel("Saisir Montant à retirer :");
    JTextField tretirer = new JTextField(10);
    JButton r = new JButton ("Valider");
    JLabel verser = new JLabel("Saisir Montant à verser :");
    JTextField tverser = new JTextField(10);
    JButton v = new JButton ("Valider");
    
	IGestion gestion=new Gestion();
    TableModele me = new TableModele();
    JTable table =new JTable(me);
    JScrollPane jsp = new JScrollPane(table);
	
	public voirCourant() {
		
		me.charger(gestion.getAllCourants());
		p1.add(jsp);
		p1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),"Tableau des Comptes Courants"));
		p2.add(quitter);
		p2.add(quitter1);
    	this.add(p1,BorderLayout.NORTH);
    	p4.add(retirer);
    	p4.add(tretirer);
    	p4.add(r);
    	p5.add(verser);
    	p5.add(tverser);
    	p5.add(v);
    	p6.add(id);
    	p6.add(tid);
    	p3.add(p6);
    	p3.add(p4);
    	p3.add(p5);
    	p3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),"Operations sur les Comptes Courants"));
    	this.add(p3,BorderLayout.CENTER);
    	this.add(p2,BorderLayout.SOUTH);
    	
		this.setTitle("Liste des Comptes Courants");
		//this.setLocationRelativeTo(null);
		this.setSize(700,700);
    	setVisible(true);
    	
    	v.addActionListener(e-> {
    		String v=tverser.getText();
    		String vs=tid.getText();
    		if(vs.equals("")||v.equals(""))
  			  JOptionPane.showMessageDialog(this, "SVP remplir les champs nécéssaires !! ");
  		    else {
  		    	double v1=Integer.parseInt(v);
  	    		int vd=Integer.parseInt(vs);
  	    		CompteCourant c= gestion.getCourant(vd);
  	    		me.charger(gestion.getAllCourants());
  	    		double s=c.getSolde()+v1;
  	    		gestion.OpCourant(vd,s);
  	    		me.charger(gestion.getAllCourants());
  	    		tid.setText("");
  	    		tverser.setText("");
    		}
    	   });
    	 
    	 r.addActionListener(e-> {
    		String r=tretirer.getText();
    		String vs=tid.getText();
    		if(vs.equals("")||r.equals(""))
  			  JOptionPane.showMessageDialog(this, "SVP remplir les champs nécéssaires !! ");
  		    else {
  		    	double v1=Integer.parseInt(r);
  	    		int vd=Integer.parseInt(vs);
  	    		CompteCourant c= gestion.getCourant(vd);
  	    		me.charger(gestion.getAllCourants());
  	    		double s=c.getSolde()-v1; 
  	    		double d=c.getDecouvert();
  	    		if (s<d) {
  	    			JOptionPane.showMessageDialog(this, "Pas Assez d'argent !! ");
  	  	    		tid.setText("");
  	  	    		tretirer.setText("");}
  	    		else {
  	    		gestion.OpCourant(vd,s);
  	    		me.charger(gestion.getAllCourants());
  	    		tid.setText("");
  	    		tretirer.setText("");
  	    		}
    		}
    	   });
    	
    	
    	quitter.addActionListener(e-> {
    		new iagent();	
    		dispose();
    	    });


    	quitter1.addActionListener(e-> {
    		dispose();	 
    	    });
	
	}
	
	
	 public static void main(String[] args) {
	        new voirCourant() ;
	    }
}