package apiclasses;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.service.LayoutServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.Layout;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LayoutApi {
	
	@SuppressWarnings("static-access")
	public void GetListRequest(String business_id, long group_id) throws Exception
	{
		LayoutServiceUtil myLayoutSU = new LayoutServiceUtil();
		ArrayList<Layout> myLayoutList = new ArrayList<Layout>();
		ServiceContext serviceContext = new ServiceContext();
		String urlString = "http://esb.site.edu.au:8280/services/ProductCatalogForBusiness/" + "sst_liferay_pages/get_all?business_id=" + business_id;
		
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
				System.out.println(jsonString);
				
				JSONFactoryUtil myUtil = new JSONFactoryUtil();
				JSONObject myObject = myUtil.createJSONObject(jsonString);
				JSONObject sst_liferay_pages_Collection = myObject.getJSONObject("sst_liferay_pagesCollection");
				JSONArray  sst_liferay_pages = sst_liferay_pages_Collection.getJSONArray("sst_liferay_pages");
				for (int i=0; i<sst_liferay_pages.length(); i++)
				{
					JSONObject myPagesObject = sst_liferay_pages.getJSONObject(i);
					String friendly_url = myPagesObject.getString("friendly_url");
					long layout_id = myPagesObject.getLong("layout_id");
					boolean is_private = myPagesObject.getBoolean("is_private");
					boolean has_parent = myPagesObject.getBoolean("has_parent");
					long parent_layout_id = myPagesObject.getLong("parent_layout_id");
					boolean is_hidden = myPagesObject.getBoolean("is_hidden");
					// boolean is_deleted = myPagesObject.getBoolean("is_deleted");
					// String page_business_id = myPagesObject.getString("page_business_id");
					// Date date_created 
					// Date date_modified 
					long created_by = myPagesObject.getLong("created_by");
					String category_name = myPagesObject.getString("category_name");
					String parent_friendly_url = "/" + myPagesObject.getString("parent_friendly_url");
					
					boolean exist = false;
					
					List<Layout> myParentList = myLayoutSU.getLayouts(group_id, is_private);
					for (int j = 0; j < myParentList.size(); j++)
					{
						if (myParentList.get(j).getFriendlyURL().equals(parent_friendly_url))
						{
							parent_layout_id = myParentList.get(j).getLayoutId();
						}
					}
					
					for (int j = 0; j < myParentList.size(); j++)
					{
						if (myParentList.get(j).getFriendlyURL().equals("/" + friendly_url))
						{
							exist = true;
						}
					}
				
					if (exist == false)
					{
						Layout myLayout = myLayoutSU.addLayout(group_id, is_private, parent_layout_id, category_name, category_name, 
								"", "portlet", is_hidden, "/" + friendly_url, serviceContext);
					}
					
					
				}	
				
	}
	
	
	

}
