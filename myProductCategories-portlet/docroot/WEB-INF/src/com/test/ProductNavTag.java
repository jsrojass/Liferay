package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.lang.*;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletSession;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import classpack.Product_Nav_Tag;
import apiclasses.ProductNavTagAPI;

/**
 * Portlet implementation class ProductNavTag
 */
public class ProductNavTag extends MVCPortlet 
{
	public void GetAllRequest(ActionRequest request, ActionResponse response) throws Exception
	{
		String business_id = "SST1";
		ProductNavTagAPI myAPI = new ProductNavTagAPI();
		ArrayList<Product_Nav_Tag> myProduct_Nav_TagList = myAPI.GetAllRequest(business_id);
		
		System.out.println("************************* GET ALL REQUEST *************************");
		for(int i=0; i<myProduct_Nav_TagList.size(); i++)
		{
			System.out.println(myProduct_Nav_TagList.get(i).getnav_tag_id());
		}
		
		request.setAttribute("myproduct_nav_tag_List", myProduct_Nav_TagList);
		
	}
	
	public void GetNavTagList(ActionRequest request, ActionResponse response) throws Exception
	{
		String nav_tag_id_filter = ParamUtil.getString(request, "nav_tag_id_filter");
		System.out.println("nav_tag_id_filter = " + nav_tag_id_filter);
		String business_id = "SST1";
		ProductNavTagAPI myAPI = new ProductNavTagAPI();
		ArrayList<Product_Nav_Tag> myProduct_Nav_TagList = myAPI.GetListRequest(business_id, nav_tag_id_filter);
		
		System.out.println("************************* FILTER BY REQUEST *************************");
		for(int i=0; i<myProduct_Nav_TagList.size(); i++)
		{
			System.out.println(myProduct_Nav_TagList.get(i).getnav_tag_id());
		}
		
		request.setAttribute("myproduct_nav_tag_List", myProduct_Nav_TagList);
		
	}
	
	public void CancelAction(ActionRequest request, ActionResponse response) throws Exception
	{
		response.setRenderParameter("jspPage", "/html/productnavtag/product_nav_tag_list.jsp");
	}
	
	public void EditNavTag(ActionRequest request, ActionResponse response) throws Exception
	{
		String business_id = "SST1";
		String nav_tag_id = ParamUtil.getString(request, "nav_tag_id");
		ProductNavTagAPI myAPI = new ProductNavTagAPI();
		Product_Nav_Tag myProduct_Nav_Tag = myAPI.GetSingleNavTagRequest(business_id, nav_tag_id);
		request.setAttribute("myProduct_Nav_Tag", myProduct_Nav_Tag);
		response.setRenderParameter("jspPage", "/html/productnavtag/edit_product_nav_tag_list.jsp");
	}
	
	public void UpdateNavTag(ActionRequest request, ActionResponse response) throws Exception
	{
		System.out.println("update request");
		String business_id = "SST1";
		String nav_tag_id = ParamUtil.getString(request, "nav_tag_id");
		String description = ParamUtil.getString(request, "description");
		description = description.replace("\n", "<br/>");
		String[] is_published = request.getParameterValues("is_published");
		String putString = 
					"nav_tag_id="		+	nav_tag_id
				+	"&description="		+	description
				+	"&is_published="	+	is_published[0]
				+	"&business_id="		+	business_id;
				
		System.out.println("putString: " + putString);
		ProductNavTagAPI myAPI = new ProductNavTagAPI();
		myAPI.UpdateNavTagRequest(putString);
	}
	
	public void CreateNavTag(ActionRequest request, ActionResponse response) throws Exception
	{
		System.out.println("create request");
		response.setRenderParameter("jspPage", "/html/productnavtag/create_product_nav_tag_list.jsp");
	}
	
	public void UploadNavTag(ActionRequest request, ActionResponse response) throws Exception
	{
		String business_id = "SST1";
		ProductNavTagAPI myAPI = new ProductNavTagAPI();
		ArrayList<Product_Nav_Tag> myProduct_Nav_TagList = myAPI.GetAllRequest(business_id);
		String nav_tag_id = ParamUtil.getString(request, "nav_tag_id");
		
		boolean check_nav_tag_id = false;
		
		for(int i=0;i<myProduct_Nav_TagList.size();i++ )
		{
			System.out.println("Compare: " + nav_tag_id + " vs. " + myProduct_Nav_TagList.get(i).getnav_tag_id());
			if(nav_tag_id.equals(myProduct_Nav_TagList.get(i).getnav_tag_id()) == true)
			{
				check_nav_tag_id = true;
			}
		}
		
		if(check_nav_tag_id == true)
		{
			System.out.println("******************* ERROR: upload request canceled *******************");
			String error = "The navigation tag is taken. Try again with a new one";
			request.setAttribute("error", error);
			response.setRenderParameter("jspPage", "/html/productnavtag/create_product_nav_tag_list.jsp");
		}
		else 
		{
			System.out.println("******************* NO ERROR: upload request in process *******************");
			String description = ParamUtil.getString(request, "description");
			description = description.replace("\n", "<br/>");
			String postString = 
					"description="		+	description
				+	"&nav_tag_id="		+	nav_tag_id
				+	"&business_id="		+	business_id;
				
			System.out.println("postString: " + postString);
			myAPI.CreateNavTagRequest(postString);
		}		
		
	}
	
	public void DeleteNavTag(ActionRequest request, ActionResponse response) throws Exception
	{
		String business_id = "SST1";
	}
}
