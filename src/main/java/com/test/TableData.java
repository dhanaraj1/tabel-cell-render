package com.test;

public class TableData implements Cloneable {
	String aa;
	String bb;
	String cc;
	Integer dd;
	Integer ee;
	public TableData(String aa2, String bb2, String cc2, Integer dd2, Integer ee2) {
	}
	public TableData() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch (final CloneNotSupportedException e) {
			return new TableData(this.aa, this.bb,this.cc,this.dd,this.ee);
		}
	}
	/**
	 * @return the aa
	 */
	public String getAa() {
		return aa;
	}
	/**
	 * @param aa the aa to set
	 */
	public void setAa(String aa) {
		this.aa = aa;
	}
	/**
	 * @return the bb
	 */
	public String getBb() {
		return bb;
	}
	/**
	 * @param bb the bb to set
	 */
	public void setBb(String bb) {
		this.bb = bb;
	}
	/**
	 * @return the cc
	 */
	public String getCc() {
		return cc;
	}
	/**
	 * @param cc the cc to set
	 */
	public void setCc(String cc) {
		this.cc = cc;
	}
	/**
	 * @return the dd
	 */
	public Integer getDd() {
		return dd;
	}
	/**
	 * @param dd the dd to set
	 */
	public void setDd(Integer dd) {
		this.dd = dd;
	}
	/**
	 * @return the ee
	 */
	public Integer getEe() {
		return ee;
	}
	/**
	 * @param ee the ee to set
	 */
	public void setEe(Integer ee) {
		this.ee = ee;
	}

}
