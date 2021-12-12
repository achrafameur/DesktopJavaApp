package presentation;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import dao.Gestion;
import dao.IGestion;
import dao.SingletonConnection;
import metier.entity.CompteCourant;


public class rechCourant extends JFrame{
	    IGestion a = new Gestion();
        JLabel l =new JLabel("Selectionner le code du compte :");
        JComboBox combo;
        JButton rechercher = new JButton ("rechercher");
        IGestion gestion = new Gestion();
    	JPanel haut = new JPanel();
    	JButton quitter1 = new JButton ("Quitter");
    	JButton quitter = new JButton ("Revenir au menu pr�c�dent ");
    	JPanel bas = new JPanel();
        TableModele me = new TableModele();
        JTable table =new JTable(me);
        JScrollPane jsp = new JScrollPane(table);
        
        public rechCourant() {
        	combo=new JComboBox();
        	
        	this.setTitle("Rechercher Un Compte Courant");
        	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        	this.setVisible(true);
        	haut.add(l);
        	haut.add(combo);
        	haut.add(rechercher);
        	this.add(haut,BorderLayout.NORTH);
        	me.charger(gestion.getAllCourants());
        	this.add(jsp,BorderLayout.CENTER);
        	bas.add(quitter1);
        	bas.add(quitter);
        	this.add(bas,BorderLayout.SOUTH);
        	this.setSize(500,400);
        
        	RemplirCombo();

        	rechercher.addActionListener(e-> {
    				// TODO Auto-generated method stub  
        		int i = ((Integer)combo.getSelectedItem()).intValue();
        		//Integer i=Integer.valueOf((String)combo.getSelectedItem()); 
				List<CompteCourant> liste = gestion.rechercheCourantParcode(i);
				me.charger(liste);			
        	});
        	
        	quitter.addActionListener(e-> {
        		new iagent();	
        		dispose();
        	    });


        	quitter1.addActionListener(e-> {
        		dispose();	 
        	    });
    	
        }
        
    	public List<CompteCourant> RemplirCombo() {
    		Connection cx =SingletonConnection.getConnection();
    		List<CompteCourant> liste = new ArrayList<>();
    		try {
    			PreparedStatement ps = cx.prepareStatement("select * from comptecourant");
    			ResultSet rs=ps.executeQuery();
    			while(rs.next()) {
    				int code = rs.getInt("code");
    			    combo.addItem(code);
    			}
    		}catch(SQLException e) {
    			e.printStackTrace();
    		}
    		return liste ;
    	}

		public static void main(String[] args) {
            new rechCourant () ;
        }
	

}