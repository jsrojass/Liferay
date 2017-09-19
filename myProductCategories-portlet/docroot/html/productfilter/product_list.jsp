<!-- A taglib directive must be added to the top of the JSP page that uses the portlet.tld custom tags -->

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import = "java.io.*,java.util.*" %>
<%@ page import = "classpack.Product" %>
<%@ page import = "apiclasses.ProductAPI" %>
<%@ page contentType="text/css" %>

<portlet:defineObjects />
<portlet:actionURL var="GetProductList" windowState="normal" name="GetProductList"></portlet:actionURL>
<portlet:actionURL var="GetAllRequest" windowState="normal" name="GetAllRequest"></portlet:actionURL>

<!DOCTYPE html>
<html>
<head>
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
</script>
</head>
<body>	

This is the <b>productfilter/product_list.jsp</b> portlet in View mode.
	
<%
			String business_id = "SST1";
			ProductAPI myAPI = new ProductAPI();
			ArrayList<Product> myProduct_List = myAPI.GetAllRequest(business_id);	
%>

			<div style="overflow-x:auto;">
			<font size="1" face="Arial" >
			<center>
			<table>	
				<tr>
									
									<td>
										
										<div>
												Filter By: 	<select onchange="getfilter_by(this)">
															<option value="1">			Product ID</option>
															<option value="2">		Product Type ID</option>
															<option value="3">		Product Code</option>
															<option value="4">			External ID</option>
															<option value="5">		Product Name</option>
															</select>
																					
												<div id="1">
												<form action = "<%=GetProductList%>" method = "POST" >
												<br>Product ID: 
															<input type="hidden" name="filter_by" value="1"/>
															<input type = "text" name = "product_filter" list="product_id_filter_list" required/>
															<datalist id="product_id_filter_list">
															<%
															for(int i=0; i<myProduct_List.size(); i++)
															{
																if(i==0 ||((i+1)<myProduct_List.size() && myProduct_List.get(i+1).getproduct_id().equals(myProduct_List.get(i).getproduct_id()) == false))
																{
															%>
															<option value="<%=myProduct_List.get(i).getproduct_id()%>" />
															<%
																}
															}
															%>
															</datalist>
												<input type = "submit" value = "Search" />
												</form>	
												</div>
												
												<div id="2" style="display:none">
												<form action = "<%=GetProductList%>" method = "POST" >
												<br>Product Type ID: 
															<input type="hidden" name="filter_by" value="2"/> 
															<input type = "text" name = "product_filter" list="product_type_id_filter_list" required />
															<datalist id="product_type_id_filter_list">
															<%
															for(int i=0; i<myProduct_List.size(); i++)
															{
																if(i==0 ||((i+1)<myProduct_List.size() && myProduct_List.get(i+1).getproduct_type_id().equals(myProduct_List.get(i).getproduct_type_id()) == false))
																{	
															%>
																<option value="<%=myProduct_List.get(i).getproduct_type_id()%>" />
															<%
																}
															}
															%>
															</datalist>
												<input type = "submit" value = "Search" />
												</form>	
												</div>
												
												<div id="3" style="display:none">									
												<form action = "<%=GetProductList%>" method = "POST" >
												<br>Product Code: 
															<input type="hidden" name="filter_by" value="3"/> 
															<input type = "text" name = "product_filter" list="product_code_filter_list" required />
															<datalist id="product_code_filter_list">
															<%
															for(int i=0; i<myProduct_List.size(); i++)
															{
																if(i==0 ||((i+1)<myProduct_List.size() && myProduct_List.get(i+1).getproduct_code().equals(myProduct_List.get(i).getproduct_code()) == false))
																{
															%>
															<option value="<%=myProduct_List.get(i).getproduct_code()%>" />
															<%
																}
															}
															%>
															</datalist>
												<input type = "submit" value = "Search" />
												</form>	
												</div>
												
												<div id="4" style="display:none">									
												<form action = "<%=GetProductList%>" method = "POST" >
												<br>External ID:
															<input type="hidden" name="filter_by" value="4"/> 
															<input type = "text" name = "product_filter" list="external_id_filter_list" required />
															<datalist id="external_id_filter_list">
															<%
															for(int i=0; i<myProduct_List.size(); i++)
															{
																if(i==0 ||((i+1)<myProduct_List.size() && myProduct_List.get(i+1).getexternal_id().equals(myProduct_List.get(i).getexternal_id()) == false))
																{
															%>
															<option value="<%=myProduct_List.get(i).getexternal_id()%>" />
															<%
																}
															}
															%>
															</datalist>
												<input type = "submit" value = "Search" />
												</form>	
												</div>
												
												<div id="5" style="display:none">
												<form action = "<%=GetProductList%>" method = "POST" >
												<br>Product Name:
															<input type="hidden" name="filter_by" value="5"/> 
															<input type = "text" name = "product_filter" list="product_name_filter_list" required />
															<datalist id="product_name_filter_list">
															<%
															for(int i=0; i<myProduct_List.size(); i++)
															{
																if(i==0 ||((i+1)<myProduct_List.size() && myProduct_List.get(i+1).getproduct_name().equals(myProduct_List.get(i).getproduct_name()) == false))
																{
															%>
															<option value="<%=myProduct_List.get(i).getproduct_name()%>" />
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
			<br><br>
			
			
<%
			if (request.getAttribute("myProductList") != null)
			{
				ArrayList<Product> myProductList = (ArrayList<Product>) request.getAttribute("myProductList");				
%>
		About <%=myProductList.size()%> <%if(myProductList.size() == 1){%>result<%}else{%>results<%}%>
		
<%
		if(myProductList.size()>0)
				{
%>
		<table border="1">
		
		<tr>		
		<td><b> row_id </b></td>
		<td><b> product_id </b></td>
		<td><b> product_type_id </b></td> 
		<td><b> product_code </b></td>
		<td><b> external_id </b></td> 
		<td><b> product_name </b></td>
		<td><b> product_web_name </b></td> 
		<td><b> name_as_webname </b></td> 
		<td><b> product_group_id </b></td> 
		<td><b> product_group_type_name </b></td> 
		<td><b> delivery_type_name </b></td>
		<td><b> duration </b></td> 
		<td><b> stream_name </b></td> 
		<td><b> short_description </b></td> 
		<td><b> domain_id </b></td> 
		<td><b> location_id </b></td> 
		<td><b> default_price </b></td>
		<td><b> business_id </b></td>
		<td><b> is_active </b></td>
		<td><b> is_published </b></td>
		<td><b> date_created </b></td>
		<td><b> date_modified </b></td>
		<td><b> has_attribute </b></td>
		<td><b> has_inventory </b></td>
		<td><b> p_image_url </b></td>
		</tr>
		
		<%
				for(int i=0; i<myProductList.size();i++)
				{		
		%>
				
					<tr>
					<td><%=myProductList.get(i).getrow_id() %></td>
					<td><%=myProductList.get(i).getproduct_id() %></td>
					<td><%=myProductList.get(i).getproduct_type_id() %></td>
					<td><%=myProductList.get(i).getproduct_code() %></td>
					<td><%=myProductList.get(i).getexternal_id() %></td>
					<td><%=myProductList.get(i).getproduct_name() %></td>
					<td><%=myProductList.get(i).getproduct_web_name() %></td> 
					<td><%=myProductList.get(i).getname_as_webname() %></td> 
					<td><%=myProductList.get(i).getproduct_group_id() %></td> 
					<td><%=myProductList.get(i).getproduct_group_type_name() %></td> 
					<td><%=myProductList.get(i).getdelivery_type_name() %></td>
					<td><%=myProductList.get(i).getduration() %></td> 
					<td><%=myProductList.get(i).getstream_name() %></td>
					<td><%=myProductList.get(i).getshort_description() %></td> 
					<td><%=myProductList.get(i).getdomain_id()%></td> 
					<td><%=myProductList.get(i).getlocation_id()%></td> 
					<td><%=myProductList.get(i).getdefault_price()%></td>
					<td><%=myProductList.get(i).getbusiness_id()%></td>
					<td><%=myProductList.get(i).getis_active()%></td>
					<td><%=myProductList.get(i).getis_published()%></td>
					<td><%=myProductList.get(i).getdate_created()%></td>
					<td><%=myProductList.get(i).getdate_modified()%></td>
					<td><%=myProductList.get(i).gethas_attribute()%></td>
					<td><%=myProductList.get(i).gethas_inventory()%></td>
					<td><%=myProductList.get(i).getp_image_url()%></td>
					</tr>
								
		<%
				}
		%>
		</table>
		</center>
		</font>
		</div>
<%
				}
			}
%>

</body>
</html>