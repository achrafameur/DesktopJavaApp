package presentation;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

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
import metier.entity.CompteEpargne;

public class ajoutEpargne extends JFrame {
	
	JPanel haut = new JPanel(new GridLayout(1,2,5,5));
	
	JPanel GaucheH = new JPanel(new GridLayout(6,1,5,5));
	JLabel solde = new JLabel("solde");
    JTextField tsolde = new JTextField();
    JLabel type = new JLabel("Type");
    JTextField ttype = new JTextField();
    JLabel taux = new JLabel("taux");
    JTextField ttaux = new JTextField();

	JPanel DroiteH = new JPanel(new GridLayout(2,1));
    JButton ajouter = new JButton ("Ajouter");
    JButton annuler = new JButton ("Annuler");
    
    JPanel bas = new JPanel();
    JButton quitter = new JButton ("Revenir Au menu Précédent");
    JButton quitter1 = new JButton ("Quitter");
    
    JPanel prs = new JPanel(new GridLayout(1,1));
    IGestion gestion=new Gestion();
    TabModele me = new TabModele();
    JTable table =new JTable(me);
    JScrollPane jsp = new JScrollPane(table);
    
    public ajoutEpargne() {
    	ttype.setText("Compte Epargne");
    	ttype.setEditable(false);
    	GaucheH.add(solde);
    	GaucheH.add(tsolde);
    	GaucheH.add(taux);
    	GaucheH.add(ttaux);
    	GaucheH.add(type);
    	GaucheH.add(ttype);
    	
    	DroiteH.add(ajouter);
    	DroiteH.add(annuler);
    	
    	haut.add(GaucheH);
    	haut.add(DroiteH);
    	this.add(haut,BorderLayout.NORTH);
    	prs.add(jsp);
    	this.add(prs,BorderLayout.CENTER);
    	bas.add(quitter);
    	bas.add(quitter1);
    	this.add(bas,BorderLayout.SOUTH);
    	
    	this.setTitle("Ajouter des Comptes Epargnes");
    	this.setSize(700,700);
    	setVisible(true);
    	
    	ajouter.addActionListener(e-> {
    		Double ss,tt;
    		String s=tsolde.getText();
            String t=ttaux.getText();
            String type=ttype.getText();
            if(s.equals("")||t.equals(""))
    			  JOptionPane.showMessageDialog(this, "SVP Remplir Tous les champs ");
    		else {
      			  CompteEpargne ce=new CompteEpargne(ss=Double.parseDouble(s),tt=Double.parseDouble(t),type);
    		      gestion.addCompteEpargne(ce);
        		  me.charger(gestion.getAllEpargnes());
        		  tsolde.setText("");
        		  ttaux.setText("");
    	    }	
        });
    	
    	annuler.addActionListener(e-> {
       	 tsolde.setText("");
       	 ttaux.setText("");
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
        new ajoutEpargne() ;
    }
    
}

