package com.test;

public class TableData implements Cloneable {
	float aa;
	float bb;
	float cc;
	Integer dd;
	Integer ee;
	public TableData(float aa2, float bb2, float cc2, Integer dd2, Integer ee2) {
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
	
	public float getAa() {
		return aa;
	}
	public void setAa(float aa) {
		this.aa = aa;
	}
	public float getBb() {
		return bb;
	}
	public void setBb(float bb) {
		this.bb = bb;
	}
	public float getCc() {
		return cc;
	}
	public void setCc(float cc) {
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
