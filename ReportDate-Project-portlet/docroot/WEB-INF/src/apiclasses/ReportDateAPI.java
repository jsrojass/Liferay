package apiclasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import classpack.Report_Date;



public class ReportDateAPI {
	
	public List<Report_Date> GetRequest() throws IOException, JSONException  
	{
		ArrayList<Report_Date> report_Dates = new ArrayList<Report_Date>();         
		String urlString = "https://esb.site.edu.au:8243/services/SGIReport/CRM_Report/get_report_date";
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
		// Call response = {"Zreport_ID_dataCollection":null}
		String null_jsonString = "{"+ "\"" + "Zreport_ID_dataCollection" + "\"" + ":null}";
		if(jsonString.equals(null_jsonString) == false)
		{
		     JSONFactoryUtil myUtil = new JSONFactoryUtil(); // constructor, new JSONFactoryUtil Object
		     JSONObject myObject = (JSONObject) myUtil.createJSONObject(jsonString); // transforms jsonString into a JSONObject called myObject
		     JSONObject Zreport_ID_dataCollection = myObject.getJSONObject("Zreport_ID_dataCollection");
		     JSONArray Zreport_ID_data = Zreport_ID_dataCollection.getJSONArray("Zreport_ID_data");
		     for(int i=0; i<Zreport_ID_data.length() ; i++)
		     {
		           JSONObject myDateObject = Zreport_ID_data.getJSONObject(i);
		           int report_id = myDateObject.getInt("report_id");
		           String report_date = myDateObject.getString("report_date");
		           Report_Date myReportDate = new Report_Date(report_id, report_date);
		           report_Dates.add(myReportDate);
		     }
		     
		 }
		return report_Dates;
		 
		 //reportDates.addAll(myReportDateList);
	 }
	      
    //public List<Report_Date> getReportDate() {
        //return report_Dates;
    //}

}
