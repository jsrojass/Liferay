<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import = "java.io.*,java.util.*,java.lang.*" %>
<%@ page import = "classpack.Product_Nav_Tag" %>
<%@ page import = "apiclasses.ProductNavTagAPI" %>

<portlet:defineObjects />
<portlet:actionURL var="UpdateNavTag" windowState="normal" name="UpdateNavTag"></portlet:actionURL>
<portlet:actionURL var="CancelAction" windowState="normal" name="CancelAction"></portlet:actionURL>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<b>edit_product_nav_tag_list.jsp</b>

<%
		if (request.getAttribute("myProduct_Nav_Tag") != null)
		{
			Product_Nav_Tag myProduct_Nav_Tag = (Product_Nav_Tag) request.getAttribute("myProduct_Nav_Tag");
%>

		<font size="1" face="Arial" >
		<center>
		<form action = "<%=UpdateNavTag%>" method = "POST" >
		<table border="1">
		<th colspan = "2" style="text-align:center" ><b> PRODUCT NAVIGATION TAG DETAILS: </b></th>
		<tr><td align="left"><b>Row ID:</b></td><td><input type = "text" style="width:600px" name = "row_id" value = "<%=myProduct_Nav_Tag.getrow_id()%>" readonly/></td></tr>
		<tr><td align="left"><b>Navigation Tag ID:</b></td><td><input type = "text" style="width:600px" name = "nav_tag_id" value = "<%=myProduct_Nav_Tag.getnav_tag_id()%>" readonly/></td></tr>
		<tr><td align="left"><b>Business ID:</b></td><td><input type = "text" style="width:600px" name = "business_id" value = "<%=myProduct_Nav_Tag.getbusiness_id()%>" readonly/></td></tr>
		<tr><td><b>Description:</b></td><td><TEXTAREA required maxlength="1000" name="description" rows="5" cols="80" required><%=myProduct_Nav_Tag.getdescription()%></TEXTAREA></td>
		<tr><td align="left"><b>Date Created:</b></td><td><input type = "text" style="width:600px" name = "date_created" value = "<%=myProduct_Nav_Tag.getdate_created()%>" readonly/></td></tr>
		<tr><td align="left"><b>Date Modified:</b></td><td><input type = "text" style="width:600px" name = "date_modified" value = "<%=myProduct_Nav_Tag.getdate_modified()%>" readonly/></td></tr>
		<tr><td align="left"><b>Is Deleted:</b></td><td><input type = "text" style="width:600px" name = "is_deleted" value = "<%=myProduct_Nav_Tag.getis_deleted()%>" readonly/></td></tr>
		<tr><td align="left"><b>Is Published:</b></td>
			<td>
			<input type = "radio" name = "is_published" value="1" <% if(myProduct_Nav_Tag.getis_published() == true){%> checked="checked" <%}%> /> true
	        <input type = "radio" name = "is_published" value="0" <% if(myProduct_Nav_Tag.getis_published() == false){%> checked="checked" <%}%>/> false
			<td>
		</table>
		<br>
		<input type = "submit" value = "Update" style=" color:white; background-color:blue; width:120px" />
		</form>
		
		<form action = "<%=CancelAction%>" method = "POST" >
		<input type = "submit" value = "Return" style=" color:white; background-color:red; width:120px" />
		</form>
		</center>
		</font>

<%
		}
%>



</body>
</html>