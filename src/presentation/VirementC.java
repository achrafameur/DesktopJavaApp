package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import dao.Gestion;
import dao.IGestion;
import dao.SingletonConnection;
import metier.entity.CompteCourant;

public class VirementC extends JFrame{
	    JPanel haut = new JPanel(new GridLayout(1,2,5,5));
	    JPanel phaut = new JPanel(new GridLayout(3,1,5,5));
	    JPanel G = new JPanel(new GridLayout(2,1,5,5));
	    JPanel D = new JPanel(new GridLayout(2,1,5,5));
	    JPanel Gh = new JPanel(new FlowLayout(2));
	    JPanel Gb = new JPanel(new FlowLayout(2));
	    JPanel Dh = new JPanel(new FlowLayout(2));
	    JPanel Db = new JPanel(new FlowLayout(2));
	    JLabel type = new JLabel("Type");
	    JTextField ttype = new JTextField();
	    JLabel type1 = new JLabel("Type");
	    JTextField ttype1 = new JTextField();
	    JLabel id1 = new JLabel("Taper code 1er Compte:");
	    JTextField tid1 = new JTextField(10);
	    JLabel id2 = new JLabel("Taper code 2eme Compte :");
	    JTextField tid2 = new JTextField(10);
	    
	    JPanel p1 = new JPanel(new GridLayout(1,1));
	    
	    JPanel btn = new JPanel();
	    JButton effectuer = new JButton ("Effectuer");
	    JButton annuler = new JButton ("Annuler");
	    
	    JPanel mont = new JPanel();
	    JLabel mt = new JLabel("Saisir le montant a transférer :");
	    JTextField tmt = new JTextField(10);
	    
	    JPanel bas = new JPanel();
	    JButton quitter = new JButton ("Revenir Au menu Précédent");
	    JButton quitter1 = new JButton ("Quitter");
	    
	    IGestion gestion = new Gestion();
	    TableModele me = new TableModele();
        JTable table =new JTable(me);
        JScrollPane jsp = new JScrollPane(table);
	    
	    public VirementC() {
    	ttype.setText("Compte Courant");
    	ttype.setEditable(false);
    	ttype1.setText("Compte Courant");
    	ttype1.setEditable(false);
    	this.setTitle("Virement Compte Courant");
    	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    	this.setVisible(true);
    	Gh.add(type);
    	Gh.add(ttype);
    	Gb.add(id1);
    	Gb.add(tid1);
    	G.add(Gh);
    	G.add(Gb);
    	G.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),"1er Compte"));
    	Dh.add(type1);
    	Dh.add(ttype1);
    	Db.add(id2);
    	Db.add(tid2);
    	D.add(Dh);
    	D.add(Db);
    	D.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),"2eme Compte"));
    	haut.add(G);
    	haut.add(D);
    	btn.add(effectuer);
    	btn.add(annuler);
    	mont.add(mt);
    	mont.add(tmt);
    	phaut.add(haut);
    	phaut.add(mont);
    	phaut.add(btn);
    	phaut.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),"Effectuer Un virement"));
    	this.add(phaut,BorderLayout.NORTH);
		me.charger(gestion.getAllCourants());
		p1.add(jsp);
		p1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),"Tableau des Comptes Courants"));
		this.add(p1,BorderLayout.CENTER);
    	bas.add(quitter1);
    	bas.add(quitter);
    	this.add(bas,BorderLayout.SOUTH);
    	this.setSize(600,600);

    	effectuer.addActionListener(e-> {
				// TODO Auto-generated method stub  
    		String r=tmt.getText();
    		String vs=tid1.getText();
    		String vs1=tid2.getText();
    		if(vs1.equals("")||r.equals("")||vs.equals("")) {
  			  JOptionPane.showMessageDialog(this, "SVP remplir les champs nécéssaires !! ");
	    		tmt.setText("");
	    		tid1.setText("");
	    		tid2.setText("");}
    		else if(vs.equals(vs1)) {
  		    	JOptionPane.showMessageDialog(this, "Opération impossible !! ");
	    		tmt.setText("");
	    		tid1.setText("");
	    		tid2.setText("");
  		    }else {
  		    	double v1=Integer.parseInt(r);
  	    		int vd=Integer.parseInt(vs);
  		    	double v2=Integer.parseInt(r);
  	    		int V3=Integer.parseInt(vs1);
  	    		
  	    		CompteCourant c= gestion.getCourant(vd);
  	    		me.charger(gestion.getAllCourants());
  	    		CompteCourant c1= gestion.getCourant(V3);
  	    		me.charger(gestion.getAllCourants());
  	    		double s=c.getSolde()-v1; 
  	    		double d=c.getDecouvert();
  	    		    if (s<d) {
  	    			     JOptionPane.showMessageDialog(this, "Pas Assez d'argent !! ");}
  	    		    else {
  	    		         gestion.OpCourant(vd,s);
  	    		         me.charger(gestion.getAllCourants());
  	    		         }
  	    		double s1=c1.getSolde()+v2;
  	    		gestion.OpCourant(V3,s1);
  	    		me.charger(gestion.getAllCourants());	
  	    		tmt.setText("");
  	    		tid1.setText("");
  	    		tid2.setText("");
    		}			
    	});
    	
    	annuler.addActionListener(e-> {
				// TODO Auto-generated method stub  
    		tmt.setText("");
    		tid1.setText("");
    		tid2.setText("");
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
            new VirementC() ;
        }
}
