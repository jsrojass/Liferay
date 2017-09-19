package com.test;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.util.bridges.mvc.MVCPortlet;

import apiclasses.ReportDateAPI;

/**
 * Portlet implementation class ReportDate
 */
public class ReportDate extends MVCPortlet {
 
	public void GetReportDates(ActionRequest request, ActionResponse response) throws Exception
	{
		ReportDateAPI myAPI = new ReportDateAPI();
		List<classpack.Report_Date> myreportDates = myAPI.GetRequest();
		
		for(int i=0; i<myreportDates.size(); i++)
		{
			System.out.println("Report_date() = " + myreportDates.get(i).getReport_date());
		}
		
		for(int i=0; i<myreportDates.size(); i++)
		{
			System.out.println("Report_id() = " + myreportDates.get(i).getReport_id());
		}
	}
}
