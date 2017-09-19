<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import = "java.io.*,java.util.*,java.lang.*" %>
<%@ page import = "classpack.Product_Category" %>
<%@ page import = "apiclasses.ProductCategoryAPI" %>
<%@ page import = "classpack.Product_Nav_Tag" %>
<%@ page import = "apiclasses.ProductNavTagAPI" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
			if (request.getAttribute("product_categories") != null && request.getAttribute("product_categories") != null)
			{
				ArrayList<Product_Nav_Tag> product_categories = (ArrayList<Product_Nav_Tag>) request.getAttribute("product_categories");
				String nav_tag_id = (String) request.getAttribute("nav_tag_id"); 
				System.out.println("*******************************************************************");
				System.out.println("nav_tag_id = " + nav_tag_id);
				System.out.println("*******************************************************************");
				for(int i=0 ; i<product_categories.size() ; i++)
				{
				System.out.println("product_categories = " + product_categories.get(i));
				}
				System.out.println("*******************************************************************");
			}
				
%>


</body>
</html>