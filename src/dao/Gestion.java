package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.entity.CarnetChèque;
import metier.entity.CompteCourant;
import metier.entity.CompteEpargne;

public class Gestion implements IGestion{

	@Override
	public void addcompteCourant(CompteCourant c) {
		// TODO Auto-generated method stub
		Connection cx =SingletonConnection.getConnection();
	    try {
	    	PreparedStatement st= cx.prepareStatement("insert into comptecourant (solde,decouvert,type) values(?,?,?)");
	    	st.setDouble(1, c.getSolde());
	    	st.setDouble(2, c.getDecouvert());
	    	st.setString(3, c.getType());
	    	st.executeUpdate();
	    }catch(SQLException e1){
	    	e1.printStackTrace();
	    }
		
	}

	@Override
	public void addCompteEpargne(CompteEpargne e) {
		// TODO Auto-generated method stub
		Connection cx =SingletonConnection.getConnection();
	    try {
	    	PreparedStatement st= cx.prepareStatement("insert into compteepargne (solde,taux,type) values(?,?,?)");
	    	st.setDouble(1, e.getSolde());
	    	st.setDouble(2, e.getTaux());
	    	st.setString(3, e.getType());
	    	st.executeUpdate();
	    }catch(SQLException e1){
	    	e1.printStackTrace();
	    }
	}

	@Override
	public List<CompteCourant> getAllCourants() {
		// TODO Auto-generated method stub
		Connection cx =SingletonConnection.getConnection();
		List<CompteCourant> liste = new ArrayList<>();
		try {
			PreparedStatement ps = cx.prepareStatement("select * from comptecourant");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				CompteCourant c =new CompteCourant();
				c.setCode(rs.getInt(1));
				c.setSolde(rs.getDouble(2));
				c.setDecouvert(rs.getDouble(3));
				c.setType(rs.getString(4));
				liste.add(c);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return liste ;
	}

	@Override
	public List<CompteEpargne> getAllEpargnes() {
		// TODO Auto-generated method stub
		Connection cx =SingletonConnection.getConnection();
		List<CompteEpargne> liste = new ArrayList<>();
		try {
			PreparedStatement ps = cx.prepareStatement("select * from compteepargne");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				CompteEpargne c =new CompteEpargne();
				c.setCode(rs.getInt(1));
				c.setSolde(rs.getDouble(2));
				c.setTaux(rs.getDouble(3));
				c.setType(rs.getString(4));
				liste.add(c);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return liste ;
	}

	@Override
	public List<CompteCourant> rechercheCourantParcode(int code) {
		// TODO Auto-generated method stub
		Connection cx =SingletonConnection.getConnection();
		List<CompteCourant> liste = new ArrayList<>();
		try {
			PreparedStatement ps = cx.prepareStatement("select * from comptecourant where code like ?");
			ps.setString(1, "%"+code+"%");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				CompteCourant c =new CompteCourant();
				c.setCode(rs.getInt(1));
				c.setSolde(rs.getDouble(2));
				c.setDecouvert(rs.getDouble(3));
				c.setType(rs.getString(4));
				liste.add(c);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return liste ;
	}

	@Override
	public List<CompteEpargne> rechercheEpargneParcode(int code) {
		// TODO Auto-generated method stub
		Connection cx =SingletonConnection.getConnection();
		List<CompteEpargne> liste = new ArrayList<>();
		try {
			PreparedStatement ps = cx.prepareStatement("select * from compteepargne  where code like ?");
			ps.setString(1, "%"+code+"%");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				CompteEpargne c =new CompteEpargne();
				c.setCode(rs.getInt(1));
				c.setSolde(rs.getDouble(2));
				c.setTaux(rs.getDouble(3));
				c.setType(rs.getString(4));
				liste.add(c);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return liste ;
	}

	@Override
	public void OpCourant(int code ,double solde) {
		// TODO Auto-generated method stub
		Connection cx =SingletonConnection.getConnection();
		  try {
		    	PreparedStatement st= cx.prepareStatement("update comptecourant set solde=? where code=?");
		    	st.setDouble(1,solde);
		    	st.setInt(2,code);
		    	st.executeUpdate();
		    }catch(SQLException e1){
		    	e1.printStackTrace();
		    }
		
	}

	
	@Override
	public void OpEpargne(int code,double solde) {
		// TODO Auto-generated method stub
		Connection cx =SingletonConnection.getConnection();
		  try {
		    	PreparedStatement st= cx.prepareStatement("update compteepargne set solde=? where code=?");
		    	st.setDouble(1,solde);
		    	st.setInt(2,code);
		    	st.executeUpdate();
		    }catch(SQLException e1){
		    	e1.printStackTrace();
		    }
	}

	@Override
	public void SuppCourant(int code) {
		// TODO Auto-generated method stub
		Connection cx =SingletonConnection.getConnection();
		try {
		      PreparedStatement ps = cx.prepareStatement("delete from comptecourant where code=?");	
		      ps.setInt(1,code);
		      ps.executeUpdate();
		}catch(SQLException ee) {
			ee.printStackTrace();
		}		
	}

	@Override
	public void SuppEpargne(int code) {
		// TODO Auto-generated method stub
		Connection cx =SingletonConnection.getConnection();
		try {
		      PreparedStatement ps = cx.prepareStatement("delete from compteepargne where code=?");	
		      ps.setInt(1,code);
		      ps.executeUpdate();
		}catch(SQLException ee) {
			ee.printStackTrace();
		}		
	}

	@Override
	public CompteCourant getCourant(int code) {
		// TODO Auto-generated method stub
		Connection cx =SingletonConnection.getConnection();
		CompteCourant c = new CompteCourant() ;
		try {
			PreparedStatement ps = cx.prepareStatement("select * from comptecourant where code=?");
			ps.setInt(1, code);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				c.setCode(rs.getInt(1));
				c.setSolde(rs.getDouble(2));
				c.setDecouvert(rs.getDouble(3));
				c.setType(rs.getString(4));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public CompteEpargne getEpargne(int code) {
		// TODO Auto-generated method stub
		Connection cx =SingletonConnection.getConnection();
		CompteEpargne c = new CompteEpargne() ;
		try {
			PreparedStatement ps = cx.prepareStatement("select * from compteepargne where code=?");
			ps.setInt(1, code);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				c.setCode(rs.getInt(1));
				c.setSolde(rs.getDouble(2));
				c.setTaux(rs.getDouble(3));
				c.setType(rs.getString(4));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return c;
	}




}
