package presentation;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import metier.entity.CompteCourant;

public class TableModele extends AbstractTableModel {
			private String titres[]= {"Code","Solde","Decouvert","Type"};
			private List<CompteCourant> ccourants =new ArrayList<>();

			
			@Override
			public int getColumnCount() {
				// TODO Auto-generated method stub
				return titres.length;
			}

			@Override
			public int getRowCount() {
				// TODO Auto-generated method stub
				return ccourants.size();
			}

			@Override
			public Object getValueAt(int l, int c) {
					switch(c) {
					case 0 :return ccourants.get(l).getCode();
					case 1 :return ccourants.get(l).getSolde();	
					case 2 :return ccourants.get(l).getDecouvert();
					case 3 :return ccourants.get(l).getType();
					}
				return null;
			}
			
			public String getColumnName(int column) {
				return titres[column];
			}
			
			public void charger(List<CompteCourant> ccourants) {
				this.ccourants =ccourants;
				fireTableDataChanged();
			}

}
