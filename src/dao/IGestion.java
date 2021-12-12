package dao;

import java.util.List;

import metier.entity.CompteCourant;
import metier.entity.CompteEpargne;


public interface IGestion {
	public void addcompteCourant(CompteCourant c);
	public void addCompteEpargne(CompteEpargne e);
	public List<CompteCourant> getAllCourants();
	public List<CompteEpargne> getAllEpargnes();
	public List<CompteCourant> rechercheCourantParcode(int code);
	public List<CompteEpargne> rechercheEpargneParcode(int code); 
	public void OpCourant(int code ,double solde);
	public void OpEpargne(int code ,double solde);
	public void SuppCourant(int code);
	public void SuppEpargne(int code);
	public CompteCourant getCourant(int code);
	public CompteEpargne getEpargne(int code);
}