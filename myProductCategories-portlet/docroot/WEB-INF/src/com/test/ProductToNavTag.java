package com.test;

import java.util.ArrayList;
import com.liferay.portal.kernel.util.*;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletSession;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import apiclasses.ProductNavTagAPI;
import apiclasses.ProductCategoryAPI;
import classpack.Product_Nav_Tag;
import classpack.Product_Category;
/**
 * Portlet implementation class ProductToNavTag
 */
public class ProductToNavTag extends MVCPortlet {
	
	public void GetAllNavTagsRequest(ActionRequest request, ActionResponse response) throws Exception
	{
		String business_id = "SST1";
		ProductNavTagAPI myAPI = new ProductNavTagAPI();
		ArrayList<Product_Nav_Tag> myProduct_Nav_TagList = myAPI.GetAllRequest(business_id);
		request.setAttribute("myproduct_nav_tag_List", myProduct_Nav_TagList);
		
	}
	
	public void GetNavTagList(ActionRequest request, ActionResponse response) throws Exception
	{
		String nav_tag_id_filter = ParamUtil.getString(request, "nav_tag_id_filter");
		String business_id = "SST1";
		ProductNavTagAPI myAPI = new ProductNavTagAPI();
		ArrayList<Product_Nav_Tag> myProduct_Nav_TagList = myAPI.GetListRequest(business_id, nav_tag_id_filter);
		request.setAttribute("myproduct_nav_tag_List", myProduct_Nav_TagList);
		
	}
	
	public void GetAllProductCategoryRequest(ActionRequest request, ActionResponse response) throws Exception
	{
		String business_id = "SST1";
		ProductCategoryAPI myAPI = new ProductCategoryAPI();
		ArrayList<Product_Category> myProductCategoryList = myAPI.GetProductCategoryList(business_id);
		PortletSession session = request.getPortletSession();
		if (session.getAttribute("nav_tag_id", PortletSession.APPLICATION_SCOPE) != null)
		{
			String nav_tag_id = (String) session.getAttribute("nav_tag_id", PortletSession.APPLICATION_SCOPE);
			session.setAttribute("nav_tag_id", nav_tag_id, PortletSession.APPLICATION_SCOPE);
			request.setAttribute("nav_tag_id", nav_tag_id);
		}
		
		if (session.getAttribute("product_categories", PortletSession.APPLICATION_SCOPE) != null)
		{
			ArrayList<String> product_categories = (ArrayList<String>) session.getAttribute("product_categories", PortletSession.APPLICATION_SCOPE);
			session.setAttribute("product_categories", product_categories, PortletSession.APPLICATION_SCOPE);
			request.setAttribute("product_categories", product_categories);
		}
		//String[] checkedAttributes = request.getParameterValues("attributes");
		//request.setAttribute("checkedAttributes", checkedAttributes);
		request.setAttribute("myProductCategoryList", myProductCategoryList);
		response.setRenderParameter("jspPage", "/html/producttonavtag/product_selection.jsp");
	}
	
	public void GetProductCategoryList(ActionRequest request, ActionResponse response) throws Exception
	{
		String product_category_filter = ParamUtil.getString(request, "product_category_filter");
		int filter_by = ParamUtil.getInteger(request,"filter_by");
		String business_id = "SST1";
		ProductCategoryAPI myAPI = new ProductCategoryAPI();
		ArrayList<Product_Category> myProductCategoryList = myAPI.GetListRequest(business_id, product_category_filter, filter_by);
		PortletSession session = request.getPortletSession();
		if (session.getAttribute("nav_tag_id", PortletSession.APPLICATION_SCOPE) != null)
		{
			String nav_tag_id = (String) session.getAttribute("nav_tag_id", PortletSession.APPLICATION_SCOPE);
			session.setAttribute("nav_tag_id", nav_tag_id, PortletSession.APPLICATION_SCOPE);
			request.setAttribute("nav_tag_id", nav_tag_id);
		}
		
		if (session.getAttribute("product_categories", PortletSession.APPLICATION_SCOPE) != null)
		{
			ArrayList<String> product_categories = (ArrayList<String>) session.getAttribute("product_categories", PortletSession.APPLICATION_SCOPE);
			session.setAttribute("product_categories", product_categories, PortletSession.APPLICATION_SCOPE);
			request.setAttribute("product_categories", product_categories);
		}
		//String[] checkedAttributes = request.getParameterValues("attributes");
		//request.setAttribute("checkedAttributes", checkedAttributes);
		request.setAttribute("myProductCategoryList", myProductCategoryList);
		response.setRenderParameter("jspPage", "/html/producttonavtag/product_selection.jsp");
	}
	
	public void SubmitSelectedNavTag(ActionRequest request, ActionResponse response)
	{
		/*
		String[] nav_tag_id = request.getParameterValues("nav_tag_id");
		PortletSession session = request.getPortletSession();
		session.setAttribute("nav_tag_id", nav_tag_id[0], PortletSession.APPLICATION_SCOPE);
		request.setAttribute("nav_tag_id", nav_tag_id[0]);
		response.setRenderParameter("jspPage", "/html/producttonavtag/product_selection.jsp");
 		*/
		
		String nav_tag_id = ParamUtil.getString(request, "nav_tag_id");
		System.out.println("nav_tag_id = " + nav_tag_id);
		PortletSession session = request.getPortletSession();
		session.setAttribute("nav_tag_id", nav_tag_id, PortletSession.APPLICATION_SCOPE);
		request.setAttribute("nav_tag_id", nav_tag_id);
		response.setRenderParameter("jspPage", "/html/producttonavtag/product_selection.jsp");
		
		
 	}
	
	public void SubmitSelectedProduct(ActionRequest request, ActionResponse response)
	{
		PortletSession session = request.getPortletSession();
		String[] selected_categories = request.getParameterValues("product_categories");
		
		ArrayList<String> product_categories = new ArrayList<String>();
		
		if (session.getAttribute("product_categories", PortletSession.APPLICATION_SCOPE) == null)
		{
			for(int i=0; i<selected_categories.length;i++)
			{
				product_categories.add(selected_categories[i]);
			}
		}
		else
		{
			product_categories = (ArrayList<String>) session.getAttribute("product_categories", PortletSession.APPLICATION_SCOPE);
			for(int i=0; i<selected_categories.length;i++)
			{
				if(product_categories.contains(selected_categories[i]) == false)
				{
					product_categories.add(selected_categories[i]);
				}
			}
		}
		
		session.setAttribute("product_categories", product_categories, PortletSession.APPLICATION_SCOPE);
		request.setAttribute("product_categories", product_categories);
		if (session.getAttribute("nav_tag_id", PortletSession.APPLICATION_SCOPE) != null)
		{
			String nav_tag_id = (String) session.getAttribute("nav_tag_id", PortletSession.APPLICATION_SCOPE);
			
			for(int i=0; i<product_categories.size(); i++)
			{
			System.out.println("product_categories: " + product_categories.get(i));
			}
			System.out.println("nav_tag_id: " + nav_tag_id);
			
			session.setAttribute("nav_tag_id", nav_tag_id, PortletSession.APPLICATION_SCOPE);
			request.setAttribute("nav_tag_id", nav_tag_id);
		}
		response.setRenderParameter("jspPage", "/html/producttonavtag/product_selection.jsp");		
	}
	
	public void CancelRequest(ActionRequest request, ActionResponse response)
	{
		response.setRenderParameter("jspPage", "/html/producttonavtag/nav_tag_selection.jsp");
	}
	
	public void RemoveSelectedProducts(ActionRequest request, ActionResponse response)
	{
		String[] remove_selected_categories = request.getParameterValues("remove_product_categories");
		System.out.println("******** INDEXES TO REMOVE ********");
		for(int i=0; i<remove_selected_categories.length;i++)
		{
			System.out.println(remove_selected_categories[i]);
		}
		
		PortletSession session = request.getPortletSession();
		if (session.getAttribute("product_categories", PortletSession.APPLICATION_SCOPE) != null)
		{
			ArrayList<String> product_categories = (ArrayList<String>) session.getAttribute("product_categories", PortletSession.APPLICATION_SCOPE);
			
			System.out.println("****** product_categories BEFORE removal request: size()= " + product_categories.size() + "******");
			for(int k=0; k<product_categories.size();k++)
			{
				System.out.println(k + " : " + product_categories.get(k));
			}
			
			/* 
			if(remove_selected_categories.length<product_categories.size())
			{
				for(int i=0; i<remove_selected_categories.length;i++)
				{
				product_categories.remove(Integer.parseInt(remove_selected_categories[i]));
				}
			}
			*/
			
			if(remove_selected_categories.length == product_categories.size())
			{
				product_categories.removeAll(product_categories);
			}
			else
			{
				for(int i=0;i<product_categories.size();i++)
				{
					for(int j=0;j<remove_selected_categories.length;j++)
					{
						if(product_categories.get(i).contains(remove_selected_categories[j]) == true)
						{
							product_categories.remove(i);
						}
					}
				}
			}
			
			System.out.println("****** product_categories AFTER removal request: size()= " + product_categories.size() + "******");
			for(int k=0; k<product_categories.size();k++)
			{
				System.out.println(k + " : " + product_categories.get(k));
			}
			
			session.setAttribute("product_categories", product_categories, PortletSession.APPLICATION_SCOPE);
			request.setAttribute("product_categories", product_categories);
		}
		
		if (session.getAttribute("nav_tag_id", PortletSession.APPLICATION_SCOPE) != null)
		{
			String nav_tag_id = (String) session.getAttribute("nav_tag_id", PortletSession.APPLICATION_SCOPE);
			session.setAttribute("nav_tag_id", nav_tag_id, PortletSession.APPLICATION_SCOPE);
			request.setAttribute("nav_tag_id", nav_tag_id);
		}
		
		response.setRenderParameter("jspPage", "/html/producttonavtag/product_selection.jsp");
	}
	public void BatchRequest(ActionRequest request, ActionResponse response) throws Exception
	{
		
		PortletSession session = request.getPortletSession();
		if (session.getAttribute("product_categories", PortletSession.APPLICATION_SCOPE) != null && session.getAttribute("nav_tag_id", PortletSession.APPLICATION_SCOPE) != null)
		{
			ArrayList<String> product_categories = (ArrayList<String>) session.getAttribute("product_categories", PortletSession.APPLICATION_SCOPE);
			String nav_tag_id = (String) session.getAttribute("nav_tag_id", PortletSession.APPLICATION_SCOPE);session.setAttribute("product_categories", product_categories, PortletSession.APPLICATION_SCOPE);
			String business_id = "SST1";
			int is_deleted = 0;
			String XMLBody = new String();
			
			for(int i=0; i<product_categories.size();i++)
			{
				XMLBody = XMLBody 
						+ 	"<p:_postcreate_batch_req xmlns:p=\"product_category_to_nav_tag_pc\">\n"
						+ 		"\t<p:_postcreate>\n"
						+ 				"\t\t\t<p:product_code>" + product_categories.get(i) + "</p:product_code>\n"
						+ 				"\t\t\t<p:nav_tag_id>" + nav_tag_id + "</p:nav_tag_id>\n"
						+ 				"\t\t\t<p:is_deleted>" + is_deleted + "</p:is_deleted>\n"
						+ 				"\t\t\t<p:business_id>" + business_id + "</p:business_id>\n"
						+ 		"\t</p:_postcreate>\n"
						+ 	"</p:_postcreate_batch_req>\n";
			}
		
			System.out.println(XMLBody);
			
			ProductNavTagAPI myAPI = new ProductNavTagAPI();
			myAPI.BatchProducttoNavTagRequest(XMLBody);
			product_categories.removeAll(product_categories);
			session.setAttribute("product_categories", product_categories, PortletSession.APPLICATION_SCOPE);
			request.setAttribute("product_categories", product_categories);
			
		}	
				
		response.setRenderParameter("jspPage", "/html/producttonavtag/nav_tag_selection.jsp");
	}
 

}
