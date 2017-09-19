package apiclasses;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import classpack.Product_Nav_Tag;

public class ProductNavTagAPI 
{
	
	public ArrayList<Product_Nav_Tag> GetListRequest(String business_id, String nav_tag_id_filter) throws Exception
	{
			ArrayList<Product_Nav_Tag> myproduct_nav_tagList = new ArrayList<Product_Nav_Tag>();
			String urlString = "http://esb.site.edu.au:8280/services/ProductCatalogForBusiness/product_nav_tag_pc/get_all?business_id=" + business_id ; 
			
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
			String null_jsonString = "{"+ "\"" + "product_nav_tagCollection" + "\"" + ":null}";
			if(jsonString.equals(null_jsonString) == false)
			{
				JSONFactoryUtil myUtil = new JSONFactoryUtil(); // constructor, new JSONFactoryUtil Object
				JSONObject myObject = myUtil.createJSONObject(jsonString); // transforms jsonString into a JSONObject called myObject
				JSONObject product_nav_tagCollection = myObject.getJSONObject("product_nav_tagCollection");
				JSONArray product_nav_tag = product_nav_tagCollection.getJSONArray("product_nav_tag");
				
				for(int i=0; i<product_nav_tag.length() ; i++)
				{
					JSONObject myNavTagObject = product_nav_tag.getJSONObject(i);
					long row_id = myNavTagObject.getLong("row_id");
					String nav_tag_id = myNavTagObject.getString("nav_tag_id");
					String description = myNavTagObject.getString("description");
					String date_created = myNavTagObject.getString("date_created");
					String date_modified = myNavTagObject.getString("date_modified");
					boolean is_deleted = myNavTagObject.getBoolean("is_deleted");
					boolean is_published = myNavTagObject.getBoolean("is_published");
					
					Product_Nav_Tag myProductNavTag = new Product_Nav_Tag(row_id, nav_tag_id, business_id, description, 
																		  date_created, date_modified, is_deleted, is_published);

					if(nav_tag_id.contains(nav_tag_id_filter) == true)
					{
						myproduct_nav_tagList.add(myProductNavTag);
					}
				}
			}
			
			return myproduct_nav_tagList;		
	}
	
	public ArrayList<Product_Nav_Tag> GetAllRequest(String business_id) throws Exception
	{
		ArrayList<Product_Nav_Tag> myproduct_nav_tagList = new ArrayList<Product_Nav_Tag>();
		String urlString = "http://esb.site.edu.au:8280/services/ProductCatalogForBusiness/product_nav_tag_pc/get_all?business_id=" + business_id ; 
		
		
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
		
		String null_jsonString = "{"+ "\"" + "product_nav_tagCollection" + "\"" + ":null}";
		
		if(jsonString.equals(null_jsonString) == false)
		{
			JSONFactoryUtil myUtil = new JSONFactoryUtil(); // constructor, new JSONFactoryUtil Object
			JSONObject myObject = myUtil.createJSONObject(jsonString); // transforms jsonString into a JSONObject called myObject
			JSONObject product_nav_tagCollection = myObject.getJSONObject("product_nav_tagCollection");
			JSONArray product_nav_tag = product_nav_tagCollection.getJSONArray("product_nav_tag");
			
			for(int i=0; i<product_nav_tag.length() ; i++)
			{
				JSONObject myNavTagObject = product_nav_tag.getJSONObject(i);
				long row_id = myNavTagObject.getLong("row_id");
				String nav_tag_id = myNavTagObject.getString("nav_tag_id");
				String description = myNavTagObject.getString("description");
				String date_created = myNavTagObject.getString("date_created");
				String date_modified = myNavTagObject.getString("date_modified");
				boolean is_deleted = myNavTagObject.getBoolean("is_deleted");
				boolean is_published = myNavTagObject.getBoolean("is_published");
				
				Product_Nav_Tag myProductNavTag = new Product_Nav_Tag(row_id, nav_tag_id, business_id, description, 
																	  date_created, date_modified, is_deleted, is_published);

				myproduct_nav_tagList.add(myProductNavTag);		
				
			}
		}
		
		return myproduct_nav_tagList;
	}
	
	public Product_Nav_Tag GetSingleNavTagRequest(String business_id, String nav_tag_id) throws Exception
	{
			Product_Nav_Tag myNavTag = null;
			String urlString = "http://esb.site.edu.au:8280/services/ProductCatalogForBusiness/product_nav_tag_pc/search_by_id?business_id=" + business_id + "&nav_tag_id=" + nav_tag_id; 
						
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
			
			String null_jsonString = "{"+ "\"" + "product_nav_tagCollection" + "\"" + ":null}";
			if(jsonString.equals(null_jsonString) == false)
			{
				JSONFactoryUtil myUtil = new JSONFactoryUtil(); // constructor, new JSONFactoryUtil Object
				@SuppressWarnings("static-access")
				JSONObject myObject = myUtil.createJSONObject(jsonString); // transforms jsonString into a JSONObject called myObject
				JSONObject product_nav_tagCollection = myObject.getJSONObject("product_nav_tagCollection"); 
				JSONObject product_nav_tag = product_nav_tagCollection.getJSONObject("product_nav_tag");
				
				long row_id = product_nav_tag.getLong("row_id");
				String description = product_nav_tag.getString("description");
				String date_created = product_nav_tag.getString("date_created");
				String date_modified = product_nav_tag.getString("date_modified");
				boolean is_deleted = product_nav_tag.getBoolean("is_deleted");
				boolean is_published = product_nav_tag.getBoolean("is_published");
				
				myNavTag = new Product_Nav_Tag(row_id, nav_tag_id, business_id, description, 
																	  date_created, date_modified, is_deleted, is_published);
			}
			
			return myNavTag;
	}
	
	public void BatchProducttoNavTagRequest(String XMLBody) throws Exception
	{
		// setting the HTTP URL Connection and request
		
				String urlString = "http://esb.site.edu.au:8280/services/ProductCatalogForBusiness/product_category_to_nav_tag_pc/create"; 
			    
				// setting the HTTP URL Connection and request
				URL url = new URL(urlString);	    
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("POST");
				con.setRequestProperty("Content-Type", "application/xml");
				con.setDoOutput(true);
				DataOutputStream wr = new DataOutputStream(con.getOutputStream());
				wr.writeBytes(XMLBody);
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
	
	public void CreateNavTagRequest(String postString) throws Exception
	{
		System.out.println(postString);
		String urlString = "http://esb.site.edu.au:8280/services/ProductCatalogForBusiness/product_nav_tag_pc/create?"; 
	    
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
	
	public void UpdateNavTagRequest(String putString) throws Exception 
	{
		String urlString = "http://esb.site.edu.au:8280/services/ProductCatalogForBusiness/product_nav_tag_pc/update?"; 
	    
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
		System.out.println("Update Call Response: " + jsonString);
	}
	

}
