package com.test.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.test.util.ApplicationConstants;
import com.test.util.ApplicationConstants.ALPHABET_CONSTANT;

public class ClientRequest implements ALPHABET_CONSTANT  {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty(ApplicationConstants.ALPHABET_CONSTANT.A)
	private List<String> scripts;
	@JsonProperty(ApplicationConstants.ALPHABET_CONSTANT.G)
	private Object data;
	@JsonProperty(ApplicationConstants.ALPHABET_CONSTANT.H)
	private Boolean wantToStop;
	@JsonProperty(ApplicationConstants.ALPHABET_CONSTANT.J)
	private Boolean isMobile;
	@JsonProperty(ApplicationConstants.ALPHABET_CONSTANT.K)
	private Boolean wantToRemoveScripts;


	public List<String> getScripts() {
		return scripts;
	}

	public void setScripts(List<String> scripts) {
		this.scripts = scripts;
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

	
	public Boolean getIsMobile() {
		return isMobile;
	}

	public void setIsMobile(Boolean isMobile) {
		this.isMobile = isMobile;
	}

	
	public Boolean getWantToRemoveScripts() {
	
		return wantToRemoveScripts;
	}

	
	public void setWantToRemoveScripts(Boolean wantToRemoveScripts) {
	
		this.wantToRemoveScripts = wantToRemoveScripts;
	}

}
