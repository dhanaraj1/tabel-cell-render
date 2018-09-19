package com.test;

import java.lang.reflect.Field;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class CustomTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;

	private final  String[] columnNames;
	private final List<TableData> listOfData;
	private final List<TableData> oldData;

	public CustomTableModel(String[] columnNames, List<TableData> listOfData, List<TableData> oldData) {
		this.columnNames=columnNames;
		this.listOfData=listOfData;
		this.oldData=oldData;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return listOfData.size();
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {
		if(listOfData !=null && listOfData.get(row) !=null) {
			Object val="";
			try {

				listOfData.get(row).getClass().getDeclaredFields()[col].setAccessible(true);
				val = TableData.class.getDeclaredFields()[col].get(listOfData.get(row));
			} catch (final Exception e) {
				e.printStackTrace();

			}
			return val;
		}
		return null;//return data[row][col];
	}

	/*
	 * JTable uses this method to determine the default renderer/
	 * editor for each cell.  If we didn't implement this method,
	 * then the last column would contain text ("true"/"false"),
	 * rather than a check box.
	 */
	@Override
	public Class<? extends Object> getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

	/*
	 * Don't need to implement this method unless your table's
	 * editable.
	 */
	@Override
	public boolean isCellEditable(int row, int col) {
		if (col < 2) {
			return false;
		} else {
			return true;
		}
	}

	/*
	 * Don't need to implement this method unless your table's
	 * data can change.
	 */
	@Override
	public void setValueAt(Object value, int row, int col) {

		listOfData.get(row).getClass().getDeclaredFields()[col].setAccessible(true);
		final Field f1 = listOfData.get(row).getClass().getDeclaredFields()[col];
		try {
			f1.set(listOfData.get(row), value);
		} catch (final Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @return the columnNames
	 */
	public String[] getColumnNames() {
		return columnNames;
	}

	/**
	 * @return the listOfData
	 */
	public List<TableData> getListOfData() {
		return listOfData;
	}

	/**
	 * @return the oldData
	 */
	public List<TableData> getOldData() {
		return oldData;
	}

}