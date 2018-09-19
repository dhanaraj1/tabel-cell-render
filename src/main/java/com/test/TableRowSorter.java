package com.test;

import java.util.Comparator;

public class TableRowSorter extends javax.swing.table.TableRowSorter<CustomTableModel>  {


	public TableRowSorter(CustomTableModel myTableModel) {
		super(myTableModel);
		for (int i=0;i<myTableModel.getColumnCount();i++) {
			super.setComparator(i, new Comparator<String>() {

				String nameB;
				@Override
				public int compare(String o111, String o222) {

					System.out.println("o111 "+o111+" o222 "+o222);
					if (o111 != null && o222 != null) {
						nameB=o222;
						return o111.compareTo(o222) ;
					} else if(o111 == null && o222 == null)  {

						return 0;
					} else if (o111==null && o222 !=null) {
						nameB=o222;
						return 0;
					}else if (o111!=null && o222 ==null) {
						if (nameB==null)
						{
							return 0;
						}

						return o111.compareTo(nameB);
					}


					return 0;
				}
			});
		}
	}
}
