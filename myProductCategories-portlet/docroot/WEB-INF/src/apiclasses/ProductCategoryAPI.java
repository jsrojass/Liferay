package apiclasses;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import classpack.Product_Category;

public class ProductCategoryAPI {
	
	public ArrayList<Product_Category> GetListRequest(String business_id, String product_category_filter, int filter_by) throws Exception
	{
		ArrayList<Product_Category> myProductCategoryList = new ArrayList<Product_Category>();
		
		String urlString = "http://esb.site.edu.au:8280/services/ProductCatalogForBusiness/product_category_pc/get_all?business_id="+ business_id; 
	    
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
		// Call response = {"product_nav_tagCollection":null}
		String null_jsonString = "{"+ "\"" + "product_categoryCollection" + "\"" + ":null}";
		if(jsonString.equals(null_jsonString) == false)
		{
			JSONFactoryUtil myUtil = new JSONFactoryUtil(); // constructor, new JSONFactoryUtil Object
			@SuppressWarnings("static-access")
			JSONObject myObject = myUtil.createJSONObject(jsonString); // transforms jsonString into a JSONObject called myObject
			JSONObject product_categoryCollection = myObject.getJSONObject("product_categoryCollection");
			JSONArray product_category = product_categoryCollection.getJSONArray("product_category");
			for(int i=0; i<product_category.length() ; i++)
			{
				JSONObject myProduct_CategoryObject = product_category.getJSONObject(i);
				
				// String nill = "{\"@nil\":\"true\"}";
				
				long row_id = myProduct_CategoryObject.getLong("row_id");
				String product_code = myProduct_CategoryObject.getString("product_code");
				String category_name = myProduct_CategoryObject.getString("category_name");
				boolean has_parent = myProduct_CategoryObject.getBoolean("has_parent");
				String myPC_business_id = myProduct_CategoryObject.getString("business_id");
				String date_created = myProduct_CategoryObject.getString("date_created");
				String date_modified = myProduct_CategoryObject.getString("date_modified");
				String parent_category_id = myProduct_CategoryObject.getString("parent_category_id");
				boolean is_published = myProduct_CategoryObject.getBoolean("is_published");
				
				
				Product_Category myProductCategory = new Product_Category(row_id, product_code, category_name, has_parent, 
																		myPC_business_id, date_created, date_modified, 
																		parent_category_id, is_published);
				if(filter_by == 1)
				{
					if(product_code.contains(product_category_filter) == true)
					{
						myProductCategoryList.add(myProductCategory);
					}
				}
				else if(filter_by == 2)
				{
					if(category_name.contains(product_category_filter) == true)
					{
						myProductCategoryList.add(myProductCategory);
					}
				}
				else if(filter_by == 3)
				{
					if(parent_category_id.contains(product_category_filter) == true)
					{
						myProductCategoryList.add(myProductCategory);
					}
				}
				
			}
			
			
			
		}
		
		return myProductCategoryList;
	
	}
	
	public ArrayList<Product_Category> GetProductCategoryList(String business_id) throws Exception
	{
		ArrayList<Product_Category> myProductCategoryList = new ArrayList<Product_Category>();
		
		String urlString = "http://esb.site.edu.au:8280/services/ProductCatalogForBusiness/product_category_pc/get_all?business_id="+ business_id; 
	    
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
		// Call response = {"product_nav_tagCollection":null}
		String null_jsonString = "{"+ "\"" + "product_categoryCollection" + "\"" + ":null}";
		if(jsonString.equals(null_jsonString) == false)
		{
			JSONFactoryUtil myUtil = new JSONFactoryUtil(); // constructor, new JSONFactoryUtil Object
			@SuppressWarnings("static-access")
			JSONObject myObject = myUtil.createJSONObject(jsonString); // transforms jsonString into a JSONObject called myObject
			JSONObject product_categoryCollection = myObject.getJSONObject("product_categoryCollection");
			JSONArray product_category = product_categoryCollection.getJSONArray("product_category");
			for(int i=0; i<product_category.length() ; i++)
			{
				JSONObject myProduct_CategoryObject = product_category.getJSONObject(i);
				
				// String nill = "{\"@nil\":\"true\"}";
				
				long row_id = myProduct_CategoryObject.getLong("row_id");
				String product_code = myProduct_CategoryObject.getString("product_code");
				String category_name = myProduct_CategoryObject.getString("category_name");
				boolean has_parent = myProduct_CategoryObject.getBoolean("has_parent");
				String myPC_business_id = myProduct_CategoryObject.getString("business_id");
				String date_created = myProduct_CategoryObject.getString("date_created");
				String date_modified = myProduct_CategoryObject.getString("date_modified");
				String parent_category_id = myProduct_CategoryObject.getString("parent_category_id");
				boolean is_published = myProduct_CategoryObject.getBoolean("is_published");
				
				
				Product_Category myProductCategory = new Product_Category(row_id, product_code, category_name, has_parent, 
																		myPC_business_id, date_created, date_modified, 
																		parent_category_id, is_published);
				myProductCategoryList.add(myProductCategory);
			}
			
			
			
		}
		
		return myProductCategoryList;
	
	}

}