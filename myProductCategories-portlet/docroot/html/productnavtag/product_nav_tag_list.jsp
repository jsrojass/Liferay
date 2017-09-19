<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import = "java.io.*,java.util.*,java.lang.*" %>
<%@ page import = "classpack.Product_Nav_Tag" %>
<%@ page import = "apiclasses.ProductNavTagAPI" %>

<portlet:defineObjects />
<portlet:actionURL var="EditNavTag" windowState="normal" name="EditNavTag"></portlet:actionURL>
<portlet:actionURL var="DeleteNavTag" windowState="normal" name="EditNavTag"></portlet:actionURL> 
<portlet:actionURL var="CreateNavTag" windowState="normal" name="CreateNavTag"></portlet:actionURL>
<portlet:actionURL var="GetNavTagList" windowState="normal" name="GetNavTagList"></portlet:actionURL>
<portlet:actionURL var="GetAllRequest" windowState="normal" name="GetAllRequest"></portlet:actionURL>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>
table, th, td {
    padding: 10px;
}
</style>

</head>
<body>
<b>product_nav_tag_list.jsp</b>

<font size="1" face="Arial" >
			<br>
							
<%
			String business_id = "SST1";
			ProductNavTagAPI myAPI = new ProductNavTagAPI();
			ArrayList<Product_Nav_Tag> myproduct_nav_tagList = myAPI.GetAllRequest(business_id);
%>
			<center>
			<table>
			<tr>
			<td>
			<form action = "<%=GetNavTagList%>" method = "POST" >
			Product Navigation Tag ID: 
						<input type = "text" name = "nav_tag_id_filter" list="nav_tag_id_filter_list" required/>
						<datalist id="nav_tag_id_filter_list">
						<%
						for(int i=0; i<myproduct_nav_tagList.size(); i++)
						{
							if(i==0 ||((i+1)<myproduct_nav_tagList.size() && myproduct_nav_tagList.get(i+1).getnav_tag_id().equals(myproduct_nav_tagList.get(i).getnav_tag_id()) == false))
							{
						%>
						<option value="<%=myproduct_nav_tagList.get(i).getnav_tag_id()%>" />
						<%
							}
						}
						%>
						</datalist>
			<input type = "submit" value = "Search" />
			</form>
			</td>
			<td>
			<form action = "<%=GetAllRequest%>" method = "POST" >			
			<input type = "submit" value = "View all" />	
			</form>
			</td>
			<td>
			<form action = "<%=CreateNavTag%>" method = "POST" >
			<input type = "submit" value = "New" style=" color:white; background-color:green; width:120px" />
			</form>
			</td>
			</tr>
			</table>

					
<%
			if (request.getAttribute("myproduct_nav_tag_List") != null)
			{
				ArrayList<Product_Nav_Tag> myproduct_nav_tag_List = (ArrayList<Product_Nav_Tag>) request.getAttribute("myproduct_nav_tag_List");
				
%>
			About <%=myproduct_nav_tag_List.size()%> <%if(myproduct_nav_tag_List.size() == 1){%>result<%}else{%>results<%}%>

<%
			if(myproduct_nav_tag_List.size()>0)
			{
%>
		
			
			<div style="overflow-x:auto; text-align:center"><center>
			<table border="1">
			
			<tr>		
			<td style="text-align:center" ><b> Row ID </b></td>
			<td style="text-align:center"><b> Nav Tag ID </b></td>
			<td style="text-align:center"><b> Business ID </b></td>
			<td style="text-align:center"><b> Description </b></td>
			<td style="text-align:center" ><b> Date Created </b></td>
			<td style="text-align:center"><b> Date Modified </b></td>
			<td style="text-align:center"><b> Is Deleted </b></td>
			<td style="text-align:center"><b> Is Published </b></td>
			<td style="text-align:center"><b> Edit/Create Nav Tags </b></td>
			<td style="text-align:center"><b> Delete Nav Tags </b></td>
			</tr>
			
<%
				for(int i=0; i<myproduct_nav_tag_List.size();i++)
				{
%>
					<tr>
					<td align="center"><%=myproduct_nav_tag_List.get(i).getrow_id() %></td>
					<td align="center"><%=myproduct_nav_tag_List.get(i).getnav_tag_id() %></td>
					<td align="center"><%=myproduct_nav_tag_List.get(i).getbusiness_id() %></td>
					<td align="center"><%=myproduct_nav_tag_List.get(i).getdescription() %></td>
					<td align="center"><%=myproduct_nav_tag_List.get(i).getdate_created() %></td>
					<td align="center"><%=myproduct_nav_tag_List.get(i).getdate_modified() %></td>
					<td align="center"><%=myproduct_nav_tag_List.get(i).getis_deleted() %></td>
					<td align="center"><%=myproduct_nav_tag_List.get(i).getis_published() %></td>
					
					<td align="center">
					<form action = "<%=EditNavTag%>" method = "POST" >
					<input type="hidden" name="nav_tag_id" value="<%=myproduct_nav_tag_List.get(i).getnav_tag_id()%>"/>
					<input type = "submit" value = "Edit" style=" color:white; background-color:blue; width:120px"  />
					</form>
					</td>
					
					<td align="center">
					<form action = "<%=DeleteNavTag%>" method = "POST" >
					<input type="hidden" name="nav_tag_id" value="<%=myproduct_nav_tag_List.get(i).getnav_tag_id()%>"/>
					<input type = "submit" disabled="disabled" value = "Delete" style=" color:white; background-color:gray; width:120px" />
					</form>
					</td>
<% 
				}
%>
			
			</table>
			</font>
			</center></div>
			
<% 
			}
			}
%>

</body>
</html>