package dao;

import java.util.List;

import metier.entity.CarnetCh�que;

public interface ICarnet {
	public void addDCarnet(CarnetCh�que c);
	public List<CarnetCh�que> getAllDemandes();
	public void suppCarnet(String nom);
	public void addCarnetA(CarnetCh�que c);
	public CarnetCh�que getCarnet(String nom);
	
}
