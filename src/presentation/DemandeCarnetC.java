package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import dao.Carnet;
import dao.Gestion;
import dao.ICarnet;
import dao.IGestion;
import metier.entity.CarnetChèque;
import metier.entity.CompteCourant;

public class DemandeCarnetC extends JFrame{
	JPanel haut = new JPanel(new GridLayout(4,2));
	JPanel p=new JPanel(new GridLayout(1,3));
	JLabel nom = new JLabel("Nom");
    JTextField tnom = new JTextField();
    JLabel prenom = new JLabel("Prenom");
    JTextField tprenom = new JTextField();
    JLabel nbp = new JLabel("Veuiller tenir à ma disposition un carnet de chèques de :");
	JRadioButton b1 = new JRadioButton ("25");
	JRadioButton b2 = new JRadioButton ("50");
	JRadioButton b3 = new JRadioButton ("100");
	JButton soumission =new JButton("Soumettre demande");
	JButton annuler =new JButton("Annuler demande");
	 
	JPanel bas = new JPanel();
	JButton quitter1 =new JButton("Quitter");
	JButton quitter =new JButton("Revenir au menu précédent");
	
	JPanel prs = new JPanel(new GridLayout(1,1));
    ICarnet gestion=new Carnet();
    TabMod me = new TabMod();
    JTable table =new JTable(me);
    JScrollPane jsp = new JScrollPane(table);	
	
	public DemandeCarnetC() {
		this.setVisible(true);
    	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    	this.setTitle("Interface de damande de carnet chèque");
    	this.setSize(600,400);
    	setVisible(true);
    	
    	 ButtonGroup bg=new ButtonGroup();
       	 bg.add(b1);
       	 bg.add(b2);
       	 bg.add(b3);
       	 p.add(b1);
       	 p.add(b2);
       	 p.add(b3);
       	haut.add(nom);
       	haut.add(tnom);
       	haut.add(prenom);
       	haut.add(tprenom);
       	haut.add(nbp);
       	haut.add(p);
       	haut.add(soumission);
       	haut.add(annuler);
       	haut.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),"Formulaire des demandes"));
       	this.add(haut,BorderLayout.NORTH);
    	prs.add(jsp);
    	this.add(prs,BorderLayout.CENTER);
       	bas.add(quitter);
       	bas.add(quitter1);
    	this.add(bas,BorderLayout.SOUTH);
    	
    	soumission.addActionListener(e-> {
    		int i;
    		String n=tnom.getText();
            String p=tprenom.getText();
            String nbp="";
            if(b1.isSelected())
          		 nbp=b1.getText();
          	else if(b2.isSelected())
         		 nbp=b2.getText();
          	else if(b3.isSelected())
        		 nbp=b3.getText();         
            if(n.equals("")||p.equals(""))
    			  JOptionPane.showMessageDialog(this, "SVP Remplir Tous les champs ");
    		else {
  			  CarnetChèque cc=new CarnetChèque(n,p,i=Integer.parseInt(nbp));
		      gestion.addDCarnet(cc);;
		      me.charger(gestion.getAllDemandes());
	          tnom.setText("");
	          tprenom.setText("");
	          bg.clearSelection();
    	    }	
        });
    	
    	annuler.addActionListener(e-> {
          	 tnom.setText("");
          	 tprenom.setText("");
          	 bg.clearSelection();
           });
    	
    	quitter.addActionListener(e-> {
    		new iclient();	
    		dispose();
    	    });


    	quitter1.addActionListener(e-> {
    		dispose();	 
    	    });
    	
    	
	}
	
	
	 public static void main(String[] args) {
	        new DemandeCarnetC() ;
	    }
}
