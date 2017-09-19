package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.lang.*;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import classpack.Product_Category;
import classpack.Product_Category_Attributes;
import apiclasses.ProductCategoryAPI;
import apiclasses.ProductCategoryAttributeAPI;

/**
 * Portlet implementation class ProductCategory
 */
public class ProductCategory extends MVCPortlet {
	
	public void GetAllRequest(ActionRequest request, ActionResponse response) throws Exception
	{
		String business_id = "SST1";
		ProductCategoryAPI myAPI = new ProductCategoryAPI();
		ProductCategoryAttributeAPI myAPI_2 = new ProductCategoryAttributeAPI();
		
		ArrayList<Product_Category> myProductCategoryList = myAPI.GetProductCategoryList(business_id);
		ArrayList<String> myproduct_codeList = myAPI_2.GetAllAttributeRequest(business_id);
		//String[] checkedAttributes = request.getParameterValues("attributes");
		
		//request.setAttribute("checkedAttributes", checkedAttributes);
		request.setAttribute("myProductCategoryList", myProductCategoryList);
		request.setAttribute("myproduct_codeList", myproduct_codeList);
		
		response.setRenderParameter("jspPage", "/html/productcategory/product_category_list.jsp");
	}
	
	public void GetProductCategoryList(ActionRequest request, ActionResponse response) throws Exception
	{
		String product_category_filter = ParamUtil.getString(request, "product_category_filter");
		int filter_by = ParamUtil.getInteger(request,"filter_by");
		System.out.println("filter_by = " + filter_by);
		System.out.println("product_category_filter= " + product_category_filter);
		String business_id = "SST1";
		ProductCategoryAPI myAPI = new ProductCategoryAPI();
		ProductCategoryAttributeAPI myAPI_2 = new ProductCategoryAttributeAPI();
		ArrayList<Product_Category> myProductCategoryList = myAPI.GetListRequest(business_id, product_category_filter, filter_by);
		ArrayList<String> myproduct_codeList = myAPI_2.GetAllAttributeRequest(business_id);
		//String[] checkedAttributes = request.getParameterValues("attributes");
		
		//request.setAttribute("checkedAttributes", checkedAttributes);
		request.setAttribute("myProductCategoryList", myProductCategoryList);
		request.setAttribute("myproduct_codeList", myproduct_codeList);
		
		response.setRenderParameter("jspPage", "/html/productcategory/product_category_list.jsp");
	}
	
	public void EditProductCategory(ActionRequest request, ActionResponse response) throws Exception
	{
		String business_id = "SST1";
		String product_code = ParamUtil.getString(request, "product_code");
		ProductCategoryAPI myAPI = new ProductCategoryAPI();
		ProductCategoryAttributeAPI myAPI_2 = new ProductCategoryAttributeAPI();
		ArrayList<Product_Category> myProductCategoryList = myAPI.GetProductCategoryList(business_id);
		Product_Category_Attributes myProductCategoryAttributes = myAPI_2.GetSingleAttributeRequest(business_id, product_code);
		
		boolean empty_flag = false; 
		if(myProductCategoryAttributes.getrow_id() == 0)
		{
			empty_flag = true;
		}
		
		for (int i = 0; i < myProductCategoryList.size(); i++)
		{
			if (myProductCategoryList.get(i).getproduct_code().equals(product_code))
			{
				Product_Category myProductCategory = myProductCategoryList.get(i);
				request.setAttribute("myProductCategory", myProductCategory);
			}
			
			
		}
		
		request.setAttribute("myProductCategoryAttributes", myProductCategoryAttributes);
		request.setAttribute("empty_flag", empty_flag);
		response.setRenderParameter("jspPage", "/html/productcategory/edit_product_category.jsp");
	}
	
	public void UpdateAttributes(ActionRequest request, ActionResponse response) throws Exception
	{
		String business_id = "SST1";
		String product_code = ParamUtil.getString(request, "product_code");
		ProductCategoryAttributeAPI myAPI_2 = new ProductCategoryAttributeAPI();
		Product_Category_Attributes myProductCategoryAttributes = myAPI_2.GetSingleAttributeRequest(business_id, product_code);
		String refund_policy = ParamUtil.getString(request, "refund_policy");
		refund_policy = refund_policy.replace("\n", "<br/>");
		String suitable_for = ParamUtil.getString(request, "suitable_for");
		suitable_for = suitable_for.replace("\n", "<br/>");
		String further_opportunities = ParamUtil.getString(request, "further_opportunities");
		further_opportunities = further_opportunities.replace("\n", "<br/>");
		boolean is_published = myProductCategoryAttributes.getis_published();
		String pre_requisite_information = ParamUtil.getString(request, "pre_requisite_information");
		pre_requisite_information = pre_requisite_information.replace("\n", "<br/>");
		String units_of_competency = ParamUtil.getString(request, "units_of_competency");
		units_of_competency = units_of_competency.replace("\n", "<br/>");
		String faq = ParamUtil.getString(request, "faq");
		faq = faq.replace("\n", "<br/>");
		String qualification_outcomes = ParamUtil.getString(request, "qualification_outcomes");
		qualification_outcomes = qualification_outcomes.replace("\n", "<br/>");
		String further_information = ParamUtil.getString(request, "further_information");
		further_information = further_information.replace("\n", "<br/>");
		String payment_options = ParamUtil.getString(request, "payment_options");
		payment_options = payment_options.replace("\n", "<br/>");
		String rpl = ParamUtil.getString(request, "rpl");
		rpl = rpl.replace("\n", "<br/>");
		String related_courses = ParamUtil.getString(request, "related_courses");
		related_courses = related_courses.replace("\n", "<br/>");
		String max_students = ParamUtil.getString(request, "max_students");
		max_students = max_students.replace("\n", "<br/>");
		Boolean[] is_active = new Boolean[12];
		for(int i=0; i<12 ;i++)
		{
				is_active[i] = myProductCategoryAttributes.getis_active(i);
		}

		String putString = 

							"refund_policy="					+ refund_policy
							+"&suitable_for="					+ suitable_for
							+"&further_opportunities="			+ further_opportunities
							+"&pre_requisite_information="		+ pre_requisite_information
							+"&units_of_competency="			+ units_of_competency
							+"&product_code="					+ product_code
							+"&faq="							+ faq
							+"&qualification_outcomes="			+ qualification_outcomes
							+"&further_information="			+ further_information
							+"&payment_options="				+ payment_options
							+"&is_active12="					+ is_active[11]
							+"&is_active10="					+ is_active[9] 
							+"&is_active11="					+ is_active[10]
							+"&rpl="							+ rpl
							+"&related_courses="				+ related_courses
							+"&is_active8="						+ is_active[7]
							+"&is_active7="						+ is_active[6]
							+"&is_active9="						+ is_active[8]
							+"&is_active4="						+ is_active[3]
							+"&is_active3="						+ is_active[2]
							+"&is_active6="						+ is_active[5]
							+"&is_active5="						+ is_active[4]
							+"&is_active2="						+ is_active[1]
							+"&is_active1="						+ is_active[0]
							+"&max_students="					+ max_students
							+"&business_id="					+ business_id
							+"&is_published="					+ is_published;
		
		myAPI_2.UpdateAttributeRequest(putString);
		EditProductCategory(request, response);
	}
	
	public void DeleteAttributes(ActionRequest request, ActionResponse response) throws Exception
	{
		String business_id = "SST1";
		String product_code = ParamUtil.getString(request, "product_code");
		String putString = 

							 "product_code="		+ product_code
							+"&business_id="		+ business_id
							+"&is_deleted=1";
		
		ProductCategoryAttributeAPI myAPI_2 = new ProductCategoryAttributeAPI();
		myAPI_2.DeleteAttributesRequest(putString);
		GetAllRequest(request, response);
	}
	
	public void ToggleAttribute(ActionRequest request, ActionResponse response) throws Exception
	{
		String business_id = "SST1";
		String product_code = ParamUtil.getString(request, "product_code");
		int is_active_ID = ParamUtil.getInteger(request, "is_active_ID");
		ProductCategoryAttributeAPI myAPI_2 = new ProductCategoryAttributeAPI();
		Product_Category_Attributes myProductCategoryAttributes = myAPI_2.GetSingleAttributeRequest(business_id, product_code);
		String refund_policy = myProductCategoryAttributes.getrefund_policy(); 
		System.out.println("refund_policy: " + refund_policy);
		String suitable_for = myProductCategoryAttributes.getsuitable_for();
		String further_opportunities = myProductCategoryAttributes.getfurther_opportunities();
		boolean is_published = myProductCategoryAttributes.getis_published();
		String pre_requisite_information = myProductCategoryAttributes.getpre_requisite_information();
		String units_of_competency = myProductCategoryAttributes.getunits_of_competency();
		String faq = myProductCategoryAttributes.getfaq();
		String qualification_outcomes = myProductCategoryAttributes.getqualification_outcomes();
		String further_information = myProductCategoryAttributes.getfurther_information();
		String payment_options = myProductCategoryAttributes.getpayment_options();
		String rpl = myProductCategoryAttributes.getrpl();
		String related_courses = myProductCategoryAttributes.getrelated_courses();
		String max_students = myProductCategoryAttributes.getmax_students();
		Boolean[] is_active = new Boolean[12];
		for(int i=0; i<12 ;i++)
		{
			if(i==is_active_ID)
			{
				is_active[i] = !(myProductCategoryAttributes.getis_active(i));
			}
			else
			{
				is_active[i] = myProductCategoryAttributes.getis_active(i);
			}
		}

		String putString = 

							"refund_policy="					+ refund_policy
							+"&suitable_for="					+ suitable_for
							+"&further_opportunities="			+ further_opportunities
							+"&pre_requisite_information="		+ pre_requisite_information
							+"&units_of_competency="			+ units_of_competency
							+"&product_code="					+ product_code
							+"&faq="							+ faq
							+"&qualification_outcomes="			+ qualification_outcomes
							+"&further_information="			+ further_information
							+"&payment_options="				+ payment_options
							+"&is_active12="					+ is_active[11]
							+"&is_active10="					+ is_active[9] 
							+"&is_active11="					+ is_active[10]
							+"&rpl="							+ rpl
							+"&related_courses="				+ related_courses
							+"&is_active8="						+ is_active[7]
							+"&is_active7="						+ is_active[6]
							+"&is_active9="						+ is_active[8]
							+"&is_active4="						+ is_active[3]
							+"&is_active3="						+ is_active[2]
							+"&is_active6="						+ is_active[5]
							+"&is_active5="						+ is_active[4]
							+"&is_active2="						+ is_active[1]
							+"&is_active1="						+ is_active[0]
							+"&max_students="					+ max_students
							+"&business_id="					+ business_id
							+"&is_published="					+ is_published;
		
		myAPI_2.UpdateAttributeRequest(putString);
		EditProductCategory(request, response);
	}
	
	public void CreateAttributes(ActionRequest request, ActionResponse response) throws Exception
	{
		 
		String refund_policy = ParamUtil.getString(request, "refund_policy");
		refund_policy = refund_policy.replace("\n", "<br/>");
		String suitable_for = ParamUtil.getString(request, "suitable_for");
		suitable_for = suitable_for.replace("\n", "<br/>");
		String further_opportunities = ParamUtil.getString(request, "further_opportunities");
		further_opportunities = further_opportunities.replace("\n", "<br/>");
		String pre_requisite_information = ParamUtil.getString(request, "pre_requisite_information");
		pre_requisite_information = pre_requisite_information.replace("\n", "<br/>");
		String units_of_competency = ParamUtil.getString(request, "units_of_competency");
		units_of_competency = units_of_competency.replace("\n", "<br/>");
		String product_code = ParamUtil.getString(request, "product_code");
		product_code = product_code.replace("\n", "<br/>");
		String faq = ParamUtil.getString(request, "faq");
		faq = faq.replace("\n", "<br/>");
		String qualification_outcomes = ParamUtil.getString(request, "qualification_outcomes");
		qualification_outcomes = qualification_outcomes.replace("\n", "<br/>");
		String further_information = ParamUtil.getString(request, "further_information");
		further_information = further_information.replace("\n", "<br/>");
		String payment_options = ParamUtil.getString(request, "payment_options");
		payment_options = payment_options.replace("\n", "<br/>");
		String rpl = ParamUtil.getString(request, "rpl");
		rpl = rpl.replace("\n", "<br/>");
		String related_courses = ParamUtil.getString(request, "related_courses");
		related_courses = related_courses.replace("\n", "<br/>");
		String max_students = ParamUtil.getString(request, "max_students");
		max_students = max_students.replace("\n", "<br/>");
		String business_id="SST1";
		Boolean[] is_active = new Boolean[12];
		Arrays.fill(is_active, Boolean.FALSE);
		
		String postString = 	
				
								"refund_policy=" 				+	refund_policy
							+	"&suitable_for=" 				+	suitable_for
							+	"&further_opportunities=" 		+	further_opportunities
							+	"&pre_requisite_information=" 	+	pre_requisite_information
							+	"&units_of_competency=" 		+	units_of_competency
							+	"&product_code=" 				+	product_code
							+	"&faq=" 						+	faq
							+	"&qualification_outcomes=" 		+	qualification_outcomes
							+	"&further_information=" 		+	further_information
							+	"&payment_options=" 			+	payment_options
							+	"&is_active12=" 				+	is_active[11]
							+	"&is_active10=" 				+	is_active[9]
							+	"&is_active11=" 				+	is_active[10]
							+	"&rpl=" 						+	rpl
							+	"&related_courses=" 			+	related_courses
							+	"&is_active8=" 					+	is_active[7]
							+	"&is_active7=" 					+	is_active[6]
							+	"&is_active9=" 					+	is_active[8]
							+	"&is_active4=" 					+	is_active[3]
							+	"&is_active3=" 					+	is_active[6]
							+	"&is_active6=" 					+	is_active[5]
							+	"&is_active5=" 					+	is_active[4]
							+	"&is_active2=" 					+	is_active[1]
							+	"&is_active1=" 					+	is_active[0]
							+	"&max_students=" 				+	max_students
							+	"&business_id=" 				+	business_id;
		
		ProductCategoryAttributeAPI myAPI_2 = new ProductCategoryAttributeAPI();
		System.out.println("create-string" + postString);
		myAPI_2.CreateAttributeRequest(postString);
		EditProductCategory(request, response);
		
				
		
	}
	
	public void CancelAction(ActionRequest request, ActionResponse response) throws Exception
	{
		System.out.println("CancelAction");	
		response.setRenderParameter("jspPage", "/html/productcategory/product_category_list.jsp");	
	}
 
	

}
