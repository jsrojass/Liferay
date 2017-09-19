package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.service.GroupServiceUtil;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.service.LayoutServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.util.bridges.mvc.MVCPortlet;

import apiclasses.LayoutApi;
/**
 * Portlet implementation class NewLayout 
 */
public class NewLayout extends MVCPortlet {
	
	public void LayoutApiCall(ActionRequest request, ActionResponse response) throws Exception
	{
		ThemeDisplay myThemeDisplay = getThemeDisplay(request);
		long group_id = myThemeDisplay.getScopeGroupId();
		String business_id = "SST1";
		LayoutApi myApi = new LayoutApi();
		myApi.GetListRequest(business_id, group_id);
		GetPagesList (request, response);
	}
	
	public static ThemeDisplay getThemeDisplay(PortletRequest request) 
	{
		if (null == request) 
		         {
		 throw new IllegalArgumentException("request is null");
	}
	return (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	}
	
	@SuppressWarnings("static-access")
	public void AddNewPage (ActionRequest request, ActionResponse response) throws PortalException
	{
		ThemeDisplay myThemeDisplay = getThemeDisplay(request);
		long groupId = myThemeDisplay.getScopeGroupId();
		boolean privateLayout = ParamUtil.getBoolean(request, "is_private");
		long parentLayoutId = 0;
		
		
		boolean has_parent = ParamUtil.getBoolean(request, "has_parent");
		if(has_parent == false)
		{
			parentLayoutId = 0;
		}
		else
		{
			if(privateLayout == true)
			{
				parentLayoutId = ParamUtil.getLong(request, "PrivateParentLayoutId");		
			}
			else
			{
				parentLayoutId = ParamUtil.getLong(request, "PublicParentLayoutId");
			}	
			
		}
		
		String name = ParamUtil.getString(request, "name");
		String title = ParamUtil.getString(request, "title");
		String description = ParamUtil.getString(request, "description");
		String type = ParamUtil.getString(request, "type");
		boolean hidden = ParamUtil.getBoolean(request, "hidden");
		String friendlyURL = ParamUtil.getString(request, "friendlyURL");
		ServiceContext serviceContext = new ServiceContext();
		
		LayoutServiceUtil myLayoutSU = new LayoutServiceUtil();
		List<Layout> myPublicLayoutList = myLayoutSU.getLayouts(groupId, false);
		List<Layout> myPrivateLayoutList = myLayoutSU.getLayouts(groupId, true);
		List<Layout> myLayoutList = new ArrayList<Layout>();
		for (int j=0 ; j<myPublicLayoutList.size() ; j++)
		{
			myLayoutList.add(myPublicLayoutList.get(j));
		}
		
		for (int j=0 ; j<myPrivateLayoutList.size() ; j++)
		{
			myLayoutList.add(myPrivateLayoutList.get(j));
		}
		
		boolean CheckURL = false;
		
		for(int i=0; i<myLayoutList.size(); i++)
		{
			if(myLayoutList.get(i).getFriendlyURL().equals(friendlyURL))
			{
				CheckURL = true;
			}
		}
		
		if(CheckURL == true)
		{
			Random rand = new Random();
			int  n = rand.nextInt(100);
			String m = Integer.toString(n);
			friendlyURL = friendlyURL + m;
			Layout myLayout = myLayoutSU.addLayout(groupId, privateLayout, parentLayoutId, name, title, description, type, hidden, friendlyURL, serviceContext);
		}
		
		else
		{
			Layout myLayout = myLayoutSU.addLayout(groupId, privateLayout, parentLayoutId, name, title, description, type, hidden, friendlyURL, serviceContext);
		}
		
		GetPagesList (request, response);
		
		
	}
	
	public void GetPagesList (ActionRequest request, ActionResponse response)
	{
		LayoutServiceUtil myLayoutSU = new LayoutServiceUtil();
		@SuppressWarnings("static-access")
		ThemeDisplay myThemeDisplay = getThemeDisplay(request);
		long groupId = myThemeDisplay.getScopeGroupId();
		Layout currentLayout = myThemeDisplay.getLayout();
		List<Layout> myPublicLayoutList = myLayoutSU.getLayouts(groupId, false);
		List<Layout> myPrivateLayoutList = myLayoutSU.getLayouts(groupId, true);
		List<Layout> myLayoutList = new ArrayList<Layout>();
		for (int j=0 ; j<myPublicLayoutList.size() ; j++)
		{
			myLayoutList.add(myPublicLayoutList.get(j));
		}
		
		for (int j=0 ; j<myPrivateLayoutList.size() ; j++)
		{
			myLayoutList.add(myPrivateLayoutList.get(j));
		}
		
		request.setAttribute("currentLayout", currentLayout);
		request.setAttribute("myLayoutList", myLayoutList);
	}
	
	public void CreatePagesList (ActionRequest request, ActionResponse response)
	{
		ThemeDisplay myThemeDisplay = getThemeDisplay(request);
		long groupId = myThemeDisplay.getScopeGroupId();
		LayoutServiceUtil myLayoutSU = new LayoutServiceUtil();
		@SuppressWarnings("static-access")
		List<Layout> myPublicLayoutList = myLayoutSU.getLayouts(groupId, false);
		List<Layout> myPrivateLayoutList = myLayoutSU.getLayouts(groupId, true);
		List<Layout> myLayoutList = new ArrayList<Layout>();
		for (int j=0 ; j<myPublicLayoutList.size() ; j++)
		{
			myLayoutList.add(myPublicLayoutList.get(j));
		}
		
		for (int j=0 ; j<myPrivateLayoutList.size() ; j++)
		{
			myLayoutList.add(myPrivateLayoutList.get(j));
		}
		request.setAttribute("myLayoutList", myLayoutList);
		response.setRenderParameter("jspPage", "/html/newlayout/new_layout.jsp");
	}
	
	public void EditLayout (ActionRequest request, ActionResponse response) throws Exception
	{
		ThemeDisplay myThemeDisplay = getThemeDisplay(request);
		long groupId = myThemeDisplay.getScopeGroupId();
		boolean is_private = ParamUtil.getBoolean(request, "is_private");
		LayoutServiceUtil myLayoutSU = new LayoutServiceUtil();
		List<Layout> myPublicLayoutList = myLayoutSU.getLayouts(groupId, false);
		List<Layout> myPrivateLayoutList = myLayoutSU.getLayouts(groupId, true);
		List<Layout> myLayoutList = new ArrayList<Layout>();
		for (int j=0 ; j<myPublicLayoutList.size() ; j++)
		{
			myLayoutList.add(myPublicLayoutList.get(j));
		}
		
		for (int j=0 ; j<myPrivateLayoutList.size() ; j++)
		{
			myLayoutList.add(myPrivateLayoutList.get(j));
		}
		long layout_id = ParamUtil.getInteger(request, "layout_id");
		Layout myLayout = null;
		
		for (int i = 0; i < myLayoutList.size(); i++)
		{
			if (myLayoutList.get(i).getLayoutId() == layout_id && myLayoutList.get(i).isPrivateLayout() == is_private)
			{
				myLayout = myLayoutList.get(i);
			}
		}
		
		boolean hidden = myLayout.getHidden();
		long parentLayoutId = myLayout.getParentLayoutId();
		System.out.println("ID: " + myLayout.getLayoutId() + " Name: " + myLayout.getName("en_US") + " is hidden = " + hidden);
		request.setAttribute("hidden", hidden);
		request.setAttribute("myLayout", myLayout);
		request.setAttribute("myLayoutList", myLayoutList);
		response.setRenderParameter("jspPage", "/html/newlayout/edit_layout.jsp");
	}
	
	public void DeleteLayout (ActionRequest request, ActionResponse response) throws Exception
	{
		ThemeDisplay myThemeDisplay = getThemeDisplay(request);
		long groupId = myThemeDisplay.getScopeGroupId();
		long Layout_ID = ParamUtil.getInteger(request, "layout_id");
		boolean privateLayout = ParamUtil.getBoolean(request, "is_private");
		ServiceContext serviceContext = new ServiceContext();
		LayoutServiceUtil myLayoutSU = new LayoutServiceUtil();
		myLayoutSU.deleteLayout(groupId, privateLayout, Layout_ID, serviceContext);
		GetPagesList (request, response);
		
		
	}
	
	public void SubmitChanges (ActionRequest request, ActionResponse response) throws Exception
	{
		String name = ParamUtil.getString(request, "name");
		long layout_id = ParamUtil.getInteger(request, "layout_id"); 
		String layout_name = ParamUtil.getString(request, "layout_name"); 
		String layout_title = ParamUtil.getString(request, "layout_title"); 
		String layout_description = ParamUtil.getString(request, "layout_description"); 
		String layout_type = ParamUtil.getString(request, "layout_type"); 
		boolean hidden = ParamUtil.getBoolean(request, "hidden"); 
		
		ThemeDisplay myThemeDisplay = getThemeDisplay(request);
		long groupId = myThemeDisplay.getScopeGroupId();
		
		ServiceContext serviceContext = new ServiceContext();
		LayoutServiceUtil myLayoutSU = new LayoutServiceUtil();
		List<Layout> myPublicLayoutList = myLayoutSU.getLayouts(groupId, false);
		List<Layout> myPrivateLayoutList = myLayoutSU.getLayouts(groupId, true);
		List<Layout> myLayoutList = new ArrayList<Layout>();
		for (int j=0 ; j<myPublicLayoutList.size() ; j++)
		{
			myLayoutList.add(myPublicLayoutList.get(j));
		}
		
		for (int j=0 ; j<myPrivateLayoutList.size() ; j++)
		{
			myLayoutList.add(myPrivateLayoutList.get(j));
		}
		Layout myLayout = null;
		String locale = "en_US";
		
		for (int i = 0; i < myLayoutList.size(); i++)
		{
			if (myLayoutList.get(i).getLayoutId() == layout_id)
			{
				myLayout = myLayoutList.get(i);
			}
		}
		
		myLayout.setName(layout_name);
		myLayout.setTitle(layout_title);
		myLayout.setDescription(layout_description);
		System.out.println(myLayout.getName());
		
		boolean is_private = myLayout.getPrivateLayout();
		long parentLayoutId = 0;
		
				boolean has_parent = ParamUtil.getBoolean(request, "has_parent");
		if(has_parent == false)
		{
			parentLayoutId = 0;
		}
		else
		{
			parentLayoutId = ParamUtil.getLong(request, "parentLayoutId");
		}
		
		Map<Locale,String> localeNamesMap = myLayout.getNameMap();
		Map<Locale,String> localeTitlesMap = myLayout.getTitleMap();
		Map<Locale,String> descriptionMap = myLayout.getDescriptionMap();
		Map<Locale,String> keywordsMap = myLayout.getKeywordsMap();
		Map<Locale,String> robotsMap = myLayout.getRobotsMap();
		Map<Locale,String> friendlyURLMap = myLayout.getFriendlyURLMap();
		boolean iconImage = false;
		byte[] iconBytes = null;
		
				
		Layout updatedLayout = myLayoutSU.updateLayout(groupId, is_private, layout_id, parentLayoutId, localeNamesMap, localeTitlesMap, descriptionMap, keywordsMap, robotsMap, layout_type, hidden, friendlyURLMap, iconImage, iconBytes, serviceContext);
		GetPagesList (request, response);
	}
		
	public void ChangeHidden (ActionRequest request, ActionResponse response) throws Exception 
	{
		long layout_id = ParamUtil.getInteger(request, "layout_id");
		ThemeDisplay myThemeDisplay = getThemeDisplay(request);
		long groupId = myThemeDisplay.getScopeGroupId();
		boolean is_private = ParamUtil.getBoolean(request, "is_private");
		
		ServiceContext serviceContext = new ServiceContext();
		LayoutServiceUtil myLayoutSU = new LayoutServiceUtil();
		List<Layout> myPublicLayoutList = myLayoutSU.getLayouts(groupId, false);
		List<Layout> myPrivateLayoutList = myLayoutSU.getLayouts(groupId, true);
		List<Layout> myLayoutList = new ArrayList<Layout>();
		for (int j=0 ; j<myPublicLayoutList.size() ; j++)
		{
			myLayoutList.add(myPublicLayoutList.get(j));
		}
		
		for (int j=0 ; j<myPrivateLayoutList.size() ; j++)
		{
			myLayoutList.add(myPrivateLayoutList.get(j));
		}
		Layout myLayout = null;
		String locale = "en_US";
		
		for (int i = 0; i < myLayoutList.size(); i++)
		{
			if (myLayoutList.get(i).getLayoutId() == layout_id 
					&& myLayoutList.get(i).isPrivateLayout() == is_private)
			{
				myLayout = myLayoutList.get(i);
			}
		}
		
		long parentLayoutId = myLayout.getParentLayoutId();
		boolean hidden = !myLayout.getHidden();
		String layout_type = "portlet" ;
		Map<Locale,String> localeNamesMap = myLayout.getNameMap();
		Map<Locale,String> localeTitlesMap = myLayout.getTitleMap();
		Map<Locale,String> descriptionMap = myLayout.getDescriptionMap();
		Map<Locale,String> keywordsMap = myLayout.getKeywordsMap();
		Map<Locale,String> robotsMap = myLayout.getRobotsMap();
		Map<Locale,String> friendlyURLMap = myLayout.getFriendlyURLMap();
		boolean iconImage = false;
		byte[] iconBytes = null;
		
				
		Layout updatedLayout = myLayoutSU.updateLayout(groupId, is_private, layout_id, parentLayoutId, localeNamesMap, localeTitlesMap, descriptionMap, keywordsMap, robotsMap, layout_type, hidden, friendlyURLMap, iconImage, iconBytes, serviceContext);
		GetPagesList (request, response);
		
		
	}

	
	
	
	
 

}
