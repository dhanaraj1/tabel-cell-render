package com.test.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.test.util.ApplicationConstants;

public class ClientRequest  {

	@JsonProperty(ApplicationConstants.ALPHABET_CONSTANT.A)
	private List<String> scripts;
	@JsonProperty(ApplicationConstants.ALPHABET_CONSTANT.B)
	private Boolean isFirstTime;
	@JsonProperty(ApplicationConstants.ALPHABET_CONSTANT.C)
	private Object data;
	@JsonProperty(ApplicationConstants.ALPHABET_CONSTANT.H)
	private Boolean wantToStop;
	@JsonProperty(ApplicationConstants.ALPHABET_CONSTANT.I)
	private Boolean wantToStart;
	@JsonProperty(ApplicationConstants.ALPHABET_CONSTANT.J)
	private Boolean isMobile;


	public List<String> getScripts() {
		return scripts;
	}

	public void setScripts(List<String> scripts) {
		this.scripts = scripts;
	}

	public Boolean getIsFirstTime() {
		return isFirstTime;
	}

	public void setIsFirstTime(Boolean isFirstTime) {
		this.isFirstTime = isFirstTime;
	}

	public Boolean getWantToStop() {
		return wantToStop;
	}

	public void setWantToStop(Boolean wantToStop) {
		this.wantToStop = wantToStop;
	}



	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Boolean getWantToStart() {
		return wantToStart;
	}

	public void setWantToStart(Boolean wantToStart) {
		this.wantToStart = wantToStart;
	}

	public Boolean getIsMobile() {
		return isMobile;
	}

	public void setIsMobile(Boolean isMobile) {
		this.isMobile = isMobile;
	}



}
