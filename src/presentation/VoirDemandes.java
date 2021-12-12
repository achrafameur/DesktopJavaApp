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
import javax.swing.table.DefaultTableModel;

import dao.Carnet;
import dao.Gestion;
import dao.ICarnet;
import dao.IGestion;
import metier.entity.CarnetChèque;
import metier.entity.CompteCourant;


public class VoirDemandes extends JFrame{

	JPanel p1 = new JPanel(new GridLayout(1,1));
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel(new GridLayout(3,1));
	JPanel p4 = new JPanel();
	JPanel p5 = new JPanel();
	JPanel p6 = new JPanel();
	
	JButton quitter1 = new JButton ("Quitter");
	JButton quitter = new JButton ("Revenir Au menu Précédent");
	
	JLabel accepter = new JLabel("Approuver la Demande :");
    JButton a = new JButton ("Accepter");
    JLabel supprimer = new JLabel("Supprimer la Demande :");
    JButton s = new JButton ("Supprimer");
    JLabel nom = new JLabel("Saisir le nom :");
    JTextField tnom = new JTextField(10);
    
	ICarnet gestion=new Carnet();
	TabM m = new TabM();
	JTable t = new JTable(m);
    TabMod me = new TabMod();
    JTable table =new JTable(me);
    JScrollPane jsp = new JScrollPane(table);
	
	public VoirDemandes() {
		
		me.charger(gestion.getAllDemandes());
		p1.add(jsp);
		p1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),"Tableau des Demandes"));
		p2.add(quitter);
		p2.add(quitter1);
    	this.add(p1,BorderLayout.NORTH);
    	p4.add(accepter);
    	p4.add(a);
        p5.add(nom);
        p5.add(tnom);
    	p6.add(supprimer);
    	p6.add(s);
    	p3.add(p5);
    	p3.add(p4);
    	p3.add(p6);
    	p3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),"Operations sur les Demandes"));
    	this.add(p3,BorderLayout.CENTER);
    	this.add(p2,BorderLayout.SOUTH);
    	
		this.setTitle("Liste des demandes de chèques");
    	this.setSize(700,700);
    	setVisible(true);
    	
    	s.addActionListener(e-> {
    		    if(tnom.getText().equals(""))
    		       JOptionPane.showMessageDialog(this, "Veuiller remplir le champ !!");
    		    else if(table.getRowCount()>=1) {
    		     gestion.suppCarnet(tnom.getText());
    		     me.charger(gestion.getAllDemandes());
    		     JOptionPane.showMessageDialog(this, "Demande supprimée avec succés !!");
    		     tnom.setText("");
    		    }else{
	    			if(table.getRowCount() == 0) {
	    			     JOptionPane.showMessageDialog(this, "Tableau de damande est Vide !!");
	    		    }else {
	    		    	JOptionPane.showMessageDialog(this, "Selectionner la demande à supprimer!!");
	    		    }
	    }
	   });
    	
    	a.addActionListener(e-> {	
		  String text=tnom.getText();
		  if(table.getRowCount()>=1) {
 		     gestion.addCarnetA(gestion.getCarnet(text));
 		     //me.charger(gestion.getAllDemandes());
 		     JOptionPane.showMessageDialog(this, "Demande acceptée avec succés !!");
 		     gestion.suppCarnet(tnom.getText());
 		     me.charger(gestion.getAllDemandes());
 		     tnom.setText("");
 		    }else {
	    			if(table.getRowCount() == 0) {
	    			     JOptionPane.showMessageDialog(this, "Tableau de damande est Vide !!");
	    		    }else {
	    		    	JOptionPane.showMessageDialog(this, "Selectionner la demande à Accepter!!");
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
	        new VoirDemandes() ;
	    }
}