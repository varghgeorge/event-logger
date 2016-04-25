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
 - All log statements contains common attributes like session & request ids along with date/time stamp.

<b>Advantages</b>
⋅⋅* No random strings in the logs. All events have its own table like structures. 
⋅⋅* Multiple teams across the organization following same logging standards enforced by the framework.
⋅⋅* Known structure and format enables writing standard tools/quries. And same queries can be used across the organization.
⋅⋅* Provides visibility into timing and bottlenecks. 
⋅⋅* Common attributes in the logs like session/request identifier provides visibility into session and request flows across multiple microservies and sub systems.

