# Event Logging Framework (ELF)

Most of the logging are random, not structred/usable and are not utilized correctly. Logs contain valuable information which most systems miss due to this lack of structure.

ELF is a framework/solution for it. In ELF, all types of logging are considered to be an "Event". That event could be a service call, database call or error or any type of event. All common events are defined in the framework and each of the types have its own structure.

<b>Event Types in ELF:</b>
 - Database Access (Type: DBA)
 - Service Calls (Type: SVC)
 - External Communication (Type: COM)
 - Error (Type: ERR)
 - Debug (DEB)

<b>Record Details:</b>
 - DBA, SVC & COM types contains start (S) (prior to the event) and end (E) records. This gives visibility into elapsed time.

```java
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

 
