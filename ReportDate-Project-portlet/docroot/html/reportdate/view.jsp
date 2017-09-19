<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />
<portlet:actionURL var="GetReportDates" windowState="normal" name="GetReportDates"></portlet:actionURL>

This is the <b>Report Date</b> portlet in View mode.

<form action = "<%=GetReportDates%>" method = "POST" >
<input type = "submit" value = "Create" style=" color:white; background-color:blue; width:120px" />
</form>