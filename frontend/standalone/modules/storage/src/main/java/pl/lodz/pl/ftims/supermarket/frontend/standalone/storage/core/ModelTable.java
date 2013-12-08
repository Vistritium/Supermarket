package pl.lodz.pl.ftims.supermarket.frontend.standalone.storage.core;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class ModelTable extends DefaultTableModel {

	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}
	
	

}
