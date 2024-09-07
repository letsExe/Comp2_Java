package view.tableModel;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.Model;
import model.ModelDisciplina;


public class TableModelDisciplina extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	
	private String[] headers = new String[] { "Identificador", "Nome", "Sigla", "Carga Horaria" };
	
	private ArrayList<Model> list = new ArrayList<Model>();
	
	public void update ( ArrayList<Model> list ) {
		this.list = list;
		fireTableDataChanged();
	}

	public void setData ( ArrayList<Model> list ) {
		this.list = list;
		fireTableDataChanged();
	}
	
	public Model getModel ( int row ) {
		return list.get(row);
	}
	
	@Override
	public String getColumnName(int column) {
		return headers[column];
	}
	
	@Override
	public int getRowCount() {
		return list.size();
	}

	@Override
	public int getColumnCount() {
		return headers.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		ModelDisciplina m = (ModelDisciplina) list.get(rowIndex);
		
		switch (columnIndex) {
			case 0 : return m.getidDisciplina();
			case 1 : return m.getnome();
			case 2 : return m.getsigla();
			case 3 : return m.getcarga_horaria();
		}
		return null;
	}

}
