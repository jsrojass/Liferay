package com.test;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.ArrayList;

import com.liferay.util.bridges.mvc.MVCPortlet;

import apiclasses.ProductAPI;
import classpack.Product;

/**
 * Portlet implementation class FilterByProductCode
 */
public class ProductFilter extends MVCPortlet {
	
	public void GetProductList(ActionRequest request, ActionResponse response) throws Exception
	{
		String product_filter = ParamUtil.getString(request, "product_filter");
		int filter_by = ParamUtil.getInteger(request,"filter_by");
		System.out.println("product_filter= " + product_filter);
		System.out.println("filter_by= " + filter_by);
		String business_id = "SST1";
		ProductAPI myAPI = new ProductAPI();
		ArrayList<Product> myProductList = myAPI.GetListRequest(business_id, product_filter, filter_by);
		
		for(int i=0; i<myProductList.size(); i++)
		{
			System.out.println(myProductList.get(i).getproduct_type_id());
		}
		
		request.setAttribute("myProductList", myProductList);
		
	}
 
	public void GetAllRequest(ActionRequest request, ActionResponse response) throws Exception
	{
		String business_id = "SST1";
		ProductAPI myAPI = new ProductAPI();
		ArrayList<Product> myProductList = myAPI.GetAllRequest(business_id);
		request.setAttribute("myProductList", myProductList);
	}
}

