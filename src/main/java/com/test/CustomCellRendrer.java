package com.test;

import java.awt.Color;
import java.awt.Component;
import java.lang.reflect.Field;
import java.util.Timer;

import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

import com.test.util.ApplicationConstants;

import sun.swing.DefaultLookup;

public class CustomCellRendrer extends DefaultTableCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color unselectedForeground;
	private Color unselectedBackground;

	private static final Border SAFE_NO_FOCUS_BORDER = new EmptyBorder(1, 1, 1, 1);
	private static final Border DEFAULT_NO_FOCUS_BORDER = new EmptyBorder(1, 1, 1, 1);
	final Timer timer = new Timer();

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int col) {
		final Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus,

				row, col);
		try {
			// if (!this.getClass().equals(String.class))return component;

			CustomTableModel customTableModel = (CustomTableModel) table.getModel();

			final Field declaredField = TableData.class
					.getDeclaredField(ApplicationConstants.COLUMN_FILELD_PAIR.get(customTableModel.getColumnName(col)));
			declaredField.setAccessible(Boolean.TRUE);

			Float oldValue = (Float) declaredField.get(customTableModel.getOldData().get(row));
			Float newValue = (Float) value;

			declaredField.set(customTableModel.getOldData().get(row), newValue);
			System.out.println("oldValue  -- " + oldValue + "new " + newValue);

	//		rowSelection(isSelected, hasFocus, table, row, col);

			if (oldValue == null || newValue == null)
				return component;

			switch (oldValue.compareTo(newValue)) {

			case -1:
				component.setBackground(Color.BLUE);
				component.setForeground(Color.WHITE);

				timer.schedule(new CellTimerTask(table, row, col, component), ApplicationConstants.BLINK_DURATION);

				return component;
			case 1:
				component.setBackground(Color.RED);
				component.setForeground(Color.WHITE);

				timer.schedule(new CellTimerTask(table, row, col, component), ApplicationConstants.BLINK_DURATION);

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

	private void rowSelection(boolean isSelected, boolean hasFocus, JTable table, int row, int column) {

		Color fg = super.getForeground();
		Color bg = super.getBackground();

		JTable.DropLocation dropLocation = table.getDropLocation();
		if (dropLocation != null && !dropLocation.isInsertRow() && !dropLocation.isInsertColumn()
				&& dropLocation.getRow() == row && dropLocation.getColumn() == column) {

			fg = DefaultLookup.getColor(this, ui, "Table.dropCellForeground");
			bg = DefaultLookup.getColor(this, ui, "Table.dropCellBackground");

			isSelected = true;
		}
		if (isSelected) {
			super.setForeground(fg == null ? table.getSelectionForeground() : fg);
			super.setBackground(bg == null ? table.getSelectionBackground() : bg);
		} else {
			Color background = unselectedBackground != null ? unselectedBackground : table.getBackground();
			if (background == null || background instanceof javax.swing.plaf.UIResource) {
				Color alternateColor = DefaultLookup.getColor(this, ui, "Table.alternateRowColor");
				if (alternateColor != null && row % 2 != 0) {
					background = alternateColor;
				}
			}
			super.setForeground(unselectedForeground != null ? unselectedForeground : table.getForeground());
			super.setBackground(background);
		}

		if (hasFocus) {
			Border border = null;
			if (isSelected) {
				border = DefaultLookup.getBorder(this, ui, "Table.focusSelectedCellHighlightBorder");
			}
			if (border == null) {
				border = DefaultLookup.getBorder(this, ui, "Table.focusCellHighlightBorder");
			}
			setBorder(border);

			if (!isSelected && table.isCellEditable(row, column)) {
				Color col;
				col = DefaultLookup.getColor(this, ui, "Table.focusCellForeground");
				if (col != null) {
					super.setForeground(col);
				}
				col = DefaultLookup.getColor(this, ui, "Table.focusCellBackground");
				if (col != null) {
					super.setBackground(col);
				}
			}
		} else {
			setBorder(getNoFocusBorder());
		}

	}

	private Border getNoFocusBorder() {
		Border border = DefaultLookup.getBorder(this, ui, "Table.cellNoFocusBorder");
		if (System.getSecurityManager() != null) {
			if (border != null)
				return border;
			return SAFE_NO_FOCUS_BORDER;
		} else if (border != null) {
			if (noFocusBorder == null || noFocusBorder == DEFAULT_NO_FOCUS_BORDER) {
				return border;
			}
		}
		return noFocusBorder;
	}
}
