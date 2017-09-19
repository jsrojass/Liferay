<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import = "java.io.*,java.util.*,java.lang.*" %>
<%@ page import = "classpack.Product_Nav_Tag" %>
<%@ page import = "apiclasses.ProductNavTagAPI" %>

<portlet:defineObjects />
<portlet:actionURL var="UploadNavTag" windowState="normal" name="UploadNavTag"></portlet:actionURL>
<portlet:actionURL var="CancelAction" windowState="normal" name="CancelAction"></portlet:actionURL>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<b>create_product_nav_tag_list.jsp</b>

		<font size="1" face="Arial" ><center>
		<form action = "<%=UploadNavTag%>" method = "POST" >
		<table border="1">
		<th colspan = "2" style="text-align:center" ><b> NEW PRODUCT NAVIGATION TAG DETAILS: </b></th>
		<tr><td align="left"><b>Navigation Tag ID:</b></td><td><input type = "text" style="width:600px" name = "nav_tag_id" required/></td></tr>
		
		<%
			if (request.getAttribute("error") != null)
			{
							
		%>
		<td colspan="2"><font color="red"><b><%=request.getAttribute("error")%></b></font></td>
		<% 
			}
		%>
		<tr><td><b>Description:</b></td><td><TEXTAREA required maxlength="1000" name="description" rows="5" cols="80" required></TEXTAREA></td>
		</table>
		<br>
		<input type = "submit" value = "Upload" style=" color:white; background-color:green; width:120px" />
		</form>

		<form action = "<%=CancelAction%>" method = "POST" >
		<input type = "submit" value = "Return" style=" color:white; background-color:red; width:120px" />
		</form>
		</center>


</body>
</html>