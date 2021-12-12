package presentation;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import metier.entity.CarnetCh�que;

public class TabM extends AbstractTableModel {
			private String titres[]= {"Id","Nom","Prenom","Nbre Pages"};
			private List<CarnetCh�que> cc =new ArrayList<>();

			
			@Override
			public int getColumnCount() {
				// TODO Auto-generated method stub
				return titres.length;
			}

			@Override
			public int getRowCount() {
				// TODO Auto-generated method stub
				return cc.size();
			}

			@Override
			public Object getValueAt(int l, int c) {
					switch(c) {
					case 0 :return cc.get(l).getId();
					case 1 :return cc.get(l).getNom();	
					case 2 :return cc.get(l).getPrenom();
					case 3 :return cc.get(l).getNbpages();
					}
				return null;
			}
			
			public String getColumnName(int column) {
				return titres[column];
			}
			
			public void charger(List<CarnetCh�que> cc) {
				this.cc =cc;
				fireTableDataChanged();
			}

}