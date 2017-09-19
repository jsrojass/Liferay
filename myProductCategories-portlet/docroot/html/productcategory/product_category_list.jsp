<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import = "java.io.*,java.util.*,java.lang.*" %>
<%@ page import = "classpack.Product_Category" %>
<%@ page import = "classpack.Product_Category_Attributes" %>
<%@ page import = "apiclasses.ProductCategoryAPI" %>
<%@ page import = "apiclasses.ProductCategoryAttributeAPI" %>

<portlet:defineObjects />
<portlet:actionURL var="EditProductCategory" windowState="normal" name="EditProductCategory"></portlet:actionURL>
<portlet:actionURL var="DeleteAttributes" windowState="normal" name="DeleteAttributes"></portlet:actionURL> 
<portlet:actionURL var="GetAllRequest" windowState="normal" name="GetAllRequest"></portlet:actionURL> 
<portlet:actionURL var="GetProductCategoryList" windowState="normal" name="GetProductCategoryList"></portlet:actionURL> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table, th, td {
    padding: 10px;
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
</script>
</head>
<body>

<b>product_category_list.jsp</b>

			<%
			String business_id = "SST1";
			ProductCategoryAPI myAPI = new ProductCategoryAPI();
			ProductCategoryAttributeAPI myAPI_2 = new ProductCategoryAttributeAPI();
			ArrayList<Product_Category> myProductCategory_List = myAPI.GetProductCategoryList(business_id);
			%>

			<div style="overflow-x:auto;">
			<font size="1" face="Arial" >
			<center>
			<table>	
				<tr>
									
									<td>
										
										<div>
												Filter By: 	<select onchange="getfilter_by(this)">
															<option value="1">			Product Code</option>
															<option value="2">			Category Name</option>
															<option value="3">			Parent Category ID</option>
															</select>
																					
												<div id="1">
												<form action = "<%=GetProductCategoryList%>" method = "POST" >
												<br>Product Code:
															<input type="hidden" name="filter_by" value="1"/>
															<input type = "text" name = "product_category_filter" list="product_code_filter_list" required/>
															<datalist id="product_code_filter_list">
															<%
															for(int i=0; i<myProductCategory_List.size(); i++)
															{
																if(i==0 ||((i+1)<myProductCategory_List.size() && myProductCategory_List.get(i+1).getproduct_code().equals(myProductCategory_List.get(i).getproduct_code()) == false))
																{
															%>
															<option value="<%=myProductCategory_List.get(i).getproduct_code()%>" />
															<%
																}
															}
															%>
															</datalist>
												<input type = "submit" value = "Search" />
												</form>	
												</div>
												
												<div id="2" style="display:none">
												<form action = "<%=GetProductCategoryList%>" method = "POST" >
												<br>Category Name: 
															<input type="hidden" name="filter_by" value="2"/> 
															<input type = "text" name = "product_category_filter" list="category_name_id_filter_list" required />
															<datalist id="category_name_id_filter_list">
															<%
															for(int i=0; i<myProductCategory_List.size(); i++)
															{
																if(i==0 ||((i+1)<myProductCategory_List.size() && myProductCategory_List.get(i+1).getcategory_name().equals(myProductCategory_List.get(i).getcategory_name()) == false))
																{	
															%>
																<option value="<%=myProductCategory_List.get(i).getcategory_name()%>" />
															<%
																}
															}
															%>
															</datalist>
												<input type = "submit" value = "Search" />
												</form>	
												</div>
												
												<div id="3" style="display:none">									
												<form action = "<%=GetProductCategoryList%>" method = "POST" >
												<br>Parent Category ID:
															<input type="hidden" name="filter_by" value="3"/> 
															<input type = "text" name = "product_category_filter" list="parent_category_id_filter_list" required />
															<datalist id="parent_category_id_filter_list">
															<%
															for(int i=0; i<myProductCategory_List.size(); i++)
															{
																if(i==0 ||((i+1)<myProductCategory_List.size() && myProductCategory_List.get(i+1).getparent_category_id().equals(myProductCategory_List.get(i).getparent_category_id()) == false))
																{
															%>
															<option value="<%=myProductCategory_List.get(i).getparent_category_id()%>" />
															<%
																}
															}
															%>
															</datalist>
												<input type = "submit" value = "Search" />
												</form>	
												</div>												
																	
										</div>
									</td>
									
									<td>
												<div>
												<form action = "<%=GetAllRequest%>" method = "POST" >			
												<input type = "submit" value = "View all" />	
												</form>
												</div>
									</td>
			
				</tr>
			</table>
			<br>

<%
			if (request.getAttribute("myProductCategoryList") != null && request.getAttribute("myproduct_codeList") != null)
			{
				ArrayList<Product_Category> myProductCategoryList = (ArrayList<Product_Category>) request.getAttribute("myProductCategoryList");
				ArrayList<String> myproduct_codeList = (ArrayList<String>) request.getAttribute("myproduct_codeList");				
%>	
		About <%=myProductCategoryList.size()%> <%if(myProductCategoryList.size() == 1){%>result<%}else{%>results<%}%>
		
<%
		if(myProductCategoryList.size()>0)
		{
			
		
%>
		<div style="overflow-x:auto;">
		<font size="1" face="Arial" >
		<table border="1">
		
		<tr>		
		<td style="text-align:center" ><b> Row ID </b></td>
		<td style="text-align:center"><b> Product Code </b></td>
		<td style="text-align:center"><b> Category Name </b></td>
		<td style="text-align:center"><b> Has Parent </b></td>
		<td style="text-align:center" ><b> Business ID </b></td>
		<td style="text-align:center"><b> Date Created </b></td>
		<td style="text-align:center"><b> Date Modified </b></td>
		<td style="text-align:center"><b> Parent Category id </b></td>
		<td style="text-align:center"><b> Is Published </b></td>
		<td style="text-align:center"><b> Edit/Create attributes </b></td>
		<td style="text-align:center"><b> Delete Attributes </b></td>
		</tr>
<%
		for(int i=0; i<myProductCategoryList.size();i++)
		{
%>			
						
					<tr>
					<td align="center"><%=myProductCategoryList.get(i).getrow_id() %></td>
					<td align="center"><%=myProductCategoryList.get(i).getproduct_code() %></td> 
					<td align="center"><%=myProductCategoryList.get(i).getcategory_name() %></td> 
					<td align="center"><%=myProductCategoryList.get(i).gethas_parent() %></td>
					<td align="center"><%=myProductCategoryList.get(i).getbusiness_id() %></td>
					<td align="center"><%=myProductCategoryList.get(i).getdate_created() %></td>
					<td align="center"><%=myProductCategoryList.get(i).getdate_modified() %></td>
					<td align="center"><%=myProductCategoryList.get(i).getparent_category_id() %></td>
					<td align="center"><%=myProductCategoryList.get(i).getis_published() %></td>
					
					<td align="center">
					<form action = "<%=EditProductCategory%>" method = "POST" >
					<input type="hidden" name="product_code" value="<%=myProductCategoryList.get(i).getproduct_code()%>"/>
					<%
					boolean empty_flag = true;
					for(int j=0; j<myproduct_codeList.size();j++)
					{
						if(myProductCategoryList.get(i).getproduct_code().equals(myproduct_codeList.get(j)) == true)
						{
							empty_flag = false;
						}
						
					}
					if(empty_flag == false)
					{
					%>
					<input type = "submit" value = "Edit" style=" color:white; background-color:blue; width:120px; height:65px"  />
					<%	
					}
					if(empty_flag == true)
					{
					%>
					<input type = "submit" value = "Create" style=" color:white; background-color:green; width:120px; height:65px"  />
					<%	
					}
					%>
					</form>
					</td>
					
					<%
					if(empty_flag == false)
					{
					%>
					<td align="center">
					<form action = "<%=DeleteAttributes%>" method = "POST" >
					<input type="hidden" name="product_code" value="<%=myProductCategoryList.get(i).getproduct_code()%>"/>
					<input type = "submit" value = "Delete" style=" color:white; background-color:red; width:120px; height:65px" onclick="return confirm('Are you sure you want to delete \'<%=myProductCategoryList.get(i).getproduct_code()%> - <%=myProductCategoryList.get(i).getcategory_name()%>\' attributes?\n\nIf you would like to create new attributes you might need technical support fom the Business Systems area: it@site.edu.au ext. 77.')" />
					<%	
					}
					else
					{
					%>
					<td align="center">
					<form action = "<%=DeleteAttributes%>" method = "POST" >
					<input type="hidden" name="product_code" value="<%=myProductCategoryList.get(i).getproduct_code()%>"/>
					<input type = "submit" disabled="disabled" value = "Delete" style=" color:white; background-color:gray; width:120px; height:65px" />
					<%	
					}
					%>
					</form>
					</td>
					
					</tr>
		
				<%
				}
			}
			}
				%>
		
		</table>
		</font>
		</div>

</body>
</html>