package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import metier.entity.CarnetChèque;
import metier.entity.CompteCourant;

public class Carnet implements ICarnet{

	@Override
	public void addDCarnet(CarnetChèque c) {
		// TODO Auto-generated method stub
		Connection cx =SingletonConnection.getConnection();
	    try {
	    	PreparedStatement st= cx.prepareStatement("insert into demandescarnets (nom,prenom,nbpages) values(?,?,?)");
	    	st.setString(1, c.getNom());
	    	st.setString(2, c.getPrenom());
	    	st.setInt(3, c.getNbpages());
	    	st.executeUpdate();
	    }catch(SQLException e1){
	    	e1.printStackTrace();
	    }
		
	}

	@Override
	public List<CarnetChèque> getAllDemandes() {
		// TODO Auto-generated method stub
		Connection cx =SingletonConnection.getConnection();
		List<CarnetChèque> liste = new ArrayList<>();
		try {
			PreparedStatement ps = cx.prepareStatement("select * from demandescarnets");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				CarnetChèque c =new CarnetChèque();
				c.setId(rs.getInt(1));
				c.setNom(rs.getString(2));
				c.setPrenom(rs.getString(3));
				c.setNbpages(rs.getInt(4));
				liste.add(c);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return liste ;
	}

	@Override
	public void suppCarnet(String nom) {
		// TODO Auto-generated method stub
		Connection cx =SingletonConnection.getConnection();
		try {
		      PreparedStatement ps = cx.prepareStatement("delete from demandescarnets where nom=?");	
		      ps.setString(1,nom);
		      ps.executeUpdate();
		}catch(SQLException ee) {
			ee.printStackTrace();
		}
	}

	@Override
	public void addCarnetA(CarnetChèque c) {
		// TODO Auto-generated method stub
		Connection cx =SingletonConnection.getConnection();
	    try {
	    	PreparedStatement st= cx.prepareStatement("insert into demandesac (nom,prenom,nbpages) values(?,?,?)");
	    	st.setString(1, c.getNom());
	    	st.setString(2, c.getPrenom());
	    	st.setInt(3, c.getNbpages());
	    	st.executeUpdate();
	    }catch(SQLException e1){
	    	e1.printStackTrace();
	    }
	}

	@Override
	public CarnetChèque getCarnet(String nom) {
		// TODO Auto-generated method stub
		Connection cx =SingletonConnection.getConnection();
		CarnetChèque c = new CarnetChèque() ;
		try {
			PreparedStatement ps = cx.prepareStatement("select * from demandescarnets where nom=?");
			ps.setString(1, nom);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				c.setId(rs.getInt(1));
				c.setNom(rs.getString(2));
				c.setPrenom(rs.getString(3));
				c.setNbpages(rs.getInt(4));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
}
