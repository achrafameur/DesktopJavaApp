package presentation;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import metier.entity.CompteEpargne;

public class TabModele extends AbstractTableModel {
			private String titres[]= {"code","Solde","Taux","Type"};
			private List<CompteEpargne> cepargnes =new ArrayList<>();

			
			@Override
			public int getColumnCount() {
				// TODO Auto-generated method stub
				return titres.length;
			}

			@Override
			public int getRowCount() {
				// TODO Auto-generated method stub
				return cepargnes.size();
			}

			@Override
			public Object getValueAt(int l, int c) {
					switch(c) {
					case 0 :return cepargnes.get(l).getCode();
					case 1 :return cepargnes.get(l).getSolde();	
					case 2 :return cepargnes.get(l).getTaux();
					case 3 :return cepargnes.get(l).getType();
					}
				return null;
			}
			
			public String getColumnName(int column) {
				return titres[column];
			}
			
			public void charger(List<CompteEpargne> cepargnes) {
				this.cepargnes =cepargnes;
				fireTableDataChanged();
			}

}