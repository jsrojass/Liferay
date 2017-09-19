<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import = "java.io.*,java.util.*,java.lang.*" %>
<%@ page import = "classpack.Product_Category" %>
<%@ page import = "classpack.Product_Category_Attributes" %>
<%@ page import = "apiclasses.ProductCategoryAPI" %>
<%@ page import = "apiclasses.ProductCategoryAttributeAPI" %>

<portlet:defineObjects />
<portlet:actionURL var="SubmitSelectedProduct" windowState="normal" name="SubmitSelectedProduct"></portlet:actionURL>
<portlet:actionURL var="GetAllProductCategoryRequest" windowState="normal" name="GetAllProductCategoryRequest"></portlet:actionURL> 
<portlet:actionURL var="GetProductCategoryList" windowState="normal" name="GetProductCategoryList"></portlet:actionURL>
<portlet:actionURL var="CancelRequest" windowState="normal" name="CancelRequest"></portlet:actionURL>
<portlet:actionURL var="BatchRequest" windowState="normal" name="BatchRequest"></portlet:actionURL>
<portlet:actionURL var="RemoveSelectedProducts" windowState="normal" name="RemoveSelectedProducts"></portlet:actionURL>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>
table, th, td 
{
    padding: 5px;
}

.button 
{
    display: inline-block;
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
														var inputs = document.getElementsByTagName("input"); //or document.forms[0].elements;
														var cbs = []; //will contain all checkboxes
														var checked = []; //will contain all checked checkboxes
														for (var i = 0; i < inputs.length; i++) {
														  if (inputs[i].type == "checkbox") {
														    cbs.push(inputs[i]);
														    if (inputs[i].checked) {
														      checked.push(inputs[i]);
														    }
														  }
														}
														var nbCbs = cbs.length; //number of checkboxes
														var nbChecked = checked.length; //number of checked checkboxes
														console.log("nbChecked = " + nbChecked);
														
														if(nbChecked != 0 && nbChecked>0)
														{
																document.getElementById("enable_submit").style.display = 'block';
																document.getElementById("disable_submit").style.display = 'none';
														}
														if(nbChecked == 0)
														{
																document.getElementById("disable_submit").style.display = 'block';
																document.getElementById("enable_submit").style.display = 'none';
														}
														
														}
														
														function check_selection2(selectObject)
														{
														var inputs = document.getElementsByTagName("input"); //or document.forms[0].elements;
														var cbs = []; //will contain all checkboxes
														var checked = []; //will contain all checked checkboxes
														for (var i = 0; i < inputs.length; i++) {
														  if (inputs[i].type == "checkbox") {
														    cbs.push(inputs[i]);
														    if (inputs[i].checked) {
														      checked.push(inputs[i]);
														    }
														  }
														}
														var nbCbs = cbs.length; //number of checkboxes
														var nbChecked = checked.length; //number of checked checkboxes
														console.log("nbChecked = " + nbChecked);
														
														if(nbChecked != 0 && nbChecked>0)
														{
																document.getElementById("enable_remove").style.display = 'block';
																document.getElementById("disable_remove").style.display = 'none';
														}
														if(nbChecked == 0)
														{
																document.getElementById("disable_remove").style.display = 'block';
																document.getElementById("enable_remove").style.display = 'none';
														}
														
														}
														
</script>

</head>
<body>
<b>product_category_list.jsp</b>
<font size="1" face="Arial" >
			
<%
			String business_id = "SST1";
			ProductCategoryAPI myAPI = new ProductCategoryAPI();
			ArrayList<Product_Category> myProductCategory_List = myAPI.GetProductCategoryList(business_id);

			String nav_tag_id = null;
			if (request.getAttribute("nav_tag_id") != null)
			{
				nav_tag_id = (String) request.getAttribute("nav_tag_id");
%>
			<center>
			<div style="background-color: #F0E5E3; color:black; width: 600px; border: 2px solid gray; border-style: solid; padding: 10px; margin: 0px;">
			<form action = "<%=RemoveSelectedProducts%>" method = "POST" >
			<table border = "1">
			<tr colspan = "3"><b>SELECTED PRODUCTS<b></tr> 
			<tr>
					<td></td>
					<td><b>Navigation Tag ID</b></td>
					<td><b>Product Code</b></td>
					<td><b>Category Name</b></td>
			</tr>			
			
			
			<%
			if (request.getAttribute("product_categories") != null)
			{ 
				ArrayList<String> product_categories = (ArrayList<String>) request.getAttribute("product_categories"); 
				if(product_categories.size()>0)
				{
					for(int i=0; i<product_categories.size() ;i++)
					{
			%>
						<tr>
						<td><input type="checkbox" onClick="check_selection2(this)" name="remove_product_categories" value="<%=product_categories.get(i)%>"></td>
						<td><%=nav_tag_id%></td>
						<td><%=product_categories.get(i)%></td>
			<%
					for(int j=0;j<myProductCategory_List.size();j++)
					{
						if(product_categories.get(i).contains(myProductCategory_List.get(j).getproduct_code()) == true)
						{
			%>
							<td><%=myProductCategory_List.get(j).getcategory_name()%> </td>
			<%
						}
					}
			%>
						</tr>
			<% 
					}
				}
				else
				{
			%>
						<tr>
						<td></td>
						<td><%=nav_tag_id%></td>
						<td colspan = "2">Waiting for selection...</td>
						</tr>
			<% 	
				}
			}
			else
			{
			%>
					<tr>
					<td></td>
					<td><%=nav_tag_id%></td>
					<td colspan = "2">Waiting for selection...</td>
					</tr>
			<% 	
			}
			%>			
			</table>
			
			<div id="enable_remove" style="display:none">
			<br><input id="Button" type = "submit" value = "Remove Selected" style=" color:white; background-color:red; width:120px"/>
			</div>
			
			
			<div id="disable_remove">		
			<br><input id="Button" type = "submit" class="button" value = "Remove Selected" style=" color:white; background-color:grey; width:120px" disabled/>
			</div></form>
			
			</div>
			</center>
			<br>
<%
			}
%>						
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
															<input type="hidden" name="nav_tag_id" value="<%=nav_tag_id%>"/>
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
															<input type="hidden" name="nav_tag_id" value="<%=nav_tag_id%>"/>
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
												<input type = "submit" value = "Search" id="submit"/>
												</form>	
												</div>
												
												<div id="3" style="display:none">									
												<form action = "<%=GetProductCategoryList%>" method = "POST" >
												<br>Parent Category ID:
															<input type="hidden" name="filter_by" value="3"/> 
															<input type="hidden" name="nav_tag_id" value="<%=nav_tag_id%>"/>
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
												<form action = "<%=GetAllProductCategoryRequest%>" method = "POST" >			
												<input type = "submit" value = "View all" />	
												</form>
												</div>
									</td>
			
				</tr>
			</table>
		
			<br>
			
			<%if(request.getAttribute("product_categories") != null)
				{
			%>	
						<form action = "<%=BatchRequest%>" method = "POST" >			
						<input type = "submit" class="button" value = "Upload Selected" style=" color:white; background-color:blue; width:120px" />	
						</form>	
			<%
				}
				else
				{
			%>
						<input type = "submit" class="button" value = "Upload Selected" style=" color:white; background-color:grey; width:120px" disabled/>
			<%	
				}
			%>
			
			
				
			<form action = "<%=CancelRequest%>" method = "POST" >			
			<input type = "submit" value = "Cancel" style=" color:white; background-color:red; width:120px" />
			</form>				
			
			<form action = "<%=SubmitSelectedProduct%>" method = "POST" >
			<input type="hidden" name="nav_tag_id" value="<%=nav_tag_id%>"/>
			<div id="enable_submit" style="display:none">
			<input id="Button" type = "submit" value = "Add Selected" style=" color:white; background-color:black; width:120px"/>
			</div>
			
			
			<div id="disable_submit">		
			<input id="Button" type = "submit" class="button" value = "Add Selected" style=" color:white; background-color:grey; width:120px" disabled/>
			</div>
					
			<br>
<%
			if (request.getAttribute("myProductCategoryList") != null)
			{
				ArrayList<Product_Category> myProductCategoryList = (ArrayList<Product_Category>) request.getAttribute("myProductCategoryList");
%>	
		
		About <%=myProductCategoryList.size()%> <%if(myProductCategoryList.size() == 1){%>result<%}else{%>results<%}%>			
		
		<div style="overflow-x:auto;">
		<table border="1">
		
		<tr>		
		<td></td>
		<td style="text-align:center" ><b> Row ID </b></td>
		<td style="text-align:center"><b> Product Code </b></td>
		<td style="text-align:center"><b> Category Name </b></td>
		<td style="text-align:center"><b> Has Parent </b></td>
		<td style="text-align:center" ><b> Business ID </b></td>
		<td style="text-align:center"><b> Date Created </b></td>
		<td style="text-align:center"><b> Date Modified </b></td>
		<td style="text-align:center"><b> Parent Category id </b></td>
		<td style="text-align:center"><b> Is Published </b></td>
		</tr>
		
				<%
				for(int i=0; i<myProductCategoryList.size();i++)
				{	
				%>
					
					
					<tr>
					<td align="center">
					
				
					<input type = "checkbox" onClick="check_selection(this)" id="myProductList" name = "product_categories" value="<%=myProductCategoryList.get(i).getproduct_code()%>" 
				<%if(request.getAttribute("product_categories") != null)
				{
					ArrayList<String> product_categories = (ArrayList<String>) request.getAttribute("product_categories");
					if(product_categories.contains(myProductCategoryList.get(i).getproduct_code()) == true )
					{
				%>	
					disabled
				<%
					}
				}
				%>
					/>
					</td>	
					<td align="center"><%=myProductCategoryList.get(i).getrow_id() %></td>
					<td align="center"><%=myProductCategoryList.get(i).getproduct_code() %></td> 
					<td align="center"><%=myProductCategoryList.get(i).getcategory_name() %></td> 
					<td align="center"><%=myProductCategoryList.get(i).gethas_parent() %></td>
					<td align="center"><%=myProductCategoryList.get(i).getbusiness_id() %></td>
					<td align="center"><%=myProductCategoryList.get(i).getdate_created() %></td>
					<td align="center"><%=myProductCategoryList.get(i).getdate_modified() %></td>
					<td align="center"><%=myProductCategoryList.get(i).getparent_category_id() %></td>
					<td align="center"><%=myProductCategoryList.get(i).getis_published() %></td>
					</tr>
					
				<%
				}
			}
				%>
					
		</table>
		</form>
		</center>
		</div>
		
		
</font>
</body>
</html>