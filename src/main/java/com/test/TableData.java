package com.test;

public class TableData implements Cloneable {
	Float aa;
	Float bb;
	Float cc;
	Integer dd;
	Integer ee;
	public TableData(Float aa2, Float bb2, Float cc2, Integer dd2, Integer ee2) {
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
	
	public Float getAa() {
		return aa;
	}
	public void setAa(Float aa) {
		this.aa = aa;
	}
	public Float getBb() {
		return bb;
	}
	public void setBb(Float bb) {
		this.bb = bb;
	}
	public Float getCc() {
		return cc;
	}
	public void setCc(Float cc) {
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
