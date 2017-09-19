package apiclasses;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import classpack.Product_Category_Attributes;

public class ProductCategoryAttributeAPI {
	
	public ArrayList<String> GetAllAttributeRequest(String business_id) throws Exception
	{
		ArrayList<String> myproduct_codeList = new ArrayList<String>();
		
		String urlString = "http://esb.site.edu.au:8280/services/ProductCatalogForBusiness/product_category_attribute_pc/get_all?business_id=" + business_id ; 
		
		
		// setting the HTTP URL Connection and request
	    
		URL url = new URL(urlString);	    
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		    
		// receiving response
		    
		int responseCode = con.getResponseCode();   
		System.out.println("Sending get request : "+ url);   
		System.out.println("Response code : "+ responseCode);   
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));  
		String output;   
		StringBuffer APIresponse = new StringBuffer();   
		while ((output = in.readLine()) != null)   
		{   
			APIresponse.append(output);   
		}   
		in.close();
		String jsonString = APIresponse.toString(); //this is the call response
		System.out.println("Call response = " + jsonString);
		// Call response = {"product_category_attributeCollection":null}
		String null_jsonString = "{"+ "\"" + "product_category_attributeCollection" + "\"" + ":null}";
				
		if(jsonString.equals(null_jsonString) == false)
		{
			JSONFactoryUtil myUtil = new JSONFactoryUtil(); // constructor, new JSONFactoryUtil Object
			JSONObject myObject = myUtil.createJSONObject(jsonString); // transforms jsonString into a JSONObject called myObject
			JSONObject product_category_attributeCollection = myObject.getJSONObject("product_category_attributeCollection");
			JSONArray product_category_attribute = product_category_attributeCollection.getJSONArray("product_category_attribute");
			for(int i=0; i<product_category_attribute.length() ; i++)
			{
				JSONObject myAttributeObject = product_category_attribute.getJSONObject(i);
				String product_code = myAttributeObject.getString("product_code");
				myproduct_codeList.add(product_code);
				System.out.println("product_code:" + product_code);
				
			}
		}
		
		return myproduct_codeList;
	}
	
	public Product_Category_Attributes GetSingleAttributeRequest(String business_id, String product_code) throws Exception
	{
		Product_Category_Attributes myAttribute = null;
		String urlString = "http://esb.site.edu.au:8280/services/ProductCatalogForBusiness/product_category_attribute_pc/search_by_id?business_id="+ business_id + "&product_code=" + product_code; 
		
		// setting the HTTP URL Connection and request
	    
		URL url = new URL(urlString);	    
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		    
		// receiving response
		    
		int responseCode = con.getResponseCode();   
		System.out.println("Sending get request : "+ url);   
		System.out.println("Response code : "+ responseCode);   
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));  
		String output;   
		StringBuffer APIresponse = new StringBuffer();   
		while ((output = in.readLine()) != null)   
		{   
			APIresponse.append(output);   
		}   
		in.close();
		String jsonString = APIresponse.toString(); //this is the call response
		System.out.println("Call response = " + jsonString);
		String null_jsonString = "{"+ "\"" + "product_category_attributeCollection" + "\"" + ":null}";
		if(jsonString.equals(null_jsonString) == true)
		{
			System.out.println("jsonString.equals(null_jsonString) == true");
			long null_long = 0;
			String null_string = "---";
			Boolean[] null_is_active = new Boolean[12];
			Arrays.fill(null_is_active, Boolean.FALSE);
			myAttribute = new Product_Category_Attributes(	
															null_long, 
															product_code, 
															business_id, 
															null_string, 
															//false, 
															null_string, 
															//false, 
															null_string, 
															//false, 
															null_string, 
															//false, 
															null_string, 
															//false, 
															null_string, 
															//false, 
															null_string, 
															//false, 
															null_string, 
															//false, 
															null_string,  
															//false, 
															null_string, 
															//false, 
															null_string, 
															//false,
															null_string, 
															//false, 
															null_string, 
															null_string, 
															false, 
															false,
															null_is_active
															);
		}
		else
		{
			System.out.println("jsonString.equals(null_jsonString) == false");
			JSONFactoryUtil myUtil = new JSONFactoryUtil(); // constructor, new JSONFactoryUtil Object
			@SuppressWarnings("static-access")
			JSONObject myObject = myUtil.createJSONObject(jsonString); // transforms jsonString into a JSONObject called myObject
			JSONObject product_category_attributeCollection = myObject.getJSONObject("product_category_attributeCollection"); 
			JSONObject myAttributeObject = product_category_attributeCollection.getJSONObject("product_category_attribute");
			long row_id = myAttributeObject.getLong("row_id");
			String suitable_for = myAttributeObject.getString("suitable_for");
			//boolean is_active1 = myAttributeObject.getBoolean("is_active1");
			String units_of_competency = myAttributeObject.getString("units_of_competency");
			//boolean is_active2 = myAttributeObject.getBoolean("is_active2");
			String qualification_outcomes = myAttributeObject.getString("qualification_outcomes");
			//boolean is_active3 = myAttributeObject.getBoolean("is_active3");
			String pre_requisite_information = myAttributeObject.getString("pre_requisite_information");
			//boolean is_active4 = myAttributeObject.getBoolean("is_active4");
			String rpl = myAttributeObject.getString("rpl");
			//boolean is_active5 = myAttributeObject.getBoolean("is_active5");
			String payment_options = myAttributeObject.getString("payment_options");
			//boolean is_active6 = myAttributeObject.getBoolean("is_active6");
			String refund_policy = myAttributeObject.getString("refund_policy");
			//boolean is_active7 = myAttributeObject.getBoolean("is_active7");
			String related_courses = myAttributeObject.getString("related_courses");
			//boolean is_active8 = myAttributeObject.getBoolean("is_active8");
			String max_students = myAttributeObject.getString("max_students");
			//boolean is_active9 = myAttributeObject.getBoolean("is_active9");
			String further_opportunities = myAttributeObject.getString("further_opportunities");
			//boolean is_active10 = myAttributeObject.getBoolean("is_active10");
			String faq = myAttributeObject.getString("faq");
			//boolean is_active11 = myAttributeObject.getBoolean("is_active11");
			String further_information = myAttributeObject.getString("further_information");
			//boolean is_active12 = myAttributeObject.getBoolean("is_active12");
			String date_created = myAttributeObject.getString("date_created");
			String date_modified = myAttributeObject.getString("date_modified");
			boolean is_deleted = myAttributeObject.getBoolean("is_deleted");
			boolean is_published = myAttributeObject.getBoolean("is_published");
			Boolean[] is_active = new Boolean[12];
						
			is_active[0] = myAttributeObject.getBoolean("is_active1");
			is_active[1] = myAttributeObject.getBoolean("is_active2");
			is_active[2] = myAttributeObject.getBoolean("is_active3");
			is_active[3] = myAttributeObject.getBoolean("is_active4");
			is_active[4] = myAttributeObject.getBoolean("is_active5");
			is_active[5] = myAttributeObject.getBoolean("is_active6");
			is_active[6] = myAttributeObject.getBoolean("is_active7");
			is_active[7] = myAttributeObject.getBoolean("is_active8");
			is_active[8] = myAttributeObject.getBoolean("is_active9");
			is_active[9] = myAttributeObject.getBoolean("is_active10");
			is_active[10] = myAttributeObject.getBoolean("is_active11");
			is_active[11] = myAttributeObject.getBoolean("is_active12");
						
			myAttribute = new Product_Category_Attributes(
															row_id, 
															product_code, 
															business_id, 
															suitable_for, 
															//is_active1, 
															units_of_competency, 
															//is_active2, 
															qualification_outcomes, 
															//is_active3, 
															pre_requisite_information, 
															//is_active4, 
															rpl, 
															//is_active5, 
															payment_options, 
															//is_active6, 
															refund_policy, 
															//is_active7, 
															related_courses, 
															//is_active8, 
															max_students,  
															//is_active9, 
															further_opportunities, 
															//is_active10,
															faq, 
															//is_active11, 
															further_information, 
															//is_active12, 
															date_created, 
															date_modified, 
															is_deleted, 
															is_published,
															is_active
															);
		}
			
		return myAttribute;
	
	}
	
	public void CreateAttributeRequest(String postString) throws Exception
	{
		System.out.println(postString);
		String urlString = "http://esb.site.edu.au:8280/services/ProductCatalogForBusiness/product_category_attribute_pc/create?"; 
	    
		// setting the HTTP URL Connection and request
		URL url = new URL(urlString);	    
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(postString);
		wr.flush();
		wr.close();
		    
		// receiving response
		int responseCode = con.getResponseCode();   
		System.out.println("Sending get request : "+ url);   
		System.out.println("Response code : "+ responseCode);   
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));  
		String output;   
		StringBuffer APIresponse = new StringBuffer();   
		while ((output = in.readLine()) != null)   
		{   
			APIresponse.append(output);   
		}   
		in.close();
		String jsonString = APIresponse.toString(); //this is the call response
		System.out.println(jsonString);
	}
	
	public void UpdateAttributeRequest(String putString) throws Exception 
	{
		String urlString = "http://esb.site.edu.au:8280/services/ProductCatalogForBusiness/product_category_attribute_pc/update?"; 
	    
		// setting the HTTP URL Connection and request
		URL url = new URL(urlString);	    
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("PUT");
		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(putString);
		wr.flush();
		wr.close();
		    
		// receiving response
		int responseCode = con.getResponseCode();   
		System.out.println("Sending get request : "+ url);   
		System.out.println("Response code : "+ responseCode);   
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));  
		String output;   
		StringBuffer APIresponse = new StringBuffer();   
		while ((output = in.readLine()) != null)   
		{   
			APIresponse.append(output);   
		}   
		in.close();
		String jsonString = APIresponse.toString(); //this is the call response
		System.out.println(jsonString);
	}
	
	public void DeleteAttributesRequest(String putString) throws Exception 
	{
		String urlString = "http://esb.site.edu.au:8280/services/ProductCatalogForBusiness/product_category_attribute_pc/delete?"; 
	    
		// setting the HTTP URL Connection and request
		URL url = new URL(urlString);	    
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("PUT");
		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(putString);
		wr.flush();
		wr.close();
		    
		// receiving response
		int responseCode = con.getResponseCode();   
		System.out.println("Sending get request : "+ url);   
		System.out.println("Response code : "+ responseCode);   
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));  
		String output;   
		StringBuffer APIresponse = new StringBuffer();   
		while ((output = in.readLine()) != null)   
		{   
			APIresponse.append(output);   
		}   
		in.close();
		String jsonString = APIresponse.toString(); //this is the call response
		System.out.println(jsonString);
	}
	

}