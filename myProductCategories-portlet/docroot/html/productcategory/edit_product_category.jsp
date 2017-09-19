<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import = "java.io.*,java.util.*" %>
<%@ page import = "classpack.Product_Category" %>
<%@ page import = "classpack.Product_Category_Attributes" %>
<%@ page import = "apiclasses.ProductCategoryAPI" %>
<%@ page import = "apiclasses.ProductCategoryAttributeAPI" %>

<portlet:defineObjects />
<portlet:actionURL var="CancelAction" windowState="normal" name="CancelAction"></portlet:actionURL>
<portlet:actionURL var="UpdateAttributes" windowState="normal" name="UpdateAttributes"></portlet:actionURL>
<portlet:actionURL var="CreateAttributes" windowState="normal" name="CreateAttributes"></portlet:actionURL>
<portlet:actionURL var="ToggleAttribute" windowState="normal" name="ToggleAttribute"></portlet:actionURL>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<b>edit_product_category.jsp</b> <br><br><br>

<font size="1" face="Arial" ><center>

<%
		if (request.getAttribute("myProductCategory") != null && request.getAttribute("myProductCategoryAttributes") != null && request.getAttribute("empty_flag") != null)
		{
			Product_Category myProductCategory = (Product_Category) request.getAttribute("myProductCategory");
			Product_Category_Attributes myProductCategoryAttributes = (Product_Category_Attributes) request.getAttribute("myProductCategoryAttributes");
			boolean empty_flag = (Boolean) request.getAttribute("empty_flag");
			
				if(empty_flag == false)
				{
%>
				<form action = "<%=UpdateAttributes%>" method = "POST" >
<% 
				}
				else
				{
%>
				<form action = "<%=CreateAttributes%>" method = "POST" >		
<% 
				}
%>

			<table border="1">
			<th colspan = "2" style="text-align:center" ><b> PRODUCT CATEGORY DETAILS: </b></th>
			<tr><td align="left"><b>row id:</b></td><td><input type = "text" style="width:550px" name = "row_id" value = "<%=myProductCategory.getrow_id()%>" readonly/></td></tr>
			<tr><td align="left"><b>product code:</b></td><td><input type = "text" style="width:550px" name = "product_code" value = "<%=myProductCategory.getproduct_code()%>" readonly/></td></tr>
			<tr><td align="left"><b>category name:</b></td><td><input type = "text" style="width:550px" name = "category_name" value = "<%=myProductCategory.getcategory_name()%>" readonly/></td></tr>
			<tr><td align="left"><b>has parent:</b></td><td><input type = "text" style="width:550px" name = "has_parent" value = "<%=myProductCategory.gethas_parent()%>" readonly/></td></tr>
			<tr><td align="left"><b>business id:</b></td><td><input type = "text" style="width:550px" name = "business_id" value = "<%=myProductCategory.getbusiness_id()%>" readonly/></td></tr>
			<tr><td align="left"><b>date created:</b></td><td><input type = "text" style="width:550px" name = "date_created" value = "<%=myProductCategory.getdate_created()%>" readonly/></td></tr>
			<tr><td align="left"><b>date modified:</b></td><td><input type = "text" style="width:550px" name = "date_modified" value = "<%=myProductCategory.getdate_modified()%>" readonly/></td></tr>
			<tr><td align="left"><b>parent category id:</b></td><td><input type = "text" style="width:550px" name = "parent_category_id" value = "<%=myProductCategory.getparent_category_id()%>" readonly/></td></tr>
			<tr><td align="left"><b>is published:</b></td><td><input type = "text" style="width:550px" name = "is_published" value = "<%=myProductCategory.getis_published()%>" readonly/></td></tr>
			</table>
			<br>
		
			<table border="1">
			<th colspan = "3" style="text-align:center" ><b> ATTRIBUTES: </b></th>
			<tr>
			<td><b>1</b></td>
			<td><b>suitable_for:</b></td><td><TEXTAREA required maxlength="1000" name="suitable_for" rows="5" cols="80"><%=myProductCategoryAttributes.getsuitable_for()%></TEXTAREA></td>
			</tr>
			<tr>
			<td><b>2</b></td>
			<td><b>units_of_competency:</b></td><td><TEXTAREA required maxlength="1000" name="units_of_competency" rows="5" cols="80"><%=myProductCategoryAttributes.getunits_of_competency()%></TEXTAREA></td>
			</tr>
			<tr>
			<td><b>3</b></td>
			<td><b>qualification_outcomes:</b></td><td><TEXTAREA required maxlength="1000" name="qualification_outcomes" rows="5" cols="80"><%=myProductCategoryAttributes.getqualification_outcomes()%></TEXTAREA></td>
			</tr>
			<tr>
			<td><b>4</b></td>
			<td><b>pre_requisite_information:</b></td><td><TEXTAREA required maxlength="1000" name="pre_requisite_information" rows="5" cols="80"><%=myProductCategoryAttributes.getpre_requisite_information()%></TEXTAREA></td>
			</tr>
			<tr>
			<td><b>5</b></td>
			<td><b>rpl:</b></td><td><TEXTAREA required maxlength="1000" name="rpl" rows="5" cols="80"><%=myProductCategoryAttributes.getrpl()%></TEXTAREA></td>
			</tr>
			<tr>
			<td><b>6</b></td>
			<td><b>payment_options:</b></td><td><TEXTAREA required maxlength="1000" name="payment_options" rows="5" cols="80"><%=myProductCategoryAttributes.getpayment_options()%></TEXTAREA></td>
			</tr>
			<tr>
			<td><b>7</b></td>
			<td><b>refund_policy:</b></td><td><TEXTAREA required wrap="hard" maxlength="1000" name="refund_policy" rows="5" cols="80"><%=myProductCategoryAttributes.getrefund_policy()%></TEXTAREA></td>
			</tr>
			<tr>
			<td><b>8</b></td>
			<td><b>related_courses:</b></td><td><TEXTAREA required maxlength="1000" name="related_courses" rows="5" cols="80"><%=myProductCategoryAttributes.getrelated_courses()%></TEXTAREA></td>
			</tr>
			<tr>
			<td><b>9</b></td>
			<td><b>max_students:</b></td><td><TEXTAREA required maxlength="1000" name="max_students" rows="5" cols="80"><%=myProductCategoryAttributes.getmax_students()%></TEXTAREA></td>
			</tr>
			<tr>
			<td><b>10</b></td>
			<td><b>further_opportunities:</b></td><td><TEXTAREA required maxlength="1000" name="further_opportunities" rows="5" cols="80"><%=myProductCategoryAttributes.getfurther_opportunities()%></TEXTAREA></td>
			</tr>
			<tr>
			<td><b>11</b></td>
			<td><b>faq:</b></td><td><TEXTAREA required maxlength="1000" name="faq" rows="5" cols="80"><%=myProductCategoryAttributes.getfaq()%></TEXTAREA></td>
			</tr>
			<tr>
			<td><b>12</b></td>
			<td><b>further_information:</b></td><td><TEXTAREA required maxlength="1000" name="further_information" rows="5" cols="80"><%=myProductCategoryAttributes.getfurther_information()%></TEXTAREA></td>
			</tr>
			</table>

			<br>
			
<%
				if(empty_flag == false)
				{
%>
			<input type = "submit" value = "Update" style=" color:white; background-color:blue; width:120px" />
<% 
				}
				else
				{
%>
			<input type = "submit" value = "Upload" style=" color:white; background-color:green; width:120px" />			
<% 
				}
%>
			</form>
				
			<form action = "<%=CancelAction%>" method = "POST" >
			<input type = "submit" value = "Return" style=" color:white; background-color:red; width:120px" />
			</form>
			<br>
			
<% 
									if(empty_flag == false)
									{			
%>			
			<table border="1">
			<th colspan = "3" style="text-align:center" ><b> ENABLE - DISABLE ATTRIBUTES: </b></th>
			<tr>
			<td><b>1</b></td>
			<td>suitable_for:</td>		
<% 
									if(empty_flag == false)
									{			
										if (myProductCategoryAttributes.getis_active(0) == false)
										{
%>
										<td>
										<form action = "<%=ToggleAttribute%>" method = "POST" >
										<input type="hidden" name="product_code" value="<%=myProductCategory.getproduct_code()%>"/>
										<input type="hidden" name="is_active_ID" value="0"/>
										<input type = "submit" value = "Enable" style=" color:white; background-color:green; width:120px" />
										</form>
										</td>
										</tr>
<%
										}
										else
										{
%>
										<td>
										<form action = "<%=ToggleAttribute%>" method = "POST" >
										<input type = "submit" value = "Disable" style=" color:black; background-color:yellow; width:120px" />
										<input type="hidden" name="product_code" value="<%=myProductCategory.getproduct_code()%>"/>
										<input type="hidden" name="is_active_ID" value="0"/>
										</form>
										</td>
										</tr>
<%
										}
									}
%>
			<tr>
			<td><b>2</b></td>
			<td>units_of_competency:</td>		
<% 
									if(empty_flag == false)
									{			
										if (myProductCategoryAttributes.getis_active(1) == false)
										{
%>
										<td>
										<form action = "<%=ToggleAttribute%>" method = "POST" >
										<input type="hidden" name="product_code" value="<%=myProductCategory.getproduct_code()%>"/>
										<input type="hidden" name="is_active_ID" value="1"/>
										<input type = "submit" value = "Enable" style=" color:white; background-color:green; width:120px" />
										</form>
										</td>
										</tr>
<%
										}
										else
										{
%>
										<td>
										<form action = "<%=ToggleAttribute%>" method = "POST" >
										<input type = "submit" value = "Disable" style=" color:black; background-color:yellow; width:120px" />
										<input type="hidden" name="product_code" value="<%=myProductCategory.getproduct_code()%>"/>
										<input type="hidden" name="is_active_ID" value="1"/>
										</form>
										</td>
										</tr>
<%
										}
									}
%>

			<tr>
			<td><b>3</b></td>
			<td>qualification_outcomes:</td>		
<% 
									if(empty_flag == false)
									{			
										if (myProductCategoryAttributes.getis_active(2) == false)
										{
%>
										<td>
										<form action = "<%=ToggleAttribute%>" method = "POST" >
										<input type="hidden" name="product_code" value="<%=myProductCategory.getproduct_code()%>"/>
										<input type="hidden" name="is_active_ID" value="2"/>
										<input type = "submit" value = "Enable" style=" color:white; background-color:green; width:120px" />
										</form>
										</td>
										</tr>
<%
										}
										else
										{
%>
										<td>
										<form action = "<%=ToggleAttribute%>" method = "POST" >
										<input type = "submit" value = "Disable" style=" color:black; background-color:yellow; width:120px" />
										<input type="hidden" name="product_code" value="<%=myProductCategory.getproduct_code()%>"/>
										<input type="hidden" name="is_active_ID" value="2"/>
										</form>
										</td>
										</tr>
<%
										}
									}
%>
			<tr>
			<td><b>4</b></td>
			<td>pre_requisite_information:</td>		
<% 
									if(empty_flag == false)
									{			
										if (myProductCategoryAttributes.getis_active(3) == false)
										{
%>
										<td>
										<form action = "<%=ToggleAttribute%>" method = "POST" >
										<input type="hidden" name="product_code" value="<%=myProductCategory.getproduct_code()%>"/>
										<input type="hidden" name="is_active_ID" value="3"/>
										<input type = "submit" value = "Enable" style=" color:white; background-color:green; width:120px" />
										</form>
										</td>
										</tr>
<%
										}
										else
										{
%>
										<td>
										<form action = "<%=ToggleAttribute%>" method = "POST" >
										<input type = "submit" value = "Disable" style=" color:black; background-color:yellow; width:120px" />
										<input type="hidden" name="product_code" value="<%=myProductCategory.getproduct_code()%>"/>
										<input type="hidden" name="is_active_ID" value="3"/>
										</form>
										</td>
										</tr>
<%
										}
									}
%>

			<tr>
			<td><b>5</b></td>
			<td>rpl:</td>		
<% 
									if(empty_flag == false)
									{			
										if (myProductCategoryAttributes.getis_active(4) == false)
										{
%>
										<td>
										<form action = "<%=ToggleAttribute%>" method = "POST" >
										<input type="hidden" name="product_code" value="<%=myProductCategory.getproduct_code()%>"/>
										<input type="hidden" name="is_active_ID" value="4"/>
										<input type = "submit" value = "Enable" style=" color:white; background-color:green; width:120px" />
										</form>
										</td>
										</tr>
<%
										}
										else
										{
%>
										<td>
										<form action = "<%=ToggleAttribute%>" method = "POST" >
										<input type = "submit" value = "Disable" style=" color:black; background-color:yellow; width:120px" />
										<input type="hidden" name="product_code" value="<%=myProductCategory.getproduct_code()%>"/>
										<input type="hidden" name="is_active_ID" value="4"/>
										</form>
										</td>
										</tr>
<%
										}
									}
%>

			<tr>
			<td><b>6</b></td>
			<td>payment_options:</td>		
<% 
									if(empty_flag == false)
									{			
										if (myProductCategoryAttributes.getis_active(5) == false)
										{
%>
										<td>
										<form action = "<%=ToggleAttribute%>" method = "POST" >
										<input type="hidden" name="product_code" value="<%=myProductCategory.getproduct_code()%>"/>
										<input type="hidden" name="is_active_ID" value="5"/>
										<input type = "submit" value = "Enable" style=" color:white; background-color:green; width:120px" />
										</form>
										</td>
										</tr>
<%
										}
										else
										{
%>
										<td>
										<form action = "<%=ToggleAttribute%>" method = "POST" >
										<input type = "submit" value = "Disable" style=" color:black; background-color:yellow; width:120px" />
										<input type="hidden" name="product_code" value="<%=myProductCategory.getproduct_code()%>"/>
										<input type="hidden" name="is_active_ID" value="5"/>
										</form>
										</td>
										</tr>
<%
										}
									}
%>

			<tr>
			<td><b>7</b></td>
			<td>refund_policy:</td>		
<% 
									if(empty_flag == false)
									{			
										if (myProductCategoryAttributes.getis_active(6) == false)
										{
%>
										<td>
										<form action = "<%=ToggleAttribute%>" method = "POST" >
										<input type="hidden" name="product_code" value="<%=myProductCategory.getproduct_code()%>"/>
										<input type="hidden" name="is_active_ID" value="6"/>
										<input type = "submit" value = "Enable" style=" color:white; background-color:green; width:120px" />
										</form>
										</td>
										</tr>
<%
										}
										else
										{
%>
										<td>
										<form action = "<%=ToggleAttribute%>" method = "POST" >
										<input type = "submit" value = "Disable" style=" color:black; background-color:yellow; width:120px" />
										<input type="hidden" name="product_code" value="<%=myProductCategory.getproduct_code()%>"/>
										<input type="hidden" name="is_active_ID" value="6"/>
										</form>
										</td>
										</tr>
<%
										}
									}
%>

			<tr>
			<td><b>8</b></td>
			<td>related_courses:</td>		
<% 
									if(empty_flag == false)
									{			
										if (myProductCategoryAttributes.getis_active(7) == false)
										{
%>
										<td>
										<form action = "<%=ToggleAttribute%>" method = "POST" >
										<input type="hidden" name="product_code" value="<%=myProductCategory.getproduct_code()%>"/>
										<input type="hidden" name="is_active_ID" value="7"/>
										<input type = "submit" value = "Enable" style=" color:white; background-color:green; width:120px" />
										</form>
										</td>
										</tr>
<%
										}
										else
										{
%>
										<td>
										<form action = "<%=ToggleAttribute%>" method = "POST" >
										<input type = "submit" value = "Disable" style=" color:black; background-color:yellow; width:120px" />
										<input type="hidden" name="product_code" value="<%=myProductCategory.getproduct_code()%>"/>
										<input type="hidden" name="is_active_ID" value="7"/>
										</form>
										</td>
										</tr>
<%
										}
									}
%>

			<tr>
			<td><b>9</b></td>
			<td>max_students:</td>		
<% 
									if(empty_flag == false)
									{			
										if (myProductCategoryAttributes.getis_active(8) == false)
										{
%>
										<td>
										<form action = "<%=ToggleAttribute%>" method = "POST" >
										<input type="hidden" name="product_code" value="<%=myProductCategory.getproduct_code()%>"/>
										<input type="hidden" name="is_active_ID" value="8"/>
										<input type = "submit" value = "Enable" style=" color:white; background-color:green; width:120px" />
										</form>
										</td>
										</tr>
<%
										}
										else
										{
%>
										<td>
										<form action = "<%=ToggleAttribute%>" method = "POST" >
										<input type = "submit" value = "Disable" style=" color:black; background-color:yellow; width:120px" />
										<input type="hidden" name="product_code" value="<%=myProductCategory.getproduct_code()%>"/>
										<input type="hidden" name="is_active_ID" value="8"/>
										</form>
										</td>
										</tr>
<%
										}
									}
%>

			<tr>
			<td><b>10</b></td>
			<td>further_opportunities:</td>		
<% 
									if(empty_flag == false)
									{			
										if (myProductCategoryAttributes.getis_active(9) == false)
										{
%>
										<td>
										<form action = "<%=ToggleAttribute%>" method = "POST" >
										<input type="hidden" name="product_code" value="<%=myProductCategory.getproduct_code()%>"/>
										<input type="hidden" name="is_active_ID" value="9"/>
										<input type = "submit" value = "Enable" style=" color:white; background-color:green; width:120px" />
										</form>
										</td>
										</tr>
<%
										}
										else
										{
%>
										<td>
										<form action = "<%=ToggleAttribute%>" method = "POST" >
										<input type = "submit" value = "Disable" style=" color:black; background-color:yellow; width:120px" />
										<input type="hidden" name="product_code" value="<%=myProductCategory.getproduct_code()%>"/>
										<input type="hidden" name="is_active_ID" value="9"/>
										</form>
										</td>
										</tr>
<%
										}
									}
%>

			<tr>
			<td><b>11</b></td>
			<td>faq:</td>		
<% 
									if(empty_flag == false)
									{			
										if (myProductCategoryAttributes.getis_active(10) == false)
										{
%>
										<td>
										<form action = "<%=ToggleAttribute%>" method = "POST" >
										<input type="hidden" name="product_code" value="<%=myProductCategory.getproduct_code()%>"/>
										<input type="hidden" name="is_active_ID" value="10"/>
										<input type = "submit" value = "Enable" style=" color:white; background-color:green; width:120px" />
										</form>
										</td>
										</tr>
<%
										}
										else
										{
%>
										<td>
										<form action = "<%=ToggleAttribute%>" method = "POST" >
										<input type = "submit" value = "Disable" style=" color:black; background-color:yellow; width:120px" />
										<input type="hidden" name="product_code" value="<%=myProductCategory.getproduct_code()%>"/>
										<input type="hidden" name="is_active_ID" value="10"/>
										</form>
										</td>
										</tr>
<%
										}
									}
%>

			<tr>
			<td><b>12</b></td>
			<td>further_information:</td>		
<% 
									if(empty_flag == false)
									{			
										if (myProductCategoryAttributes.getis_active(11) == false)
										{
%>
										<td>
										<form action = "<%=ToggleAttribute%>" method = "POST" >
										<input type="hidden" name="product_code" value="<%=myProductCategory.getproduct_code()%>"/>
										<input type="hidden" name="is_active_ID" value="11"/>
										<input type = "submit" value = "Enable" style=" color:white; background-color:green; width:120px" />
										</form>
										</td>
										</tr>
<%
										}
										else
										{
%>
										<td>
										<form action = "<%=ToggleAttribute%>" method = "POST" >
										<input type = "submit" value = "Disable" style=" color:black; background-color:yellow; width:120px" />
										<input type="hidden" name="product_code" value="<%=myProductCategory.getproduct_code()%>"/>
										<input type="hidden" name="is_active_ID" value="11"/>
										</form>
										</td>
										</tr>
<%
										}
									}
%>

			</table>
			</center>
			</font>

<% 
									}			
%>	

<%
} // end of if (request.getAttribute("myProductCategory") != null)
%>

			
			
			
			
			
			

</body>
</html>