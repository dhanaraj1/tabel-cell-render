package com.test;

import java.util.Comparator;

public class TableRowSorter extends 	javax.swing.table.TableRowSorter<CustomTableModel>  {


	public TableRowSorter(CustomTableModel myTableModel) {
		super(myTableModel);
		for (int i=0;i<myTableModel.getColumnCount();i++) {
			super.setComparator(i, new Comparator<Float>() {

				Float nameB;
				@Override
				public int compare(Float o111, Float o222) {

					System.out.println("o111 "+o111+" o222 "+o222);
					if (o111 != null && o222 != null) {
						System.out.println("1");
						nameB=o222;
						return o111.compareTo(o222) ;
					} else if(o111 == null && o222 == null)  {
						System.out.println("2");
						return 0;
					} else if (o111==null && o222 !=null) {
						nameB=o222;
						System.out.println("3");
						return 0;
					}else if (o111!=null && o222 ==null) {
						if (nameB==null)
						{
							System.out.println("4");
							return 0;
						}
						System.out.println("5");
						return o111.compareTo(nameB);
					}

					System.out.println("6");
					return 0;
				}
			});
		}
	}
}
