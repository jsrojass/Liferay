package apiclasses;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import classpack.Product;

public class ProductAPI {
	
	public ArrayList<Product> GetListRequest(String business_id, String product_filter, int filter_by) throws Exception
	{
		ArrayList<Product> myProductList = new ArrayList<Product>();
		
		String urlString = "https://esb.site.edu.au:8243/services/ProductCatalogForBusiness/product_pc/get_all?business_id="+ business_id; 
	    
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
		// Call response = {"productCollection":null}
		String null_jsonString = "{"+ "\"" + "productCollection" + "\"" + ":null}";
				
		if(jsonString.equals(null_jsonString) == false)
		{
				JSONFactoryUtil myUtil = new JSONFactoryUtil(); // constructor, new JSONFactoryUtil Object
				@SuppressWarnings("static-access")
				JSONObject myObject = myUtil.createJSONObject(jsonString); // transforms jsonString into a JSONObject called myObject
				JSONObject ProductCollection = myObject.getJSONObject("productCollection");
				JSONArray product = ProductCollection.getJSONArray("product");
				for(int i=0; i<product.length() ; i++)
				{
					JSONObject myProductObject = product.getJSONObject(i);
					
					String nill = "{\"@nil\":\"true\"}";
					
					long row_id = myProductObject.getLong("row_id");
					String product_id = myProductObject.getString("product_id");
					String product_type_id = myProductObject.getString("product_type_id");
					String product_code = myProductObject.getString("product_code");
					String external_id = myProductObject.getString("external_id");
						
						if(external_id.equals(nill))
						{
							external_id = "";
						}
						
					String product_name = myProductObject.getString("product_name");
					String product_web_name = myProductObject.getString("product_web_name");
					
						if(product_web_name.equals(nill))
						{
							product_web_name = "";
						}
					
					String name_as_webname = myProductObject.getString("name_as_webname");
					
						if(name_as_webname.equals(nill))
						{
							name_as_webname = "";
						}
					
					String product_group_id = myProductObject.getString("product_group_id");
					String product_group_type_name = myProductObject.getString("product_group_type_name");
					String delivery_type_name = myProductObject.getString("delivery_type_name");
					String duration = myProductObject.getString("duration");
					
						if(duration.equals(nill))
						{
							duration = "";
						}
					
					String stream_name = myProductObject.getString("stream_name");
					
						if(stream_name.equals(nill))
						{
							stream_name = "";
						}
						
					String short_description = myProductObject.getString("short_description");
					
						if(short_description.equals(nill))
						{
							short_description = "";
						}
					
					String domain_id = myProductObject.getString("domain_id");
					
						if(domain_id.equals(nill))
						{
							domain_id = "";
						}
					
					String location_id = myProductObject.getString("location_id");
					
						if(location_id.equals(nill))
						{
							location_id = "";
						}
					
					String default_price = myProductObject.getString("default_price");
					boolean is_active = myProductObject.getBoolean("is_active");
					boolean is_published = myProductObject.getBoolean("is_active");
					String date_created = myProductObject.getString("date_created");
					String date_modified = myProductObject.getString("date_modified");
					boolean has_attribute = myProductObject.getBoolean("is_active");
					boolean has_inventory = myProductObject.getBoolean("is_active"); 
					String p_image_url = myProductObject.getString("p_image_url");
					
						if(p_image_url.equals(nill))
						{
							p_image_url = "";
						}
					
					
					Product myProduct = new Product(row_id, product_id, product_type_id, product_code, 
							external_id, product_name, product_web_name, name_as_webname, 
							product_group_id, product_group_type_name, delivery_type_name, duration, 
							stream_name, short_description, domain_id, location_id, default_price, 
							business_id, is_active, is_published, date_created, date_modified, 
							has_attribute, has_inventory, p_image_url);
					
					if(filter_by == 1)
					{
						if(product_id.contains(product_filter) == true)
						{
						myProductList.add(myProduct);
						}
					}
					else if(filter_by == 2)
					{
						if(product_type_id.contains(product_filter) == true)
						{
						myProductList.add(myProduct);
						}
					}
					else if(filter_by == 3)
					{
						if(product_code.contains(product_filter) == true)
						{
						myProductList.add(myProduct);
						}
					}
					else if(filter_by == 4)
					{
						if(external_id.contains(product_filter) == true)
						{
						myProductList.add(myProduct);
						}
					}
					else if(filter_by == 5)
					{
						if(product_name.contains(product_filter) == true)
						{
						myProductList.add(myProduct);
						}
					}	
	
				}
		}
			
		return myProductList;
	
	}
	
	public ArrayList<Product> GetAllRequest(String business_id) throws Exception
	{
		ArrayList<Product> myProductList = new ArrayList<Product>();
		
		String urlString = "https://esb.site.edu.au:8243/services/ProductCatalogForBusiness/product_pc/get_all?business_id="+ business_id; 
	    
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
		// Call response = {"productCollection":null}
		String null_jsonString = "{"+ "\"" + "productCollection" + "\"" + ":null}";
		
		if(jsonString.equals(null_jsonString) == false)
		{
			JSONFactoryUtil myUtil = new JSONFactoryUtil(); // constructor, new JSONFactoryUtil Object
			@SuppressWarnings("static-access")
			JSONObject myObject = myUtil.createJSONObject(jsonString); // transforms jsonString into a JSONObject called myObject
			JSONObject ProductCollection = myObject.getJSONObject("productCollection");
			JSONArray product = ProductCollection.getJSONArray("product");
			for(int i=0; i<product.length() ; i++)
			{
				JSONObject myProductObject = product.getJSONObject(i);
				
				String nill = "{\"@nil\":\"true\"}";
				
				long row_id = myProductObject.getLong("row_id");
				String product_id = myProductObject.getString("product_id");
				String product_type_id = myProductObject.getString("product_type_id");
				String product_code = myProductObject.getString("product_code");
				String external_id = myProductObject.getString("external_id");
					
					if(external_id.equals(nill))
					{
						external_id = "";
					}
					
				String product_name = myProductObject.getString("product_name");
				String product_web_name = myProductObject.getString("product_web_name");
				
					if(product_web_name.equals(nill))
					{
						product_web_name = "";
					}
				
				String name_as_webname = myProductObject.getString("name_as_webname");
				
					if(name_as_webname.equals(nill))
					{
						name_as_webname = "";
					}
				
				String product_group_id = myProductObject.getString("product_group_id");
				String product_group_type_name = myProductObject.getString("product_group_type_name");
				String delivery_type_name = myProductObject.getString("delivery_type_name");
				String duration = myProductObject.getString("duration");
				
					if(duration.equals(nill))
					{
						duration = "";
					}
				
				String stream_name = myProductObject.getString("stream_name");
				
					if(stream_name.equals(nill))
					{
						stream_name = "";
					}
					
				String short_description = myProductObject.getString("short_description");
				
					if(short_description.equals(nill))
					{
						short_description = "";
					}
				
				String domain_id = myProductObject.getString("domain_id");
				
					if(domain_id.equals(nill))
					{
						domain_id = "";
					}
				
				String location_id = myProductObject.getString("location_id");
				
					if(location_id.equals(nill))
					{
						location_id = "";
					}
				
				String default_price = myProductObject.getString("default_price");
				boolean is_active = myProductObject.getBoolean("is_active");
				boolean is_published = myProductObject.getBoolean("is_active");
				String date_created = myProductObject.getString("date_created");
				String date_modified = myProductObject.getString("date_modified");
				boolean has_attribute = myProductObject.getBoolean("is_active");
				boolean has_inventory = myProductObject.getBoolean("is_active"); 
				String p_image_url = myProductObject.getString("p_image_url");
				
					if(p_image_url.equals(nill))
					{
						p_image_url = "";
					}
				
				
				Product myProduct = new Product(row_id, product_id, product_type_id, product_code, 
						external_id, product_name, product_web_name, name_as_webname, 
						product_group_id, product_group_type_name, delivery_type_name, duration, 
						stream_name, short_description, domain_id, location_id, default_price, 
						business_id, is_active, is_published, date_created, date_modified, 
						has_attribute, has_inventory, p_image_url);
				
				myProductList.add(myProduct);
				
			}
		}	
		
		return myProductList;
	
	}

}