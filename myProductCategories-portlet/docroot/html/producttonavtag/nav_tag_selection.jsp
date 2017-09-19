<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import = "java.io.*,java.util.*,java.lang.*" %>
<%@ page import = "classpack.Product_Nav_Tag" %>
<%@ page import = "apiclasses.ProductNavTagAPI" %>

<portlet:defineObjects />
<portlet:actionURL var="SubmitSelectedNavTag" windowState="normal" name="SubmitSelectedNavTag"></portlet:actionURL>
<portlet:actionURL var="GetNavTagList" windowState="normal" name="GetNavTagList"></portlet:actionURL>
<portlet:actionURL var="GetAllNavTagsRequest" windowState="normal" name="GetAllNavTagsRequest"></portlet:actionURL>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>
table, th, td {
    padding: 5px;
}
</style>

<script>
														function getfilter_by(selectObject) 
														{
									    					var ObjectValue = selectObject.value;
									    					console.log("ObjectValue = " + ObjectValue);
									    					var filter_id = parseInt(ObjectValue); 
									    					console.log("filter_id = " + filter_id);	
									    					for(var i=1; i<6;i++)
															{
																if(i == filter_id)
																{
																		document.getElementById(i).style.display = 'block';
																}
																else
																{
																		document.getElementById(i).style.display = 'none';
																}
															}
														}
														
														function check_selection(selectObject)
														{
														// var inputs = document.getElementsByTagName("input"); //or document.forms[0].elements;
														
														var inputs = document.getElementById('nav_tag_id');
														var onClick = 1; //number of checked checkboxes
														console.log("onClick = " + onClick);
														
														if(onClick == 1)
														{
																document.getElementById("enable_continue").style.display = 'block';
																document.getElementById("disable_continue").style.display = 'none';
														}
														if(onClick != 1)
														{
																document.getElementById("disable_continue").style.display = 'block';
																document.getElementById("enable_continue").style.display = 'none';
														}
														
														}
														
</script>

</head>
<body>
<b>nav_tag_selection.jsp</b>

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
			<form action = "<%=GetAllNavTagsRequest%>" method = "POST" >			
			<input type = "submit" value = "View all" />	
			</form>
			</td>
			</tr>
			</table>
			
			

<%
			if (request.getAttribute("myproduct_nav_tag_List") != null)
			{
				ArrayList<Product_Nav_Tag> myproduct_nav_tag_List = (ArrayList<Product_Nav_Tag>) request.getAttribute("myproduct_nav_tag_List");
				System.out.println("myproduct_nav_tag_List.size() = " + myproduct_nav_tag_List.size());
				
%>
			About <%=myproduct_nav_tag_List.size()%> <%if(myproduct_nav_tag_List.size() == 1){%>result<%}else{%>results<%}%>
			
			<%
			if(myproduct_nav_tag_List.size()>0)
			{
			%>
			
			<form action = "<%=SubmitSelectedNavTag%>" method = "POST" >
			<div style="overflow-x:auto; text-align:center"><center>
			<table border ="1">
			
			<tr>		
			<td></td>
			<td style="text-align:center" ><b> Row ID </b></td>
			<td style="text-align:center"><b> Nav Tag ID </b></td>
			<td style="text-align:center"><b> Business ID </b></td>
			<td style="text-align:center"><b> Description </b></td>
			<td style="text-align:center"><b> Is Deleted </b></td>
			<td style="text-align:center"><b> Is Published </b></td>
			</tr>
			
<%
					for(int i=0; i<myproduct_nav_tag_List.size();i++)
					{
%>
					<tr>
					<td>
					<input type="radio" onClick="check_selection(this)" id="nav_tag_id" name="nav_tag_id" value="<%=myproduct_nav_tagList.get(i).getnav_tag_id()%>">
					</td>
					<td align="center"><%=myproduct_nav_tag_List.get(i).getrow_id() %></td>
					<td align="center"><%=myproduct_nav_tag_List.get(i).getnav_tag_id() %></td>
					<td align="center"><%=myproduct_nav_tag_List.get(i).getbusiness_id() %></td>
					<td align="center"><%=myproduct_nav_tag_List.get(i).getdescription() %></td>
					<td align="center"><%=myproduct_nav_tag_List.get(i).getis_deleted() %></td>
					<td align="center"><%=myproduct_nav_tag_List.get(i).getis_published() %></td>
	
<% 
					}
%>
			
			</table>
			
			</center>
			</div>
			
			<div id="enable_continue" style="display:none">
			<br><input id="Button" type = "submit" value = "Continue" style=" color:white; background-color:blue; width:120px"/>
			</div>
			
			
			<div id="disable_continue">		
			<br><input id="Button" type = "submit" value = "Continue" style=" color:white; background-color:grey; width:120px" disabled/>
			</div>
			
			
			
			</form>	
			</font>		
			
<% 
			}
			}
%>

</body>
</html>