package com.github.elf.event.logging;

/**
* @author George Varghese
* @version 1.0
* @since 2016-03-20
* @category event logging
* @see GitHub URL: https://github.com/varghgeorge
**/

public class EventLogRequest {
	
	private String sessionId;
	private String requestId;
	private String appId;
	private String companyId;

	public EventLogRequest() {
		super();
	}

	public EventLogRequest(String sessionId, String requestId, String appId, String companyId) {
		super();
		this.requestId = requestId;
		this.appId = appId;
		this.companyId = companyId;
		this.sessionId = sessionId;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	
	
}
