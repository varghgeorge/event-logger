package com.github.elf.event.logging;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author George Varghese
 * @version 1.0
 * @since 2016-03-20
 * @category event logging
 * @see GitHub URL: https://github.com/varghgeorge
 * 
 * Event logger is an event logging library to log different event types like DB calls, service calls, external calls and errors. 
 * Goal is to create a uniform way of writing events into logs so that other tools and standard queries can find information from the logs easily. 
 * This will also help us to store the information into databases if needed.
 */
public class EventLogger{
	
	private final static Logger logger = LoggerFactory.getLogger(EventLogger.class);

	/**
	 * Field name: logIndicator
	 * Indicates that this is a Java Event Logging record.
	 */
	private static String logIndicator = "EL";
	
	/**
	 * Field name: fs
	 * Field separator.
	 */	
	private static String fs = "|";
	
	/**
	 * Field name: startIndicator
	 * Indicates the start of the event.
	 */
	private static String startIndicator = "S";
	
	/**
	 * Field name: endIndicator
	 * Indicates the end of the event.
	 */
	private static String endIndicator = "E";
	
	/**
	 * Field name: appId
	 * Name or ID of the application logging the event.
	 */
	private static String appId = "ELF";
	
	/**
	 * Field name: logTypeDb
	 * Indicates that the event is of 'DataBase Access' type. Used for interactions with database.
	 */
	private static String logTypeDb = "DBA";
	
	/**
	 * Field name: logTypeSvc
	 * Indicates that the event is of 'Service' type. Used by the program when invoking internal services.
	 */
	private static String logTypeSvc = "SVC";
	
	/**
	 * Field name: logTypeComm
	 * Indicates that the event is of 'Communications' type. Used by the program when invoking external system calls.
	 */
	private static String logTypeComm = "COM";
	
	/**
	 * Field name: logTypeError
	 * Indicates that the event is of 'Error' type. Used for logging error events.
	 */
	private static String logTypeError = "ERR";
	
	/**
	 * Field name: logTypeError
	 * Indicates that the event is of 'Error' type. Used for logging error events.
	 */
	private static String logTypeDebug = "DEB";
	
	
	private static StringBuilder sb = new StringBuilder();
	
	
	/**
	 * Used to log the start record of DB event
	 * @param sessionId: identifier for user session.
	 * @param requestId: unique identifier for the request.
	 * @param dbCallIdentifier: Identifier for the DB call. This could be anything which will help identify the database call.
	 * @param comments: Any additional comments for this event.
	 */
	public static void logStartDBEvent(String appName, String sessionId, String requestId,String dbCallIdentifier, String comments) {
		logger.info(sb.append(logIndicator).append(fs)
					  .append(appId).append(fs)
					  .append(logTypeDb).append(fs)
					  .append(startIndicator).append(fs)
					  .append(new Date()).append(fs)
					  .append(sessionId).append(fs)
					  .append(requestId).append(fs)
					  .append(dbCallIdentifier).append(fs)
					  .append(comments).append(fs)
					  .toString());
	}
	
	/**
	 * Used to log the start record of DB event
	 * @param eventLogRequest: EventLogRequest object with request related fields.
	 * @param dbCallIdentifier: Identifier for the DB call. This could be anything which will help identify the database call.
	 * @param comments: Any additional comments for this event.
	 */
	public static void logStartDBEvent(EventLogRequest eventLogRequest, String dbCallIdentifier, String comments) {
		logger.info(sb.append(logIndicator).append(fs)
					  .append(eventLogRequest.getAppId()).append(fs)
					  .append(logTypeDb).append(fs)
					  .append(startIndicator).append(fs)
					  .append(new Date()).append(fs)
					  .append(eventLogRequest.getSessionId()).append(fs)
					  .append(eventLogRequest.getRequestId()).append(fs)
					  .append(dbCallIdentifier).append(fs)
					  .append(comments).append(fs)
					  .toString());
	}
	
	/**
	 * Used to log the end record of DB event
	 * @param sessionId: identifier for user session.
	 * @param requestId: unique identifier for the request.
	 * @param dbCallIdentifier: Identifier for the DB call. This could be anything which will help identify the database call.
	 * @param comments: Any additional comments for this event.
	 */
	public static void logEndDBEvent(String appId, String sessionId, String requestId,String dbCallIdentifier, String comments) {
		logger.info(sb.append(logIndicator).append(fs)
					  .append(appId).append(fs)
					  .append(logTypeDb).append(fs)
					  .append(endIndicator).append(fs)
					  .append(new Date()).append(fs)
					  .append(sessionId).append(fs)
					  .append(requestId).append(fs)
					  .append(dbCallIdentifier).append(fs)
					  .append(comments).append(fs)
					  .toString());
	}
	
	
	/**
	 * Used to log the end record of DB event
	 * @param eventLogRequest: EventLogRequest object with request related fields.
	 * @param dbCallIdentifier: Identifier for the DB call. This could be anything which will help identify the database call.
	 * @param comments: Any additional comments for this event.
	 */
	public static void logEndDBEvent(EventLogRequest eventLogRequest, String dbCallIdentifier, String comments) {
		logger.info(sb.append(logIndicator).append(fs)
				  	  .append(eventLogRequest.getAppId()).append(fs)
					  .append(logTypeDb).append(fs)
					  .append(endIndicator).append(fs)
					  .append(new Date()).append(fs)
					  .append(eventLogRequest.getSessionId()).append(fs)
					  .append(eventLogRequest.getRequestId()).append(fs)
					  .append(dbCallIdentifier).append(fs)
					  .append(comments).append(fs)
					  .toString());
	}
	
	/**
	 * Used to log the error event.
	 * @param sessionId: identifier for user session.
	 * @param requestId: unique identifier for the request.
	 * @param errorDetails: Details of the error.
	 * @param comments: Any additional comments for this event.
	 */
	public static void logErrorEvent(String appId, String sessionId, String requestId,String errorDetails, Exception exception, String comments) {
		logger.info(sb.append(logIndicator).append(fs)
					  .append(appId).append(fs)
					  .append(logTypeError).append(fs)
					  .append(new Date()).append(fs)
					  .append(sessionId).append(fs)
					  .append(requestId).append(fs)
					  .append(errorDetails).append(fs)
					  .append(comments).append(fs)
					  .toString());
	}
	
	/**
	 * Used to log the error event.
	 * @param eventLogRequest: EventLogRequest object with request related fields.
	 * @param errorDetails: Details of the error.
	 * @param comments: Any additional comments for this event.
	 */
	public static void logErrorEvent(EventLogRequest eventLogRequest, String errorDetails, Exception exception, String comments) {
		logger.info(sb.append(logIndicator).append(fs)
					  .append(eventLogRequest.getAppId()).append(fs)
					  .append(logTypeError).append(fs)
					  .append(new Date()).append(fs)
					  .append(eventLogRequest.getSessionId()).append(fs)
					  .append(eventLogRequest.getRequestId()).append(fs)
					  .append(errorDetails).append(fs)
					  .append(comments).append(fs)
					  .toString());
	}
	
	
	/**
	 * Used to log the debug event/record.
	 * @param sessionId: identifier for user session.
	 * @param requestId: unique identifier for the request.
	 * @param debugIdentifier: Identifier for debug statement.
	 * @param debugStatement: Debug statement.
	 * @param comments: Any additional comments for this event.
	 */
	public static void logDebugEvent(String appId, String sessionId, String requestId, String className, String debugIdentifier, String debugStatement, String comments) {
		logger.debug(sb.append(logIndicator).append(fs)
					   .append(appId).append(fs)
					   .append(logTypeDebug).append(fs)
					   .append(new Date()).append(fs)
					   .append(sessionId).append(fs)
					   .append(requestId).append(fs)
					   .append(className).append(fs)
					   .append(debugIdentifier).append(fs)
					   .append(debugStatement).append(fs)
					   .append(comments).append(fs)
					   .toString());
	}
	
	
	/**
	 * Used to log the debug event/record.
	 * @param eventLogRequest: EventLogRequest object with request related fields.
	 * @param debugIdentifier: Identifier for debug statement.
	 * @param debugStatement: Debug statement.
	 * @param comments: Any additional comments for this event.
	 */
	public static void logDebugEvent(EventLogRequest eventLogRequest, String className, String debugIdentifier, String debugStatement, String comments) {
		logger.debug(sb.append(logIndicator).append(fs)
					   .append(eventLogRequest.getAppId()).append(fs)
					   .append(logTypeDebug).append(fs)
					   .append(new Date()).append(fs)
					   .append(eventLogRequest.getSessionId()).append(fs)
					   .append(eventLogRequest.getRequestId()).append(fs)
					   .append(className).append(fs)
					   .append(debugIdentifier).append(fs)
					   .append(debugStatement).append(fs)
					   .append(comments).append(fs)
					   .toString());
	}
	
	
	/**
	 * Used to log the start record for service call event.
	 * @param sessionId: identifier for user session.
	 * @param requestId: unique identifier for the request.
	 * @param serviceName: Name or identifier of the service invoked.
	 * @param comments: Any additional comments for this event.
	 */
	public static void logStartSvcEvent(String appId, String sessionId, String requestId,String serviceName, String comments) {
		logger.info(sb.append(logIndicator).append(fs)
					  .append(appId).append(fs)
					  .append(logTypeSvc).append(fs)
					  .append(startIndicator).append(fs)
					  .append(new Date()).append(fs)
					  .append(sessionId).append(fs)
					  .append(requestId).append(fs)
					  .append(serviceName).append(fs)
					  .append(comments).append(fs)
					  .toString());
	}
	
	
	/**
	 * Used to log the start record for service call event.
	 * @param eventLogRequest: EventLogRequest object with request related fields.
	 * @param serviceName: Name or identifier of the service invoked.
	 * @param comments: Any additional comments for this event.
	 */
	public static void logStartSvcEvent(EventLogRequest eventLogRequest, String serviceName, String comments) {
		logger.info(sb.append(logIndicator).append(fs)
					  .append(eventLogRequest.getAppId()).append(fs)
					  .append(logTypeSvc).append(fs)
					  .append(startIndicator).append(fs)
					  .append(new Date()).append(fs)
					  .append(eventLogRequest.getSessionId()).append(fs)
					  .append(eventLogRequest.getRequestId()).append(fs)
					  .append(serviceName).append(fs)
					  .append(comments).append(fs)
					  .toString());
	}
	
	
	/**
	 * Used to log the end record for service call event.
	 * @param sessionId: identifier for user session.
	 * @param requestId: unique identifier for the request.
	 * @param serviceName: Name or identifier of the service invoked.
	 * @param comments: Any additional comments for this event.
	 */	
	public static void logEndSvcEvent(String appId, String sessionId, String requestId,String serviceName, String comments) {
		logger.info(sb.append(logIndicator).append(fs)
					  .append(appId).append(fs)
					  .append(logTypeSvc).append(fs)
					  .append(endIndicator).append(fs)
					  .append(new Date()).append(fs)
					  .append(sessionId).append(fs)
					  .append(requestId).append(fs)
					  .append(serviceName).append(fs)
					  .append(comments).append(fs)
					  .toString());
	}
	
	
	/**
	 * Used to log the end record for service call event.
	 * @param eventLogRequest: EventLogRequest object with request related fields.
	 * @param serviceName: Name or identifier of the service invoked.
	 * @param comments: Any additional comments for this event.
	 */	
	public static void logEndSvcEvent(EventLogRequest eventLogRequest, String serviceName, String comments) {
		logger.info(sb.append(logIndicator).append(fs)
					  .append(eventLogRequest.getAppId()).append(fs)
					  .append(logTypeSvc).append(fs)
					  .append(endIndicator).append(fs)
					  .append(new Date()).append(fs)
					  .append(eventLogRequest.getSessionId()).append(fs)
					  .append(eventLogRequest.getRequestId()).append(fs)
					  .append(serviceName).append(fs)
					  .append(comments).append(fs)
					  .toString());
	}
	
	
	/**
	 * Used to log the start record for external communication event.
	 * @param sessionId: identifier for user session.
	 * @param requestId: unique identifier for the request.
	 * @param commIdentifier: Name or identifier of the communication event.
	 * @param url: URL or related details for this call.
	 * @param comments: Any additional comments for this event.
	 */
	public static void logStartCommEvent(String appId, String sessionId, String requestId, String commIdentifier,  String url, String comments) {
		logger.info(sb.append(logIndicator).append(fs)
					  .append(appId).append(fs)
					  .append(logTypeComm).append(fs)
					  .append(startIndicator).append(fs)
					  .append(new Date()).append(fs)
					  .append(sessionId).append(fs)
					  .append(requestId).append(fs)
					  .append(commIdentifier).append(fs)
					  .append(url).append(fs)
					  .append(comments).append(fs)
					  .toString());
	}
	

	/**
	 * Used to log the start record for external communication event.
	 * @param eventLogRequest: EventLogRequest object with request related fields.
	 * @param commIdentifier: Name or identifier of the communication event.
	 * @param url: URL or related details for this call.
	 * @param comments: Any additional comments for this event.
	 */
	public static void logStartCommEvent(EventLogRequest eventLogRequest, String commIdentifier,  String url, String comments) {
		logger.info(sb.append(logIndicator).append(fs)
				  	  .append(eventLogRequest.getAppId()).append(fs)
					  .append(logTypeComm).append(fs)
					  .append(startIndicator).append(fs)
					  .append(new Date()).append(fs)
					  .append(eventLogRequest.getSessionId()).append(fs)
					  .append(eventLogRequest.getRequestId()).append(fs)
					  .append(commIdentifier).append(fs)
					  .append(url).append(fs)
					  .append(comments).append(fs)
					  .toString());
	}
	
	/**
	 * Used to log the end record for external communication event.
	 * @param sessionId: identifier for user session.
	 * @param requestId: unique identifier for the request.
	 * @param commIdentifier: Name or identifier of the communication event.
	 * @param url: URL or related details for this call.
	 * @param comments: Any additional comments for this event.
	 */
	public static void logEndCommEvent(String appId, String sessionId, String requestId, String commIdentifier, String url, String comments) {
		logger.info(sb.append(logIndicator).append(fs)
					  .append(appId).append(fs)
					  .append(logTypeComm).append(fs)
					  .append(endIndicator).append(fs)
					  .append(new Date()).append(fs)
					  .append(sessionId).append(fs)
					  .append(requestId).append(fs)
					  .append(commIdentifier).append(fs)
					  .append(url).append(fs)
					  .append(comments).append(fs)
					  .toString());
	}


	/**
	 * Used to log the end record for external communication event.
	 * @param eventLogRequest: EventLogRequest object with request related fields.
	 * @param commIdentifier: Name or identifier of the communication event.
	 * @param url: URL or related details for this call.
	 * @param comments: Any additional comments for this event.
	 */
	public static void logEndCommEvent(EventLogRequest eventLogRequest, String commIdentifier, String url, String comments) {
		logger.info(sb.append(logIndicator).append(fs)
					  .append(eventLogRequest.getAppId()).append(fs)
					  .append(logTypeComm).append(fs)
					  .append(endIndicator).append(fs)
					  .append(new Date()).append(fs)
					  .append(eventLogRequest.getSessionId()).append(fs)
					  .append(eventLogRequest.getRequestId()).append(fs)
					  .append(commIdentifier).append(fs)
					  .append(url).append(fs)
					  .append(comments).append(fs)
					  .toString());
	}

	
}
