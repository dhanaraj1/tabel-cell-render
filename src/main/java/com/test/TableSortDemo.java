
package com.test;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

/*
 * TableSortDemo.java requires no other files.
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TableSortDemo extends JPanel {
	final String[] columnNames = {"First Name",
			"Last Name",
			"Sport",
			"# of Years",
	"Vegetarian"};
	List<TableData> listOfData=null;
	List<TableData> oldData=null;
	final CustomTableModel myTableModel;
	public TableSortDemo() {
		super(new GridLayout(1,0));

		listOfData= new ArrayList<>();
		fillListdata(listOfData);
		oldData =new ArrayList<>();
		listOfData.stream().forEach(cl->{
			if (cl!=null) {oldData.add((TableData) cl.clone());}

		});
		myTableModel = new CustomTableModel(columnNames,listOfData,oldData);
		final JTable table = new JTable(myTableModel);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);

		table.setAutoCreateRowSorter(false);
		final TableRowSorter tableRowSorter = new TableRowSorter(myTableModel);
		table.setRowSorter(tableRowSorter);

		table.getColumn("First Name").setCellRenderer(new  DefaultTableCellRenderer() {

			private static final long serialVersionUID = 1L;

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
				final Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus,

						row, col);
				final Field declaredFields = TableData.class.getDeclaredFields()[col];
				try {

					if ("i am update".equals(value)	) {
						System.out.println("text ----->"+declaredFields.get(oldData.get(row))+" value  "+value+"  col "+col+" row "+row);
						component.setBackground(Color.BLUE);
						component.setForeground(Color.WHITE);

						final CellThread timerTask =new CellThread(table, row, col,component);

						final Timer tim = new Timer();
						tim.schedule(timerTask,1000);


					}else {
						component.setBackground(null);
						component.setForeground(null);
					}


				} catch (final IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


				return component;
			}
		});


		//Create the scroll pane and add the table to it.
		final JScrollPane scrollPane = new JScrollPane(table);

		//Add the scroll pane to this panel.
		add(scrollPane);

		//new Thread( () -> {

		//			listOfData.get(0).setAa("i am update");
		//			myTableModel.fireTableDataChanged();
		//			listOfData.stream().forEach(cl->{
		//				if (cl!=null) {oldData.add((TableData) cl.clone());}
		//
		//			});
		//}).start();
		listOfData.get(0).setAa("i am update");
		myTableModel.fireTableDataChanged();
		listOfData.stream().forEach(cl->{
			if (cl!=null) {oldData.add((TableData) cl.clone());}

		});
		createAndShowGUI();
		//	table.getColumnModel().getColumn(1).setCellRenderer(table.getDefaultRenderer(Object.class));

		/*JLabel comp =(JLabel) table.getCellRenderer(1,1).getTableCellRendererComponent(table, "AA 0", Boolean.FALSE, Boolean.FALSE, 1, 1);
	comp.setBackground(Color.YELLOW);*/
		//System.out.println(comp);
	}


	private void fillListdata(List<TableData> listOfData) {
		for(int i=0;i<10;i++) {
			final TableData data = new TableData();
			data.setAa("AA "+i);
			data.setBb("BB "+i);
			data.setCc("CC " +i);
			data.setDd(i);
			data.setEe(i);
			listOfData.add(data);
			if (i==5) {
				listOfData.add( new TableData());
			}
		}


		//listOfData.add( new TableData());
	}


	/**
	 * Create the GUI and show it.  For thread safety,
	 * this method should be invoked from the
	 * event-dispatching thread.
	 */
	private  void createAndShowGUI() {
		//Create and set up the window.
		final JFrame frame = new JFrame("TableSortDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Create and set up the content pane.

		//final TableSortDemo newContentPane = new TableSortDemo();
		this.setOpaque(true); //content panes must be opaque
		frame.setContentPane(this);

		frame.setMaximumSize(new Dimension(500, 500));

		//Display the window.
		frame.pack();
		frame.setVisible(true);
		try {
			Thread.sleep(200);
		} catch (final InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		listOfData.get(0).setAa("i am not update");


	}

	public static void main(String[] args) {
		new TableSortDemo();
	}
}
