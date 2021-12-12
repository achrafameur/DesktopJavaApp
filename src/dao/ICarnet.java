package dao;

import java.util.List;

import metier.entity.CarnetChèque;

public interface ICarnet {
	public void addDCarnet(CarnetChèque c);
	public List<CarnetChèque> getAllDemandes();
	public void suppCarnet(String nom);
	public void addCarnetA(CarnetChèque c);
	public CarnetChèque getCarnet(String nom);
	
}
