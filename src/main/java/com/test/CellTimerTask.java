package com.test;

import java.awt.Component;
import java.util.TimerTask;

import javax.swing.JTable;

public class CellTimerTask extends TimerTask implements Runnable {

	JTable table;
	int row;
	int col;
	Component  component;
	public CellTimerTask(JTable table,int row,int col,Component component) {
		super();
		this.table =table;
		this.row=row;
		this.col=col;
		this.component=component;
	}

	@Override
	public void run() {
		System.out.println("Cell threedd  run called");
		final CustomTableModel model = (CustomTableModel) table.getModel();
		model.fireTableCellUpdated(row, col);
		component.setBackground(null);
		component.setForeground(null);
		this.cancel();

	}


}
