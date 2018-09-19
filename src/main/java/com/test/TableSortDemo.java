
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
		CustomCellRendrer cellRendrer=new CustomCellRendrer();

		table.getColumn("First Name").setCellRenderer(cellRendrer);


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
		listOfData.get(0).setAa(25);
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
			data.setAa(i);
			data.setBb(i);
			data.setCc(i);
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

		frame.setMaximumSize(new Dimension(700, 700));

		//Display the window.
		frame.pack();
		frame.setVisible(true);
		try {
			Thread.sleep(3000);
		} catch (final InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		listOfData.get(0).setAa(3);

myTableModel.fireTableDataChanged();
	}

	public static void main(String[] args) {
		new TableSortDemo();
	}
}
