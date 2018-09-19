package com.test;

import java.awt.Color;
import java.awt.Component;
import java.lang.reflect.Field;
import java.util.Timer;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import com.test.util.ApplicationConstants;

public class CustomCellRendrer extends DefaultTableCellRenderer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final Timer timer = new Timer();

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
		final Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus,

				row, col);
		System.out.println("data "+value);
		try {
			//if (!this.getClass().equals(String.class))return component;
			
			CustomTableModel customTableModel=(CustomTableModel) table.getModel();
			
			final Field declaredField = TableData.class.getDeclaredField(ApplicationConstants.COLUMN_FILELD_PAIR.get(customTableModel.getColumnName(col)));
			declaredField.setAccessible(Boolean.TRUE);
			
			Float oldValue = (Float) declaredField.get(customTableModel.getOldData().get(row));
			Float newValue=(Float) value;
			
			declaredField.set(customTableModel.getOldData().get(row), newValue);
			System.out.println("oldValue  -- " +oldValue+"new "+newValue);
			if (oldValue == null || newValue == null) return component;
			
			switch (oldValue.compareTo(newValue)) {
			
			case -1:
				component.setBackground(Color.BLUE);
				component.setForeground(Color.WHITE);
				
				timer.schedule(new CellTimerTask(table, row, col,component),ApplicationConstants.BLINK_DURATION);
				
				return component;
			case 1:
				component.setBackground(Color.RED);
				component.setForeground(Color.WHITE);

				timer.schedule(new CellTimerTask(table, row, col,component),ApplicationConstants.BLINK_DURATION);
				
				return component;
				
			default:
				component.setBackground(null);
				component.setForeground(null);
				break;
			}
			


		} catch (final Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return component;
	}
}
